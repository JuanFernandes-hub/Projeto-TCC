/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juann
 */

//classe para modelo ajax
public interface Modelo {

    public void executa(HttpServletRequest request, HttpServletResponse response);
    
}
