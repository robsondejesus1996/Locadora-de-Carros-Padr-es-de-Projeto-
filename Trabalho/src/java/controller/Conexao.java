/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.jms.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.jms.JMSException;
/**
 *
 * @author Robson de Jesus
 */
public class Conexao {
     //para a conexao com o meu banco de trabalho web
    private static final String URL = "jdbc:postgresql://localhost:5432/trabalho";
    private static final String DRIVER = "org.postgressql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "12345";
    
    private static Connection con;
    
    public static Connection conecta() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        con = (Connection) DriverManager.getConnection(URL, URL, PASS);
        return con;
    }
    
    public static void desconecta() throws JMSException{
        con.close();
    }
    
    
}
