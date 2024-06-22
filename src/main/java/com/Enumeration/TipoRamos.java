package com.Enumeration;

public enum TipoRamos {
    
    ALIMENTICIO(1),
    ELETRODOMESTICOS(2),
    FINANCEIRO(3),
    TECNOLOGIA(4);

    private int value;

    private TipoRamos(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static TipoRamos definirTipoRamos(int value) {
        for (TipoRamos tipo : TipoRamos.values()) {
            if (tipo.getValue() == value) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}