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
import java.util.ArrayList;
import java.util.List;
import model.Login;
import model.LoginLugar;
import model.Lugar;


/**
 *
 * @author juann
 */
public class LoginLugarDAO {

    static Connection c;
    
    //Retorna uma lista de LoginLugar (usado para verificar se o usuario cadastrou algum lugar)
    public static List<LoginLugar> getLoginLugar(Login login) {
        List<LoginLugar> loginLugares = new ArrayList<LoginLugar>();
        String sql = "SELECT pkidusuariolugar, fkidlogin, fkidlugar\n"
                + "FROM usuarioLugar\n"
                + "WHERE fkidlogin = ?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, login.getIdUsuario());
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                LoginLugar loginLugar = new LoginLugar();
                Login loginObj = LoginDAO.getLogin(login.getIdUsuario());
                Lugar lugar = LugarDAO.getLugar(rs.getInt("fkidLugar"));
                loginLugar.setIdUsuarioLugar(rs.getInt("pkidusuariolugar"));
                loginLugar.setLogin(loginObj);
                loginLugar.setLugar(lugar);
                
                loginLugares.add(loginLugar);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loginLugares;
    }
    
    //Tabela usuarioLugar
    public static void insereLoginLugar(int idLugar, int idLoginLugar) {
        c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO usuariolugar(fkidlogin,fkidlugar)\n"
                + "VALUES (?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, idLoginLugar);
            ppstt.setInt(2, idLugar);
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.print("Erro no sistema. Desculpe.");
        }

    }

    //Pega lugares cadastrados pelo usuário
    public static Lugar getLugar(int idLogin, int idLugar) {
        String sql = "SELECT pkidusuariolugar, fkidlogin, fkidlugar\n"
                + "FROM usuarioLugar\n"
                + "WHERE fkidlogin = ? AND fkidlugar = ?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, idLogin);
            ppstt.setInt(2, idLugar);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                idLugar = rs.getInt("fkidlugar");
                Lugar lugar = LugarDAO.getLugar(idLugar);
                
                return lugar;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    public static void deletaLoginLugar(int idLugar) {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM usuarioLugar WHERE fkidlugar= ? ";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, idLugar);
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            fecharConexao();
        }
    }
    
    //Deleta por usuario
    public static void deletaLoginLugar(Login login) {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM usuarioLugar WHERE fkidlogin= ? ";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, login.getIdUsuario());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            fecharConexao();
        }
    }
    
    private static void fecharConexao() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
