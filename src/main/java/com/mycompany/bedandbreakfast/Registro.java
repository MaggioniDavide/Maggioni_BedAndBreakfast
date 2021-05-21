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
    
    //costruttore
    public Registro()
    {
        registroPrenotazioni=new Prenotazione[N_POSTI];
        
        this.nPrenotazioniPresenti=0;
    }

    //aggiungi prenotazione
    public int aggiungiPrenotazione(Prenotazione p)
    {      
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]==null)
              {
                 registroPrenotazioni[i]=new Prenotazione(p);
                 nPrenotazioniPresenti++;
                 
                 return 0;
              }  
        }
        return -1;
    }
  
    //elimina prenotazione
    public int eliminaPrenotazione(int codicePrenotazione)
    {
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
              {
                 if(registroPrenotazioni[i].getCodicePrenotazione()==codicePrenotazione)
                 {
                     registroPrenotazioni[i]=null;
                     nPrenotazioniPresenti--;
                     
                     return 0;
                 }
              }  
        }
        return -1;
    }
      
    //visualizza prenotazione
    public void visualizzaPrenotazione()
    {
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
              {
                  System.out.println(registroPrenotazioni[i].toString());
              }  
        }
        System.out.println("Nessuna prenotazione presente");
    }
    
    //visualizza dati cliente
    public void visualizzaCliente(int codicefiscale)
    {
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
            {
                if(registroPrenotazioni[i].getCodicefiscale()==codicefiscale)
                   {
                       System.out.println("nome: "+registroPrenotazioni[i].getNome()+","+" cognome: "+registroPrenotazioni[i].getCognome()+","+" codice fiscale: "+registroPrenotazioni[i].getCodicefiscale());
                       
                       return;
                   }
            }
            
        }
        System.out.println("Nessun cliente corrisponde a questo codice fiscale");
    }
    
    //visualizza tutte le prenotazioni di un cliente
    public void visualizzaPrenotazioniCliente(int codicefiscale)
    {
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
            {
                if(registroPrenotazioni[i].getCodicefiscale()==codicefiscale)
                   {
                       System.out.println(registroPrenotazioni[i].toString());
                       
                       return;
                   }
            }
            
        }
        System.out.println("Nessun cliente corrisponde a questo codice fiscale");
    }
    
    //toString
    public String toString()
    {
        String s="";
         
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
              {
                  s=s+registroPrenotazioni[i].toString()+"\n";
              }  
        }
         
        return s;    
    }
}
