/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.LugarDAO.c;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Cidade;
import model.Estado;
import model.Localizacao;
import model.Login;
import model.Lugar;

/**
 *
 * @author user
 */
public class LoginDAO {

    static Connection c;

    public static boolean insereLogin(Login login) {
        c = ConnectionFactory.getConnection();

        //mudar banco
        String sql = "INSERT INTO login(usuario,senha,email)\n"
                + "VALUES (?,?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, login.getUsuario());
            ppstt.setString(2, login.getSenha());
            ppstt.setString(3, login.getEmail());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public Login getLogin(String usuario, String senha, String email) {
        String sql = "SELECT login.pkidusuario, login.usuario, login.senha, classe.nome AS classe\n"
                + "FROM login, classe\n"
                + "WHERE (usuario = ? OR email = ?) AND senha = ? AND login.fkidclasse = classe.pkidclasse";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, usuario);
            ppstt.setString(2, email);
            ppstt.setString(3, senha);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                Login login = new Login();
                login.setIdUsuario(rs.getInt("pkidusuario"));
                login.setUsuario(rs.getString("usuario"));
                login.setSenha(rs.getString("senha"));
                login.setClasse(rs.getString("classe"));
                return login;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
        }

        return null;
    }

    //Retornar Lugares Cadastrados por Usuarios
    public static List<Lugar> getLugaresCad(int id) {
        List<Lugar> lugares = new ArrayList<Lugar>();
        String sql = "SELECT lugar.pkidlugar, lugar.nome, lugar.descricao, lugar.fkidcategoria ,categoria.nome AS categorianome\n"
                + "FROM lugar, categoria, usuarioLugar\n"
                + "WHERE usuarioLugar.fkidlugar = lugar.pkidlugar AND\n"
                + "lugar.fkidcategoria = categoria.pkidcategoria AND\n"
                + "usuarioLugar.fkidlogin = ?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, id);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Lugar lugarObj = new Lugar();
                Categoria categoria = new Categoria();
                lugarObj.setIdLugar(rs.getInt("pkidlugar"));
                lugarObj.setNome(rs.getString("nome"));
                lugarObj.setDescricao(rs.getString("descricao"));
                
                categoria.setIdCategoria(rs.getInt("fkidcategoria"));
                categoria.setNome("nomecategoria");
                lugarObj.setCategoria(categoria);
                

                lugares.add(lugarObj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lugares;
    }

    private static void fecharConexao() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
