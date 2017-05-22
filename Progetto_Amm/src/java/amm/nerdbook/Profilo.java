/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.classi.Gruppo;
import amm.nerdbook.classi.GruppoFactory;
import amm.nerdbook.classi.Utente;
import amm.nerdbook.classi.UtenteFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class Profilo extends HttpServlet {

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

            request.setAttribute("NonAutorizzato", false);

            int idUtente = (int) session.getAttribute("idUtente");

            Utente utente = UtenteFactory.getInstance().getUtentebyId(idUtente);

            if (utente != null) {
                request.setAttribute("utente", utente);

                ArrayList<Utente> ListAmici = UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);

                ArrayList<Gruppo> ListGruppo = GruppoFactory.getInstance().getGruppoListUtente(idUtente);
                request.setAttribute("gruppi", ListGruppo);

                //Modifica del profilo
                if (request.getParameter("modifica") != null) {

                    String nome = request.getParameter("nome");
                    String cognome = request.getParameter("cognome");
                    String url = request.getParameter("url");
                    String frasePres = request.getParameter("frase");
                    String data = request.getParameter("data");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String confpassword = request.getParameter("confpassword");

                    Utente utenteAgg = new Utente();
                    utenteAgg.setNome(nome);
                    utenteAgg.setCognome(cognome);
                    utenteAgg.setFrasePres(frasePres);
                    utenteAgg.setDataNascita(data);
                    utenteAgg.setPassword(password);
                    utenteAgg.setUsername(username);
                    utenteAgg.setUrlFotoProfilo(url);
                    utenteAgg.setId(idUtente);

                    UtenteFactory.getInstance().updateProfilo(utenteAgg);

                    request.setAttribute("modificaDati", true);
                    
                    String URL = request.getContextPath() + "/profilo.html";
                    response.sendRedirect(URL);
                    return;

                }
                //Cancellazione profilo 
                if (request.getParameter("cancella") != null) {
                    try {
                        UtenteFactory.getInstance().deleteUtente(utente);
                        session.setAttribute("loggedIn", false);
                        session.setAttribute("idUtente", null);

                        request.getRequestDispatcher("login.html").forward(request, response);
                        return;

                    } catch (SQLException e) {

                    }

                }

                request.getRequestDispatcher("profilo.jsp").forward(request, response);

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
     * @throws IOException if an I/O error occu
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
