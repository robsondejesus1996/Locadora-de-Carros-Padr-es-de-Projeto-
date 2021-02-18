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
public class Cliente {
    
//   create table Cliente(
//   codigo serial not null,
//   cpf varchar(50),
//   nome varchar(50),
//   cnh varchar(50),
//   fone varchar(50),
//   email varchar(50)
//)

    private int codigo;
    private String cpf;
    private String nome;
    private String cnh;
    private String fone;
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Cliente() {
    }

    public Cliente(int codigo, String cpf, String nome, String cnh, String fone, String email) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.cnh = cnh;
        this.fone = fone;
        this.email = email;
    }

   
    
    
}

