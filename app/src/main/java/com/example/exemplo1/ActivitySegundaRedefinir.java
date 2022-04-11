package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ActivitySegundaRedefinir extends AppCompatActivity {


    ImageButton ImageButtonVoltarRedefinir;
    Button BotaoRedefinirSegundaTelaRedefinir;
    EditText EditTextCodigoSegundaTelaRedefinir, EditTextSenhaSegundaTelaRedefinir,
            EditTextConfirmaSenhaSegundaTelaRedefinir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaredefinir);

        BotaoRedefinirSegundaTelaRedefinir=findViewById(R.id.btnRedefinirSegundaTelaRedefinir);
        BotaoRedefinirSegundaTelaRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(it);
            }
        });
        ImageButtonVoltarRedefinir=findViewById(R.id.imageButtonVoltarTelaRedefinir);
        ImageButtonVoltarRedefinir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ActivityRedefinir.class);
                startActivity(it);
            }
        });

        EditTextCodigoSegundaTelaRedefinir=findViewById(R.id.editTextCodigoSegundaTelaRedefinir);
        EditTextSenhaSegundaTelaRedefinir=findViewById(R.id.editTextSenhaSegundaTelaRedefinir);
        EditTextConfirmaSenhaSegundaTelaRedefinir=findViewById(R.id.editTextConfirmaSenhaSegundaTelaRedefinir);

    }
}