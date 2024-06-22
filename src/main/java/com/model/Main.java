package com.model;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
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
                    Funcionario novoFuncionario = Funcionario.criarFuncionario(s);
                    novoFuncionario.salvarFuncionarioBD(); // Salva o funcionário no banco de dados
                    break;

                case 2:
                    Empresa novaEmpresa = Empresa.criarEmpresa(s);
                    novaEmpresa.salvarEmpresaBD();
                    break;

                case 3:
                    Departamento novoDepartamento = Departamento.criarDepartamento(s);
                    novoDepartamento.salvarDepartamentoBD();
                    break;

                case 4:
                    List<Funcionario> funcionarios = Funcionario.consultarFuncionarios();
                    Funcionario.imprimirFuncionarios(funcionarios);
                    break;

                case 5:
                    List<Empresa> empresas = Empresa.consultarEmpresas();
                    Empresa.imprimirEmpresas(empresas);
                    break;

                case 6:
                    List<Departamento> departamentos = Departamento.consultarDepartamentos();
                    Departamento.imprimirDepartamentos(departamentos);
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
}
