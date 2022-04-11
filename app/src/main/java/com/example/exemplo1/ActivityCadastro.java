package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplo1.Modelos.Usuario;
import com.example.exemplo1.database.BancoSQLite;

public class ActivityCadastro extends AppCompatActivity {

   Button BotaoVoltarLoginCadastro,BotaoValidarCadastro;
   EditText EditTextNomeCadastro,EditTextSenhaCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditTextNomeCadastro=findViewById(R.id.editTextNomeCadastro);
        EditTextSenhaCadastro=findViewById(R.id.editTextSenhaCadastro);
        BotaoVoltarLoginCadastro=findViewById(R.id.btnVoltarLoginCadastro);
        BotaoValidarCadastro=findViewById(R.id.btnValidarCadastro);


        BotaoVoltarLoginCadastro.setOnClickListener(view -> {
            Intent it = new Intent(getApplicationContext(), ActivityLogin.class);
            startActivity(it);
        });


        BotaoValidarCadastro.setOnClickListener(view ->  {

            BancoSQLite db= new BancoSQLite(this);

          if (db.inserirUsuario(
                  new Usuario(
                          EditTextNomeCadastro.getText().toString(),
                          EditTextSenhaCadastro.getText().toString()))
          ){
        Toast.makeText(this,"usuario cadastrado com sucesso!",Toast.LENGTH_SHORT).show();}
        else{
                  Toast.makeText(this,"Não foi possivel realizar cadastro",Toast.LENGTH_SHORT).show();
              }

    });

    }
}