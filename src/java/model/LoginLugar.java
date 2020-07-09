/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author juann
 */
public class LoginLugar {
    private int idUsuarioLugar;
    private Login login;
    private Lugar lugar;
    private LocalDateTime dataCadastro;
    
    public LoginLugar(Login login, Lugar lugar) {
        this.login = login;
        this.lugar = lugar;
    }

    public LoginLugar() {
    }
    
    public int getIdUsuarioLugar() {
        return idUsuarioLugar;
    }

    public void setIdUsuarioLugar(int idUsuarioLugar) {
        this.idUsuarioLugar = idUsuarioLugar;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
}
