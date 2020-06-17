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
import model.Classe;

/**
 *
 * @author juann
 */
public class ClasseDAO {

    static Connection c;

    public static Classe getClasse(int idClasse) {
        String sql = "SELECT pkidclasse, nome from classe where pkidclasse=?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, idClasse);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("pkidclasse");
                String nome = rs.getString("nome");
                Classe classe = new Classe(id, nome);
                
                return classe;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    public static Classe getClasse(String nomeClasse) {
        String sql = "SELECT pkidclasse, nome from classe where nome=?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, nomeClasse);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("pkidclasse");
                String nome = rs.getString("nome");
                Classe classe = new Classe(id, nome);
                
                return classe;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
