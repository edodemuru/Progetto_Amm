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
public class Login extends HttpServlet {

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

        if (request.getParameter("logout") != null) {

            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

        //Utente loggato in precedenza
        if (session.getAttribute("loggedIn") != null
                && session.getAttribute("loggedIn").equals(true) &&
                session.getAttribute("idUtente")!=null              
                ) {

            // Ricerco l'utente
           
            int idUtente=(int) session.getAttribute("idUtente");

            Utente utente = UtenteFactory.getInstance().getUtentebyId(idUtente);

            // Verifica profilo utente
            if (session.getAttribute("ProfileOk") != null
                    && session.getAttribute("ProfileOk").equals(true)) {

                if (utente != null) {
                    //Carico la bacheca

                    //request.setAttribute("loggedUserID", idUtente);
                    session.setAttribute("loggedUserID", idUtente);

                    request.getRequestDispatcher("bacheca.html").forward(request, response);
                    
                    return;

                } else {
                    //Utente inesistente

                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }

            } else {
                if (utente != null) {
                    //Utente con profilo incompleto

                    session.setAttribute("ProfileOk", false);
                    //request.setAttribute("idUtente", idUtente);
                    session.setAttribute("idUtente", idUtente);

                    request.getRequestDispatcher("profilo.html").forward(request, response);
                    return;

                } else {
                    //Utente inesistente
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }

            }

        } else if (request.getParameter("Submit") != null) {
            //Utente non loggato in precedenza
            //Verifica username e password     
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //Tentativo di login da parte dell'utente
            if (username != null && password != null && this.login(username, password)) {

                session.setAttribute("loggedIn", true);

                Utente utente = UtenteFactory.getInstance().getUtenteByUsername(username);
                Integer idUtente = utente.getId();

               // request.setAttribute("idUtente", idUtente);
                session.setAttribute("idUtente", idUtente);
                
                
                if (checkProfile(utente)) {
                    //Utente con profilo completo
                    session.setAttribute("ProfileOk", true);
                    request.getRequestDispatcher("bacheca.html").forward(request, response);
                    return;
                    
                   
                } else {
                    //Utente con profilo incompleto
                    session.setAttribute("ProfileOk", false);

                    request.getRequestDispatcher("profilo.html").forward(request, response);
                    return;

                }

            } else {
                //Username o password errati
                request.setAttribute("errore", "Errore nell'inserimento dell'username o della password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;

            }

        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

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

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        ArrayList<Utente> utenti = UtenteFactory.getInstance().getUtenti();
        for (Utente utente : utenti) {
            if (utente.getUsername().equals(username) && utente.getPassword().equals(password)) {
                return true;

            }

        }

        return false;
    }

    public boolean checkProfile(Utente utente) {
        if (utente != null) {
            return !(utente.getNome().equals("") || utente.getCognome().equals("") || utente.getFrasePres().equals("")
                    || utente.getUrlFotoProfilo().equals(""));
        } else {
            return true;
        }

    }

}
