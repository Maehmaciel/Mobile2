package com.example.jsonlocalexample;

public class Estudante {
    private String nome,disciplina;
    private double nota;

    public Estudante(String nome,String disciplina,double nota){
        this.nome=nome;
        this.disciplina=disciplina;
        this.nota=nota;
    }

    public Estudante(){}

    public String getNome(){
        return  this.nome;
    }
    public  String getDisciplina(){
        return this.disciplina;
    }
    public double getNota(){
        return this.nota;
    }
}
