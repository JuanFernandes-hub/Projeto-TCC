/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.LoginDAO.c;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Login;
import model.Lugar;


/**
 *
 * @author juann
 */
public class LugarDAO {
    static Connection c;
    
    public static boolean insereLugar(Lugar lugar){
        c = ConnectionFactory.getConnection();
        
        //mudar banco
        String sql = "INSERT INTO lugar(nome,avaliacao,fkidcategoria,fkidlocalizacao) "
                + "VALUES (?,?,?,?);";
        try{
            //mandar nome ou numero? rever
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,lugar.getNome());
            ppstt.setInt(2,lugar.getAvaliacao());
            ppstt.setInt(3,lugar.getLocalizacao());
            ppstt.execute();
            ppstt.close();
        }catch(SQLException e){
            return false;
        }
        return true;
    }
    
    public Login getLugar(String usuario, String senha){
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
