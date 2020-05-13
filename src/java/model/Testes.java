/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
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
        Lugar lugar = new Lugar();
        LugarDAO lugardao = new LugarDAO();
        lugar = lugardao.getLugar(12);
        
        System.out.println(lugar.getNome());
        
        /*
        EstadoDAO dao1 = new EstadoDAO();
        List<Estado> estados = dao1.getEstado();

        for (Estado estado : estados) {
            System.out.print(estado.getNome());
            
        }*/
        
    }

}
