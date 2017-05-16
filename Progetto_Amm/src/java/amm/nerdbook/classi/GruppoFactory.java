/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Edoardo
 */
public class GruppoFactory {
    
    private static GruppoFactory singleton;
    private String connectionString;
    
    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }
    
    private ArrayList<Gruppo> gruppi=new ArrayList<>();
    
    public GruppoFactory(){
        
       /* //Gruppo 1
        Gruppo gruppo1=new Gruppo();
        gruppo1.setIdamministratore(0);
        gruppo1.setId(3);
        gruppo1.setInteresse("Studio");
        gruppo1.setName("Ingegneria");
        ArrayList <Integer> membri1=new ArrayList<>();
        membri1.add(0);
        membri1.add(1);
        gruppo1.setIdMembri(membri1);
        gruppo1.setUrlFotoGruppo("img/gruppo2.jpg");
        
        //Gruppo 2
        Gruppo gruppo2=new Gruppo();
        gruppo2.setIdamministratore(1);
        gruppo2.setId(4);
        gruppo2.setInteresse("Studio");
        gruppo2.setName("Informatica");
        ArrayList<Integer> membri2=new ArrayList<>();
        membri2.add(2);
        membri2.add(0);
        gruppo2.setIdMembri(membri2);
        gruppo2.setUrlFotoGruppo("img/gruppo1.jpg");
        
        gruppi.add(gruppo1);
        gruppi.add(gruppo2);*/
    
    }
    
     /*public Gruppo getGruppobyId(int id){
     for(Gruppo gruppo: this.gruppi){
       if(gruppo.getId()==id)
           return gruppo;
     
     }
     return null;
    
    }*/
    
    public Gruppo getgruppobyId(int id){
    try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "select * from utente "
                    + "where idUtente=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Gruppo gruppo= new Gruppo();
                gruppo.setUrlFotoGruppo(res.getString("urlFotoGruppo"));
                gruppo.setInteresse(res.getString("interesse"));
                gruppo.setName(res.getString("nome"));
                gruppo.setId(res.getInt("idGruppo"));
                gruppo.setIdamministratore(res.getInt("idAmministratore"));
                
                stmt.close();
                conn.close();

                return gruppo;

            }

            //Nel caso la ricerca non dia risultati
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     
     /*public ArrayList<Gruppo> getGruppoListUtente(int id){
         ArrayList<Gruppo> GruppoList=new ArrayList<>();
         for(Gruppo gruppo: this.gruppi){
             if(gruppo.getIdMembri().contains(id)){
                 GruppoList.add(gruppo);
             
             }
         
         }
         
         return GruppoList;
     
     
     }*/
    
    public ArrayList<Gruppo> getGruppoListUtente(int id){
        ArrayList<Gruppo> gruppoList=new ArrayList<>();
        
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");
            
            
            String query = 
                      "select * from gruppo "
                    + "join partecipazionegruppo on gruppo.idgruppo = partecipazionegruppo.idgruppo "
                    + "where partecipazionegruppo.idutente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1,id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Gruppo gruppo= new Gruppo();
                
                gruppo.setUrlFotoGruppo(res.getString("urlFotoGruppo"));
                gruppo.setInteresse(res.getString("interesse"));
                gruppo.setName(res.getString("nome"));
                gruppo.setId(res.getInt("idGruppo"));
                gruppo.setIdamministratore(res.getInt("idAmministratore"));
                
               
                gruppoList.add(gruppo);
                
            }

            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gruppoList;
    
    
    
    }
     
     public void setConnectionString(String s){
	this.connectionString = s;
}
public String getConnectionString(){
	return this.connectionString;
}
     
     
     
    
    
}
