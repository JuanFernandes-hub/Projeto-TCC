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
import static java.lang.Integer.parseInt;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Cidade;

/**
 *
 * @author juann
 */
public class Testes {

    public static void main(String[] args) throws ParseException {
        LugarDAO ldao = new LugarDAO();
        Lugar lugar = ldao.getLugar(13);
        Time horaInicial = lugar.getHoraInicial();
        String data = "16/06/2020";

        //Diz o formato esperado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //converte string em date
        Date dataaa = sdf.parse(data);
        //cria um novo formato
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        data = sdf.format(dataaa);
        System.out.println("DATA: "+data);
        
        System.out.println(sdf.format(dataaa));


        Time horaInicial_lugar = new java.sql.Time(horaInicial.getTime());
        System.out.println(horaInicial_lugar);

    }

}
