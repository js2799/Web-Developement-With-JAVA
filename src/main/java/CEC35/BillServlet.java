package CEC35;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import CEC35.ProductBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class BillServlet
 */
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		ArrayList<ProductBean> cart = (ArrayList<ProductBean>) session.getAttribute("cart");

		double totalCost = 0.0;

		out.println("<h2>Shopping Cart Contents:</h2>");
		out.println("<ul>");

		for (ProductBean p : cart) {
		    out.println("<li>" + p.getProductId() + " " + p.getProductName() + " " + p.getProductPrice() + " " + p.getProductQuantity() + "</li>");
//		    totalCost += (Integer.parseInt(p.getProductPrice()) * Integer.parseInt(p.getProductQuantity()));
		    if (p.getProductPrice() != null && p.getProductQuantity() != null) {
		        totalCost += (Integer.parseInt(p.getProductPrice()) * Integer.parseInt(p.getProductQuantity()));
		        out.println(" " + p.getProductPrice() + " " + p.getProductQuantity());
		    } else {
		        out.println(" Price or Quantity not available for this product.");
		    }
		    
		}

		out.println("</ul>");
		out.println("<h3>Total Cost: $" + totalCost + "</h3>");

		


		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
