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
import model.Cidade;
import model.Estado;

/**
 *
 * @author juann
 */
public class CidadeDAO {

    static Connection c;

    
    //Talevz nao seja necessario inserir cidades
    public static boolean insereCidade(Cidade cidade) {
        c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO cidade(nome, fkidestado) "
                + "VALUES (?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, cidade.getNome());
            //estado objeto convertido para string para converter para int
            ppstt.setInt(2, Integer.parseInt(cidade.getEstado().toString()));
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    
    //Recebe cidade atraves do nome
    public Cidade getCidade(String nome) {
        String sql = "SELECT cidade.pkidcidade, cidade.nome AS cidadenome, cidade.fkidestado, estado.nome AS estadonome, estado.sigla"
                + "FROM cidade INNER JOIN estado ON (cidade.fkidestado = estado.pkidestado) AND cidade.nome = '?' ";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, nome);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                //objeto cidade
                cidade.setIdCidade(rs.getInt("pkidcidade"));
                cidade.setNome(rs.getString("cidadenome"));

                //objeto estado
                estado.setIdEstado(rs.getInt("fkidestado"));
                estado.setNome("estadonome");
                estado.setSigla("sigla");
                cidade.setEstado(estado);
                return cidade;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    
    //Recebe todas as cidade
    public static List<Cidade> getCidade() {
        List<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "SELECT cidade.pkidcidade, cidade.nome AS cidadenome, cidade.fkidestado, estado.nome AS estadonome, estado.sigla\n"
                + "FROM cidade INNER JOIN estado ON (cidade.fkidestado = estado.pkidestado)";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                //objeto cidade
                cidade.setIdCidade(rs.getInt("pkidcidade"));
                cidade.setNome(rs.getString("cidadenome"));

                Estado estado = new Estado();
                //objeto estado
                estado.setIdEstado(rs.getInt("fkidestado"));
                estado.setNome(rs.getString("estadonome"));
                estado.setSigla(rs.getString("sigla"));
                
                cidade.setEstado(estado);
                cidades.add(cidade);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cidades;
    }

}
