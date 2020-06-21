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
import model.Classe;
import model.Login;
import model.LoginLugar;
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
        String sql = "INSERT INTO login(usuario,senha,email,fkidclasse)\n"
                + "VALUES (?,?,?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, login.getUsuario());
            ppstt.setString(2, login.getSenha());
            ppstt.setString(3, login.getEmail());
            ppstt.setInt(4, login.getClasse().getIdClasse());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static boolean atualizaLogin(Login login) {
        c = ConnectionFactory.getConnection();

        String sql = "UPDATE login SET usuario=?, senha=?, email=?, fkidclasse=?\n"
                + " WHERE pkidusuario = ?";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, login.getUsuario());
            ppstt.setString(2, login.getSenha());
            ppstt.setString(3, login.getEmail());
            ppstt.setInt(4, login.getClasse().getIdClasse());
            ppstt.setInt(5, login.getIdUsuario());
            ppstt.execute();
            ppstt.close();
            System.out.println(login.toString());
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    //verifica se email ja foi cadastrado
    //true = cadastrado, false = não cadastrado
    public static boolean emailCadastrado(String email) {
        String sql = "SELECT email\n"
                + "FROM login\n"
                + "WHERE email = ?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, email);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
        }
        return false;
    }
    
    //Verifica se usuario ja foi cadastrado
    public static boolean usuarioCadastrado(String usuario) {
        String sql = "SELECT usuario\n"
                + "FROM login\n"
                + "WHERE usuario = ?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, usuario);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
        }
        return false;
    }

    public Login getLogin(String usuario, String senha, String email) {
        String sql = "SELECT login.pkidusuario, login.usuario, login.senha, login.email, classe.pkidclasse, classe.nome AS classe\n"
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
                Classe classe = new Classe(rs.getInt("pkidclasse"), rs.getString("classe"));
                login.setIdUsuario(rs.getInt("pkidusuario"));
                login.setUsuario(rs.getString("usuario"));
                login.setEmail(rs.getString("email"));
                login.setSenha(rs.getString("senha"));
                login.setClasse(classe);
                return login;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");
        }

        return null;
    }

    public static Login getLogin(int idLogin) {
        String sql = "SELECT login.pkidusuario, login.usuario, login.senha, login.email, classe.pkidclasse, classe.nome AS classe\n"
                + "   FROM login, classe\n"
                + "   WHERE login.pkidusuario = ? AND login.fkidclasse = classe.pkidclasse";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, idLogin);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                Login login = new Login();
                Classe classe = new Classe(rs.getInt("pkidclasse"), rs.getString("classe"));
                login.setIdUsuario(rs.getInt("pkidusuario"));
                login.setUsuario(rs.getString("usuario"));
                login.setSenha(rs.getString("senha"));
                login.setEmail(rs.getString("email"));
                login.setClasse(classe);
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
        String sql = "SELECT lugar.pkidlugar\n"
                + "FROM lugar, usuariolugar\n"
                + "WHERE usuariolugar.fkidlugar = lugar.pkidlugar AND\n"
                + "usuariolugar.fkidlogin = ?";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, id);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Lugar lugar = LugarDAO.getLugar(rs.getInt("pkidlugar"));
                lugares.add(lugar);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lugares;
    }

    public static void deletaLogin(Login login) {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM login WHERE pkidusuario= ? ";
        try {
            //Verifica se o usuário tem algum lugar cadastrado
            List<LoginLugar> lugaresCad = LoginLugarDAO.getLoginLugar(login);
            if (lugaresCad != null) {
                //Deleta Lugares
                for (LoginLugar loginL : lugaresCad) {
                    Lugar lugar = LugarDAO.getLugar(loginL.getLugar().getIdLugar());
                    LugarDAO.deletaLugar(lugar.getIdLugar());
                }
            }
            //Deleta associação de login e lugar da Tabela LoginLugar
            LoginLugarDAO.deletaLoginLugar(login);

            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, login.getIdUsuario());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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
