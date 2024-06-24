package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Departamento {
    private int cdDepartamento;
    private String nmDepartamento;
   // private  Empresa nomeEmpresa; 

    

    public Departamento() {
        // Construtor vazio
    }

    public Departamento(int cdDepartamento, String nmDepartamento) {
        this.cdDepartamento = cdDepartamento;
        this.nmDepartamento = nmDepartamento;
    }

    public static Departamento criarDepartamento(Scanner s) {
        System.out.println("Digite o código do Departamento:");
        int cdDepartamento = s.nextInt();
        s.nextLine();

        System.out.println("Digite o nome do Departamento:");
        String nmDepartamento = s.nextLine();

        return new Departamento(cdDepartamento, nmDepartamento);
    }

    public void salvarDepartamentoBD() {
        String urlDB = "jdbc:postgresql://localhost:5432/postgres";
        String userDB = "postgres";
        String passwordDB = "7412369";

        String sql = "INSERT INTO departamentos (cdDepartamento, nmDepartamento) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cdDepartamento);
            stmt.setString(2, nmDepartamento);

            stmt.executeUpdate();
            System.out.println("Departamento inserido com sucesso no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir departamento no banco de dados: " + e.getMessage());
        }
    }

    public static List<Departamento> consultarDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();
        String urlDB = "jdbc:postgresql://localhost:5432/postgres";
        String userDB = "postgres";
        String passwordDB = "7412369";

        String sql = "SELECT * FROM departamentos";

        try (Connection conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cdDepartamento = rs.getInt("cdDepartamento");
                String nmDepartamento = rs.getString("nmDepartamento");

                Departamento departamento = new Departamento(cdDepartamento, nmDepartamento);
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar departamentos: " + e.getMessage());
        }

        return departamentos;
    }

    public static void imprimirDepartamentos(List<Departamento> departamentos) {
        for (Departamento departamento : departamentos) {
            System.out.println("Código: " + departamento.getCdDepartamento());
            System.out.println("Nome: " + departamento.getNmDepartamento());
            System.out.println("--------------------------");
        }
    }

    // Getters e Setters
    public int getCdDepartamento() {
        return cdDepartamento;
    }

    public void setCdDepartamento(int cdDepartamento) {
        this.cdDepartamento = cdDepartamento;
    }

    public String getNmDepartamento() {
        return nmDepartamento;
    }

    public void setNmDepartamento(String nmDepartamento) {
        this.nmDepartamento = nmDepartamento;
    }
    //public Empresa getNomeEmpresa() {
       // return nomeEmpresa;
   // }

   // public void setNomeEmpresa(Empresa nomeEmpresa) {
   //     this.nomeEmpresa = nomeEmpresa;
   // }
}
