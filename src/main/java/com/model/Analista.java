package com.model;

public class Analista extends Cargo {
    String areasEspecialização;
    int nivelExperiencia;

    public Analista(){}


    public Analista(String areasEspecialização, int nivelExperiencia) {
        this.areasEspecialização = areasEspecialização;
        this.nivelExperiencia = nivelExperiencia;
    }






    public String getAreasEspecialização() {
        return areasEspecialização;
    }
    public void setAreasEspecialização(String areasEspecialização) {
        this.areasEspecialização = areasEspecialização;
    }
    public int getNivelExperiencia() {
        return nivelExperiencia;
    }
    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    } 
}
