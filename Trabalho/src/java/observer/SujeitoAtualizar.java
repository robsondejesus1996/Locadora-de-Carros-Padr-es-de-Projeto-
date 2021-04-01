/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SujeitoAtualizar {

    //classe concreta, que vai ter uma lista de observadores
    public ArrayList<Observer> listaObservadores = new ArrayList<Observer>();

    public void setNotificacao() {
        notificarObservadores();
    }

    public void addObserver(Observer observer) {
        this.listaObservadores.add(observer);
    }

    public void notificarObservadores() {
        for (Observer observer : listaObservadores) {
            observer.atualizarDados();
        }
    }
}
