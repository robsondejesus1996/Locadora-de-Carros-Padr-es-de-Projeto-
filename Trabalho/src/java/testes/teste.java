/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ClienteDao;
import model.ClienteModel;
import com.google.gson.Gson;
import dao.CarroDao;
import dao.LocacaoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jms.JMSException;
import model.CarroModel;
import model.LocacaoModel;

/**
 *
 * @author Robson
 */
public class teste {
    
    public static void main(String[] args) throws Exception{
        
        //testa buscar todos normal
        
//        ClienteDao dao = new ClienteDao();
//        ClienteModel c = new ClienteModel();
//        dao.getClientes();
        



        //teste para inserir normal 
        
//        ClienteDao dao = new ClienteDao();
//        ClienteModel c = new ClienteModel();
//        c.setCodigo(1);
//        c.setNome("Robson");
//        c.setCpf("1111");
//        c.setCnh("182812");
//        c.setFone("4999107773");
//        c.setEmail("robson@hotmail.com");
//        dao.inserirCliente(c);


        //teste para deletar
        
//        ClienteDao dao = new ClienteDao();
//        ClienteModel c = new ClienteModel();        
//        dao.deletarCliete(2);


        //teste para atualizar
        
//        ClienteDao dao = new ClienteDao();
//        ClienteModel c = new ClienteModel();
//        
//        c.setCodigo(3);
//        c.setCpf("5555");
//        c.setNome("Gabriel de souza");
//        c.setCnh("13.1234.2323");
//        c.setFone("47665353");
//        c.setEmail("grabriel@unidavi");
//        dao.atualizar(c);
//        
        
        
        
        //teste busca pelo codigo
        
//        ClienteModel c = new ClienteModel();
//        ClienteDao dao = new ClienteDao();
//        
//        c.setCpf("5555");
//        dao.buscar(c);


        //teste excluir locacao
        
//        LocacaoDao dao = new LocacaoDao();
//        LocacaoModel l = new LocacaoModel();
//        
//        l.setCodigolocacao(1);
//        dao.excluir(l);



           //teste excluir carro
           CarroDao dao = CarroDao.getInstance();
           CarroModel carro = new CarroModel();
           
           carro.setPlaca("AW13");
           dao.excluir("AW13");
    }
    
}
