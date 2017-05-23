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
        
      
    }
    
     
    
    public Gruppo getgruppobyId(int id){
    try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "select * from gruppo "
                    + "where idGruppo=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Gruppo gruppo= new Gruppo();
                gruppo.setUrlFotoGruppo(res.getString("urlfotogruppo"));
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
    
     public void deleteGruppo(Gruppo gruppo) throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "utente", "password");
        
        System.out.println("Inizio cancellazione gruppo");

        PreparedStatement stmtPosts = null;
        PreparedStatement stmtPartecipazione=null;
        PreparedStatement stmtGruppo = null;

        String deletePosts = "delete from post "
                + "where idDestinatarioGruppo=?";
        
        String deletePartecipazione="delete from partecipazioneGruppo "
                                   +"where idGruppo=?";

        String deleteGruppo = "delete from gruppo "
                + "where idGruppo=?";

        try {

            conn.setAutoCommit(false);

            stmtPosts = conn.prepareStatement(deletePosts);
            stmtPartecipazione=conn.prepareStatement(deletePartecipazione);
            stmtGruppo = conn.prepareStatement(deleteGruppo);

            stmtPosts.setInt(1, gruppo.getId());
            
            stmtPartecipazione.setInt(1,gruppo.getId());       

            stmtGruppo.setInt(1, gruppo.getId());
            
            stmtPosts.executeUpdate();
            stmtPartecipazione.executeUpdate();
            stmtGruppo.executeUpdate();
            

            conn.commit();
            

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                

            } catch (SQLException e2) {
                e2.printStackTrace();

            }

        } finally {
            if (stmtPosts != null) {
                stmtPosts.close();
            }
            
            if(stmtPartecipazione !=null){
                stmtPartecipazione.close();            
            }
            
            if (stmtGruppo != null) {
                stmtGruppo.close();
            }

            conn.setAutoCommit(true);
            conn.close();

        }

    }
     
     public void setConnectionString(String s){
	this.connectionString = s;
}
public String getConnectionString(){
	return this.connectionString;
}
     
     
     
    
    
}
