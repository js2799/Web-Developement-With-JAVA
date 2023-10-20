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
 * Servlet implementation class AddCartProductServlet
 */
public class AddCartProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		String nm = request.getParameter("nm");
		String pr = request.getParameter("pr");
		String pq = request.getParameter("pq");
		ProductBean p = new ProductBean();
		p.setProductId(Integer.parseInt(id));
		p.setProductName(nm);
		p.setProductPrice(pr);
		p.setProductQuantity(pq);
		HttpSession session = request.getSession(false);
		ArrayList<ProductBean> cart = (ArrayList<ProductBean>) session.getAttribute("cart");
		cart.add(p);
		session.setAttribute("cart", cart);
		response.sendRedirect("Homepage.jsp");
//		PrintWriter out = response.getWriter();
//		out.print(p.getProductId());
//		out.print(p.getProductName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
