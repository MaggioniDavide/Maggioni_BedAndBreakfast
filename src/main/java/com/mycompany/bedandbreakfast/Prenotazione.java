/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.time.*;
import java.io.Serializable;
/**
 *
 * @author Studente
 */
public class Prenotazione implements Serializable
{
    private String nome;
    private String cognome;
    private int codicefiscale;
    private static final int N_STANZE=5;
    private int stanza;
    private final int prezzo=40;
    private LocalDate dataInizioSoggiorno;
    private LocalDate dataFineSoggiorno;
    private int codicePrenotazione;
    
    //costruttore
    public Prenotazione(String nome, String cognome, int codicefiscale, LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno, int codicePrenotazione, int stanza) 
    {
        this.nome = nome;
        this.cognome = cognome;
        this.codicefiscale = codicefiscale;
        this.dataInizioSoggiorno = dataInizioSoggiorno;
        this.dataFineSoggiorno = dataFineSoggiorno;
        this.codicePrenotazione = codicePrenotazione;   
        this.stanza = stanza; 
    }
    
    //costruttore di copia
    public Prenotazione(Prenotazione p) 
    {
        this.nome= p.getNome();
        this.cognome= p.getCognome();
        this.codicefiscale= p.getCodicefiscale();
        this.dataInizioSoggiorno= p.getDataInizioSoggiorno();
        this.dataFineSoggiorno= p.getDataFineSoggiorno();
        this.codicePrenotazione= p.getCodicePrenotazione();
        this.stanza= p.getStanza();
    }
    
    public Prenotazione ()
   {
       nome="";
       cognome="";
       codicefiscale=0;
       dataInizioSoggiorno=null;
       dataFineSoggiorno=null;
       codicePrenotazione=0;
       stanza=0;
   }
    
    //metodi
    
    //getter
    public int getStanza() 
    {
        return stanza;
    }
     
    public String getNome() 
    {
        return nome;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public int getCodicefiscale() 
    {
        return codicefiscale;
    }

    public static int getN_STANZE() 
    {
        return N_STANZE;
    }

    public int getPrezzo() 
    {
        return prezzo;
    }

    public LocalDate getDataInizioSoggiorno() 
    {
        return dataInizioSoggiorno;
    }

    public LocalDate getDataFineSoggiorno() 
    {
        return dataFineSoggiorno;
    }

    public int getCodicePrenotazione() 
    {
        return codicePrenotazione;
    }
    
    //setter
    public void setStanza(int stanza) 
    {
        this.stanza = stanza;
    }
    
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public void setCodicefiscale(int codicefiscale) 
    {
        this.codicefiscale = codicefiscale;
    }

    public void setDataInizioSoggiorno(LocalDate dataInizioSoggiorno) 
    {
        this.dataInizioSoggiorno = dataInizioSoggiorno;
    }

    public void setDataFineSoggiorno(LocalDate dataFineSoggiorno) 
    {
        this.dataFineSoggiorno = dataFineSoggiorno;
    }

    public void setCodicePrenotazione(int codicePrenotazione)
    {
        this.codicePrenotazione = codicePrenotazione;
    }
    
    //toString
    public String toString()
    {
         String s;
         
         s= "nome: "+getNome()+","+" cognome: "+getCognome()+","+" codice fiscale: "+getCodicefiscale()+","+" data di inizio soggiorno: "+getDataInizioSoggiorno()+","+" data di fine soggiorno: "+getDataFineSoggiorno()+","+" codice della prenotazione: "+getCodicePrenotazione()+","+" prezzo: "+getPrezzo()+","+" stanza: "+getStanza();
         
         return s;    
    }
      
}
