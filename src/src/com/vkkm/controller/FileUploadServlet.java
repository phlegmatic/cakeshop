package src.com.vkkm.controller;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import src.com.vkkm.bean.ProductInfo;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/Admin")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String SAVE_DIR="images";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
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
		
		Dao d= new Dao();
		String hiddenvar=request.getParameter("hiddenVar");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		StringBuffer s= new StringBuffer(getServletContext().getRealPath("/images"));
		//s.replace(s.substring(s.indexOf(".")-1, s.indexOf("webapps")+7),"");
		// converting C:\Users\devsan\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\CakeShopPortal\images
		// to C:\Users\devsan\workspace\CakeShopPortal\WebContent\images
		 s.replace(s.indexOf(".")-1, s.indexOf("webapps")+7,"");
		 String target="WebContent"+File.separator+"images";
		 String savePath = s.replace(s.indexOf("images"),s.indexOf("images")+7,target).toString();
		 File fileSaveDir=new File(savePath);
		if(!fileSaveDir.exists()){
			fileSaveDir.mkdir();
		}
		String name=request.getParameter("productname"); //product name
		String description=request.getParameter("productDescription"); //product description
		String productCategory=request.getParameter("productType"); //product description
		int manuCost=Integer.parseInt(request.getParameter("productManufacturingCost")); 
		int sellingCost=Integer.parseInt(request.getParameter("productSellingCost")); 
		int quantity=Integer.parseInt(request.getParameter("productQuantity")); 
		Part part=request.getPart("productImage");
		String fileName=extractFileName(part);
		part.write(savePath + File.separator + fileName);
		String filePath=  "images/"+fileName ;
		/* 
            //You need this loop if you submitted more than one file
            for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }*/
		ProductInfo p = new ProductInfo();
		p.setProductName(name);
		p.setDescription(description);
		p.setProductCategory(productCategory);
		p.setManufacturingCost(manuCost);
		p.setSellingPrice(sellingCost);
		p.setAvailableQuantity(quantity);
		p.setFilepath(filePath);
		d.CreateProduct(p);
	}
	// file name of the upload file is included in content-disposition header like this:
	//form-data; name="dataFile"; filename="PHOTO.JPG"
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
}


