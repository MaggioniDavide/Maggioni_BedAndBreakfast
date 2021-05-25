/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bedandbreakfast;

/**
 *
 * @author david
 */
class FileExeption extends Exception 
{
    String motivoEccezione;

    public FileExeption(String message)
    {
        motivoEccezione=message;
        
    }
    public String toString()
    {
        return motivoEccezione;
    }
   
    
}
