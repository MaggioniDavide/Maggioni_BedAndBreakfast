/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.io.IOException;
import java.nio.charset.CodingErrorAction;
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
        int esito;
        Registro r1=new Registro();
        Prenotazione p;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[6];
        
        //voci menu
        vociMenu[0] = "Esci dal registro";
        vociMenu[1] = "Aggiungi prenotazione";
        vociMenu[2] = "Visualizza prenotazione";
        vociMenu[3] = "Elimina prenotazione";
        vociMenu[4] = "Visualizza cliene";
        vociMenu[5] = "Visualizza tutte le prenotazioni di un cliente";
        
        
        Menu menu= new Menu(vociMenu);
        
        do
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
                    p=new Prenotazione();
                    
                    System.out.println("Nome: ");
                    p.setNome(tastiera.nextLine());
                    System.out.println("Cognome: ");
                    p.setCognome(tastiera.nextLine());
                    System.out.println("Codice fiscale: ");
                    p.setCodicefiscale(tastiera.nextInt());
                    System.out.println("Data inizio soggiorno: ");
                    
                    System.out.println("anno: ");
                    int anno=tastiera.nextInt();
                    System.out.println("mese: ");
                    int mese=tastiera.nextInt();
                    System.out.println("giorno: ");
                    int giorno=tastiera.nextInt();
                    
                    p.setDataInizioSoggiorno(LocalDate.of(anno, mese, giorno));
                    System.out.println("Data fine soggiorno: ");
                    
                    System.out.println("anno: ");
                    anno=tastiera.nextInt();
                    System.out.println("mese: ");
                    mese=tastiera.nextInt();
                    System.out.println("giorno: ");
                    giorno=tastiera.nextInt();
                    
                    p.setDataFineSoggiorno(LocalDate.of(anno, mese, giorno));
                    System.out.println("Codice prenotazione: ");
                    p.setCodicePrenotazione(tastiera.nextInt()); 
                    
                    
                    r1.aggiungiPrenotazione(p);
                  
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
            }

        
        /*
        r1.aggiungiPrenotazione(p1);
        r1.aggiungiPrenotazione(p2);
          
        System.out.println(r1.toString());
        
        r1.eliminaPrenotazione(2);
        
        System.out.println(r1.toString());
        
        r1.aggiungiPrenotazione(p2);
        
        System.out.println(r1.toString());
        
        r1.visualizzaCliente(123);
        */
        }while(sceltaUtente!=0);
    }       

}    
