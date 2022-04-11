package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplo1.Modelos.Usuario;
import com.example.exemplo1.database.BancoSQLite;

public class ActivityLogin extends AppCompatActivity {

    Button BotaoCadastroLogin,BotaoRedefinirSenhaLogin,BotaoLogin;
    EditText EditTextUsuarioLogin,EditTextSenhaLogin;
    public int pontos=0;
    public int teste = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      VinculoComponentes();
      EventosClicar();
      BotaoLogin.setOnClickListener(view->{
            BancoSQLite db = new BancoSQLite(this);
                    try {
                        Usuario usuario= db.selecionarUsuario(EditTextUsuarioLogin.getText().toString());
                        if(usuario.getSenha().equals(EditTextSenhaLogin.getText().toString()))
                        {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("nome",usuario.getLogin());
                            startActivity(intent);
                        }else {
                            Toast.makeText(this,"usuario não cadastrado",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        Toast.makeText(this,"Usuario não cadastrado!",Toast.LENGTH_SHORT).show();
                    }
        });
    }
    public void ProximaTela (Class x){
        Intent it = new Intent(getApplicationContext() , x);
        startActivity(it);
    }
  private void EventosClicar(){
        BotaoCadastroLogin.setOnClickListener(evt->ProximaTela(ActivityCadastro.class));
        BotaoRedefinirSenhaLogin.setOnClickListener(evt->ProximaTela(ActivityRedefinir.class));
    }
    private void VinculoComponentes(){
        BotaoCadastroLogin= findViewById(R.id.btnCadastroLogin);
        BotaoLogin =findViewById(R.id.btnLogin);
        BotaoRedefinirSenhaLogin=findViewById(R.id.btnRedefinirSenhaLogin);
        EditTextUsuarioLogin=findViewById(R.id.editTextUsuarioLogin);
        EditTextSenhaLogin=findViewById(R.id.editTextSenhaLogin);

    }

}