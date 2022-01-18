/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widok;

import ORM.HashDAO;
import ORM.NewHash;
import ORM.Wcy19kc1s1DudkaProjekt;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kontroler.DataBeanLocal;

/**
 *
 * @author student
 */
//@WebServlet(name = "HashServlet", urlPatterns = {"/HashServlet"})
@WebServlet(urlPatterns = {"/"})
public class HashServlet extends HttpServlet {

    @EJB
    private DataBeanLocal bean;
    private HashDAO hashDAO;
    /*
    @Override
    public void init() {
        hashDAO = new HashDAO();
    }
    */
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
        hashDAO = new HashDAO();
        String action = request.getServletPath();
        
        try {
            switch (action) {
                case "/new":
                    generateForm(request, response);
                    break;
                case "/delete":
                    deleteHash(request, response);
                    break;
                case "/add":
                    insertHash(request, response);
                    break;
                case "/calculate":
                    calculateForm(request, response);
                    break;
                
                default:
                    listHash(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listHash(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List<Wcy19kc1s1DudkaProjekt> listHash = hashDAO.getAllHash();
        request.setAttribute("listHash", listHash);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hashHistory.jsp");
        dispatcher.forward(request, response);
    }
    
    private void calculateForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //hashDAO = new HashDAO();
        String input = request.getParameter("input");
        if(input == null) {
            generateForm(request, response);
        }
        else {
            bean.calculateHash(input);
            NewHash newHash = new NewHash(request.getParameter("input"), bean.getHash());
            RequestDispatcher dispatcher = request.getRequestDispatcher("hashGenerate.jsp");
            request.setAttribute("newHash", newHash);
            dispatcher.forward(request, response);
        }
    }
    
    private void generateForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //hashDAO = new HashDAO();
        RequestDispatcher dispatcher = request.getRequestDispatcher("hashGenerate.jsp");
        dispatcher.forward(request, response);
    }
    
    private void deleteHash(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //hashDAO = new HashDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        hashDAO.deleteHash(id);
        response.sendRedirect("listHash");
    }
    
    private void insertHash(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //int id = Integer.parseInt(request.getParameter("input"));   //tymczasowo
        String hash = request.getParameter("hash");
        Wcy19kc1s1DudkaProjekt newHash = new Wcy19kc1s1DudkaProjekt(hash);
        hashDAO.insertHash(newHash);
        response.sendRedirect("listHash");
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
