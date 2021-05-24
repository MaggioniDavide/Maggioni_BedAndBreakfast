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
public class Registro 
{
    private Prenotazione[] registroPrenotazioni;
    private static final int N_POSTI=100;
    private static final int N_STANZE=5;
    private static int [] stanze;
    private int nPrenotazioniPresenti;
    private int prezzo=40;
    
    //costruttore
    public Registro()
    {
        registroPrenotazioni=new Prenotazione[N_POSTI];
        stanze= new int[N_STANZE];
        
        this.nPrenotazioniPresenti=0;
    }
    
    //stanze libere
    public static int StanzaLibera(int[] stanze)
    {
        for(int i=0;i<stanze.length;i++)
        {
            if(stanze[i]!=1)
            {
                return i;
            }
        }
        return -1;
    }

    //aggiungi prenotazione
    public int aggiungiPrenotazione(Prenotazione p)
    {      
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]==null)
              {
                 int stanza=StanzaLibera(stanze);
                 if(stanza==-1)
                 {
                     System.out.println("tutte le stanze sono occupate");
                     return -1;
                 }
                 else
                 {
                     p.setStanza(stanza+1);
                     stanze[stanza]=1;
                 }
                 registroPrenotazioni[i]=new Prenotazione(p);
                 System.out.println("inserimento avvenuto correttamente!");
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
        if(nPrenotazioniPresenti==0)
        System.out.println("Nessuna prenotazione presente");
        
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
              {
                  System.out.println(registroPrenotazioni[i].toString());
              }  
        }
        
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
    
    //visualizza tutte le prenotazioni effettuate da un cliente
    public void visualizzaPrenotazioniCliente(int codicefiscale)
    {
        int a=0;
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
            {
                if(registroPrenotazioni[i].getCodicefiscale()==codicefiscale)
                   {
                       System.out.println(registroPrenotazioni[i].toString());
                       a++;
                   }
            }
            
        }
        if(a==0)
        {
            System.out.println("Nessun cliente corrisponde a questo codice fiscale");
        }
        else 
        {
            return;
        }
    }
    
    //visualizza tutte le prenotazioni avute da una determinata stanza
    public void visualizzaPrenotazioniStanze(int stanza)
    {
        int a=0;
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
            {
                if(registroPrenotazioni[i].getStanza()==stanza)
                   {
                       System.out.println(registroPrenotazioni[i].toString());
                       a++;
                   }
            }
            
        }
    }
    
    //visualizza stanze occupate in una data
    public int visualizzaStanzeOccupate(LocalDate dataDaControllare)
    {
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
            {
                LocalDate inizio=registroPrenotazioni[i].getDataInizioSoggiorno();
                LocalDate fine=registroPrenotazioni[i].getDataFineSoggiorno();

                if(dataDaControllare.isAfter(inizio))
                {
                    if(dataDaControllare.isBefore(fine))
                    {
                        System.out.println("stanze occupate: "+registroPrenotazioni[i].getStanza());

                    }

                }
                System.out.println("stanze libere: "+registroPrenotazioni[i].getStanza());
        
            }
               
        }return 0;  
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
