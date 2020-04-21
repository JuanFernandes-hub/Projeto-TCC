/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CidadeDAO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juann
 */
public class GetCidades implements Modelo{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) {
        //vai retornar ajax
        
        //cabeçalho
        try{
            CidadeDAO cdao = new CidadeDAO();
            String pesquisa = request.getParameter("pesquisa");
            
            Gson gson = new Gson();
            JsonObject obj = new JsonObject();
            JsonElement jsonobj = gson.toJsonTree(cdao.getCidade(parseInt(pesquisa)));
            obj.add("dados",jsonobj);
            
            PrintWriter out = response.getWriter();
            out.println(obj.toString());
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
