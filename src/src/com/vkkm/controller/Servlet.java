package src.com.vkkm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.vkkm.bean.Book;
import src.com.vkkm.bean.Login;
import src.com.vkkm.bean.Person;
import src.com.vkkm.model.Dao;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                   Dao d=new Dao();
                   
                   String hiddenvar=request.getParameter("pavani");
                   if(hiddenvar.equalsIgnoreCase("login")){
                	   String username=request.getParameter("username");
                	   String password=request.getParameter("password");
                	   String category=request.getParameter("category");
                	   Login l=new Login();
                	   l.setUsername(username);
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

}
