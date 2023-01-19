package com.example.activity_array_adaptator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseOpenHelper extends SQLiteOpenHelper {
    public static final int BASE_VERSION=1;
    public static final String BASE_NOM="planetes.db";
    public static final String TABLE_PLANETES="table_planetes";
    public static final String COLONNE_ID="id";
    public static final int COLONNE_ID_ID=0;
    public static final String COLONNE_NOM="nom";
    public static final int COLONNE_NOM_ID=1;
    public static final String COLONNE_RAYON="rayon";
    public static final int COLONNE_RAYON_ID=2;
    public static final String REQUETE_CREATION_BD="create table "
            + TABLE_PLANETES + " ("+ COLONNE_ID +" integer primary key autoincrement ,"+ COLONNE_NOM +
    "text not null," +COLONNE_RAYON + "text not null);";

    public MyDatabaseOpenHelper(@Nullable Context context
                                ) {
        super(context,BASE_NOM,null,BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // cette méthode onCreate sera appelé à la suite de la création de la BD
        // ceci execute la syntaxe SQL de création de la table unique de notre BD
        sqLiteDatabase.execSQL(REQUETE_CREATION_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //cette méthode onUpgrade est appelé suite à la mise à niveau de l'application (BD)
        //alors , on supprime la table unique existante et on la crée
    sqLiteDatabase.execSQL("drop table" + TABLE_PLANETES +";");
    onCreate(sqLiteDatabase);
    }

}

