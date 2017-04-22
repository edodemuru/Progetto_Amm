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
public class Utente {
    
    private String nome;
    private String cognome;
    private String urlFotoProfilo;
    private String frasePres;
    private String dataNascita;
    private String password;
    private int id;
    
    public Utente(){
        this.id=0;
        this.nome="";
        this.cognome="";
        this.urlFotoProfilo="";
        this.frasePres="";
        this.dataNascita="";
        this.password="";
    
    
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    /**
     * @return the frasePres
     */
    public String getFrasePres() {
        return frasePres;
    }

    /**
     * @param frasePres the frasePres to set
     */
    public void setFrasePres(String frasePres) {
        this.frasePres = frasePres;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
    
    @Override
    public boolean equals(Object altroUtente){
        if(altroUtente instanceof Utente){
            if(this.getId()==((Utente) altroUtente).getId())
                return true;
        }
            return false;
   
    
    
    
    }
    
}
