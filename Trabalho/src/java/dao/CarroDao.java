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
import model.CarroModel;
import observer.DadosObserver;
import observer.SujeitoAtualizar;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

/**
 *
 * @author Robson
 */
public class CarroDao {

    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;

   //aplicação padrao Singleton
    
    private CarroDao(){
        
    }
    
    private static CarroDao instance;
    
    public synchronized static CarroDao getInstance(){
        if(instance == null){
            instance = new CarroDao();
        }
        return instance;
    }

    //funcionando
    public List<CarroModel> getAll() throws Exception {
        List<CarroModel> carros = new ArrayList<>();
        CarroModel c = null;
        sql = "select * from carro";
        con = ConexaoUtil.getInstance().getConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {
            c = new CarroModel();
            c.setCodigoCarro(rs.getInt("codigoCarro"));
            c.setPlaca(rs.getString("placa"));
            c.setMarca(rs.getString("marca"));
            c.setModelo(rs.getString("modelo"));
            c.setValor_km(rs.getInt("valor_km"));
            c.setAnoFabricacao(rs.getDate("anofabricacao"));
            carros.add(c);
        }
        con.close();
        return carros;
    }

    public CarroModel buscar(CarroModel cliente) throws Exception {
        List<CarroModel> listaCarros = new ArrayList<CarroModel>();
        CarroModel retorno = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();

            String sql = "SELECT * FROM carro where placa= ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getPlaca());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                retorno = new CarroModel();
                retorno.setCodigoCarro(resultSet.getInt("codigoCarro"));
                retorno.setPlaca(resultSet.getString("placa"));
                retorno.setMarca(resultSet.getString("marca"));
                retorno.setModelo(resultSet.getString("modelo"));
                retorno.setAnoFabricacao(resultSet.getDate("anofabricacao"));
                retorno.setValor_km(resultSet.getInt("valor_km"));

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Logger.Level.FATAL, ex);
        }
        return retorno;
    }

    public boolean inserirCarro(CarroModel c) throws Exception {
        //teste aplicacao observer
        SujeitoAtualizar sujeito = new SujeitoAtualizar();
        
        //observer
        new DadosObserver(sujeito);
        
        
        try {
            sql = "insert into carro(codigoCarro, placa, marca, modelo, anofabricacao, valor_km) values (?,?,?,?,?,?)";
            con = ConexaoUtil.getInstance().getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, c.getCodigoCarro());
            pst.setString(2, c.getPlaca());
            pst.setString(3, c.getMarca());
            pst.setString(4, c.getModelo());
            pst.setDate(5, c.getAnoFabricacao());
            pst.setInt(6, c.getValor_km());
            pst.execute();
            con.close();
            //observer
            System.out.println("Notificacao ao adicionar abservadores de carros");
            sujeito.setNotificacao();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public boolean atualizar(CarroModel c) throws Exception {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "update carro set codigoCarro = ?, placa = ?, marca = ?, modelo = ?, anofabricacao = ?, valor_km = ? where  codigoCarro = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, c.getCodigoCarro());
            statement.setString(2, c.getPlaca());
            statement.setString(3, c.getMarca());
            statement.setString(4, c.getModelo());
            statement.setDate(5, c.getAnoFabricacao());
            statement.setInt(6, c.getValor_km());
            statement.setInt(7, c.getCodigoCarro());
            statement.executeUpdate();
            System.out.println("Carro atualizado com sucesso!!!");
            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar");
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(String placa) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "delete from carro WHERE placa = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, placa);
            statement.execute();
            System.out.println("Carro remvovido com sucesso!!!");
            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            return true;
        }
    }

}
