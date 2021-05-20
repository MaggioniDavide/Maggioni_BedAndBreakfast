/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

/**
 *
 * @author Studente
 */
public class Registro 
{
    private Prenotazione[] registroPrenotazioni;
    private static final int N_POSTI=100;
    private static final int N_STANZE=5;
    private int nPrenotazioniPresenti;
    private int prezzo=40;

    //aggiungi prenotazione
    public int aggiungiPrenotazione(Prenotazione p)
    {
        if(nPrenotazioniPresenti>=N_POSTI)
            return 0;
        
        registroPrenotazioni[nPrenotazioniPresenti]=p;
        nPrenotazioniPresenti++;
        
        return 1;
    }
  
    //elimina prenotazione
    public int eliminaPrenotazione(Prenotazione p)
    {
        
    }
    
    
    
    //visualizza prenotazione
    
    
    
    
    //visualizza dati cliente
}
