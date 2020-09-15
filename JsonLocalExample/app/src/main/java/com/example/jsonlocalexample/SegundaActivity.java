package com.example.jsonlocalexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    }

    public List<Estudante> consumirJson(){
        List<Estudante> estudantes=null;
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
