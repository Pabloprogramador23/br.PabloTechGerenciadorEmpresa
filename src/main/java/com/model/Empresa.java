package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Empresa {
    private String nmEmpresa;
    private int code;
    private String tipoRamos;
    private String endEmpresa;

    public Empresa(){}

    public Empresa(String nmEmpresa, int code, String tipoRamos, String endEmpresa) {
        this.nmEmpresa = nmEmpresa;
        this.code = code;
        this.tipoRamos = tipoRamos;
        this.endEmpresa = endEmpresa;
    }
 public void salvarEmpresaBD() {
        String urlDB = "jdbc:postgresql://localhost:5432/postgres";
        String userDB = "postgres";
        String passwordDB = "7412369";

        String sql = "INSERT INTO empresas (code, nmEmpresa, endEmpresa, tipoRamos) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, code);
            stmt.setString(2, nmEmpresa);
            stmt.setString(3, endEmpresa);
            stmt.setString(4, tipoRamos);

            stmt.executeUpdate();
            System.out.println("Empresa inserida com sucesso no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir empresa no banco de dados: " + e.getMessage());
        }
    }

public static List<Empresa> consultarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        String urlDB = "jdbc:postgresql://localhost:5432/postgres";
        String userDB = "postgres";
        String passwordDB = "7412369";

        String sql = "SELECT * FROM empresas";

        try (Connection conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int code = rs.getInt("code");
                String nmEmpresa = rs.getString("nmEmpresa");
                String endEmpresa = rs.getString("endEmpresa");
                String tipoRamos = rs.getString("tipoRamos");

                Empresa empresa = new Empresa(nmEmpresa, code, tipoRamos, endEmpresa);
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar empresas: " + e.getMessage());
        }

        return empresas;
    }


    public static void imprimirEmpresas(List<Empresa> empresas) {
        for (Empresa empresa : empresas) {
            System.out.println("Código: " + empresa.getCode());
            System.out.println("Nome: " + empresa.getNmEmpresa());
            System.out.println("Endereço: " + empresa.getEndEmpresa());
            System.out.println("Ramo: " + empresa.getTipoRamos());
            System.out.println("--------------------------");
        }
    }




    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTipoRamos() {
        return tipoRamos;
    }

    public void setTipoRamos(String tipoRamos) {
        this.tipoRamos = tipoRamos;
    }

    public String getEndEmpresa() {
        return endEmpresa;
    }

    public void setEndEmpresa(String endEmpresa) {
        this.endEmpresa = endEmpresa;
    }
    
    
    

}
