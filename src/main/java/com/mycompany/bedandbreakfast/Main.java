/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.io.IOException;
import java.nio.charset.CodingErrorAction;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Studente
 */
public class Main 
{
    public static void main(String[] args) throws IOException, EccezionePosizioneNonValida, FileExeption
    {
        int sceltaUtente=-1;
        int esito;
        Registro r1=new Registro();
        Prenotazione p;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[10];
        String nomeFileCSV="Prenotazioni.txt";
        String nomeFileBinario="Prenotazione.bin";
        
        //voci menu
        vociMenu[0] = "Esci dal registro";
        vociMenu[1] = "Aggiungi prenotazione";
        vociMenu[2] = "Visualizza prenotazione";
        vociMenu[3] = "Elimina prenotazione";
        vociMenu[4] = "Visualizza cliene";
        vociMenu[5] = "Visualizza tutte le prenotazioni di un cliente";
        vociMenu[6] = "visualizza tutte le prenotazioni di una stanza";
        vociMenu[7] = "visualizza stanze occupate in una data";
        vociMenu[8] = "esporta file csv";
        vociMenu[9] = "salva dati";
        
        
        Menu menu= new Menu(vociMenu);
        
        try 
        {
            
            r1.caricaPrenotazione(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file. I dati non sono stati caricati");
        }
        
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
                    
                    System.out.println("premi tasto per continuare: ");
                    tastiera.nextLine();
                    
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
                    
                    System.out.println("stanza da assegnare: ");
                    p.setStanza(tastiera.nextInt());
                    
                    r1.aggiungiPrenotazione(p);
                  
                    break;
                }
                 case 2:
                {
                    //visualizza una prenotazione
                    r1.visualizzaPrenotazione();
                            
                    break;
                }
                 case 3:
                {
                    //elimina una prenotazione
                    int codicePrenotazione;
                    System.out.println("inserisci codice prenotazione della prenotazione da eliminare: ");
                    codicePrenotazione=tastiera.nextInt();
                    r1.eliminaPrenotazione(codicePrenotazione);
                    break;       
                }

                 case 4:
                {
                    //visualizza un cliente
                    int codiceFiscale;
                    System.out.println("inserisci codice fiscale dell' utente da visualizzare: ");
                    codiceFiscale=tastiera.nextInt();
                    r1.visualizzaCliente(codiceFiscale);
                    
                    break;
                }
                 case 5:
                {
                    //Visualizza tutte le prenotazioni di un cliente
                    int codiceFiscale;
                    System.out.println("inserisci codice fiscale dell' utente per visualizzare tutte le prenotazioni: ");
                    codiceFiscale=tastiera.nextInt();
                    r1.visualizzaPrenotazioniCliente(codiceFiscale);
                    
                    break;
                }  
                 case 6:
                {
                    //visualizza tutte le prenotazioni di una stanza
                    int stanza;
                    System.out.println("inserisci stanza per visualizzare tutte le prenotazioni effettuate su di essa: ");
                    stanza=tastiera.nextInt();
                    r1.visualizzaPrenotazioniStanze(stanza);
                    
                    break;
                }
                 case 7:
                {
                    //visualizza tutte le stanze occupate in una data
                    int anno;
                    int mese;
                    int giorno;
                    
                    System.out.println("Data da controllare: ");
                    
                    System.out.println("anno: ");
                    anno=tastiera.nextInt();
                    System.out.println("mese: ");
                    mese=tastiera.nextInt();
                    System.out.println("giorno: ");
                    giorno=tastiera.nextInt();
                    
                    LocalDate d1= LocalDate.of(anno, mese, giorno);
                    
                    r1.visualizzaStanzeOccupate(d1);
                    
                    break;    
                }
                 case 8:
                {
                    //esporta la tutte le prenotazioni in un file CSV
                     try
                     {
                         r1.esportaPrenotazioneCsv(nomeFileCSV);
                         System.out.println("esportazione avvenuta correttamente");
                     }
                      
                     catch(IOException e1)
                     {
                         System.out.println("impossibire accedere al FILE");
                     }
                     catch(EccezionePosizioneNonValida |  FileExeption e2)
                     {
                         System.out.println(e2.toString());
                     }
                      break;
                }
                 case 9:
                {
                    //salva tutti i dati in binario
                     try
                     {
                         r1.salvaPrenotazione(nomeFileBinario);
                         System.out.println("dati salvati correttamente");
                     }
                     catch(IOException ex)
                     {
                         System.out.println("impossibile accedere al file");
                     }
                      break;
                }
            }
            
        }while(sceltaUtente!=0);
    }       

}    
