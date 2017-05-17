/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//CHECK DELLE DATE
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
public class PostFactory {

    private static PostFactory singleton;
    private String connectionString;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> post = new ArrayList<>();

    private PostFactory() {
        /*UtenteFactory utenteFactory = UtenteFactory.getInstance();

        //Post 1
        Post post1 = new Post();
        post1.setText("Ehi ciao! Da quanto non ci sentiamo! Vediamoci appena puoi!");
        post1.setContent("");
        post1.setId(1);
        post1.setUtenteDest(utenteFactory.getUtentebyId(0));
        post1.setGruppoDest(null);
        post1.setUtenteMitt(utenteFactory.getUtentebyId(1));
        post1.setPostType(Post.Type.TEXT);

        //Post 2
        Post post2 = new Post();
        post2.setText("Ehi guarda la foto di questo bellissimo gatto!");
        post2.setContent("img/djanni1.jpg");
        post2.setId(1);
        post2.setUtenteDest(utenteFactory.getUtentebyId(0));
        post2.setGruppoDest(null);
        post2.setUtenteMitt(utenteFactory.getUtentebyId(1));
        post2.setPostType(Post.Type.IMAGE);

        //Post 3
        Post post3 = new Post();
        post3.setText("Ehi guarda questo video di youtube!");
        post3.setContent("https://www.youtube.com/watch?v=-OnRxfhbHB4");
        post3.setId(2);
        post3.setUtenteDest(utenteFactory.getUtentebyId(0));
        post3.setGruppoDest(null);
        post3.setUtenteMitt(utenteFactory.getUtentebyId(2));
        post3.setPostType(Post.Type.LINK);
        
        //Post 4
        Post post4 = new Post();
        post4.setText("Ciao come stai?");        
        post4.setId(9);
        post4.setUtenteDest(utenteFactory.getUtentebyId(0));
        post4.setGruppoDest(null);
        post4.setUtenteMitt(utenteFactory.getUtentebyId(2));
        post4.setPostType(Post.Type.TEXT);
        
        post.add(post1);
        post.add(post2);
        post.add(post3);
        post.add(post4);*/

    }

    public Post getPostbyId(int id) {
        try {
            UtenteFactory utenteFactory = UtenteFactory.getInstance();
            GruppoFactory gruppoFactory = GruppoFactory.getInstance();

            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "select * from post "
                    + "join postType on postType.idType = post.idPostType "
                    + "where idPost=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);

            ResultSet res = stmt.executeQuery();

            if (res.next()) {

                Post post = new Post();
                post.setText(res.getString("text"));
                post.setId(res.getInt("idPost"));
                post.setUtenteDest(utenteFactory.getUtentebyId(res.getInt("idDestinatarioUtente")));
                post.setGruppoDest(gruppoFactory.getgruppobyId(res.getInt("idDestinatarioGruppo")));
                post.setUtenteMitt(utenteFactory.getUtentebyId(res.getInt("idDestinatarioUtente")));
                post.setPostType(postTypeFromString(res.getString("name")));

                stmt.close();
                conn.close();

                return post;

            }

            //Nel caso la ricerca non dia risultati
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<Post> getPostListBacheca(Utente utente) {
        ArrayList postList = new ArrayList();

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            UtenteFactory utenteFactory = UtenteFactory.getInstance();

            String query
                    = "select * from post "
                    + "join posttype on post.idposttype = posttype.idtype "
                    + "where idDestinatarioUtente = ?";

            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);

            // Si associano i valori
            stmt.setInt(1, utente.getId());

            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {

                // Settaggio parametri del post
                Post current = new Post();

                current.setId(res.getInt("idpost"));
                current.setUtenteMitt(utenteFactory.getUtentebyId(res.getInt("idMittente")));
                current.setUtenteDest(utenteFactory.getUtentebyId(res.getInt("idDestinatarioUtente")));
                current.setGruppoDest(null);
                current.setContent(res.getString("content"));
                current.setText(res.getString("text"));
                current.setPostType(this.postTypeFromString(res.getString("name")));

                if (current.getUtenteDest() != null) {
                    postList.add(current);
                }
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postList;

    }

    //Lista dei post di un gruppo
    public ArrayList<Post> getPostListGruppo(Gruppo gruppo) {
        ArrayList postList = new ArrayList();

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            UtenteFactory utenteFactory = UtenteFactory.getInstance();
            GruppoFactory gruppoFactory = GruppoFactory.getInstance();

            String query
                    = "select * from post "
                    + "join posttype on post.idposttype = posttype.idtype "
                    + "where idDestinarioGruppo = ?";

            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);

            // Si associano i valori
            stmt.setInt(1, gruppo.getId());

            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {

                Post current = new Post();

                current.setId(res.getInt("idpost"));
                current.setUtenteMitt(utenteFactory.getUtentebyId(res.getInt("idMittente")));
                current.setUtenteDest(null);
                current.setGruppoDest(gruppoFactory.getgruppobyId(res.getInt("idDestinatarioGruppo")));
                current.setContent(res.getString("content"));
                current.setText(res.getString("text"));
                current.setPostType(this.postTypeFromString(res.getString("name")));

                if (current.getUtenteDest() != null) {
                    postList.add(current);
                }

            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postList;

    }

    public void addNewPost(Post post) {
        try {
            Connection conn = DriverManager.getConnection(connectionString, "utente", "password");

            String query = "insert into post (idPost,content,text,idPostType,idMittente,idDestinatarioUtente,idDestinatarioGruppo) "
                    + "values(default,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, post.getContent());
            stmt.setString(2, post.getText());
            stmt.setInt(3, this.postTypeFromEnum(post.getPostType()));
            stmt.setInt(4, post.getUtenteMitt().getId());

            if (post.getUtenteDest() != null && post.getGruppoDest() == null) {
                stmt.setInt(5, post.getUtenteDest().getId());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);;                
            }

            if (post.getGruppoDest() != null && post.getUtenteDest()== null) {
                stmt.setInt(6, post.getGruppoDest().getId());
            } else {               
               stmt.setNull(6, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    private Post.Type postTypeFromString(String type) {
        if (type.equals("TEXT")) {
            return Post.Type.TEXT;
        }
        if (type.equals("IMAGE")) {
            return Post.Type.IMAGE;
        }

        return Post.Type.LINK;

    }

    private int postTypeFromEnum(Post.Type type) {
        if (type == Post.Type.TEXT) {
            return 0;
        } else if (type == Post.Type.IMAGE) {
            return 1;
        }
        return 2;

    }

}
