package com.example.jsonlocalexample;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends AppCompatActivity {
    private String json;
    private ListView listView;
    private List<Estudante> lista;
    private ArrayAdapter<Estudante> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        json=getIntent().getStringExtra("dados");
        listView=findViewById(R.id.listView);
        lista=consumirJson();
        adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"(CLICK) Aluno: "+lista.get(position).getNome()+"\nNota:"+lista.get(position).getNota(),Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Toast.makeText(getApplicationContext(),"(LONG CLICK) Aluno: "+lista.get(pos).getNome()+"\nNota:"+lista.get(pos).getNota(),Toast.LENGTH_LONG).show();

                return true;
            }
        });

    }

    public List<Estudante> consumirJson(){
        List<Estudante> estudantes=new ArrayList<>();
        try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray array = jsonObject.getJSONArray("estudantes");
        for(int i=0;i<array.length();i++){
        JSONObject obj=array.getJSONObject(i);

                Estudante estudante=new Estudante(obj.getString("nome"),obj.getString("disciplina"),obj.getDouble("nota"));
                estudantes.add(estudante);

            }}
        catch (JSONException ex){
            ex.printStackTrace();
            }
        return  estudantes;
        }

    }
