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
public class Utente {
    
    private String nome;
    private String cognome;
    private String urlFotoProfilo;
    private String frasePres;
    private String dataNascita;
    private String username;
    private String password;
    private int id;
    private ArrayList<Integer> amici;
    private ArrayList<Integer> gruppi;
    
    public Utente(){
        this.id=0;
        this.nome="";
        this.cognome="";
        this.urlFotoProfilo="";
        this.frasePres="";
        this.dataNascita="";
        this.username="";
        this.password="";
        this.amici=null;
        this.gruppi=null;
    
    
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

    /**
     * @return the amici
     */
    public ArrayList<Integer> getAmici() {
        return amici;
    }

    /**
     * @param amici the amici to set
     */
    public void setAmici(ArrayList<Integer> amici) {
        this.amici = amici;
    }

    /**
     * @return the gruppi
     */
    public ArrayList<Integer> getGruppi() {
        return gruppi;
    }

    /**
     * @param gruppi the gruppi to set
     */
    public void setGruppi(ArrayList<Integer> gruppi) {
        this.gruppi = gruppi;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
    
    @Override
    public boolean equals(Object altroUtente){
        if(altroUtente instanceof Utente){
            if(this.getId()==((Utente) altroUtente).getId())
                return true;
        }
            return false;
   
    
    
    
    }
    
}
