/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rj
 */
public class ConexaoUtil {
    
    //aplicação do singleton
    private static ConexaoUtil conexaoUtil;
    
    public static ConexaoUtil getInstance()throws Exception{
        if(conexaoUtil == null){
            conexaoUtil = new ConexaoUtil();
        }
        return conexaoUtil;
    }
    public Connection getConnection()throws Exception{
        Class.forName("org.postgresql.Driver");
        System.out.println("Conexão deu boa!");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/trabalho", "postgres", "12345");
    }
    
    public static void main(String[]args){
        try{
            System.out.println(getInstance().getConnection());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}