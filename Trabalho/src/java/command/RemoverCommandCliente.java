/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.ClienteModel;

/**
 *
 * @author Robson de Jesus
 */
public class RemoverCommandCliente implements Command {

    private ClienteModel cliente;

    public RemoverCommandCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    @Override
    public void execute() {
        cliente.excluir();
    }

    @Override
    public void undo() {
        cliente.inserir();
    }
}
