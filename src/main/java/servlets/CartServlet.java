package servlets;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Product;
import mySQL.MySQLProductDAO;

/**
 * Servlet implementation class CartServlet
 */
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int numberGeneral;
		if (request.getParameter("ClearCart")!=null) {
			numberGeneral = 0;
			session.setAttribute("cart", null);
			session.setAttribute("number", numberGeneral);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CartView.jsp");
		
		request.setAttribute("productList", (List<Product>) session.getAttribute("cart"));
		rd.forward(request, response);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("productToBuy")!=null) {
			long productId = Integer.parseInt(request.getParameter("productToBuy"));
			Product product = new MySQLProductDAO().getProductById(productId);
			HttpSession session = request.getSession();
			
			List<Product> products;
			int numberProduct = 1;
			int numberGeneral;
			if(session.getAttribute("cart")!=null) {		
				products = (List<Product>) session.getAttribute("cart");
				numberGeneral = (int)(session.getAttribute("number"));
				numberGeneral++;
			}else {
				products= new ArrayList<Product>();
				numberGeneral = 1;
			}
									
//			for(Product pr: products) {
//				if (productId == product.getId()) {
//					numberProduct++;
//				}
//			}
//			
//			if (numberProduct==1) {
//				products.add(product);
//			}
//			
	//		session.setAttribute("numberProduct", numberProduct);
			products.add(product);
			session.setAttribute("cart",products);
			session.setAttribute("number", numberGeneral);
			System.out.println(products);
			response.sendRedirect("./products");
		}
	}

}
