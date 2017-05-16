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

        //Utente 1 
        /*Utente utente1= new Utente();
    utente1.setNome("Edoardo");
    utente1.setCognome("Demuru");
    utente1.setId(0);
    utente1.setDataNascita("1995-06-18");
    utente1.setFrasePres("Ciò che non ti uccide ti rende più forte");
    utente1.setUsername("edo95");
    utente1.setPassword("abcd");
    utente1.setUrlFotoProfilo("img/utente1.jpg");
    ArrayList<Integer> Amici1= new ArrayList<>();
    ArrayList<Integer>Gruppi1= new ArrayList<>();
    
    
    //Utente 2
    Utente utente2= new Utente();
    utente2.setNome("Marco");
    utente2.setCognome("Broccolo");
    utente2.setId(1);
    utente2.setDataNascita("1998-09-20");
    utente2.setFrasePres("Che la forza sia con te");
    utente2.setUsername("marco23");
    utente2.setPassword("456");
    utente2.setUrlFotoProfilo("img/utente2.jpg");
    ArrayList<Integer> Amici2= new ArrayList<>();
    ArrayList<Integer>Gruppi2= new ArrayList<>();
    
    
    //Utente3
    Utente utente3= new Utente();
    utente3.setNome("Giovanni");
    utente3.setCognome("");
    utente3.setId(2);
    utente3.setDataNascita("1994-02-27");
    utente3.setFrasePres("");
    utente3.setUsername("ciao94");
    utente3.setPassword("4325");
    utente3.setUrlFotoProfilo("img/utente3.jpg");
    ArrayList<Integer> Amici3= new ArrayList<>();
    ArrayList<Integer>Gruppi3= new ArrayList<>();
  
    
    //Amici
    Amici1.add(2);
    Amici2.add(0);
    Amici2.add(2);
    utente1.setAmici(Amici1);
    utente2.setAmici(Amici2);
    utente3.setAmici(Amici3);
    
    //Gruppi         
    Gruppi1.add(3);
    Gruppi1.add(4);
    utente1.setGruppi(Gruppi1);
    utente2.setGruppi(Gruppi2);
    utente3.setGruppi(Gruppi3);
    
    Utenti.add(utente1);
    Utenti.add(utente2);
    Utenti.add(utente3);*/
    }

    /*public Utente getUtentebyId(int id){
     for(Utente utente: this.getUtenti()){
       if(utente.getId()==id)
           return utente;
     
     }
     return null;
    
    }*/
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

    /*public ArrayList<Utente> getListAmicibyId(int id){
      ArrayList<Utente> ListAmici=new ArrayList<>();
      Utente utente=getUtentebyId(id);
      
      for(int idAmico: utente.getAmici()){
        ListAmici.add(getUtentebyId(idAmico));
      }
      
      return ListAmici;
  
  
  }*/
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

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

}
