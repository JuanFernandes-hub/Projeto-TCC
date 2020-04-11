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
import model.Categoria;

/**
 *
 * @author juann
 */
public class CategoriaDAO {
    static Connection c;
    
    public static boolean insereCategoria(Categoria categoria){
        c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO categoria(nome) "
                + "VALUES (?);";
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,categoria.getNome());
            ppstt.execute();
            ppstt.close();
        }catch(SQLException e){
            return false;
        }
        return true;
    }
    
    public static Categoria getCategoria(Categoria categoria){
        String sql = "SELECT * FROM categoria WHERE nome = ?";
        c = ConnectionFactory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1,categoria.getNome());
            ResultSet rs = ppstt.executeQuery();
            if(rs.next()){
                Categoria categoriaObj = new Categoria();
                categoriaObj.setIdCategoria(rs.getInt("pkidcategoria"));
                categoriaObj.setNome(rs.getString("nome"));
                return categoriaObj;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public static List<Categoria> getCategoria(){
        List<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "SELECT * FROM categoria;";
        c = ConnectionFactory.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("pkidcategoria"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return categorias;
    }
}
