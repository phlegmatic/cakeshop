package src.com.vkkm.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.vkkm.bean.Address;
import src.com.vkkm.bean.CartItems;
import src.com.vkkm.bean.Order;
import src.com.vkkm.bean.OrderProductDetails;
import src.com.vkkm.bean.ProductInfo;
import src.com.vkkm.bean.User;
import src.com.vkkm.dao.Dao;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**l
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In order Servlet");
		Dao d= new Dao();

		Address ad = new Address();
		ad.setAddress(request.getParameter("address"));
		ad.setCity(request.getParameter("city"));
		ad.setPincode(Integer.parseInt(request.getParameter("pin")));
		d.saveAddress(ad);

		Order order = new Order();
		order.setAddress(ad);
		order.setAmount(Integer.parseInt(request.getParameter("totalCost")));
		order.setDeliveryDate(request.getParameter("deliveryDate"));
		order.setDeliveryTime(request.getParameter("deliveryTime"));
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		//get current date time with Date()
		Date date = new Date();
		order.setOrderDate(dateFormat.format(date));
		order.setOrderStatus("Order received");
		order.setPaymentMode(request.getParameter("paymentMethod"));

		HttpSession session = request.getSession(true); // getting session
		List <User> currentUser = (List<User>) session.getAttribute("userInSessionList");
		User u = currentUser.get(0);
		order.setUser(u);

		Cart cart = (Cart) session.getAttribute("cart");
		Set<OrderProductDetails> orderProducts = new HashSet<OrderProductDetails>(0);
		OrderProductDetails op;
		for (CartItems item : cart.getItems()){
			op = new OrderProductDetails();
			ProductInfo products = d.loadProducts(item.getProdId());
			op.setProducts(products);
			op.setQuantity(item.getQtyOrdered());

			//updating qunatity in products info table
			products.setAvailableQuantity(products.getAvailableQuantity()-item.getQtyOrdered());
			d.CreateProduct(products);

			op.setOrders(order);
			//d.saveProductsInOrder(op);
			orderProducts.add(op);
		}

		order.setOrderProducts(orderProducts);
		Order receipt=d.saveOrder(order);

		Set<OrderProductDetails> orderedProducts=receipt.getOrderProducts();
		request.setAttribute("orderedProducts", orderedProducts);
		request.setAttribute("receipt", receipt);
		request.getRequestDispatcher("orderReceipt.jsp").forward(request, response);

	}

}
