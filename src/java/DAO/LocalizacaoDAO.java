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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cidade;
import model.Estado;
import model.Localizacao;

/**
 *
 * @author juann
 */
public class LocalizacaoDAO {

    static Connection c;

    public static boolean insereLocalizacao(Localizacao localizacao) {
        c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO localizacao(rua,fkidcidade,complemento,bairro,numero)\n"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, localizacao.getRua());
            ppstt.setInt(2, localizacao.getCidade().getIdCidade());
            ppstt.setString(3, localizacao.getComplemento());
            ppstt.setString(4, localizacao.getBairro());
            ppstt.setString(5, localizacao.getNumero());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    
    //Para pegar id da localizacao
    public static int insere(Localizacao localizacao) {
        c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO localizacao(rua,fkidcidade,complemento,bairro,numero)\n"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ppstt.setString(1, localizacao.getRua());
            ppstt.setInt(2, localizacao.getCidade().getIdCidade());
            ppstt.setString(3, localizacao.getComplemento());
            ppstt.setString(4, localizacao.getBairro());
            ppstt.setString(5, localizacao.getNumero());
            ppstt.execute();
            ResultSet rs = ppstt.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            ppstt.close();
            return (id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (0);
    }

    //Filtar localizacao por cidade
    public Localizacao getLocalizacao(Cidade cidade) {
        String sql = "SELECT loc.pkidlocalizacao, loc.rua, loc.fkidcidade, loc.complemento,\n"
                + "cid.nome AS cidadenome, cid.fkidestado, est.nome AS estadonome, est.sigla\n"
                + "FROM localizacao loc\n"
                + "INNER JOIN cidade AS cid ON (loc.fkidcidade = ?)\n" //recebe o pkid da cidade
                + "INNER JOIN estado AS est ON (cid.fkidestado = est.pkidestado)\n";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setInt(1, cidade.getIdCidade());
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                Localizacao localizacao = new Localizacao();
                localizacao.setIdLocalizacao(rs.getInt("pkidlocalizacao"));
                localizacao.setRua(rs.getString("rua"));
                localizacao.setComplemento("complemento");

                //objeto cidade 
                Cidade cidadeObj = new Cidade();
                cidadeObj.setIdCidade(rs.getInt("fkidcidade"));
                cidadeObj.setNome(rs.getString("cidadenome"));

                //objeto estado
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("fkidestado"));
                estado.setNome(rs.getString("estadonome"));
                estado.setSigla(rs.getString("sigla"));

                //cidade recebe estado
                cidadeObj.setEstado(estado);
                //localizacao recebe cidade
                localizacao.setCidade(cidadeObj);
                return localizacao;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public  List<Localizacao> getLocalizacao() {
        List<Localizacao> localizacoes = new ArrayList<Localizacao>();
        String sql = "SELECT loc.pkidlocalizacao, loc.rua, loc.fkidcidade, loc.complemento,\n"
                + "cid.nome AS cidadenome, cid.fkidestado, est.nome AS estadonome, est.sigla\n"
                + "FROM localizacao loc\n"
                + "INNER JOIN cidade AS cid ON (loc.fkidcidade = cid.pkidcidade)\n"
                + "INNER JOIN estado AS est ON (cid.fkidestado = est.pkidestado)\n";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Localizacao localizacao = new Localizacao();
                localizacao.setIdLocalizacao(rs.getInt("pkidlocalizacao"));
                localizacao.setRua(rs.getString("rua"));
                localizacao.setComplemento("complemento");

                //objeto cidade 
                Cidade cidadeObj = new Cidade();
                cidadeObj.setIdCidade(rs.getInt("fkidcidade"));
                cidadeObj.setNome(rs.getString("cidadenome"));

                //objeto estado
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("fkidestado"));
                estado.setNome(rs.getString("estadonome"));
                estado.setSigla(rs.getString("sigla"));

                //cidade recebe estado
                cidadeObj.setEstado(estado);
                //localizacao recebe cidade
                localizacao.setCidade(cidadeObj);
                localizacoes.add(localizacao);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return localizacoes;
    }
}
