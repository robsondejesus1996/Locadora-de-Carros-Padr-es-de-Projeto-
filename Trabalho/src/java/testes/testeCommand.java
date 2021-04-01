/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import command.Command;
import command.ControleCarro;
import command.ControleCliente;
import command.InserirCommandCarro;
import command.InserirCommandCliente;
import command.RemoverCommandCarro;
import command.RemoverCommandCliente;
import model.CarroModel;
import model.ClienteModel;

/**
 *
 * @author admin
 */
public class testeCommand {
    
    public static void main(String[] args) {
//        ClienteModel cliente = new ClienteModel();
//        Command inserirCommand = new InserirCommandCliente(cliente);
//        Command removerCommad = new RemoverCommandCliente(cliente);
//        
//        ControleCliente controle = new ControleCliente(inserirCommand, removerCommad);
//        
//        controle.inserirCliente();
//        controle.removerCliente();
//        controle.desfazer();


          CarroModel carro = new CarroModel();
          Command inserirCommand = new InserirCommandCarro(carro);
          Command removerCommad = new RemoverCommandCarro(carro);
          
          
          ControleCarro controle = new ControleCarro(inserirCommand,removerCommad);
          
          controle.inserirCarro();
          controle.removerCarro();
          controle.desfazer();
    }
}
