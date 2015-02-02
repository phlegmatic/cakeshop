package src.com.vkkm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import src.com.vkkm.bean.Order;
import src.com.vkkm.bean.User;
import src.com.vkkm.model.HibernateFactory;


/**
 * Servlet implementation class Servlet
 */

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Servlet.class.getName());
    /**
     * Default constructor. 
     */
    /*public Servlet() {
        // TODO Auto-generated constructor stub
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException{
		Dao d= new Dao();
		
		String hiddenvar=request.getParameter("hiddenVar");
		
		log.info("in servlet with hidden variable"+hiddenvar);
		
		if(hiddenvar.equalsIgnoreCase("loginlogic")){
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			System.out.println(email+" AND  "+password);

			User u= new User();
			u.setEmail(email);
			u.setPassword(password);
			//Order o= new Order();
			if(d.isValidUser(u)){
				System.out.println("valid user");
				//fetch details  of user
				List<User> userDetail=d.getUserDetails(u);
				// Create a new HTTPSession and save the username and roles
	            // First, invalidate the session. if any
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				session = request.getSession(true);
				synchronized (session) {
					session.setAttribute("userInSessionList", userDetail); //setting userdetails in session
				}
				//redirection based upon roles
				if(userDetail.get(0).getUserType().equalsIgnoreCase("user")){
					System.out.println("userrole");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
					rd.include(request, response);
				}
				else{
					System.out.println("adminrole");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout-2-notneeded.html");
					rd.include(request, response);
				}
					
				//redirection
			}	
			else{
				System.out.println("invalid user"); //invalid message
			}
		}
		else if (hiddenvar.equalsIgnoreCase("createUserlogic")){
			 System.out.println("in create user servlet");
			String firstname = request.getParameter("firstName");
			String lastname = request.getParameter("lastName");
			String email = request.getParameter("email"); //unique validation exception message
			String password = request.getParameter("password");
			
			User u=new User();
			u.setFirstname(firstname);
			u.setLastname(lastname);
			u.setEmail(email);
			u.setPassword(password);
			
			d.CreateUser(u);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
			//redirection nd exception handling here
		}
	
		else if (hiddenvar.equalsIgnoreCase("createProductlogic")){
			System.out.println("in create product");
		}
	}
	/* logout
	 * response.setContentType("text/html;charset=UTF-8");
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
            out.println("<p><a href='index.html'>Login</a></p>");
         }
         out.println("</body></html>");
      } finally {
         out.close();
      }
	 */
}
