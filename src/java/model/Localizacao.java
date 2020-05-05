/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author juann
 */
public class Localizacao {
    
    private int idLocalizacao;
    private String rua;
    private Cidade cidade;
    private String complemento;
    private String bairro;
    private int numero;
    
    public Localizacao() {
    }

    public Localizacao(int idLocalizacao, String rua, Cidade cidade, String complemento, String bairro, int numero) {
        this.idLocalizacao = idLocalizacao;
        this.rua = rua;
        this.cidade = cidade;
        this.complemento = complemento;
        this.bairro = bairro;
        this.numero = numero;
    }
    
    public int getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(int idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    } 
    
}
