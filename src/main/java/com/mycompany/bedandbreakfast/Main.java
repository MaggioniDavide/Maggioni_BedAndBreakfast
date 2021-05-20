/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.time.LocalDate;

/**
 *
 * @author Studente
 */
public class Main 
{
    public static void main(String[] args)
    {
        Registro r1=new Registro();
        Prenotazione p1=new Prenotazione("davide", "maggioni", 123, LocalDate.now(), LocalDate.now(), 1);
        Prenotazione p2=new Prenotazione("marco", "cesari", 456, LocalDate.now(), LocalDate.now(), 2);
        
        r1.aggiungiPrenotazione(p1);
        r1.aggiungiPrenotazione(p2);
        
        System.out.println(r1.toString());
        
        r1.eliminaPrenotazione(2);
        
        System.out.println(r1.toString());
        
        r1.aggiungiPrenotazione(p2);
        
        System.out.println(r1.toString());
    }
}
