package src.com.vkkm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.vkkm.bean.User;
import src.com.vkkm.dao.Dao;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		new Dao();

		HttpSession session = request.getSession(true);
		Cart cart;
		synchronized (session) {  // synchronized to prevent concurrent updates
			// Retrieve the shopping cart for this session, if any. Otherwise, create one.
			cart = (Cart) session.getAttribute("cart");
			if (cart == null) {  // No cart, create one.
				cart = new Cart();
				session.setAttribute("cart", cart);  // Save it into session
			}
		}

		
		List <User> currentUser = (List<User>) session.getAttribute("userInSessionList");
		if (currentUser.isEmpty() ){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		User u = currentUser.get(0);
		
		// This servlet handles 4 cases:
		// (1) todo=add id=1001 qty1001=5 [id=1002 qty1002=1 ...]
		// (2) todo=update id=1001 qty1001=5
		// (3) todo=remove id=1001
		// (4) todo=view

		//String todo = request.getParameter("todo");
		String todo = request.getParameter("cartAtrrib");

		if (todo == null)
		 {
			todo = "view";  // to prevent null pointer
		}
		if (todo.equals("add") ) {
			// (1) todo=add id=1001 qty1001=5 [id=1002 qty1002=1 ...]
			// (2) todo=update id=1001 qty1001=5   	 
			int prodId = Integer.parseInt(request.getParameter("productId"));
			String prodName =request.getParameter("productName");
			int prodPrice = Integer.parseInt(request.getParameter("productPrice"));
			int qtyOrdered = Integer.parseInt(request.getParameter("selQuantity"));
			//int idInt = Integer.parseInt(id);
			cart.add(prodId,prodName,prodPrice, u, qtyOrdered);
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);   

		} 
		else if (todo.equals("remove")) {
			String id = request.getParameter("prodId");  // Only one id for remove case
			cart.remove(Integer.parseInt(id));
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		}
		else if (todo.equals("checkout")) {
			String[] words = request.getParameterValues("Qty");
			int index=0;
			for (String qty : words){
				int quant =Integer.parseInt(qty);
				cart.update(cart.getItems().get(index).getProdId(), quant);
				index++;
				//cart.checkout(quant);
			}
			int totalCost = Integer.parseInt(request.getParameter("totalCost"));
			session.setAttribute("totalCost", totalCost);
			request.getRequestDispatcher("billingInformation.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
