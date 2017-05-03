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
            request.setAttribute("NonAutorizzato", false);

            idUtente = (int) session.getAttribute("idUtente");

            Utente utente = UtenteFactory.getInstance().getUtentebyId(idUtente);

            if (request.getParameter("idAmico") != null && !request.getParameter("idAmico").equals("")) {
                idAmico = Integer.parseInt(request.getParameter("idAmico"));

            } else {
                idAmico = -1;
            }

            if (utente != null && idAmico == -1) {
                //Bacheca propria
                request.setAttribute("utente", utente);

                ArrayList<Utente> ListAmici = UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);

                ArrayList<Post> ListPost = PostFactory.getInstance().getPostListBacheca(utente);
                request.setAttribute("posts", ListPost);

                ArrayList<Gruppo> ListGruppo = GruppoFactory.getInstance().getGruppoListUtente(idUtente);
                request.setAttribute("gruppi", ListGruppo);

                request.setAttribute("propriaBacheca", true);

                if (request.getParameter("conferma") != null
                        && request.getParameter("idDestPost") != null) {

                    //Controllo per il messaggio di conferma
                    request.setAttribute("inserimentoPost", 2);
                    int idDestPost = Integer.parseInt(request.getParameter("idDestPost"));

                    Utente utenteDest = UtenteFactory.getInstance().getUtentebyId(idDestPost);
                    request.setAttribute("utenteDest", utenteDest);

                } else {
                    request.setAttribute("inserimentoPost", 0);
                }

                //Inserimento nuovo post
                if (request.getParameter("nuovoPost") != null) {
                    Post nuovoPost = new Post();

                    //Tipo di post
                    if (request.getParameter("allegato") != null
                            && request.getParameter("allegato").equals("Immagine")) {
                        nuovoPost.setPostType(Post.Type.IMAGE);
                        nuovoPost.setContent(request.getParameter("urlAllegato"));
                        nuovoPost.setText(request.getParameter("frase"));
                        nuovoPost.setUtenteMitt(utente);
                        nuovoPost.setUtenteDest(utente);
                        nuovoPost.setId((int) (Math.random()) * 10000);

                        request.setAttribute("nuovoAllegato", true);
                        request.setAttribute("nuovoPost", nuovoPost);
                        request.setAttribute("inserimentoPost", 1);

                    } else if (request.getParameter("allegato") != null && request.getParameter("allegato").equals("URL")) {
                        nuovoPost.setPostType(Post.Type.LINK);
                        nuovoPost.setContent(request.getParameter("urlAllegato"));
                        nuovoPost.setText(request.getParameter("frase"));
                        nuovoPost.setUtenteMitt(utente);
                        nuovoPost.setUtenteDest(utente);
                        nuovoPost.setId((int) (Math.random()) * 10000);

                        request.setAttribute("nuovoAllegato", true);
                        request.setAttribute("nuovoPost", nuovoPost);
                        request.setAttribute("inserimentoPost", 1);
                    } else {
                        nuovoPost.setPostType(Post.Type.TEXT);
                        nuovoPost.setText(request.getParameter("frase"));
                        nuovoPost.setUtenteMitt(utente);
                        nuovoPost.setUtenteDest(utente);
                        nuovoPost.setId(10);

                        //Ci sono allegati nel post?
                        request.setAttribute("nuovoAllegato", false);
                        // Creo un attributo in cui inserisco il nuovo post
                        request.setAttribute("nuovoPost", nuovoPost);
                        // Attributo per modifica pagina html di output
                        request.setAttribute("inserimentoPost", 1);

                    }

                }

                request.getRequestDispatcher("bacheca.jsp").forward(request, response);

            }
            if (utente != null && idAmico != -1) {

                //Bacheca amico
                Utente amico = UtenteFactory.getInstance().getUtentebyId(idAmico);

                request.setAttribute("utente", utente);
                request.setAttribute("amico", amico);

                ArrayList<Utente> ListAmici = UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);

                ArrayList<Post> ListPost = PostFactory.getInstance().getPostListBacheca(amico);
                request.setAttribute("posts", ListPost);

                ArrayList<Gruppo> ListGruppo = GruppoFactory.getInstance().getGruppoListUtente(idUtente);
                request.setAttribute("gruppi", ListGruppo);

                request.setAttribute("propriaBacheca", false);

                if (request.getParameter("conferma") != null
                        && request.getParameter("idDestPost") != null) {

                    //Controllo per il messaggio di conferma
                    request.setAttribute("inserimentoPost", 2);
                    int idDestPost = Integer.parseInt(request.getParameter("idDestPost"));

                    Utente utenteDest = UtenteFactory.getInstance().getUtentebyId(idDestPost);
                    request.setAttribute("utenteDest", utenteDest);

                } else {
                    request.setAttribute("inserimentoPost", 0);
                }

                //Inserimento nuovo post
                if (request.getParameter("nuovoPost") != null) {
                    Post nuovoPost = new Post();

                    //Tipo di post
                    if (request.getParameter("allegato") != null
                            && request.getParameter("allegato").equals("Immagine")) {
                        nuovoPost.setPostType(Post.Type.IMAGE);
                        nuovoPost.setContent(request.getParameter("urlAllegato"));
                        nuovoPost.setText(request.getParameter("frase"));
                        nuovoPost.setUtenteMitt(utente);
                        nuovoPost.setUtenteDest(amico);
                        nuovoPost.setId((int) (Math.random()) * 10000);

                        request.setAttribute("nuovoAllegato", true);
                        request.setAttribute("nuovoPost", nuovoPost);
                        request.setAttribute("inserimentoPost", 1);

                    } else if (request.getParameter("allegato") != null && request.getParameter("allegato").equals("URL")) {
                        nuovoPost.setPostType(Post.Type.LINK);
                        nuovoPost.setContent(request.getParameter("urlAllegato"));
                        nuovoPost.setText(request.getParameter("frase"));
                        nuovoPost.setUtenteMitt(utente);
                        nuovoPost.setUtenteDest(amico);
                        nuovoPost.setId((int) (Math.random()) * 10000);

                        request.setAttribute("nuovoAllegato", true);
                        request.setAttribute("nuovoPost", nuovoPost);
                        request.setAttribute("inserimentoPost", 1);
                    } else {
                        nuovoPost.setPostType(Post.Type.TEXT);
                        nuovoPost.setText(request.getParameter("frase"));
                        nuovoPost.setUtenteMitt(utente);
                        nuovoPost.setUtenteDest(amico);
                        nuovoPost.setId(11);

                        request.setAttribute("nuovoAllegato", false);
                        request.setAttribute("nuovoPost", nuovoPost);
                        request.setAttribute("inserimentoPost", 1);

                    }

                }

                request.getRequestDispatcher("bacheca.jsp").forward(request, response);

            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            request.setAttribute("NonAutorizzato", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);

        }

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
