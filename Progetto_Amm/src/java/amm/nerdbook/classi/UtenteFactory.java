/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templ
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
                //Controllo formato data di nascita
                if (this.checkFormatDate(res.getString("dataNasc"))) {

                    utente.setDataNascita(res.getString("dataNasc"));

                } else {
                    utente.setDataNascita("00/00/0000");
                }
                
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

                //Controllo formato data di nascita
                if (this.checkFormatDate(res.getString("dataNasc"))) {

                    utente.setDataNascita(res.getString("dataNasc"));

                } else {
                    utente.setDataNascita("00/00/0000");
                }

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

                //Controllo formato data di nascita
                if (this.checkFormatDate(res.getString("dataNasc"))) {

                    utente.setDataNascita(res.getString("dataNasc"));

                } else {
                    utente.setDataNascita("00/00/0000");
                }
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

    public void deleteUtente(Utente utente) throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "utente", "password");
        
        PreparedStatement stmtPosts = null;
        PreparedStatement stmtAmicizia = null;
        PreparedStatement stmtPartecipazione = null;
        PreparedStatement stmtGruppo = null;
        PreparedStatement stmtProf = null;

        String deletePosts = "delete from post "
                + "where post.idMittente=? or post.idDestinatarioUtente=?";
        
        String deleteAmicizia="delete from amicizia "
                             +"where follower=? or followed=?";
        
        String deletePartecipazione= "delete from partecipazioneGruppo "
                                    +"where idUtente=?";
        
        String deleteGruppo="delete from gruppo "
                            +"where idAmministratore=?";
        
        String deleteProfilo = "delete from utente "
                + "where utente.idUtente=?";

        try {

            conn.setAutoCommit(false);

            stmtPosts = conn.prepareStatement(deletePosts);
            stmtAmicizia=conn.prepareStatement(deleteAmicizia);
            stmtPartecipazione=conn.prepareStatement(deletePartecipazione);
            stmtGruppo=conn.prepareStatement(deleteGruppo);
            stmtProf = conn.prepareStatement(deleteProfilo);

            stmtPosts.setInt(1, utente.getId());
            stmtPosts.setInt(2, utente.getId());
            
            stmtAmicizia.setInt(1, utente.getId());
            stmtAmicizia.setInt(2,utente.getId());
            
            stmtPartecipazione.setInt(1, utente.getId());
            
            stmtGruppo.setInt(1, utente.getId());           
            
            stmtProf.setInt(1, utente.getId());

            stmtPosts.executeUpdate();
            stmtAmicizia.executeUpdate();
            stmtPartecipazione.executeUpdate();
            stmtGruppo.executeUpdate();            
            stmtProf.executeUpdate();
           

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
            if(stmtAmicizia!=null){
                stmtAmicizia.close();
            
            }
            
            if(stmtPartecipazione!=null){
            stmtPartecipazione.close();
            }
            
            if(stmtGruppo!=null){
                stmtGruppo.close();
            }
            
            if (stmtProf != null) {
                stmtProf.close();
            }

            conn.setAutoCommit(true);
            conn.close();

        }

    }

    public void updateProfilo(Utente utente) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = " update utente set "
                    + "nome=? ,cognome=? ,urlFotoProfilo=? ,frasePres=? ,dataNasc=? ,username=? ,password=? "
                    + "where idUtente=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, utente.getNome());
            stmt.setString(2, utente.getCognome());
            stmt.setString(3, utente.getUrlFotoProfilo());
            stmt.setString(4, utente.getFrasePres());
            stmt.setString(5, utente.getDataNascita());
            stmt.setString(6, utente.getUsername());
            stmt.setString(7, utente.getPassword());
            stmt.setInt(8, utente.getId());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addAmico(int idUtente, int idAmico) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "insert into amicizia(follower,followed) "
                    + "values (?,?),(?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, idUtente);
            stmt.setInt(2, idAmico);
            stmt.setInt(3, idAmico);
            stmt.setInt(4, idUtente);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addGruppo(int idUtente, int idGruppo) {

        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "insert into partecipazioneGruppo(idUtente,idGruppo) "
                    + "values (?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, idUtente);
            stmt.setInt(2, idGruppo);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public ArrayList <Utente> searchUtente(String value){
        
        ArrayList<Utente> userFound= new ArrayList<>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "select * from utente "
                    + "where nome LIKE ? and cognome LIKE ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, "%" + value + "%");
            stmt.setString(2, "%" + value + "%");

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Utente utente = new Utente();
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                utente.setFrasePres(res.getString("frasePres"));

                //Controllo formato data di nascita
                if (this.checkFormatDate(res.getString("dataNasc"))) {

                    utente.setDataNascita(res.getString("dataNasc"));

                } else {
                    utente.setDataNascita("00/00/0000");
                }
                utente.setUsername(res.getString("username"));
                utente.setPassword(res.getString("password"));
                utente.setId(res.getInt("idUtente"));

                userFound.add(utente);

                

            }

            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;

        
    
    
    }

    private boolean checkFormatDate(String dateString) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
        dt.setLenient(false);

        if (dateString == null) {
            return false;
        }

        try {
            Date date = dt.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
            return false;

        }

        return true;

    }

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

}
