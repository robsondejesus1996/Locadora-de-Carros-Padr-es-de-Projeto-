/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.CarroDao;
import dao.ClienteDao;
import model.CarroModel;
import model.ClienteModel;

/**
 *
 * @author admin
 */
public class TesteExcluir {
    public static void main(String[] args) {
        
            ClienteModel cliente = new ClienteModel();
            ClienteDao dao = ClienteDao.getInstance();
            dao.excluir("teste");


//              CarroModel carro = new CarroModel();
//              CarroDao dao = CarroDao.getInstance();
//              dao.excluir("teste");
            
            
    }
}
