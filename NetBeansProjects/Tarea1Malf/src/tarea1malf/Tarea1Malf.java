/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1malf;

/**
 *
 * @author fernanda
 */
public class Tarea1Malf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InfixToPostfix prueba = new InfixToPostfix();
        
        RegExConverter prueba2 = new RegExConverter();
        System.out.println("postfix: " + prueba2.infixToPostfix("a|(a.b)*"));
    }
    
}
