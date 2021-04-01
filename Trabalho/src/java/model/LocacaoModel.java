/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Robson de Jesus
 */
public class LocacaoModel {
    
    private int codigolocacao;
    private int quilometragem_saida;
    private int quilometragem_retorno;
    private String data_locacao;
    private String data_devolucao;
    private String status;
    private String codigocliente;
    private String codigocarro;

    public LocacaoModel() {
    }

    @Override
    public String toString() {
        return "LocacaoModel{" + "codigolocacao=" + codigolocacao + ", quilometragem_saida=" + quilometragem_saida + ", quilometragem_retorno=" + quilometragem_retorno + ", data_locacao=" + data_locacao + ", data_devolucao=" + data_devolucao + ", status=" + status + ", codigocliente=" + codigocliente + ", codigocarro=" + codigocarro + '}';
    }

    public int getCodigolocacao() {
        return codigolocacao;
    }

    public void setCodigolocacao(int codigolocacao) {
        this.codigolocacao = codigolocacao;
    }

    public int getQuilometragem_saida() {
        return quilometragem_saida;
    }

    public void setQuilometragem_saida(int quilometragem_saida) {
        this.quilometragem_saida = quilometragem_saida;
    }

    public int getQuilometragem_retorno() {
        return quilometragem_retorno;
    }

    public void setQuilometragem_retorno(int quilometragem_retorno) {
        this.quilometragem_retorno = quilometragem_retorno;
    }

    public String getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    public String getCodigocarro() {
        return codigocarro;
    }

    public void setCodigocarro(String codigocarro) {
        this.codigocarro = codigocarro;
    }

    
}
