package com.example.activity_array_adaptator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlaneteActivity extends AppCompatActivity {

    EditText id_Identifiant, id_name, id_rayon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_planete);
        id_Identifiant = findViewById(R.id.id_Identifiant);
        id_name = findViewById(R.id.id_name);
        id_rayon = findViewById(R.id.id_rayon);
    }

    public void retourner(View view) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    public void valider(View view) {
        //1-creation d'une instance de type MydatabaseManager
        try {
            //3-recuperer les valeurs relatifs aux attributs d'une planete :
            int id = Integer.parseInt(id_Identifiant.getText().toString());
            String name = id_name.getText().toString();
            String rayon = id_name.getText().toString();

            //4-appeler la methode insert pour la nouvelle planete à la base de données
            if (MainActivity.Myconnection.insert(id, name, rayon) == 0) {
                Toast.makeText(this, "Aucune planete n'est ajoutée", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Planete ajoutée avec succès", Toast.LENGTH_SHORT).show();
                Intent i = new Intent();
                setResult(Activity.RESULT_OK);
                //finish();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "get numeric value", Toast.LENGTH_SHORT).show();
        }catch (SQLiteException e) {
            Toast.makeText(this, "Check your connection to your database", Toast.LENGTH_SHORT).show();
        }
    }
}