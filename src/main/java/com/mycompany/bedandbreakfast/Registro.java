/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    /**
     * questo metodo serve per creare ed aggiungere una prenotazione al registro
     * al metodo viene passato p che contiene al suo interno tutti gli attributi utili: nome,cognome,codicefiscale,datainizio,datafine,numeroprenotazione e stanza
     * @param p
     * @return 
     */
    public int aggiungiPrenotazione(Prenotazione p)
    {      
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]==null)
              {
                  
                 registroPrenotazioni[i]=new Prenotazione(p);
                 System.out.println("inserimento avvenuto correttamente!");
                 nPrenotazioniPresenti++;
                 
                 return 0;
              }  
        }
        return -1;
    }
  
    //elimina prenotazione
    /**
     * questo metodo serve per eliminare una prenotazione precedentemente inserita nel registro
     * al metodo viene passato l'attributo codiceprenotazione: tramite questo attributo possiamo risalire all intero testo delle prenotazione ed eliminarlo(serve ad identificare la prenotazione)
     * @param codicePrenotazione
     * @return 
     */

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
    /**
     * questo metodo serve per visualizzare tutte le prenotazioni inserite nel registro
     */
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
    /**
     * questo metodo serve per visualizzare i dati di un cliente (nome,cognome,codicefiscale)
     * al metodo viene passato l'attributo codice fiscale: tramite questo attributo possiamo visualizzare tutti i dati dell'utente identificandolo
     * @param codicefiscale 
     */
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
    /**
     * questo metodo serve per visualizzare tutte le prenotazioni che un cliente ha effettuato presso il bed and breakfast
     * al metodo viene passato l'attributo codice fiscale : serve per individuare l'utente e ci mostrerà tutti i dati (nome,cognome,codicefiscale,data inizio,data fine,codice prenotazione e stanza)di tutte le prenotazioni con quel codice fiscale
     * @param codicefiscale 
     */
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
    /**
     * questo metodo serve per individuare tutte le prenotazioni che sono state efettuate su una determinata stanza del bed and breakfast
     * al metodo viene passato l'attributo stanza: serve per indicare quale stanza si vuole controllare e tramite esso riusciremo a risalire a tutte le prenotazioni contenenti quella stanza
     * @param stanza 
     */
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
    /**
     * questo metodo serve per visualizzare in una determinata data quali stanze saranno occupate
     * al metodo passiamo l'attributo datadacontrollare: serve per creare una data che verrà confrontata con tutte le date presenti nel registro (quindi tutte le prenotazioni) e controllarà quali e quante stanza sono occupate e quali sono libere in quel determinato giorno
     * @param dataDaControllare
     * @return 
     */
    public int visualizzaStanzeOccupate(LocalDate dataDaControllare)
    {
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
            {
                LocalDate inizio=registroPrenotazioni[i].getDataInizioSoggiorno();
                LocalDate fine=registroPrenotazioni[i].getDataFineSoggiorno();
                
                if(dataDaControllare==inizio)
                {
                    System.out.println("stanze occupate: "+registroPrenotazioni[i].getStanza());
                }
                else if(dataDaControllare==fine)
                {
                    System.out.println("stanze occupate: "+registroPrenotazioni[i].getStanza());
                }
                else if(dataDaControllare.isAfter(inizio))
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
    
    
    public void esportaPrenotazione(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileExeption
    { 
      TextFile f1= new TextFile(nomeFile, 'w');
      
      for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)
                {
                  f1.toFile("Nome-->"+registroPrenotazioni[i].getNome()+"; "+"cognome-->"+registroPrenotazioni[i].getCognome()+"; "+"codice fiscale-->"+registroPrenotazioni[i].getCodicefiscale()+"; "+"data inizio-->"+registroPrenotazioni[i].getDataInizioSoggiorno()+"; "+"data fine-->"+registroPrenotazioni[i].getDataFineSoggiorno()+";"+"codice prenotazione-->"+registroPrenotazioni[i].getCodicePrenotazione()+";"+"stanza-->"+registroPrenotazioni[i].getStanza());
                   
                }
        }
             
    }
        
   
    
    //esporta prenotazione CSV
    /**
     * questo metodo serve per esportare in formato csv il file
     * viene passato nome file: il file che vogliamo venga esportato
     * @param nomeFile
     * @throws IOException
     * @throws EccezionePosizioneNonValida
     * @throws FileExeption 
     */
    public void esportaPrenotazioneCsv(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileExeption
    {
        TextFile f1= new TextFile(nomeFile, 'W');
        String rigaDaScrivere="";
      
        for(int i=0;i<this.registroPrenotazioni.length;i++)
        {
            if(registroPrenotazioni[i]!=null)             
                { 
                    rigaDaScrivere="Nome-->"+registroPrenotazioni[i].getNome()+"; "+"cognome-->"+registroPrenotazioni[i].getCognome()+"; "+"codice fiscale-->"+registroPrenotazioni[i].getCodicefiscale()+"; "+"data inizio-->"+registroPrenotazioni[i].getDataInizioSoggiorno()+"; "+"data fine-->"+registroPrenotazioni[i].getDataFineSoggiorno()+";"+"codice prenotazione-->"+registroPrenotazioni[i].getCodicePrenotazione()+";"+"stanza-->"+registroPrenotazioni[i].getStanza();  
                }
        }
      
    f1.close();
    }
    
    //salva dati
    /**
     * questo metodo serve per salvare tutti i dati in binario
     * viene passato nome file cio il file con all'interno i dati da voler trasformare in binario
     * @param nomeFile
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void salvaPrenotazione(String nomeFile) throws FileNotFoundException, IOException
  {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream writer=new ObjectOutputStream(f1);
      writer.writeObject(this);
      writer.flush();
      writer.close();
  }
    
    
    
    public Prenotazione caricaPrenotazione(String nomeFile) throws FileNotFoundException, IOException, FileExeption 
  {
      FileInputStream f1=new FileInputStream(nomeFile);
      ObjectInputStream inputStream=new ObjectInputStream(f1);
      Prenotazione s;
       try 
       {
           s=(Prenotazione)inputStream.readObject();
           inputStream.close();
            return s;
       } 
       catch (ClassNotFoundException ex) 
       {
          inputStream.close();
          throw new FileExeption("Errore nella lettura del file");
       }
       
  }
    
    //toString
    /**
     * questo metodo mostra tutti gli attributi
     * @return 
     */
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
