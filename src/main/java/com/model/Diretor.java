package com.model;

public class Diretor extends Cargo {
    String projetosEstratégicos;



    public Diretor(){}

    
    public Diretor(String projetosEstratégicos) {
        this.projetosEstratégicos = projetosEstratégicos;
    }


    public String getProjetosEstratégicos() {
        return projetosEstratégicos;
    }

    public void setProjetosEstratégicos(String projetosEstratégicos) {
        this.projetosEstratégicos = projetosEstratégicos;
    }

}
