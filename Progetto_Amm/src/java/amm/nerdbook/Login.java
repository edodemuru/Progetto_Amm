/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

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
 
        
        HttpSession session = request.getSession();
        session.setAttribute("LoggedIn", "no");
        session.setAttribute("ProfileOk", "no");
        
        
        
        //Utente non loggato in precedenza
         if(request.getParameter("Submit")!=null && 
               session.getAttribute("LoggedIn").equals("no")){
            //Verifica username e password     
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            
            //Tentativo di login da parte dell'utente
            if(username != null && password != null && this.login(username, password)){
                session.setAttribute("LoggedIn", true);
                Utente utente=UtenteFactory.getInstance().getUtenteByUsername(username);
                int idUtente=utente.getId();
                
                session.setAttribute("idUtente", idUtente);
                
                if(checkProfile(utente)){
               
                request.setAttribute("utente",utente );
             
                ArrayList<Utente> ListAmici= UtenteFactory.getInstance().getListAmicibyId(idUtente);
                request.setAttribute("amici", ListAmici);
             
                ArrayList<Post> ListPost=PostFactory.getInstance().getPostListBacheca(utente);
                request.setAttribute("posts", ListPost);
                session.setAttribute("ProfileOk", true);
             
             
             
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
                else{
                    session.setAttribute("ProfileOk", false);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                
                }
   
                
            }
            //Password errata 
            else if(this.login(username, password)==false){
                request.setAttribute("errore", "Errore nell'inserimento dell'username o della password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            
            }
            
            }
         
         
        
         
         else if(session.getAttribute("LoggedIn").equals(true)){
            //Utente loggato in precedenza
            
            // Ricerco l'utente
            int idUtente= (int) session.getAttribute("idUtente");
                      
            Utente utente= UtenteFactory.getInstance().getUtentebyId(idUtente);
        
            // Verifica profilo utente
            if(session.getAttribute("ProfileOk").equals(true)){
                if(utente!= null){
                    //Carico la bacheca
                    
                    request.setAttribute("utente",utente );
             
                    ArrayList<Utente> ListAmici= UtenteFactory.getInstance().getListAmicibyId(idUtente);
                    request.setAttribute("amici", ListAmici);
             
                    ArrayList<Post> ListPost=PostFactory.getInstance().getPostListBacheca(utente);
                    request.setAttribute("posts", ListPost);
         
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
   
         } else
                    //Utente inesistente
                {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
         }
                
            
            
            }
            else{
                if(utente!=null){
                    //Utente con profilo incompleto
                    request.setAttribute("utente", utente);
                    session.setAttribute("ProfileOk", false);
                                      
                    request.getRequestDispatcher("profilo.jsp").forward(request, response);
                
                }
                else{
                    //Utente inesistente
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);                
                }
                
            
            
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
    public boolean login(String username, String password){
        ArrayList<Utente> utenti=UtenteFactory.getInstance().getUtenti();
        for(Utente utente: utenti){
            if(utente.getUsername().equals(username) && utente.getPassword().equals(password)){
              return true; 
            
            
            }
        
        }
  
    return false;
  } 
    
    public boolean checkProfile(Utente utente){
        if(utente!=null){
        return !(utente.getNome()==null || utente.getCognome()==null || utente.getFrasePres()==null || 
                utente.getUrlFotoProfilo()==null);
        }
        else{
            return true;        
        }
    
    
    }




}
