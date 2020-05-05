/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Login;

/**
 *
 * @author user
 */
public class LoginDAO {
    static Connection c;
    
    public static boolean insereLogin(Login login){
        c = ConnectionFactory.getConnection();
        
        //mudar banco
        String sql = "INSERT INTO login(usuario,senha,email)\n"
                + "VALUES (?,?,?);";
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,login.getUsuario());
            ppstt.setString(2,login.getSenha());
            ppstt.setString(3,login.getEmail());
            ppstt.execute();
            ppstt.close();
        }catch(SQLException e){
            return false;
        }
        return true;
    }
    
    public Login getLogin(String usuario, String senha){
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        c = ConnectionFactory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,usuario);
            ppstt.setString(2,senha);
            ResultSet rs = ppstt.executeQuery();
            if(rs.next()){
                Login login = new Login();
                login.setIdUsuario(rs.getInt("pkidusuario"));
                login.setUsuario(rs.getString("usuario"));
                login.setSenha(rs.getString("senha"));
                login.setClasse(rs.getString("classe"));
                System.out.println(login);
                return login;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    private static void fecharConexao(){
        try{
        c.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
