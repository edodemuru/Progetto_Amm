/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;

/**
 *
 * @author Edoardo
 */
public class Gruppo {
    
    private int id;
    private String name;
    private String interesse;
    private int Idamministratore;
    
    public Gruppo(){
    this.id=0;
    this.name="";
    this.interesse="";
    this.Idamministratore=0;
    
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
