/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Robson
 */
public class ClienteModel {
    
//   create table ClienteModel(
//   codigo serial not null,
//   cpf varchar(50),
//   nome varchar(50),
//   cnh varchar(50),
//   fone varchar(50),
//   email varchar(50)
//)

    private int codigoCliente;
    private String cpf;
    private String nome;
    private String cnh;
    private String fone;
    private String email;

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

   
    
}

