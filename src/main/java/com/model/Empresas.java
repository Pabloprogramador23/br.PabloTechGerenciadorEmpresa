package com.model;

import com.Enumeration.TipoRamos;

public class Empresas {
    private String nmEmpresa;
    private int cdEmpresa;
    private TipoRamos tipoRamos;


    
    public Empresas(String nmEmpresa, int cdEmpresa, TipoRamos tipoRamos) {
        this.nmEmpresa = nmEmpresa;
        this.cdEmpresa = cdEmpresa;
        this.tipoRamos = tipoRamos;
    }
    public String getNmEmpresa() {
        return nmEmpresa;
    }
    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }
    public int getCdEmpresa() {
        return cdEmpresa;
    }
    public void setCdEmpresa(int cdEmpresa) {
        this.cdEmpresa = cdEmpresa;
    }
    public TipoRamos getTipoRamos() {
        return tipoRamos;
    }
    public void setTipoRamos(TipoRamos tipoRamos) {
        this.tipoRamos = tipoRamos;
    }

}
