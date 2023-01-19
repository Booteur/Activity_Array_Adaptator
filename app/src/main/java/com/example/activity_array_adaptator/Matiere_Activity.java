package com.example.activity_array_adaptator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Matiere_Activity extends AppCompatActivity {

    private String matieres[]={"Java POO","Base de données","Android Mobile","Java C#"};
    private String noteJava_POO[]={"12.0", "10.5", "14.2", "16.5"};
    private String Base_De_Donnees[]={"5.5", "17.5", "15.2", "8.5"};
    private String Android_Mobile[]={"18.0", "10.5", "15.4", "16.5"};
    private String Java_CSharp[]={"5.5", "19.5", "11.5", "10.5"};
    private AutoCompleteTextView value_auto_tv;
    private ListView notes_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);
        value_auto_tv= findViewById(R.id.value_auto_tv);
        notes_list=findViewById(R.id.notes_list);
        ArrayAdapter<String> module_Adaptator = new ArrayAdapter<String>(this,R.layout.line_list_view_model,
                R.id.value_tv,matieres);
        value_auto_tv.setAdapter(module_Adaptator);
        value_auto_tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String val=value_auto_tv.getText().toString();
                try {
                    if(val.equals(matieres[0])){
                        ArrayAdapter<String> current_Adapter = new ArrayAdapter<String>(Matiere_Activity.this,
                                R.layout.line_list_view_model, R.id.value_tv,noteJava_POO);
                        notes_list.setAdapter(current_Adapter);
                    }
                    else if(val.equals(matieres[1])){
                        ArrayAdapter<String> current_Adapter1 = new ArrayAdapter<String>(Matiere_Activity.this,
                                R.layout.line_list_view_model, R.id.value_tv,Base_De_Donnees);
                        notes_list.setAdapter(current_Adapter1);
                    }
                    else if(val.equals(matieres[2])){
                        ArrayAdapter<String> current_Adapter2 = new ArrayAdapter<String>(Matiere_Activity.this,
                                R.layout.line_list_view_model, R.id.value_tv,Android_Mobile);
                        notes_list.setAdapter(current_Adapter2);
                    }
                    else if(val.equals(matieres[3])){
                        ArrayAdapter<String> current_Adapter3 = new ArrayAdapter<String>(Matiere_Activity.this,
                                R.layout.line_list_view_model, R.id.value_tv,Java_CSharp);
                        notes_list.setAdapter(current_Adapter3);
                    }
                }catch (Exception e){
                    Toast.makeText(Matiere_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}