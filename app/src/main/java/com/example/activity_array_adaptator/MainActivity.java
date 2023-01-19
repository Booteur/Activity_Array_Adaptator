package com.example.activity_array_adaptator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
static final int REQUEST_CODE = 100;
   public static MyDatabaseManager Myconnection;
   ListView listPlanet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPlanet = findViewById(R.id.list_planetes);

        Myconnection = new MyDatabaseManager(this);

        //2-ouvrir la connection vers la base de données en mode read/write
        Myconnection.open();
        //rafraichir la liste des planetes
        //refreshPlanetList();

    }
    public void add(View view){
        Intent i = new Intent(this,AddPlaneteActivity.class);
        startActivityForResult(i,REQUEST_CODE);
    }
    public void refreshPlanetList(){
        // remplissage de la liste
        //1-recuperer le curseur contenant les lignes de la table auprès de la base de données

        Cursor result = Myconnection.getAllPlanetes();

        //2-creer un cursorAdaptor pour ramener les données auprès du curseur
        SimpleCursorAdapter myadapter = new SimpleCursorAdapter(this, R.layout.model_liste_planetes,result
        ,new String[]{MyDatabaseOpenHelper.COLONNE_ID,
        MyDatabaseOpenHelper.COLONNE_NOM,MyDatabaseOpenHelper.COLONNE_RAYON},new int[]{
                R.id.id_tv,R.id.nom_tv,R.id.rayon_tv
        });

        //3- initialiser les adaptateurs de la liste par celui recemment crée

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== REQUEST_CODE && resultCode== Activity.RESULT_OK){
            refreshPlanetList();
        }
    }
}