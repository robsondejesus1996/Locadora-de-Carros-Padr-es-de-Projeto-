/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.CarroModel;

/**
 *
 * @author Robson de Jesus
 */
public class RemoverCommandCarro implements Command {

    private CarroModel carro;

    public RemoverCommandCarro(CarroModel carro) {
        this.carro = carro;
    }

    @Override
    public void execute() {
        carro.excluir();
    }

    @Override
    public void undo() {
        carro.inserir();
    }

}
