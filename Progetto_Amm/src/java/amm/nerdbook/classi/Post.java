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
public class Post {
    
    public enum Type {
        TEXT,IMAGE,LINK
    };
    
    private int id;
    private Utente utente;
    private String text;
    private String content;
    private Type TypePost;
    
    public Post(){
     this.id=0;
     this.utente=null;
     this.text="";
     this.content="";
     this.TypePost=Type.TEXT;
     
    
    
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
     * @return the utente
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * @param utente the utente to set
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the TypePost
     */
    public Type getTypePost() {
        return TypePost;
    }

    /**
     * @param TypePost the TypePost to set
     */
    public void setTypePost(Type TypePost) {
        this.TypePost = TypePost;
    }
    
    
}
