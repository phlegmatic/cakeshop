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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/ProductServlet", "/productOverview.*" })
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
		
		List<ProductInfo> cupcakes = productMap.get("Cupcakes");
		List<ProductInfo> pastries = productMap.get("Pastries");
		
        request.setAttribute("cupcakes", cupcakes);
        request.setAttribute("pastries", pastries);
        request.getRequestDispatcher("productOverview.jsp").forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// TODO Auto-generated method stub
	}

}
