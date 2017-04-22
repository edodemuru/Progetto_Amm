/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.util.ArrayList;

/**
 *
 * @author Edoardo
 */
public class UtenteFactory {
    
    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }
    
    private ArrayList<Utente> Utenti= new ArrayList<>();
    
    private UtenteFactory(){
    //Utente 1 
    Utente utente1= new Utente();
    utente1.setNome("Edoardo");
    utente1.setCognome("Demuru");
    utente1.setId(0);
    utente1.setDataNascita("18/06/1995");
    utente1.setFrasePres("Ciò che non ti uccide ti rende più forte");
    utente1.setPassword("abcd");
    utente1.setUrlFotoProfilo("../img/utente1.jpg");
    
    //Utente 2
    Utente utente2= new Utente();
    utente2.setNome("Marco");
    utente2.setCognome("Broccolo");
    utente2.setId(1);
    utente2.setDataNascita("20/09/1998");
    utente2.setFrasePres("Che la forza sia con te");
    utente2.setPassword("21413");
    utente2.setUrlFotoProfilo("../img/utente2.jpg");
    
    //Utente3
    Utente utente3= new Utente();
    utente3.setNome("Giovanni");
    utente3.setCognome("Puddu");
    utente3.setId(3);
    utente3.setDataNascita("27/02/1994");
    utente3.setFrasePres("Basta un poco di zucchero");
    utente3.setPassword("4325");
    utente3.setUrlFotoProfilo("../img/utente3.jpg");
    
    Utenti.add(utente1);
    Utenti.add(utente2);
    Utenti.add(utente3);
    
    
    
    
    }
    
    public Utente getUtentebyId(int id){
     for(Utente utente: this.Utenti){
       if(utente.getId()==id)
           return utente;
     
     }
     return null;
    
    }
    
    
    
    
}
