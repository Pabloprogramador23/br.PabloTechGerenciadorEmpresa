package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {

    private int cdFuncionario;
    private String nmFuncionario;
    private LocalDate dtNascimento;
    private double salario;
    private String depart;
    private String cargo;

    public Funcionario() {
        // Construtor vazio
    }

    public Funcionario(int cdFuncionario, String nmFuncionario, LocalDate dtNascimento, double salario, String depart, String cargo) {
        this.cdFuncionario = cdFuncionario;
        this.nmFuncionario = nmFuncionario;
        this.dtNascimento = dtNascimento;
        this.salario = salario;
        this.depart = depart;
        this.cargo = cargo;
    }

    public static Funcionario criarFuncionario(Scanner s) {
        System.out.println("Digite o código do Funcionário:");
        int cdFuncionario = s.nextInt();
        s.nextLine();

        System.out.println("Digite o nome do Funcionário:");
        String nmFuncionario = s.nextLine();

        System.out.println("Digite o nome do Departamento:");
        String depart = s.nextLine();

        System.out.println("Digite o salário:");
        double salario = s.nextDouble();
        s.nextLine();

        System.out.println("Digite a data de Nascimento (dd/MM/yyyy):");
        String dataNascimentoStr = s.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dtNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        return new Funcionario(cdFuncionario, nmFuncionario, dtNascimento, salario, depart, "Gerente");
    }

    public void salvarFuncionarioBD() {
        String urlDB = "jdbc:postgresql://localhost:5432/postgres";
        String userDB = "postgres";
        String passwordDB = "7412369";

        String sql = "INSERT INTO funcionarios (cd_funcionario, nm_funcionario, dt_nascimento, salario, departamento, cargo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, cdFuncionario);
                stmt.setString(2, nmFuncionario);
                stmt.setDate(3, java.sql.Date.valueOf(dtNascimento));
                stmt.setDouble(4, salario);
                stmt.setString(5, depart);
                stmt.setString(6, cargo);

            stmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir funcionário no banco de dados: " + e.getMessage());
        }
    }

    public static List<Funcionario> consultarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String urlDB = "jdbc:postgresql://localhost:5432/postgres";
        String userDB = "postgres";
        String passwordDB = "7412369";

        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = DriverManager.getConnection(urlDB, userDB, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cdFuncionario = rs.getInt("cd_Funcionario");
                String nmFuncionario = rs.getString("nm_Funcionario");
                LocalDate dtNascimento = rs.getDate("dt_Nascimento").toLocalDate();
                double salario = rs.getDouble("salario");
                String depart = rs.getString("departamento");
                String cargo = rs.getString("cargo");

                Funcionario funcionario = new Funcionario(cdFuncionario, nmFuncionario, dtNascimento, salario, depart, cargo);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar funcionários: " + e.getMessage());
        }

        return funcionarios;
    }

    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Código: " + funcionario.getCdFuncionario());
            System.out.println("Nome: " + funcionario.getNmFuncionario());
            System.out.println("Departamento: " + funcionario.getDepart());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Data de Nascimento: " + funcionario.getDtNascimento());
            System.out.println("--------------------------");
        }
    }

    // Getters e Setters
    public int getCdFuncionario() {
        return cdFuncionario;
    }

    public void setCdFuncionario(int cdFuncionario) {
        this.cdFuncionario = cdFuncionario;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
