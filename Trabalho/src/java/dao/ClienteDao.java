/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConexaoUtil;
import model.ClienteModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.jms.JMSException;
import javax.persistence.TypedQuery;
import observer.DadosObserver;
import observer.SujeitoAtualizar;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

/**
 *
 * @author Robson
 */
public class ClienteDao {
    
    private ClienteDao(){
        
    }
    private static ClienteDao instance;
    
    //aplicacao do padrao singleton 
    public synchronized static ClienteDao getInstance(){
        if(instance == null){
            instance = new ClienteDao();
            
        }
        return instance;
    } 

    public List<ClienteModel> getClientes() {
        List<ClienteModel> listaClientes = new ArrayList<ClienteModel>();

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "select * from cliente";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                System.out.println("Codigo: " + resultset.getLong("codigo"));
                System.out.println("Cpf: " + resultset.getString("cpf"));
                System.out.println("Nome: " + resultset.getString("nome"));
                System.out.println("Cnh: " + resultset.getString("cnh"));
                System.out.println("Fone: " + resultset.getString("fone"));
                System.out.println("Email: " + resultset.getString("email"));
                System.out.println("-----------------------------");
            }
            resultset.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro na consulta!!!");
            e.printStackTrace();
        }
        return listaClientes;
    }

    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;

    public List<ClienteModel> getAll() throws Exception {
        List<ClienteModel> clientes = new ArrayList<>();
        ClienteModel c = null;
        sql = "select * from cliente";
        con = ConexaoUtil.getInstance().getConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {
            c = new ClienteModel();
            c.setNome(rs.getString("nome"));
            c.setCodigoCliente(rs.getInt("codigoCliente"));
            c.setCpf(rs.getString("cpf"));
            c.setCnh(rs.getString("cnh"));
            c.setEmail(rs.getString("email"));
            c.setFone(rs.getString("fone"));

            clientes.add(c);
        }
        con.close();
        return clientes;
    }

    public boolean inserirCliente(ClienteModel c) throws Exception {
        //teste aplicacao observer
        SujeitoAtualizar sujeito = new SujeitoAtualizar();
        
        
        //observer
        new DadosObserver(sujeito);
        try {
            sql = "insert into cliente(codigoCliente, cpf, nome, cnh, fone, email) values (?,?,?,?,?,?)";
            con = ConexaoUtil.getInstance().getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigoCliente());
            pst.setString(2, c.getCpf());
            pst.setString(3, c.getNome());
            pst.setString(4, c.getCnh());
            pst.setString(5, c.getFone());
            pst.setString(6, c.getEmail());
            pst.execute();
            con.close();
            //observer
            System.out.println("Notificacao ao adicionar abservadores de clientes");
            sujeito.setNotificacao();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }

    }
     public boolean excluir(String cpf) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "delete from cliente WHERE cpf = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.execute();
            System.out.println("Cliente remvovido com sucesso!!!");
            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            return true;
        }
    }

//    public boolean excluir(ClienteModel cliente) {
//        try {
//            Connection connection = ConexaoUtil.getInstance().getConnection();
//            String sql = "delete from cliente WHERE cpf = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, cliente.getCpf());
//            statement.execute();
//            System.out.println("Cliente remvovido com sucesso!!!");
//            statement.close();
//            connection.close();
//            return true;
//        } catch (Exception e) {
//            return true;
//        }
//
//    }

    public boolean atualizar(ClienteModel cliente) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "update cliente set codigoCliente = ?, cpf = ?, nome = ?, cnh = ?, fone = ?, email = ? where  codigoCliente = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cliente.getCodigoCliente());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getCnh());
            statement.setString(5, cliente.getFone());
            statement.setString(6, cliente.getEmail());
            statement.setInt(7, cliente.getCodigoCliente());
            statement.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!!!");
            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar");
            e.printStackTrace();
            return false;
        }
    }

    public ClienteModel buscar(ClienteModel cliente) throws Exception {
         List<ClienteModel> listaClientes = new ArrayList<ClienteModel>();
         ClienteModel retorno = null;
        
        try{
            Connection connection = ConexaoUtil.getInstance().getConnection();
            
            String sql = "SELECT * FROM cliente where cpf = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getCpf());
            ResultSet resultSet = statement.executeQuery();
            
            
            
            while(resultSet.next()){
                retorno = new ClienteModel();
                retorno.setCodigoCliente(resultSet.getInt("codigoCliente"));
                retorno.setCpf(resultSet.getString("cpf"));
                retorno.setNome(resultSet.getString("nome"));
                retorno.setCnh(resultSet.getString("cnh"));
                retorno.setFone(resultSet.getString("fone"));
                retorno.setEmail(resultSet.getString("email"));
                
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    }

   
}
