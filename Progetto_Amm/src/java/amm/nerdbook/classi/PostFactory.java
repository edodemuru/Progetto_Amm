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
public class PostFactory {
    
    private static PostFactory singleton;
    
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private ArrayList<Post> post=new ArrayList<>();
    
    private PostFactory(){
     UtenteFactory utenteFactory = UtenteFactory.getInstance();

        //Post 1
        Post post1 = new Post();
        post1.setText("Ehi ciao! Da quanto non ci sentiamo! Vediamoci appena puoi!");
        post1.setContent("");
        post1.setId(1);
        post1.setUtente(utenteFactory.getUtentebyId(0));
        post1.setTypePost(Post.Type.TEXT);

        //Post 2
        Post post2 = new Post();
        post2.setText("Ehi guarda la foto di questo bellissimo gatto!");
        post2.setContent("../img/djanni1.jpg");
        post2.setId(1);
        post2.setUtente(utenteFactory.getUtentebyId(1));
        post2.setTypePost(Post.Type.IMAGE);

        //Post 3
        Post post3 = new Post();
        post3.setText("Ehi guarda questo video di youtube!");
        post3.setContent("https://www.youtube.com/watch?v=-OnRxfhbHB4");
        post3.setId(2);
        post3.setUtente(utenteFactory.getUtentebyId(0));
        post3.setTypePost(Post.Type.LINK);
        
        post.add(post1);
        post.add(post2);
        post.add(post3);
    
    
    }
    
    public Post getPostId(int id){
     for(Post post: this.post){
       if(post.getId()==id)
           return post;
     
     }
     return null;
    
    }
    
}
