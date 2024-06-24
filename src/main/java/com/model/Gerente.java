package com.model;

public class Gerente extends Cargo {
    int numeroSubordinados; 
    String projetosSpervisionados;

    public Gerente(){}

    
    public Gerente(int numeroSubordinados, String projetosSpervisionados) {
        this.numeroSubordinados = numeroSubordinados;
        this.projetosSpervisionados = projetosSpervisionados;
    }





    public int getNumeroSubordinados() {
        return numeroSubordinados;
    }

    public void setNumeroSubordinados(int numeroSubordinados) {
        this.numeroSubordinados = numeroSubordinados;
    }

    public String getProjetosSpervisionados() {
        return projetosSpervisionados;
    }

    public void setProjetosSpervisionados(String projetosSpervisionados) {
        this.projetosSpervisionados = projetosSpervisionados;
    }

    
}
