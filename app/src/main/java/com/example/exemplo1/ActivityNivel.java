package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityNivel extends AppCompatActivity {
   Button BotaoContinuarTelaNivel;
   ImageView ImageViewTelaNivel;
    int nivel;
   // int nivelB =getIntent().getExtras().getInt("nivelB");
   // int nivelA =getIntent().getExtras().getInt("nivelA");
    //int nivelC =getIntent().getExtras().getInt("nivelC");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telanivel);

        BotaoContinuarTelaNivel=findViewById(R.id.btnContinuarHomeTelaNivel);
        BotaoContinuarTelaNivel.setOnClickListener(view -> {
            Intent it= new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
        });


       ImageViewTelaNivel=findViewById(R.id.imageViewTelaNivel);

        Bundle intent =getIntent().getExtras();
        nivel=intent.getInt("nivelA");
        ImageViewTelaNivel.setImageResource(R.drawable.nivel_b);

         /*    if (nivelA == nivel){
        nivelA = intent.getInt("nivelA");
        ImageViewTelaNivel.setImageResource(R.drawable.nivel_a);
        Log.e("*", "onCreate: " + nivelA);
            }
            else if (nivel== nivelB){
        nivelB =intent.getInt("nivelB");
        ImageViewTelaNivel.setImageResource(R.drawable.nivel_b);
        Log.e("*", "onCreate: "+ nivelB);
            }
         else {
        nivelC = intent.getInt("nivelC");
        ImageViewTelaNivel.setImageResource(R.drawable.nivel_c);
        Log.e("*", "onCreate: " + nivelC);
         }






    /*   if(pontos<=4){
            Intent intent = new Intent(getApplicationContext(), ActivityNivel.class);
            intent.putExtra("nivelA",pontos);
            startActivity(intent);
           // ImageViewTelaNivel.setImageResource(R.drawable.nivel_a);

        }
        else if(pontos<=7){
            Intent intent = new Intent(getApplicationContext(), ActivityNivel.class);
            intent.putExtra("nivelB",pontos);
            startActivity(intent);
            //ImageViewTelaNivel.setImageResource(R.drawable.nivel_b);

        }else if(pontos>8){
            Intent intent = new Intent(getApplicationContext(), ActivityNivel.class);
            intent.putExtra("nivelC" ,pontos);
            startActivity(intent);
           // ImageViewTelaNivel.setImageResource(R.drawable.nivel_c);

        }else{
           Toast.makeText(getApplicationContext(),"Erro pontos não encontrados",Toast.LENGTH_SHORT).show();
        }

*/

    }



}