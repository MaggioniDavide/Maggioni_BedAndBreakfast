/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Studente
 */
public class Main 
{
    public static void main(String[] args)
    {
        int sceltaUtente=-1;
        int esitoOperazione;
        Registro r1=new Registro();
        Prenotazione prenotazione;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[8];
        
        //voci menu
        vociMenu[0] = "Esci dal registro";
        vociMenu[1] = "Aggiungi prenotazione";
        vociMenu[2] = "Visualizza prenotazione";
        vociMenu[3] = "Elimina prenotazione";
        vociMenu[4] = "Visualizza cliene";
        vociMenu[5] = "Visualizza tutte le prenotazioni di un cliente";
        vociMenu[6] = " ";
        vociMenu[7] = " ";
        vociMenu[8] = " ";
        
        Menu menu= new Menu(vociMenu);
        
        do
        {
            try
            {
                 sceltaUtente=menu.sceltaMenu();
            switch(sceltaUtente)
            {
                case 0:
                {
                    //esci dal registro
                    System.out.println("il registro viene chiuso");
                    break;
                }
                case 1:
                {
                    //aggiungi una prenotazione
                    
                    break;
                }
                 case 2:
                {
                    //visualizza una prenotazione
                    
                    break;
                }
                 case 3:
                {
                    //elimina una prenotazione
                    
                    break;       
                }
                 case 4:
                {
                    //visualizza un cliente
                    
                    break;
                }
                 case 5:
                {
                    //Visualizza tutte le prenotazioni di un cliente
                    
                    break;
                }           
        }while(sceltaUtente!=0);

        Prenotazione p1=new Prenotazione("davide", "maggioni", 123, LocalDate.now(), LocalDate.now(), 1);
        Prenotazione p2=new Prenotazione("marco", "cesari", 456, LocalDate.now(), LocalDate.now(), 2);
        
        r1.aggiungiPrenotazione(p1);
        r1.aggiungiPrenotazione(p2);
          
        System.out.println(r1.toString());
        
        r1.eliminaPrenotazione(2);
        
        System.out.println(r1.toString());
        
        r1.aggiungiPrenotazione(p2);
        
        System.out.println(r1.toString());
        
        r1.visualizzaCliente(123);
        
    }
}
