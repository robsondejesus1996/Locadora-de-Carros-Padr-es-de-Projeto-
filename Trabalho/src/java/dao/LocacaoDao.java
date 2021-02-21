/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LocacaoModel;
import controller.ConexaoUtil;
import model.ClienteModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.jms.JMSException;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

/**
 *
 * @author Robson
 */
public class LocacaoDao {
    
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;
    
     //aplicacao do padrao singleton
    private LocacaoDao(){
        
    }
    
    private static LocacaoDao instance;
    
    public synchronized static LocacaoDao getInstance(){
        if(instance == null){
            instance = new LocacaoDao();
        }
        return instance;
    }
    
    //so não esta traznndo alguns campos
     public List<LocacaoModel> getAll() throws Exception {
        List<LocacaoModel> locacoes = new ArrayList<>();
        LocacaoModel l = null;
        sql = "select * from locacao";
        con = ConexaoUtil.getInstance().getConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {
            l = new LocacaoModel();
            l.setCodigolocacao(rs.getInt("codigoLocacao"));
            l.setQuilometragem_saida(rs.getInt("quilometragem_saida"));
            l.setQuilometragem_retorno(rs.getInt("quilomentragem_retorno"));
            l.setData_locacao(rs.getDate("data_locacao"));
            l.setData_devolucao(rs.getDate("data_devolucao"));
            l.setStatus(rs.getString("status"));
            l.setCodigocliente(rs.getInt("codigoCliente"));
            l.setCodigocarro(rs.getInt("codigoCarro"));
            locacoes.add(l);
        }
        con.close();
        return locacoes;
    }
     
     //so não esta traznndo alguns campos
     public LocacaoModel buscar(LocacaoModel l) throws Exception {
         List<LocacaoModel> listaLocacao = new ArrayList<LocacaoModel>();
         LocacaoModel retorno = null;
        
        try{
            Connection connection = ConexaoUtil.getInstance().getConnection();
            
            String sql = "SELECT * FROM locacao where codigolocacao = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, l.getCodigolocacao());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                retorno = new LocacaoModel();
                retorno.setCodigolocacao(resultSet.getInt("codigolocacao"));
                retorno.setQuilometragem_saida(resultSet.getInt("quilometragem_saida"));
                retorno.setQuilometragem_retorno(resultSet.getInt("quilometragem_retorno"));
                retorno.setData_locacao(resultSet.getDate("data_locacao"));
                retorno.setData_devolucao(resultSet.getDate("data_devolucao"));
                retorno.setStatus(resultSet.getString("status"));
                retorno.setCodigocliente(resultSet.getInt("codigocliente"));
                retorno.setCodigocarro(resultSet.getInt("codigocarro"));
                
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    }
     
     
    public LocacaoModel buscarDisponibilidade(LocacaoModel l) throws Exception {
          List<LocacaoModel> listaLocacao = new ArrayList<LocacaoModel>();
         LocacaoModel retorno = null;
        
        try{
            Connection connection = ConexaoUtil.getInstance().getConnection();
            
            String sql = "SELECT status FROM locacao where codigocarro = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, l.getCodigocarro());
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                retorno = new LocacaoModel();
                retorno.setStatus(resultSet.getString("status"));
                
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    } 
     
     public boolean inserirLocacao(LocacaoModel l)throws Exception{
         try {
            sql = "insert into locacao(codigolocacao, quilometragem_saida,data_locacao,status, codigocliente, codigocarro) values (?,?,?,?,?,?)";
            con = ConexaoUtil.getInstance().getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, l.getCodigolocacao());
            pst.setInt(2, l.getQuilometragem_saida());
            pst.setDate(3, l.getData_locacao());
            pst.setString(4, l.getStatus());
            pst.setInt(5, l.getCodigocliente());
            pst.setInt(6, l.getCodigocarro());
            pst.execute();
            con.close();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
     }
     
     
     public boolean atualizar(LocacaoModel l)throws Exception{
       try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "UPDATE locacao SET codigolocacao=?, quilometragem_saida=?, quilomentragem_retorno=?, data_locacao=?, data_devolucao=?, status=?, codigocliente=?, codigocarro=? WHERE codigolocacao = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, l.getCodigolocacao());
            statement.setInt(2, l.getQuilometragem_saida());
            statement.setInt(3, l.getQuilometragem_retorno());
            statement.setDate(4, l.getData_locacao());
            statement.setDate(5, l.getData_devolucao());
            statement.setString(6, l.getStatus());
            statement.setInt(7, l.getCodigocliente());
            statement.setInt(8, l.getCodigocarro());
            statement.setInt(9, l.getCodigolocacao());
            statement.executeUpdate();
            System.out.println("Locação atualizado com sucesso!!!");
            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar");
            e.printStackTrace();
            return false;
        }
     }

    
    
}
