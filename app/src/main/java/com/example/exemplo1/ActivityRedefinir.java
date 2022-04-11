package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class ActivityRedefinir extends AppCompatActivity {
Button BotaoEnviarRedefinir;
ImageButton ImageButtonVoltarLoginRedefinir;
EditText EditTextEmailRedefinir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefinir);

        BotaoEnviarRedefinir=findViewById(R.id.btnEnviarRedefinir);
        BotaoEnviarRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ActivitySegundaRedefinir.class);
                startActivity(it);
            }
        });
        ImageButtonVoltarLoginRedefinir=findViewById(R.id.imageButtonVoltarLoginRedefinir);
        ImageButtonVoltarLoginRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(it);

            }
        });

        EditTextEmailRedefinir=findViewById(R.id.editTextEmailRedefinir);

    }
}