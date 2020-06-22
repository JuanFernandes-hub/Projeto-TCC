/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CategoriaDAO;
import DAO.LoginDAO;
import DAO.LugarDAO;
import java.util.List;
import model.Categoria;
import model.Login;
import model.Lugar;

/**
 *
 * @author juann
 */
public class Testes {
    public static void main(String[] args){
        Login login = LoginDAO.getLogin(3);
        login.setEmail("JuanTesteATT@gmail");
        LoginDAO.atualizaLogin(login);
    }
}
