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
public class Gruppo {

    
    
    private int id;
    private String name;
    private String interesse;
    private int idamministratore;
    private ArrayList<Integer> idMembri;
    private String urlFotoGruppo;
    
    public Gruppo(){
    this.id=0;
    this.name="";
    this.interesse="";
    this.idamministratore=0;
    this.idMembri=null;
    this.urlFotoGruppo="";
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Idamministratore
     */
    public int getIdamministratore() {
        return idamministratore;
    }

    /**
     * @param idamministratore the Idamministratore to set
     */
    public void setIdamministratore(int idamministratore) {
        this.idamministratore = idamministratore;
    }

    /**
     * @return the interesse
     */
    public String getInteresse() {
        return interesse;
    }

    /**
     * @param interesse the interesse to set
     */
    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    /**
     * @return the urlFotoGruppo
     */
    public String getUrlFotoGruppo() {
        return urlFotoGruppo;
    }

    /**
     * @param urlFotoGruppo the UrlFotoGruppo to set
     */
    public void setUrlFotoGruppo(String urlFotoGruppo) {
        this.urlFotoGruppo = urlFotoGruppo;
    }

    /**
     * @return the idMembri
     */
    public ArrayList<Integer> getIdMembri() {
        return idMembri;
    }

    /**
     * @param idMembri the idMembri to set
     */
    public void setIdMembri(ArrayList<Integer> idMembri) {
        this.idMembri = idMembri;
    }

    
 
    
}
