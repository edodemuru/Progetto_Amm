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
public class Descrizione extends HttpServlet {

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

        if (session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true) &&
                request.getParameter("idUtente")!=null) {

            String user = request.getParameter("idUtente");

            int idUtente;

            idUtente = Integer.parseInt(user);

            

            Utente utente = UtenteFactory.getInstance().getUtentebyId(idUtente);

            if (utente != null) {
                request.setAttribute("utente", utente);

                ArrayList<Utente> ListAmici = UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);
                
                ArrayList<Gruppo> ListGruppo=GruppoFactory.getInstance().getGruppoListUtente(idUtente);
                request.setAttribute("gruppi", ListGruppo);

                request.getRequestDispatcher("descrizione.jsp").forward(request, response);

            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else{
            
            request.getRequestDispatcher("descrizione.jsp").forward(request, response);
        
        
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
