package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("action");
        if(logout != null) {
            session.invalidate();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null) {
            request.setAttribute("message", "Hello, " + session.getAttribute("username"));
        }
        else {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            if (username != null) {
                request.setAttribute("message", "Hello, " + username);
            }
        }
        
        
        String item = request.getParameter("item");
        if (item != null) {
            ArrayList<String> array =(ArrayList<String>) session.getAttribute("items");
            if(array == null) {
                array = new ArrayList<String>();
            }
            array.add(item);
            session.setAttribute("items", array);
        }
        
        String delete = request.getParameter("delete");
        if(delete != null) {
            ArrayList<String> array = (ArrayList<String>) session.getAttribute("items");
            array.remove(delete);
            session.setAttribute("items", array);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }



}
