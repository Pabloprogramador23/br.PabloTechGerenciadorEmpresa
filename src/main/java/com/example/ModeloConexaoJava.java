package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.naming.spi.DirStateFactory.Result;

public class ModeloConexaoJava {

    static void consultaDados (Statement stmConsulta){
        //Statemente é o modo pra colocar informação dentro do banco de dados 

        //nessa query vai armazenar o comando sql pra ser executado pelo banco de dados 
        String querry = "SELECT INFORMAÇÕES, DATABELA FROM NOME_TABELA";
        try {
            //stmConsulta.executeQuery(querry) vai executar o comando e vai armazernar no result
            //esse result é comando do sql que vai passando pela tabela e fornecendo o resultado dos 
            //objetos

        ResultSet result = stmConsulta.executeQuery(querry);
            //o while vai fazer o result andar pela tabela imprimindo os coisas
            while (result.next()) {
            System.out.println("id Funcioário:" + result.getInt(0)+"nome: "+result.getString(0));
    
}

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 

    }

    static void colocaDados (Statement stm) {

        //essa é a syntax que o sql entende, a gente coloca ela dentro de uma váriavel 
        //assim é como se aquela variavel guardasse aquela "carta"
                //onde tem nome e Pablo é o nome da variavel na tabela e a alteração 
        String inseriSql = "insert into usuario (nome) values (Pablo)";

        try {
            //esse . executeUpdate é pra poder fazer a alteração 
            stm.executeUpdate(inseriSql);
            
        } catch (Exception e) {
            e.printStackTrace();

            // TODO: handle exception
        }


    }
   


    public static void ConectarDB(){

      String urlDB = "jdbc:postgresql://localhost:5432/postgres";
      String userDB = "postgres";
      String passwordDB = "7412369";


        try {
            // essa linha vai ser responsavel por "logar"
            Connection conex = DriverManager.getConnection(urlDB, userDB, passwordDB);

            if (conex !=null ) {
                //abaixo vai nos mostrar que a conexão foi estabelecida

                System.out.println(" logado!!");
                //abaixo foi criado o Statement pra poder ser usado o metódo consultaDados.
                //esse metodo consiste em inserir uma query no banco de dado que vai ler num while
                //todos os objetos daquela tabela  
               // Statement stm = conex.createStatement();
                //colocaDados(stm);// <-chamada do metodo de colocar Dados
                //consultaDados(stm);// <-chamada do metodo de consultar Dados com um loop While
            
            } else{
                System.out.println("conecção falhou :()");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       }
    }   
     
}
        
