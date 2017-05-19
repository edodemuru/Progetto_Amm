/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.classi.Gruppo;
import amm.nerdbook.classi.GruppoFactory;
import amm.nerdbook.classi.Post;
import amm.nerdbook.classi.PostFactory;
import amm.nerdbook.classi.Utente;
import amm.nerdbook.classi.UtenteFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edoardo
 */
public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);

        if (session != null
                && session.getAttribute("loggedIn") != null
                && session.getAttribute("loggedIn").equals(true)
                && session.getAttribute("idUtente") != null) {

            int idUtente;
            int idAmico;
            int idGruppo;
            
            request.setAttribute("NonAutorizzato", false);

            idUtente = (int) session.getAttribute("idUtente");

            Utente utente = UtenteFactory.getInstance().getUtentebyId(idUtente);
            
            
            // Registrazione id della persona di cui si sta visitando la bacheca
            if (request.getParameter("idAmico") != null && !request.getParameter("idAmico").equals("")) {
                idAmico = Integer.parseInt(request.getParameter("idAmico"));

            } else {
                idAmico = -1;
            }
            
            //Registrazione id del gruppo di cui si sta visitando la bacheca
            if (request.getParameter("idGruppo") != null && !request.getParameter("idGruppo").equals("")) {
                idGruppo = Integer.parseInt(request.getParameter("idGruppo"));

            } else {
                idGruppo = -1;
            }
            

            if (utente != null && idAmico == -1 && idGruppo== -1) {
                //Bacheca propria
                request.setAttribute("utente", utente);

                ArrayList<Utente> ListAmici = UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);

                ArrayList<Post> ListPost = PostFactory.getInstance().getPostListBacheca(utente);
                request.setAttribute("posts", ListPost);

                ArrayList<Gruppo> ListGruppo = GruppoFactory.getInstance().getGruppoListUtente(idUtente);
                request.setAttribute("gruppi", ListGruppo);

                request.setAttribute("propriaBacheca", true);
                
                request.setAttribute("inserimentoPost", 0);

                //Inserimento nuovo post
                if (request.getParameter("nuovoPost") != null) {

                    //Dati che servono alla jsp
                    String testoNuovoPost = request.getParameter("frase");
                    String content = request.getParameter("urlAllegato");
                    String typePost = request.getParameter("allegato");
                    Utente utenteDest = utente;
                    Utente utenteMitt = utente;

                    if (typePost == null) {
                        typePost = "TEXT";
                    }

                    int idUtenteDest = utente.getId();
                    int idUtenteMitt = utente.getId();

                    request.setAttribute("typePost", typePost);
                    request.setAttribute("content", content);
                    request.setAttribute("testoNuovoPost", testoNuovoPost);
                    request.setAttribute("idUtenteDest", idUtenteDest);
                    request.setAttribute("idUtenteMitt", idUtenteMitt);
                    request.setAttribute("utenteMitt", utenteMitt);
                    request.setAttribute("utenteDest", utenteDest);

                    request.setAttribute("nuovoAllegato", true);
                    request.setAttribute("inserimentoPost", 1);

                }

                if (request.getParameter("conferma") != null
                        && request.getParameter("idDestPost") != null) {

                    //Controllo per il messaggio di conferma
                    request.setAttribute("inserimentoPost", 2);
                    //Prendo l'id dell'utente destinatario
                    int idDestPost = Integer.parseInt(request.getParameter("idDestPost"));

                    //Ottengo gli altri dati dell'utente
                    Utente utenteDest = UtenteFactory.getInstance().getUtentebyId(idDestPost);
                    request.setAttribute("utenteDest", utenteDest);

                    String typePost = request.getParameter("typePost");

                    Post nuovoPost = new Post();

                    if (typePost.equals("IMAGE")) {
                        nuovoPost.setPostType(Post.Type.IMAGE);
                    }
                    if (typePost.equals("LINK")) {
                        nuovoPost.setPostType(Post.Type.LINK);
                    } else {
                        nuovoPost.setPostType(Post.Type.TEXT);
                    }

                    nuovoPost.setContent(request.getParameter("content"));
                    nuovoPost.setText(request.getParameter("testoNuovoPost"));
                    nuovoPost.setUtenteMitt(utenteDest);
                    nuovoPost.setUtenteDest(utenteDest);

                    PostFactory.getInstance().addNewPost(nuovoPost);

                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    return;

                } 
                
                if (request.getAttribute("conferma2") != null) {
                    //Reindirizzamento
                    String URL = request.getContextPath() + "/bacheca.html";
                    response.sendRedirect(URL);
                    return;

                }

                request.getRequestDispatcher("bacheca.jsp").forward(request, response);

            }
            if (utente != null && idAmico != -1 && idGruppo==-1) {

                //Bacheca altro utente
                Utente utenteEst = UtenteFactory.getInstance().getUtentebyId(idAmico);

                request.setAttribute("utente", utente);
                request.setAttribute("amico", utenteEst);

                ArrayList<Utente> ListAmici = UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);

                ArrayList<Post> ListPost = PostFactory.getInstance().getPostListBacheca(utenteEst);
                request.setAttribute("posts", ListPost);

                ArrayList<Gruppo> ListGruppo = GruppoFactory.getInstance().getGruppoListUtente(idUtente);
                request.setAttribute("gruppi", ListGruppo);
                
                request.setAttribute("inserimentoPost", 0);

                if (this.verificaAmicizia(idAmico, ListAmici) || idAmico==idUtente) {
                    // amico
                    request.setAttribute("amicizia", true);

                } else //Altro utente
                {
                    request.setAttribute("amicizia", false);
                }

                request.setAttribute("propriaBacheca", false);

                //Controllo per la richiesta di amicizia
                if (request.getParameter("richiestaAmicizia") != null) {
                    UtenteFactory.getInstance().addAmico(idUtente, idAmico);
                    request.setAttribute("amicizia", true);

                    String URL = request.getContextPath() + "/bacheca.html?idAmico=" + idAmico;
                    response.sendRedirect(URL);
                    return;

                }

                //Inserimento nuovo post
                if (request.getParameter("nuovoPost") != null) {
                    //Dati che servono alla jsp
                    String testoNuovoPost = request.getParameter("frase");
                    String content = request.getParameter("urlAllegato");
                    String typePost = request.getParameter("allegato");

                    Utente utenteDest = utenteEst;
                    Utente utenteMitt = utente;

                    if (typePost == null) {
                        typePost = "TEXT";
                    }

                    int idUtenteDest = utenteEst.getId();
                    int idUtenteMitt = utente.getId();

                    request.setAttribute("typePost", typePost);
                    request.setAttribute("content", content);
                    request.setAttribute("testoNuovoPost", testoNuovoPost);
                    request.setAttribute("idUtenteDest", idUtenteDest);
                    request.setAttribute("idUtenteMitt", idUtenteMitt);
                    request.setAttribute("utenteMitt", utenteMitt);
                    request.setAttribute("utenteDest", utenteDest);

                    request.setAttribute("nuovoAllegato", true);
                    request.setAttribute("inserimentoPost", 1);

                }

                //Controllo per il messaggio di conferma del post
                if (request.getParameter("conferma") != null
                        && request.getParameter("idDestPost") != null) {

                    request.setAttribute("inserimentoPost", 2);

                    //Prendo l'id dell'utente destinatario
                    int idDestPost = Integer.parseInt(request.getParameter("idDestPost"));

                    //Ottengo gli altri dati dell'utente
                    Utente utenteDest = UtenteFactory.getInstance().getUtentebyId(idDestPost);
                    request.setAttribute("utenteDest", utenteDest);

                    Post nuovoPost = new Post();

                    String typePost = request.getParameter("typePost");

                    if (typePost.equals("IMAGE")) {
                        nuovoPost.setPostType(Post.Type.IMAGE);
                    }
                    if (typePost.equals("LINK")) {
                        nuovoPost.setPostType(Post.Type.LINK);
                    } else {
                        nuovoPost.setPostType(Post.Type.TEXT);
                    }

                    nuovoPost.setContent(request.getParameter("content"));
                    nuovoPost.setText(request.getParameter("testoNuovoPost"));
                    nuovoPost.setUtenteMitt(utente);
                    nuovoPost.setUtenteDest(utenteDest);

                    PostFactory.getInstance().addNewPost(nuovoPost);

                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    return;

                } 

                if (request.getAttribute("conferma2") != null) {
                    //Reindirizzamento                    
                    String URL = request.getContextPath() + "/bacheca.html";
                    response.sendRedirect(URL);
                    return;

                }

                request.getRequestDispatcher("bacheca.jsp").forward(request, response);

            } 
            if(utente!= null && idGruppo!=-1 && idAmico==-1){
            
            
            }
            
            
            
            else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            request.setAttribute("NonAutorizzato", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);

        }

    }

    public boolean verificaAmicizia(int idAmico, ArrayList<Utente> amici) {
        for (Utente utente : amici) {
            if (utente.getId() == idAmico) {
                return true;
            }

        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
