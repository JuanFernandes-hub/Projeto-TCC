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
import model.LoginLugar;
import model.Lugar;


/**
 *
 * @author juann
 */
public class LoginLugarDAO {

    static Connection c;
    


    public static LoginLugar getLugar(int idLogin, int idLugar) {
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
                idLogin = rs.getInt("fkidlogin");
                Lugar lugar = LugarDAO.getLugar(idLugar);
                Login login = LoginDAO.getLogin(idLogin);
                LoginLugar loginLugar = new LoginLugar();
                loginLugar.setIdUsuarioLugar(rs.getInt("pkidusuariolugar"));
                loginLugar.setLogin(login);
                loginLugar.setLugar(lugar);
                
                return loginLugar;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
