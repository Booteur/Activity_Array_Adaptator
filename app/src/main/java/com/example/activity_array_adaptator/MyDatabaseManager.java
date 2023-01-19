package com.example.activity_array_adaptator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabaseManager {

    private SQLiteDatabase maBaseDonnees;
    private MyDatabaseOpenHelper baseHelper;
    public  MyDatabaseManager(Context ctx){
        baseHelper = new MyDatabaseOpenHelper(ctx);

    }
    public void open(){
        // ouvrir la BD en mode Read/Write
        maBaseDonnees = baseHelper.getWritableDatabase();
       // return baseHelper.getWritableDatabase();
    }
    public void close(){
        baseHelper.close();
    }
    public long insert( int id ,String name , String rayon){
        ContentValues content = new ContentValues();
        content.put(MyDatabaseOpenHelper.COLONNE_ID,id);
        content.put(MyDatabaseOpenHelper.COLONNE_NOM,name);
        content.put(MyDatabaseOpenHelper.COLONNE_RAYON,rayon);
        return  maBaseDonnees.insert(MyDatabaseOpenHelper.TABLE_PLANETES,null,content);
    }
    public long update (int id , String name , String rayon){
        ContentValues content = new ContentValues();
        content.put(MyDatabaseOpenHelper.COLONNE_ID,id);
        content.put(MyDatabaseOpenHelper.COLONNE_NOM,name);
        content.put(MyDatabaseOpenHelper.COLONNE_RAYON,rayon);
        return maBaseDonnees.update(MyDatabaseOpenHelper.TABLE_PLANETES,content,MyDatabaseOpenHelper.COLONNE_ID + " = " +id,null);
    }
    /**
     * This method may delete one existed line from Database
     * id
     * return
     */
    public long detele (int id){
        return maBaseDonnees.delete(MyDatabaseOpenHelper.TABLE_PLANETES,MyDatabaseOpenHelper.COLONNE_ID + " = " +id,null);

    }
    public Cursor getPlanete (String nom){
        Cursor c = maBaseDonnees.rawQuery("Select * from " +MyDatabaseOpenHelper.TABLE_PLANETES+ " where "+ MyDatabaseOpenHelper.COLONNE_NOM + " = '" +
                nom +"'",null);
    return  c;
    }

    public Cursor getAllPlanetes () {
        Cursor c = maBaseDonnees.rawQuery("Select * from " + MyDatabaseOpenHelper.TABLE_PLANETES, null);
        return c;
    }

}

