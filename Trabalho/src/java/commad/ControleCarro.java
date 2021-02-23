/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commad;

/**
 *
 * @author Robson de Jesus
 */
public class ControleCarro {

    private Command[] commands;
    private Command ultimoCommand;

    public ControleCarro(Command inserirCommand, Command removerCommand) {
        this.commands = new Command[2];
        commands[0] = inserirCommand;
        commands[1] = removerCommand;
    }

    public void inserirCarro() {
        commands[0].execute();
        ultimoCommand = commands[0];

    }

    public void removerCarro() {
        commands[1].execute();
        ultimoCommand = commands[1];
    }

    public void desfazer() {
        ultimoCommand.undo();

    }
    
}
