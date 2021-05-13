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
    
}
