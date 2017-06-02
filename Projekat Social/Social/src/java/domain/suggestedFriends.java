/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Nikola
 */
@WebServlet(name = "suggestedFriends", urlPatterns = {"/suggestedFriends"})
public class suggestedFriends extends HttpServlet {

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
        
        Session hbma = HibernateUtil.getSessionFactory().openSession();
        int id = request.getParameter("id")!=null?Integer.parseInt(request.getParameter("id")):0;
        
        User friendUser =(User)hbma.get(User.class, id);
        request.setAttribute("friendUser", friendUser);
        
        SQLQuery query = hbma.createSQLQuery("select user2 from friends where user1 in (select user2 from friends where user1 = :id) ");
        query.setParameter("id", id);
        List<Integer>idijevi = query.list();
        List<User>suggestedFriends = new ArrayList<User>();
        for(int user_id : idijevi){
            suggestedFriends.add((User)hbma.get(User.class, user_id));
        }
        request.setAttribute("suggestedFriends", suggestedFriends);
        request.getRequestDispatcher("suggestedFriends.jsp").forward(request, response);
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
