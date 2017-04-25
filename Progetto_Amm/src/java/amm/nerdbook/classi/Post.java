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
    private Utente utenteDest;
    private Gruppo gruppoDest;
    private Utente utenteMitt;
    private String text;
    private String content;
    private Type postType;
    
    public Post(){
     this.id=0;
     this.utenteDest=null;
     this.gruppoDest=null;
     this.utenteMitt=null;
     this.text="";
     this.content="";
     this.postType=Type.TEXT;
     
    
    
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
     * @return the gruppoDest
     */
    public Gruppo getGruppoDest() {
        return gruppoDest;
    }

    /**
     * @param gruppoDest the gruppoDest to set
     */
    public void setGruppoDest(Gruppo gruppoDest) {
        this.gruppoDest = gruppoDest;
    }

    /**
     * @return the utenteDest
     */
    public Utente getUtenteDest() {
        return utenteDest;
    }

    /**
     * @param utenteDest the utenteDest to set
     */
    public void setUtenteDest(Utente utenteDest) {
        this.utenteDest = utenteDest;
    }

    /**
     * @return the utenteMitt
     */
    public Utente getUtenteMitt() {
        return utenteMitt;
    }

    /**
     * @param utenteMitt the utenteMitt to set
     */
    public void setUtenteMitt(Utente utenteMitt) {
        this.utenteMitt = utenteMitt;
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
     * @return the PostType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param PostType the TypePost to set
     */
    public void setPostType(Type PostType) {
        this.postType = PostType;
    }
    
    
}
