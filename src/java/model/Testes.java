/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
import DAO.LoginDAO;
import DAO.LugarDAO;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Cidade;

/**
 *
 * @author juann
 */
public class Testes {

    public static void main(String[] args) throws ParseException {
        LoginDAO dao = new LoginDAO();
        Login login = dao.getLogin("Juan", "Fernandes");
        System.out.println("Usuario; "+login.getUsuario());
        System.out.println("Senha: "+login.getSenha());
        
        /*
        EstadoDAO dao1 = new EstadoDAO();
        List<Estado> estados = dao1.getEstado();

        for (Estado estado : estados) {
            System.out.print(estado.getNome());
            
        }*/
        
    }

}
