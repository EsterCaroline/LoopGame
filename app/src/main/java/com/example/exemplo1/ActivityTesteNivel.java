package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplo1.Modelos.Questoes;
import com.example.exemplo1.Modelos.QuestoesTeste;

import java.util.Random;

public class ActivityTesteNivel extends AppCompatActivity {
    Button BotaoPrimeiraAlternativaTeste,
            BotaoSegundaAlternativaTeste,
            BotaoTerceiraAlternativaTeste,
            BotaoQuartaAlternativaTeste,
            BotaoQuintaAlternativaTeste;
    ImageButton VoltarTelaProvaNivel;

    TextView TextViewPontosTeste,TextViewPerguntaTeste;

    public QuestoesTeste QuestoesT= new QuestoesTeste();
    public String TesteRespostas;
    private int  contador = 0;
    private int QuestoesTesteLenght = QuestoesT.QuestoesT.length;
    Random r;
    int numero= new Random().nextInt(5);

        int pontos,tentativa=0;
        boolean teste = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testenivel);
        r= new Random();
        ConverterComponentes();
       updateQuestao(r.nextInt(QuestoesTesteLenght));


            BotaoPrimeiraAlternativaTeste.setOnClickListener(view -> {
                TempoQuestoes();
                if (BotaoPrimeiraAlternativaTeste.getText() == TesteRespostas) {
                    contador = contador + 1;
                   tentativa ++;
                    TextViewPontosTeste.setText("" + tentativa);
                    updateQuestao(r.nextInt(QuestoesTesteLenght));

                } else {

                    ErroQuestoes();
                   tentativa ++;
                    updateQuestao(r.nextInt(QuestoesTesteLenght));
                }
            });
            BotaoSegundaAlternativaTeste.setOnClickListener(view -> {
                TempoQuestoes();
                if (BotaoSegundaAlternativaTeste.getText() == TesteRespostas) {
                    contador = contador + 1;
                    tentativa++;
                    TextViewPontosTeste.setText("" + tentativa);
                    updateQuestao(r.nextInt(QuestoesTesteLenght));


                } else {

                    ErroQuestoes();
                    tentativa++;
                    updateQuestao(r.nextInt(QuestoesTesteLenght));
                }
            });
            BotaoTerceiraAlternativaTeste.setOnClickListener(view -> {
                TempoQuestoes();
                if (BotaoTerceiraAlternativaTeste.getText() == TesteRespostas) {
                    contador = contador + 1;
                    tentativa++;
                    TextViewPontosTeste.setText("" + tentativa);
                    updateQuestao(r.nextInt(QuestoesTesteLenght));

                } else {

                    ErroQuestoes();
                    tentativa++;
                    updateQuestao(r.nextInt(QuestoesTesteLenght));
                }
            });
            BotaoQuartaAlternativaTeste.setOnClickListener(view -> {
                TempoQuestoes();
                if (BotaoQuartaAlternativaTeste.getText() == TesteRespostas) {
                    contador = contador + 1;
                   tentativa++;
                    TextViewPontosTeste.setText("" + tentativa);
                    updateQuestao(r.nextInt(QuestoesTesteLenght));

                } else {
                    ErroQuestoes();
                    tentativa++;
                    updateQuestao(r.nextInt(QuestoesTesteLenght));
                }
            });
            BotaoQuintaAlternativaTeste.setOnClickListener(view -> {
                TempoQuestoes();
                if (BotaoQuintaAlternativaTeste.getText() == TesteRespostas) {
                    contador++;
                    tentativa++;
                    Log.e("nivel", "ValidaNivelA cont: " + contador);
                    Log.e("nivel", "ValidaNivelA tentat: " + tentativa);
                    finish();
                    TextViewPontosTeste.setText("" + tentativa);
                    updateQuestao(r.nextInt(QuestoesTesteLenght));

                } else {

                    ErroQuestoes();
                    tentativa++;
                    updateQuestao(r.nextInt(QuestoesTesteLenght));
                }

            });

        Log.e("nivel", "ValidaNivelA: " + contador);
       VoltarTelaProvaNivel.setOnClickListener(view -> {
            Intent it = new Intent(getApplicationContext(), ActivityIniciarTeste.class);
            startActivity(it);
        });

    }


    public void ConverterComponentes(){

        BotaoPrimeiraAlternativaTeste=findViewById(R.id.btnPrimeiraAlternativaTeste);
        BotaoSegundaAlternativaTeste=findViewById(R.id.btnSegundaAlternativaTeste);
        BotaoTerceiraAlternativaTeste=findViewById(R.id.btnTerceiraAlternativaTeste);
        BotaoQuartaAlternativaTeste=findViewById(R.id.btnQuartaAlternativaTeste);
        BotaoQuintaAlternativaTeste=findViewById(R.id.btnQuintaAlternativaTeste);

        VoltarTelaProvaNivel=findViewById(R.id.imageButtonVoltarTelaRealizeProvaNivel);
        TextViewPontosTeste=findViewById(R.id.textViewPontosTeste);
        TextViewPerguntaTeste=findViewById(R.id.textViewPerguntaTeste);

    }
  private void updateQuestao(int num){
        TempoQuestoes();

        TextViewPerguntaTeste.setText(QuestoesT.getQuestoesT(num));
        BotaoPrimeiraAlternativaTeste.setText(QuestoesT.getPrimeiraAlternativa(num));
        BotaoSegundaAlternativaTeste.setText(QuestoesT.getSegundaAlternativa(num));
        BotaoTerceiraAlternativaTeste.setText(QuestoesT.getTerceiraAlternativa(num));
        BotaoQuartaAlternativaTeste.setText(QuestoesT.getQuartaAlternativa(num));
        BotaoQuintaAlternativaTeste.setText(QuestoesT.getQuintaAlternativa(num));

        TesteRespostas = QuestoesT.getTesteRespostas(num);
        //tentativa++;

    }

    private void ErroQuestoes(){

        Toast.makeText(getApplicationContext(),"Incorreta",Toast.LENGTH_SHORT).show();
    }
    public void TempoQuestoes() {

        int delay_ms = 30000;
        new Handler().postDelayed(()->{
           updateQuestao(r.nextInt(QuestoesTesteLenght));

        },delay_ms);
      /*    try {
          while (tentativa==10){
                if(pontos<5){
                    Intent nivel = new Intent(getApplicationContext(), ActivityNivel.class);
                    nivel.putExtra("nivelA", pontos);
                    startActivity(nivel);
                    Log.e("nivel", "ValidaNivelA: " + tentativa);

                     finish();
                }else if(pontos>=6){
                    Intent nivel = new Intent(getApplicationContext(), ActivityNivel.class);
                    nivel.putExtra("nivelB", pontos);
                    Log.e("nivel", "ValidaNivelB: " + pontos);
                    startActivity(nivel);
                     finish();
                }
                else { Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);

                } }}catch (Exception e ){ Toast.makeText(getApplicationContext(),
                "Continue tentando!",
                Toast.LENGTH_SHORT).show();

        }
    }*/

    /* public void Nivel(){
       if( tentativa >= 10) {
            Intent nivel = new Intent(getApplicationContext(), ActivityNivel.class);
            nivel.putExtra("nivelA", contador);
            //ImageViewTelaNivel.setImageResource(R.drawable.nivel_a);
            startActivity(nivel);
        } else if ( tentativa == 10 && contador > 4){


            Intent nivelB = new Intent(getApplicationContext(), ActivityNivel.class);
            nivelB.putExtra("nivelB" , contador);
            //ImageViewTelaNivel.setImageResource(R.drawable.nivel_a);
            startActivity(nivelB);

        }

         if(pontos<=7){
            Intent intent = new Intent(getApplicationContext(), ActivityNivel.class);
            intent.putExtra("nivelB",pontos);
            startActivity(intent);
            //ImageViewTelaNivel.setImageResource(R.drawable.nivel_b);

        }else if( pontos>8){
            Intent intent = new Intent(getApplicationContext(), ActivityNivel.class);
            intent.putExtra("nivelC" ,pontos);
            startActivity(intent);
            // ImageViewTelaNivel.setImageResource(R.drawable.nivel_b);

        }else{
            Toast.makeText(getApplicationContext(),"Erro pontos não encontrados",Toast.LENGTH_SHORT).show();
        }*/
        }


    
}