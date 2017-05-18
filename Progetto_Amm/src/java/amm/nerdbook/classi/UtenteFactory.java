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
public class UtenteFactory {

    private static UtenteFactory singleton;
    private String connectionString;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    //private ArrayList<Utente> utenti = new ArrayList<>();

    private UtenteFactory() {

        
    }

   
    public Utente getUtentebyId(int id) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "select * from utente "
                    + "where idUtente=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Utente utente = new Utente();
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                utente.setFrasePres(res.getString("frasePres"));
                utente.setDataNascita(res.getString("dataNasc"));
                utente.setUsername(res.getString("username"));
                utente.setPassword(res.getString("password"));
                utente.setId(res.getInt("idUtente"));

                stmt.close();
                conn.close();

                return utente;

            }

            //Nel caso la ricerca non dia risultati
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

  
    public ArrayList<Utente> getListAmicibyId(int id) {
        ArrayList<Utente> ListAmici = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");
            String query = "select * from utente "
                    + "join amicizia on utente.idutente = amicizia.follower "
                    + "where utente.idutente= ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                int idAmico = res.getInt("followed");
                ListAmici.add(getUtentebyId(idAmico));

            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListAmici;

    }

    /**
     * @return the Utenti
     */
    public ArrayList<Utente> getUtenti() {
        ArrayList<Utente> utenti = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");
            String query = "select * from utente";
                    
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Utente utente = new Utente();
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                utente.setFrasePres(res.getString("frasePres"));
                utente.setDataNascita(res.getString("dataNasc"));
                utente.setUsername(res.getString("username"));
                utente.setPassword(res.getString("password"));
                utente.setId(res.getInt("idUtente"));
                
                utenti.add(utente);
                
            }
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return utenti;
    }

    public Utente getUtenteByUsername(String username) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "select * from utente "
                    + "where username=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, username);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                Utente utente = new Utente();
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                utente.setFrasePres(res.getString("frasePres"));
                utente.setDataNascita(res.getString("dataNasc"));
                utente.setUsername(res.getString("username"));
                utente.setPassword(res.getString("password"));
                utente.setId(res.getInt("idUtente"));

                stmt.close();
                conn.close();

                return utente;

            }

            //Nel caso la ricerca non dia risultati
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
    public void deleteUtente(Utente utente) throws SQLException{
        Connection conn = DriverManager.getConnection(connectionString, "utente", "password");
        
        PreparedStatement stmtPosts = null;
        PreparedStatement stmtProf=null;
        
        
        String deletePosts= "delete from post "
                           +"where idMittente=? or idDestinatarioUtente=?";
        
        String deleteProfilo="delete from utente "
                             +"where idUtente=?";
        
        try{
            
            
            conn.setAutoCommit(false);
            
            stmtPosts = conn.prepareStatement(deletePosts);
            stmtProf =conn.prepareStatement(deleteProfilo);
            
            stmtPosts.setInt(1, utente.getId());
            stmtPosts.setInt(2, utente.getId());
            
            stmtProf.setInt(1,utente.getId());
            
            int ver1= stmtPosts.executeUpdate();
            int ver2=stmtProf.executeUpdate();
            
            if(ver1!=1 || ver2!=1)
                conn.rollback();
            
            conn.commit();
          
        
        
        }catch(SQLException e){
            try{
                conn.rollback();
                
            
            } catch(SQLException e2){
            
            }
        
        } finally{
            if(stmtPosts!=null)
                stmtPosts.close();
            if(stmtProf!=null)
                stmtProf.close();
            
            conn.setAutoCommit(true);
            conn.close();
        
        
        }
                            
    
    }

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

}
