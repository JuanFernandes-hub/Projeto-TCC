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
import model.Localizacao;
import model.Lugar;

/**
 *
 * @author juann
 */
public class LugarDAO {

    static Connection c;

    public static boolean insereLugar(Lugar lugar) {
        c = ConnectionFactory.getConnection();

        String sql = "INSERT INTO lugar(nome,avaliacao,fkidcategoria,fkidlocalizacao,acesso,horainicial,horafinal,descricao)\n"
                + "VALUES (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, lugar.getNome());
            ppstt.setFloat(2, lugar.getAvaliacao()); //Passar avaliacao?
            ppstt.setInt(3, lugar.getCategoria().getIdCategoria());
            ppstt.setInt(4, lugar.getLocalizacao().getIdLocalizacao());
            ppstt.setString(5, lugar.getAcesso());
            ppstt.setTime(6, lugar.getHoraInicial());
            ppstt.setTime(7, lugar.getHoraFinal());
            ppstt.setString(8, lugar.getDescricao());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.print("Erro no sistema. Desculpe.");
            return false;
        }
        return true;
    }

    //metodo para passar a avaliacao(update) 
    //pegar avaliacao, fazer a media e mandar para o banco
    //Procurar pelo nome do lugar
    public Lugar getLugar(Lugar lugar) {
        String sql = "SELECT lug.pkidlugar, lug.nome AS lugarnome, lug.avaliacao, lug.fkidcategoria, lug.fkidlocalizacao,\n" +
"		 lug.acesso, lug.horainicial, lug.horafinal, lug.descricao,\n" +
"                cat.nome AS categorianome, loc.rua, loc.fkidcidade, loc.complemento, cid.nome AS nomecidade, cid.fkidestado,\n" +
"                est.nome AS estadonome, est.sigla\n" +
"                FROM lugar lug\n" +
"                INNER JOIN categoria AS cat ON (lug.fkidcategoria = cat.pkidcategoria)\n" +
"                INNER JOIN localizacao AS loc ON (lug.fkidlocalizacao = loc.pkidlocalizacao)\n" +
"                INNER JOIN cidade AS cid ON (loc.fkidcidade = cid.pkidcidade)\n" +
"                INNER JOIN estado AS est ON (cid.fkidestado = est.pkidestado)\n" +
"                AND lug.nome = '?' ";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, lugar.getNome());
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                Lugar lugarObj = new Lugar();
                lugarObj.setIdLugar(rs.getInt("pkidlugar"));
                lugarObj.setNome(rs.getString("lugarnome"));
                lugarObj.setAvaliacao(rs.getFloat("avaliacao"));
                lugarObj.setAcesso(rs.getString("acesso"));
                lugarObj.setHoraInicial(rs.getTime("horainicial"));
                lugarObj.setHoraFinal(rs.getTime("horafinal"));
                lugarObj.setDescricao(rs.getString("descricao"));

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("fkidcategoria"));
                categoria.setNome(rs.getString("categorianome"));
                lugarObj.setCategoria(categoria);

                Localizacao localizacao = new Localizacao();
                localizacao.setIdLocalizacao(rs.getInt("fkidlocalizacao"));
                localizacao.setRua(rs.getString("rua"));
                localizacao.setComplemento("complemento");

                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("fkidcidade"));
                cidade.setNome(rs.getString("nomecidade"));

                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("fkidestado"));
                estado.setNome(rs.getString("estadonome"));
                estado.setNome(rs.getString("sigla"));
                cidade.setEstado(estado);
                localizacao.setCidade(cidade);

                lugarObj.setLocalizacao(localizacao);

                return lugarObj;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static List<Lugar> getLugar() {
        List<Lugar> lugares = new ArrayList<Lugar>();
        String sql = "SELECT lug.pkidlugar, lug.nome AS lugarnome, lug.avaliacao, lug.fkidcategoria, lug.fkidlocalizacao, \n" +
"		 lug.acesso, lug.horainicial, lug.horafinal, lug.descricao,\n" +
"                cat.nome AS categorianome, loc.rua, loc.fkidcidade, loc.complemento, cid.nome AS nomecidade, cid.fkidestado,\n" +
"                est.nome AS estadonome, est.sigla\n" +
"                FROM lugar lug\n" +
"                INNER JOIN categoria AS cat ON (lug.fkidcategoria = cat.pkidcategoria)\n" +
"                INNER JOIN localizacao AS loc ON (lug.fkidlocalizacao = loc.pkidlocalizacao)\n" +
"                INNER JOIN cidade AS cid ON (loc.fkidcidade = cid.pkidcidade)\n" +
"                INNER JOIN estado AS est ON (cid.fkidestado = est.pkidestado)";
        c = ConnectionFactory.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Lugar lugarObj = new Lugar();
                lugarObj.setIdLugar(rs.getInt("pkidlugar"));
                lugarObj.setNome(rs.getString("lugarnome"));
                lugarObj.setAvaliacao(rs.getFloat("avaliacao"));
                lugarObj.setAcesso(rs.getString("acesso"));
                lugarObj.setHoraInicial(rs.getTime("horainicial"));
                lugarObj.setHoraFinal(rs.getTime("horafinal"));
                lugarObj.setDescricao(rs.getString("descricao"));
                
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("fkidcategoria"));
                categoria.setNome(rs.getString("categorianome"));
                lugarObj.setCategoria(categoria);

                Localizacao localizacao = new Localizacao();
                localizacao.setIdLocalizacao(rs.getInt("fkidlocalizacao"));
                localizacao.setRua(rs.getString("rua"));
                localizacao.setComplemento("complemento");

                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("fkidcidade"));
                cidade.setNome(rs.getString("nomecidade"));

                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("fkidestado"));
                estado.setNome(rs.getString("estadonome"));
                estado.setNome(rs.getString("sigla"));
                cidade.setEstado(estado);
                localizacao.setCidade(cidade);

                lugarObj.setLocalizacao(localizacao);

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
