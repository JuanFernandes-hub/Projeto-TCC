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
import model.Estado;

/**
 *
 * @author juann
 */
public class EstadoDAO {
    static Connection c;
    
    public static Estado getEstado(Estado estado){
        String sql = "SELECT * FROM estado WHERE nome = ?";
        c = ConnectionFactory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,estado.getNome());
            ResultSet rs = ppstt.executeQuery();
            if(rs.next()){
                Estado estadoObj = new Estado();
                estadoObj.setIdEstado(rs.getInt("pkidestado"));
                estadoObj.setNome(rs.getString("nome"));
                estadoObj.setSigla("sigla");
                return estadoObj;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public static Estado getEstado(int idEstado){
        String sql = "SELECT * FROM estado WHERE pkidestado = ?";
        c = ConnectionFactory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1,idEstado);
            ResultSet rs = ppstt.executeQuery();
            if(rs.next()){
                Estado estadoObj = new Estado();
                estadoObj.setIdEstado(rs.getInt("pkidestado"));
                estadoObj.setSigla("sigla");
                estadoObj.setNome(rs.getString("nome"));
                return estadoObj;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    
    public static List<Estado> getEstado(){
        List<Estado> estados = new ArrayList<Estado>();
        String sql = "SELECT * FROM estado;";
        c = ConnectionFactory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while(rs.next()){
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("pkidestado"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                estados.add(estado);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return estados;
    }
}
