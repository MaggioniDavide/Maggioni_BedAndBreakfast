/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.time.*;

/**
 *
 * @author Studente
 */
public class Prenotazione
{
    private String nome;
    private String cognome;
    private int codicefiscale;
    private static final int N_STANZE=5;
    private int prezzo=40;
    private LocalDate dataInizioSoggiorno;
    private LocalDate dataFineSoggiorno;
    private int codicePrenotazione;
    
    //costruttore
    public Prenotazione(String nome, String cognome, int codicefiscale, String dataInizioSoggiorno, String dataFineSoggiorno, int codicePrenotazione, int anno, int mese, int giorno) 
    {
        this.nome = nome;
        this.cognome = cognome;
        this.codicefiscale = codicefiscale;
        this.dataInizioSoggiorno = LocalDate.of(anno, mese, giorno);
        this.dataFineSoggiorno = LocalDate.of(anno, mese, giorno);
        this.codicePrenotazione = codicePrenotazione;
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
    }
    
    //metodi
    
    //getter
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

    public void setPrezzo(int prezzo)
    {
        this.prezzo = prezzo;
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
         
         s= "nome:"+getNome()+"cognome:"+getCognome()+"codice fiscale:"+getCodicefiscale()+"data di inizio soggiorno:"+getDataInizioSoggiorno()+"data di fine soggiorno:"+getDataFineSoggiorno()+"codice della prenotazione:"+getCodicePrenotazione();
         
         return s;    
    }
}
