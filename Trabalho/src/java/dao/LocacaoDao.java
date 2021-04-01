/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.LocacaoModel;
import observer.DadosObserver;
import observer.SujeitoAtualizar;
import org.jboss.logging.Logger;

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
            l.setData_locacao(rs.getString("data_locacao"));
            l.setData_devolucao(rs.getString("data_devolucao"));
            l.setStatus(rs.getString("status"));
            l.setCodigocliente(rs.getString("codigoCliente"));
            l.setCodigocarro(rs.getString("codigoCarro"));

            locacoes.add(l);
        }

        con.close();
        return locacoes;

    }

    public boolean inserirLocacao(LocacaoModel c) throws Exception {
        
        //teste aplicacao padrao observer
        SujeitoAtualizar sujeito = new SujeitoAtualizar();
        new DadosObserver(sujeito);
        try {
            sql = "insert into locacao(codigolocacao, quilometragem_saida, quilomentragem_retorno, data_locacao, data_devolucao, status, codigocliente, codigocarro) values (?,?,?,?,?,?,?,?)";
            con = ConexaoUtil.getInstance().getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigolocacao());
            pst.setInt(2, c.getQuilometragem_saida());
            pst.setInt(3, c.getQuilometragem_retorno());
            pst.setString(4, c.getData_locacao());
            pst.setString(5, c.getData_devolucao());
            pst.setString(6, c.getStatus());
            pst.setString(7, c.getCodigocliente());
            pst.setString(8, c.getCodigocarro());
            pst.execute();
            con.close();
            System.out.println("Notificacao ao adicionar abservadores");
            sujeito.setNotificacao();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }

    }

    public LocacaoModel buscarCarro(LocacaoModel c) throws Exception {

        List<LocacaoModel> listaLocacao = new ArrayList<LocacaoModel>();
        LocacaoModel retorno = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "select * from locacao where codigocarro = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getCodigocarro());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                retorno = new LocacaoModel();
                retorno.setCodigolocacao(resultSet.getInt("codigolocacao"));
                retorno.setQuilometragem_saida(resultSet.getInt("quilometragem_saida"));
                retorno.setQuilometragem_retorno(resultSet.getInt("quilomentragem_retorno"));
                retorno.setData_locacao(resultSet.getString("data_locacao"));
                retorno.setData_devolucao(resultSet.getString(""));
                retorno.setStatus(resultSet.getString("status"));
                retorno.setCodigocliente(resultSet.getString("codigocliente"));
                retorno.setCodigocarro(resultSet.getString("codigocarro"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    }

    public LocacaoModel buscarCliente(LocacaoModel c) throws Exception {
        List<LocacaoModel> listaLocacao = new ArrayList<LocacaoModel>();
        LocacaoModel retorno = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "select * from locacao where codigocliente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getCodigocliente());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                retorno = new LocacaoModel();
                retorno.setCodigolocacao(resultSet.getInt("codigolocacao"));
                retorno.setQuilometragem_saida(resultSet.getInt("quilometragem_saida"));
                retorno.setQuilometragem_retorno(resultSet.getInt("quilomentragem_retorno"));
                retorno.setData_locacao(resultSet.getString("data_locacao"));
                retorno.setData_devolucao(resultSet.getString(""));
                retorno.setStatus(resultSet.getString("status"));
                retorno.setCodigocliente(resultSet.getString("codigocliente"));
                retorno.setCodigocarro(resultSet.getString("codigocarro"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    }

    public LocacaoModel buscarData(LocacaoModel c) throws Exception{
        List<LocacaoModel> listaLocacao = new ArrayList<LocacaoModel>();
        LocacaoModel retorno = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "select * from locacao where data_locacao = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getData_locacao());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                retorno = new LocacaoModel();
                retorno.setCodigolocacao(resultSet.getInt("codigolocacao"));
                retorno.setQuilometragem_saida(resultSet.getInt("quilometragem_saida"));
                retorno.setQuilometragem_retorno(resultSet.getInt("quilomentragem_retorno"));
                retorno.setData_locacao(resultSet.getString("data_locacao"));
                retorno.setData_devolucao(resultSet.getString(""));
                retorno.setStatus(resultSet.getString("status"));
                retorno.setCodigocliente(resultSet.getString("codigocliente"));
                retorno.setCodigocarro(resultSet.getString("codigocarro"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    }
    
    
    public boolean atualizar(LocacaoModel l) throws Exception {
        //teste para aplicacao padrao oberver
        SujeitoAtualizar sujeito = new SujeitoAtualizar();
        new DadosObserver(sujeito);
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "UPDATE locacao SET codigolocacao=?, quilometragem_saida=?, quilomentragem_retorno=?, data_locacao=?, data_devolucao=?, status=?, codigocliente=?, codigocarro=? WHERE codigolocacao = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, l.getCodigolocacao());
            statement.setInt(2, l.getQuilometragem_saida());
            statement.setInt(3, l.getQuilometragem_retorno());
            statement.setString(4, l.getData_locacao());
            statement.setString(5, l.getData_devolucao());
            statement.setString(6, l.getStatus());
            statement.setString(7, l.getCodigocliente());
            statement.setString(8, l.getCodigocarro());
            statement.setInt(9, l.getCodigolocacao());
            statement.executeUpdate();
            statement.close();
            connection.close();
            System.out.println("Notificacao ao adicionar abservadores");
            sujeito.setNotificacao();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar");
            e.printStackTrace();
            return false;
        }
    }


}
