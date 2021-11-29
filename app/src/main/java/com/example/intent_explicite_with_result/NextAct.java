package com.example.intent_explicite_with_result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Button bFacile=findViewById(R.id.buttonFacile);
        Button bmoyenne=findViewById(R.id.buttonMoyenne);
        Button bDifficile=findViewById(R.id.buttonDifficile);


        bFacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retournerRésultat(RESULT_OK,"Niveau Facile");
            }
        });

        bmoyenne.setOnClickListener(v -> retournerRésultat(RESULT_OK,"Niveau Moyen"));

        bDifficile.setOnClickListener(v -> retournerRésultat(RESULT_OK,"Niveau Difficile"));

    }

    void retournerRésultat(int resCode, String res){
        Intent i= new Intent();
        i.putExtra("res",res);
        setResult(resCode,i);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        retournerRésultat(RESULT_CANCELED,"Aucun niveau de difficulté sélectionné");

    }
}