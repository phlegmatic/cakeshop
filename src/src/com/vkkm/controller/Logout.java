package src.com.vkkm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	 
	      try {
	         out.println("<html><head><title>Logout</title></head><body>");
	         out.println("<h2>Logout</h2>");
	         HttpSession session = request.getSession(false);
	         if (session == null) {
	            out.println("<h3>You have not login!</h3>");
	         } else {
	            session.invalidate();
	            out.println("<p>Bye!</p>");
	            out.println("<p><a href='index.jsp'>Login</a></p>");
	         }
	         out.println("</body></html>");
	      } finally {
	         out.close();
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
