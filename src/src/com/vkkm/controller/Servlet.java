package src.com.vkkm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
				rd.include(request, response);
				//redirection
			}	
			else{
				System.out.println("invalid user"); //invalid message
		
			}
		}
		else if (hiddenvar.equalsIgnoreCase("createUserlogic")){
			 System.out.println("in servlet");
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
			//redirection nd exception handling here
		}

	}
}
                	   /* Login l=new Login();
                	   l.setEmail(email);
                	   l.setPassword(password);
                	   l.setCategory(category);
                	   int retCount=d.insert(l);
                	   
                	   if(retCount>0){
                		request.setAttribute("key", l);
                		RequestDispatcher r= request.getRequestDispatcher("/loginview.jsp");
                		r.forward(request, response);
                	   } else {
                		   RequestDispatcher r= request.getRequestDispatcher("/login.jsp");
                		   r.forward(request, response);
                	   }
                   }
                   if(hiddenvar.equalsIgnoreCase("bookinsert")){
                	   int bid=Integer.parseInt(request.getParameter("bid"));
                	   String bname=request.getParameter("bname");
                	   String author=request.getParameter("author");
                	   int pages=Integer.parseInt(request.getParameter("pages"));
                	   Book b=new Book();
                	   b.setBid(bid);
                	b.setBname(bname);
                	b.setAuthor(author);
                	b.setPages(pages);
                	Book b1=d.binsert(b);
                	System.out.println(b1);
                	   

                	   
                   }
                   if(hiddenvar.equalsIgnoreCase("bookview")){
                	   ArrayList<Book> blist=new ArrayList<Book>();
                	   blist=d.viewall();
                	   request.setAttribute("viewall", blist);
                	   RequestDispatcher r=request.getRequestDispatcher("/viewallbook.jsp");
                	r.forward(request, response);
                   }
                   if(hiddenvar.equalsIgnoreCase("personinsert")){
                	   int pid=Integer.parseInt(request.getParameter("pid"));
                	   String pname=request.getParameter("pname");
                	   int bid=Integer.parseInt(request.getParameter("bid"));
                	   Person p=new Person();
                	   p.setPid(pid);
                	   p.setPname(pname);
                	   p.setBid(bid);
                	   Person p1=d.insert(p);
                	   System.out.println(p1);
                   }
                   if(hiddenvar.equalsIgnoreCase("personview")){
                	   Person p=new Person();
                	   if(request.getParameter("bid")!=null){
                	   ArrayList<Person> plist=new ArrayList<Person>();
                	   plist=d.viewall1();
                	   request.setAttribute("view",plist);
                	   RequestDispatcher r=request.getRequestDispatcher("/viewallperson.jsp");
                	   r.forward(request, response);
                   }
          }
 
	}

}}*/