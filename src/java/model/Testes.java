/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
import java.util.List;
import model.Cidade;

/**
 *
 * @author juann
 */
public class Testes {

    public static void main(String[] args) {
        CidadeDAO dao = new CidadeDAO();
        List<Cidade> cidades = dao.getCidade();

        for (Cidade cidade : cidades) {
            System.out.print(cidade.getNome());
            
        }
        
        EstadoDAO dao1 = new EstadoDAO();
        List<Estado> estados = dao1.getEstado();

        for (Estado estado : estados) {
            System.out.print(estado.getNome());
            
        }
        
    }

}
