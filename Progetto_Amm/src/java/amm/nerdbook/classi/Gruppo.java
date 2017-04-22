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
    private String amministratore;
    
    public Gruppo(){
    this.id=0;
    this.name="";
    this.interesse="";
    this.amministratore="";
    
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
     * @return the amministratore
     */
    public String getAmministratore() {
        return amministratore;
    }

    /**
     * @param amministratore the amministratore to set
     */
    public void setAmministratore(String amministratore) {
        this.amministratore = amministratore;
    }
    
}
