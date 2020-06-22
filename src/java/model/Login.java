/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Login {
    private int idUsuario;
    private String usuario;
    private String senha;
    private String email;
    private Classe classe;


    public Login() {
    }

    public Login(int idUsuario, String usuario, String senha, String email, Classe classe) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.classe = classe;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Login{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", senha=" + senha + ", classe=" + classe + '}';
    }
    
    
    
    
   
    
}
