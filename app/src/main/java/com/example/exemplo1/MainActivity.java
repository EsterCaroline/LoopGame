package com.example.exemplo1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplo1.Modelos.Questoes;
import com.example.exemplo1.Modelos.Usuario;
import com.example.exemplo1.database.BancoSQLite;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String[] arrayDicas={" Você pode criar algoritmos para priorizar suas tarefas, organizar trabalhos e tornar os caminhos menos complicados.",
            "Aprender sobre estrutura fará você ter um melhor planejamento para focar no seu problema e ter softwares mais eficientes" +
                    "","Na programação temos diversos caminhos para resolver problemas",
            "talvez outra pessoa tenha solucionado seu problema de um jeito simples e que você não tinha pensado.",
            "O raciocínio lógico desperta a habilidade de organizar informações, analisá-las e solucionar problemas.",
            "algoritmos são um conjunto de passos definidos para gerar um resultado."};
    int indice =-1;
    Button BotaoJogarHome,BotaoSairHome;
    TextView TexviewPontosHome,TextViewNomeJogadorHome,TextViewPrimeiroJogadorHome,
            TextViewSegundoJogadorHome,TextViewTerceiroJogadorHome,
            TextViewQuartoJogadorHome,TextViewQuintoJogadorHome,
            TextViewSextoJogadorHome, TextViewDicaHome;

    String id;
    String nome;
    boolean teste = true ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VinculoComponentes();
        EventosClicar();
        PassarDicas();
        ValidarTeste();

      BancoSQLite db= new BancoSQLite(this);
      Usuario usuario =db.selecionarUsuarioporID("1");

      // Intent intent =getIntent();
        Bundle intent =getIntent().getExtras();
        nome =intent.getString("nome");
        TextViewNomeJogadorHome.setText(nome);
        Log.e("*", "onCreate: "+ nome);

     //   Bundle nivel =getIntent().getExtras();
      //  pontos = nivel.getInt("nivelA");
      //  TexviewPontosHome.setText(mPontos);



       // TextViewNomeJogadorHome.setText(usuario.getLogin());
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        BotaoSairHome.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick (View view) {

                dialog.setTitle("Sair");
                dialog.setMessage("Tem certeza que deseja sair do jogo");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i) {

                        Intent it = new Intent(getApplicationContext() , ActivityLogin.class);
                        startActivity(it);
                    }
                });
                dialog.setNegativeButton("não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.create();
                dialog.show();
            }
        });



    }
   public void ProximaTela (Class x){
        Intent it = new Intent(getApplicationContext() , x);
        startActivity(it);
    }

    public void Dicas(){
        if(indice < 5){ indice= indice +1;
            Log.d("indice",String.valueOf(indice));}
        TextViewDicaHome=findViewById(R.id.textViewDicaHome);
        TextViewDicaHome.setText(arrayDicas[indice]);

        PassarDicas();

         }
    public void PassarDicas() {

    int delay_ms = 20000;
    new Handler().postDelayed(()->{
        Dicas();
    },delay_ms);

    }

    private void EventosClicar() {

        BotaoJogarHome.setOnClickListener(evt -> ProximaTela(ActivityQuestoes.class));
        // BotaoSairHome.setOnClickListener(evt->ProximaTela(ActivityLogin.class));

    }
        private void VinculoComponentes () {
            TextViewPrimeiroJogadorHome = findViewById(R.id.textViewPrimeiroJogadorHome);
            TextViewSegundoJogadorHome = findViewById(R.id.textViewSegundoJogadorHome);
            TextViewTerceiroJogadorHome = findViewById(R.id.textViewTerceiroJogadorHome);
            TextViewQuartoJogadorHome = findViewById(R.id.textViewQuartoJogadorHome);
            TextViewQuintoJogadorHome = findViewById(R.id.textViewQuintoJogadorHome);
            TextViewSextoJogadorHome = findViewById(R.id.textViewSextoJogadorHome);
            TextViewDicaHome = findViewById(R.id.textViewDicaHome);
            TexviewPontosHome = findViewById(R.id.textViewPontosHome);
            TextViewNomeJogadorHome = findViewById(R.id.textViewNomeJogadorHome);

            BotaoJogarHome = findViewById(R.id.btnJogarHome);
            BotaoSairHome = findViewById(R.id.btnSairHome);

        }

    public boolean ValidarTeste() {
       BancoSQLite db = new BancoSQLite(this);
        try {
            // Usuario usuario= db.selecionarUsuario(EditTextUsuarioLogin.getText().toString());
            if (teste == false) {
                Intent intent = new Intent(getApplicationContext(), ActivityIniciarTeste.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "usuario ja fez o teste", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Usuario  fez o teste!", Toast.LENGTH_SHORT).show();
        }
        return teste=true;
    }

   /*


        }
    }*/

    }