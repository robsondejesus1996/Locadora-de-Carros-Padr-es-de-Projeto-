/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Robson de Jesus
 */
public class ControleCliente {

    private Command[] commands;
    private Command ultimoCommand;

    public ControleCliente(Command inserirCommand, Command removerCommand) {
        this.commands = new Command[2];
        commands[0] = inserirCommand;
        commands[1] = removerCommand;
    }

    public void inserirCliente() {
        commands[0].execute();
        ultimoCommand = commands[0];

    }

    public void removerCliente() {
        commands[1].execute();
        ultimoCommand = commands[1];
    }

    public void desfazer() {
        ultimoCommand.undo();

    }
    
}
