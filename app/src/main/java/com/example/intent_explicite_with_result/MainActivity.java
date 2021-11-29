package com.example.intent_explicite_with_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int LEVEL_SELECTION_REQUEST_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bOpen=findViewById(R.id.buttonOpen);
        bOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(), NextAct.class);
                startActivityForResult(i,LEVEL_SELECTION_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LEVEL_SELECTION_REQUEST_CODE){
            if(resultCode== RESULT_OK){
                //View tvRes= findViewById(R.id.tv_res);
                //tvRes.se
                String res= data.getStringExtra("res");
                Log.d(MainActivity.class.getSimpleName(),res);
            }
            else
                if(resultCode== RESULT_CANCELED){
                    //Log.d(MainActivity.class.getSimpleName(),res);
                    Toast.makeText(this,"aucune sélection", Toast.LENGTH_LONG).show();
                    String res= data.getStringExtra("res");

                    Log.d(MainActivity.class.getSimpleName(),res);

                }
        }

    }
}