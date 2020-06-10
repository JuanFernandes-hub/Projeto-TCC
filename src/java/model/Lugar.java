/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;


/**
 *
 * @author juann
 */
public class Lugar {
    private int idLugar;
    private String nome;
    private float avaliacao;
    private Categoria categoria;
    private Localizacao localizacao;
    private String acesso;
    private Time horaInicial;
    private Time horaFinal;
    private String descricao;

    public Lugar() {
        this.avaliacao = 0;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Lugar{" + "idLugar=" + idLugar + ", nome=" + nome + ", avaliacao=" + avaliacao + ", categoria=" + categoria + ", localizacao=" + localizacao + ", acesso=" + acesso + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + ", descricao=" + descricao + '}';
    }
    
    
}
