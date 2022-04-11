package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplo1.Modelos.Questoes;

import java.util.Random;

public class ActivityQuestoes extends AppCompatActivity {
    Button BotaoPrimeiraAlternativaQuestoes,
            BotaoSegundaAlternativaQuestoes,
            BotaoTerceiraAlternativaQuestoes,
            BotaoQuartaAlternativaQuestoes,
            BotaoQuintaAlternativaQuestoes;
     TextView TextViewPergunta, TextViewPontosQuestoes;

     private Questoes mQuestoes = new Questoes();
     public String mRespostas;
     private int mPontos;
     private  int mQuestoesLenght = mQuestoes.mQuestoes.length;
     Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes);

        r= new Random();

       ConverterComponentes();
       updateQuestion(r.nextInt(mQuestoesLenght));

       BotaoPrimeiraAlternativaQuestoes.setOnClickListener(view -> {

            if (BotaoPrimeiraAlternativaQuestoes.getText()== mRespostas ) {
                mPontos= mPontos +50;
                TextViewPontosQuestoes.setText(""+ mPontos);
                updateQuestion(r.nextInt(mQuestoesLenght));
            }else{

                ErroQuestoes();
            }
           });
        BotaoSegundaAlternativaQuestoes.setOnClickListener(view -> {
            if (BotaoSegundaAlternativaQuestoes.getText()== mRespostas ) {
                mPontos= mPontos +50;
                TextViewPontosQuestoes.setText(""+ mPontos);
                updateQuestion(r.nextInt(mQuestoesLenght));
            }else{

                ErroQuestoes();
            }
        });
        BotaoTerceiraAlternativaQuestoes.setOnClickListener(view -> {
            if (BotaoTerceiraAlternativaQuestoes.getText()== mRespostas ) {
                mPontos= mPontos +50;
                TextViewPontosQuestoes.setText(""+ mPontos);
                updateQuestion(r.nextInt(mQuestoesLenght));
            }else{

                ErroQuestoes();
                return;
            }

        });
        BotaoQuartaAlternativaQuestoes.setOnClickListener(view -> {
            if (BotaoQuartaAlternativaQuestoes.getText()== mRespostas ) {
                mPontos= mPontos +50;
                TextViewPontosQuestoes.setText(""+ mPontos);
                 updateQuestion(r.nextInt(mQuestoesLenght));
            }else{

                ErroQuestoes();
                return;
            }

        });
        BotaoQuintaAlternativaQuestoes.setOnClickListener(view -> {
            if (BotaoQuintaAlternativaQuestoes.getText()== mRespostas ) {
                mPontos= mPontos +50;
                TextViewPontosQuestoes.setText(""+ mPontos);
                updateQuestion(r.nextInt(mQuestoesLenght));
            }
           else{

                ErroQuestoes();
                return;
            }

        });

      }

    private void ConverterComponentes(){
        TextViewPontosQuestoes=findViewById(R.id.textViewPontosTeste);
        TextViewPergunta=findViewById(R.id.textViewPerguntaTeste);

        BotaoPrimeiraAlternativaQuestoes=findViewById(R.id.btnPrimeiraAlternativaQuestoes);
        BotaoSegundaAlternativaQuestoes=findViewById(R.id.btnSegundaAlternativaQuestoes);
        BotaoTerceiraAlternativaQuestoes=findViewById(R.id.btnTerceiraAlternativaQuestoes);
        BotaoQuartaAlternativaQuestoes=findViewById(R.id.btnQuartaAlternativaQuestoes);
        BotaoQuintaAlternativaQuestoes=findViewById(R.id.btnQuintaAlternativaQuestoes);
    }
    private void updateQuestion(int num){
        TempoQuestoes();

        TextViewPergunta.setText(mQuestoes.getQuestoes(num));
        BotaoPrimeiraAlternativaQuestoes.setText(mQuestoes.getAlternativa1(num));
        BotaoSegundaAlternativaQuestoes.setText(mQuestoes.getAlternativa2(num));
        BotaoTerceiraAlternativaQuestoes.setText(mQuestoes.getAlternativa3(num));
        BotaoQuartaAlternativaQuestoes.setText(mQuestoes.getAlternativa4(num));
        BotaoQuintaAlternativaQuestoes.setText(mQuestoes.getAlternativa5(num));

        mRespostas = mQuestoes.getcRespostas(num);

    }
    private void ErroQuestoes(){

        Toast.makeText(getApplicationContext(),"Incorreta",Toast.LENGTH_SHORT).show();
    }
    public void TempoQuestoes() {

        int delay_ms = 30000;
        new Handler().postDelayed(()->{
            updateQuestion(r.nextInt(mQuestoesLenght));

        },delay_ms);

        try {
            while (mPontos>250);
            if(mPontos==250){
                Intent nivel = new Intent(getApplicationContext(), ActivityNivel.class);
                nivel.putExtra("nivelA", mPontos);
                startActivity(nivel);
                Log.e("nivel", "ValidaNivelA: " + mPontos);

                finish();
            }else if(mPontos>=300){
                Intent nivel = new Intent(getApplicationContext(), ActivityNivel.class);
                nivel.putExtra("nivelB", mPontos);
                Log.e("nivel", "ValidaNivelB: " + mPontos);
                startActivity(nivel);
                finish();
            }
            else {Toast.makeText(getApplicationContext(),
                    "Continue tentando",
                    Toast.LENGTH_SHORT).show();

            } }catch (Exception e ){ Toast.makeText(getApplicationContext(),
                "Continue tentando",
                Toast.LENGTH_SHORT).show();

        }


      /*  ProgressBar pbQuestoes= findViewById(R.id.progressBarQuestoes);
        pbQuestoes.setMax(delay_ms);
        pbQuestoes.setProgress(mQuestoesLenght);*/
    }
   /* public void BarraProgresso(){
    }*/
}