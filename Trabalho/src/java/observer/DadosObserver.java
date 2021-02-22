/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Robson de Jesus
 */
public class DadosObserver extends Observer{
    
    public DadosObserver(SujeitoAtualizar sujeito){
        this.subject = sujeito;
        this.subject.addObserver(this);
    }

    @Override
    public void atualizarDados() {
        System.out.println("Atualizando dados....");
    }
    
}
