/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Robson de Jesus
 */
public class ClienteModel {
    

    private int codigoCliente;
    private String cpf;
    private String nome;
    private String cnh;
    private String fone;
    private String email;
    
    
    
    //teste aplicacao command
    public final static int INSERIR = 0;
    public final static int EXCLUIR = 1;
    private int estado = 0;

    public void inserir() {
        this.estado = INSERIR;
        System.out.println("Command inserindo cliente....");
    }

    public void excluir() {
        this.estado = EXCLUIR;
        System.out.println("Command excluindo cliente....");
    }
    
    public String verEstado(){
        if(estado == INSERIR){
            return "Cliente Inserido...";
        }else{
           return "Cliente removido..."; 
        }
    }


    public ClienteModel() {
    }

    public ClienteModel(int codigoCliente, String cpf, String nome, String cnh, String fone, String email) {
        this.codigoCliente = codigoCliente;
        this.cpf = cpf;
        this.nome = nome;
        this.cnh = cnh;
        this.fone = fone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteModel{" + "codigoCliente=" + codigoCliente + ", cpf=" + cpf + ", nome=" + nome + ", cnh=" + cnh + ", fone=" + fone + ", email=" + email + '}';
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
    
}

