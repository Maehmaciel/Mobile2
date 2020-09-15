package com.example.jsonlocalexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtNota,edtAluno,edtDisciplina;
    private Button btnAdicionar, btnConsumir,btnGerar;
    private List<Estudante> lista;
    private  TextView txtResultado;
    private String retorno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResultado=findViewById(R.id.txtResultado);
        btnAdicionar=findViewById(R.id.btnAdicionar);
        btnConsumir=findViewById(R.id.btnConsumir);
        btnGerar=findViewById(R.id.btnGerar);
        edtNota=findViewById(R.id.edtNota);
        edtAluno=findViewById(R.id.edtAluno);
        edtDisciplina=findViewById(R.id.edtDisciplina);
        lista=new ArrayList<>();

    }

    public void criarLista(View v){
        lista.add(new Estudante(edtAluno.getText().toString(),edtDisciplina.getText().toString(),Double.parseDouble(edtNota.getText().toString())));

    }

    public String criarJson() {
        JSONArray jsonArray= new JSONArray();
        for(Estudante e : lista){
            JSONObject obj = new JSONObject();
            try {
                obj.put("nome",e.getNome());
                obj.put("disciplina",e.getDisciplina());
                obj.put("nota",e.getNota());
                jsonArray.put(obj);
            }catch (JSONException ex){
                ex.printStackTrace();
            }

        }
        return "{estudantes:"+jsonArray.toString()+"}";
    }

    public void gerarJson(View v){
        retorno =criarJson();
        txtResultado.setText(retorno);
    }
    public void abrirtela(View v){
        Intent it = new Intent(getApplicationContext(),SegundaActivity.class);
        it.putExtra("dados",retorno);
        startActivity(it);
    }
}
