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

    /**
     * @return the IdMembri
     */
    public ArrayList<Integer> getIdMembri() {
        return IdMembri;
    }

    /**
     * @param IdMembri the IdMembri to set
     */
    public void setIdMembri(ArrayList<Integer> IdMembri) {
        this.IdMembri = IdMembri;
    }
    
    private int id;
    private String name;
    private String interesse;
    private int Idamministratore;
    private ArrayList<Integer> IdMembri;
    
    public Gruppo(){
    this.id=0;
    this.name="";
    this.interesse="";
    this.Idamministratore=0;
    this.IdMembri=null;
    
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
        return Idamministratore;
    }

    /**
     * @param Idamministratore the Idamministratore to set
     */
    public void setIdamministratore(int Idamministratore) {
        this.Idamministratore = Idamministratore;
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

    
 
    
}
