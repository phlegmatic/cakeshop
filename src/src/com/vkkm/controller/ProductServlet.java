package src.com.vkkm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.vkkm.bean.ProductInfo;
import src.com.vkkm.dao.Dao;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/cakes", "/productOverview.*" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao d= new Dao();

		if(request.getParameter("id")!=null){ //load product detail page 
			int prodId = 0;
			prodId=Integer.parseInt((request.getParameter("id")));

			ProductInfo product;
			product = d.loadProducts(prodId);
			request.setAttribute("product", product);
			request.getRequestDispatcher("productDetails.jsp").forward(request, response);

		}
		else{ //load product overview page
			List<ProductInfo> products = new ArrayList<ProductInfo>();
			products = d.loadProducts();

			Map<String, List<ProductInfo>> productMap = new HashMap<String, List<ProductInfo>>();
			for (ProductInfo p : products) {
				String key = p.getProductCategory();
				if (productMap.get(key) == null) {
					productMap.put(key, new ArrayList<ProductInfo>());
				}
				productMap.get(key).add(p);
			}
			
			request.setAttribute("productMap", productMap);
			request.getRequestDispatcher("productOverview.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// TODO Auto-generated method stub
	}

}
