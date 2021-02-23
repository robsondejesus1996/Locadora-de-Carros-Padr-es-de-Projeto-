/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commad;

import model.CarroModel;

/**
 *
 * @author Robson de Jesus
 */
public class InserirCommandCarro implements Command {

    public InserirCommandCarro(CarroModel carro) {
        this.carro = carro;
    }

    private CarroModel carro;

    @Override
    public void execute() {
        carro.inserir();

    }

    @Override
    public void undo() {
        carro.excluir();
    }

}
