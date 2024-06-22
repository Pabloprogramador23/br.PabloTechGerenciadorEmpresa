package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Conexao.ModeloConexaoJava;
import com.model.Funcionario;

public class Main {
    public static void main(String[] args) {
        ModeloConexaoJava conexaoJava = new ModeloConexaoJava();
        List<Funcionario> funcionários = new ArrayList<>();
        //List<Empresa> empresas = new ArrayList<>();
        //List<Departamento> departamentos = new ArrayList<>();
        Scanner s = new Scanner(System.in);


        
        conexaoJava.ConectarDB();

        int continuar;

        do {
            System.out.println("Bom dia usuário, escolha qual opção deseja:");
            System.out.println("1 - Criar novo Funcionário");
            System.out.println("2 - Criar nova Empresa");
            System.out.println("3 - Criar novo Departamento");
            System.out.println("4 - Consultar Funcionários");
            System.out.println("5 - Consultar Empresas");
            System.out.println("6 - Consultar Departamentos");
            System.out.println("0 - Sair");

            int opcao = s.nextInt();
            s.nextLine(); // Limpar o buffer
            
            switch (opcao) {

                case 1:
                
                Funcionario novoFuncionario = new Funcionario();
                novoFuncionario.criarFuncionario(s);
                novoFuncionario.salvarFuncionarioBD(); // Salva o funcionário no banco de dados
                    break;

                case 2:
                    // Método para criar empresa
                    break;

                case 3:
                    // Método para criar departamento
                    break;

                case 4:

                
                    Funcionario.consultarFuncionarios();
                    imprimirFuncionarios(funcionários);
                    break;

                case 5:
                    // Método para consultar empresas
                    break;

                case 6:
                    // Método para consultar departamentos
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;


                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println("Deseja continuar? (1 - Sim / 0 - Não)");
            continuar = s.nextInt();
            s.nextLine(); // Limpar o buffer

        } while (continuar == 1);

        System.out.println("Fim do programa.");
        s.close();
    }

  

    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {

        System.out.println(funcionarios);
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirFuncionarios'");
    }

   

    
}
