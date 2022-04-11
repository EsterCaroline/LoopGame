package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityIniciarTeste extends AppCompatActivity {
 Button BotaoIniciarTesteNivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarteste);

        BotaoIniciarTesteNivel=findViewById(R.id.btnIniciarProvaNivel);


        BotaoIniciarTesteNivel.setOnClickListener(view -> {
            Intent it = new Intent(getApplicationContext(), ActivityTesteNivel.class);
            startActivity(it);
        });


    }
}