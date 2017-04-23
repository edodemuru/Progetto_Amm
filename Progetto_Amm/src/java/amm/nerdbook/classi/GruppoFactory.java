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
public class GruppoFactory {
    
    private static GruppoFactory singleton;
    
    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }
    
    private ArrayList<Gruppo> gruppi=new ArrayList<>();
    
    public GruppoFactory(){
        
        //Gruppo 1
        Gruppo gruppo1=new Gruppo();
        gruppo1.setIdamministratore(0);
        gruppo1.setId(0);
        gruppo1.setInteresse("Studio");
        gruppo1.setName("Ingegneria");
        
        //Gruppo 2
        Gruppo gruppo2=new Gruppo();
        gruppo1.setIdamministratore(1);
        gruppo1.setId(1);
        gruppo1.setInteresse("Studio");
        gruppo1.setName("Informatica");
        
        gruppi.add(gruppo1);
        gruppi.add(gruppo2);
    
    }
    
     public Gruppo getGruppobyId(int id){
     for(Gruppo gruppo: this.gruppi){
       if(gruppo.getId()==id)
           return gruppo;
     
     }
     return null;
    
    }
     
     
     
    
    
}
