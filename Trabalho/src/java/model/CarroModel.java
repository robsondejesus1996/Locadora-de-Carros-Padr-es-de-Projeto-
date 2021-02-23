/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Robson de Jesus
 */
public class CarroModel {
    
    private int codigoCarro;
    private String placa;
    private String marca;
    private String modelo;
    private Date anoFabricacao;
    private int valor_km;
    
    
    //teste aplicacao command 
    public final static int INSERIR = 0;
    public final static int EXCLUIR = 1;
    private int estado = 0;
    
    public void inserir(){
        this.estado = INSERIR;
        System.out.println("Command inserindo carro...");
    }
    
    public void excluir(){
        this.estado = EXCLUIR;
        System.out.println("Command excluindo carro...");
    }
    
    public String verEstado(){
        if(estado == INSERIR){
            return "Carro inserido...";
        }else{
            return "Carro removido...";
        }
    }


    public CarroModel(int codigoCarro, String placa, String marca, String modelo, Date anoFabricacao, int valor_km) {
        this.codigoCarro = codigoCarro;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valor_km = valor_km;
    }

    public CarroModel() {
    }

    @Override
    public String toString() {
        return "CarroModel{" + "codigoCarro=" + codigoCarro + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao=" + anoFabricacao + ", valor_km=" + valor_km + '}';
    }

    public int getCodigoCarro() {
        return codigoCarro;
    }

    public void setCodigoCarro(int codigoCarro) {
        this.codigoCarro = codigoCarro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getValor_km() {
        return valor_km;
    }

    public void setValor_km(int valor_km) {
        this.valor_km = valor_km;
    }
    
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
   
   
    
    
}
