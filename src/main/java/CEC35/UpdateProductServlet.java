package CEC35;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String upnm = request.getParameter("upnm");
		String uprice = request.getParameter("uprice");
		String upqua = request.getParameter("upqua");
		String Username = "root";
		String Password = "";
		String url ="jdbc:mysql://localhost/cec";
		String driver ="com.mysql.cj.jdbc.Driver";
		int P_Id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, Username, Password);
			Statement st = con.createStatement();
			String query = "update product set Product_Name ='"+upnm+"', Product_Price='"+uprice+"', Product_Quantity='"+upqua+"'where id="+P_Id;
			int i =st.executeUpdate(query);
			PrintWriter out = response.getWriter();
			out.print(query);
			response.sendRedirect("AdminHomepage.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
