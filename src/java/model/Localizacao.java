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

    public Localizacao() {
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
    
    
    
    
    
}