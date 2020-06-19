/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.LoginDAO;

/**
 *
 * @author juann
 */
public class Testes {
    public static void main(String[] args){
        System.out.println(!LoginDAO.emailCadastrado("jmjkh2@gmail.com"));
        System.out.println("");
    }
}
