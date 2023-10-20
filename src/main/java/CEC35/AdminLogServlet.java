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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class AdminLogServlet
 */
public class AdminLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ea = request.getParameter("email");
		String pas = request.getParameter("pass");
		String Username = "root";
		String Password = "";
		String Url ="jdbc:mysql://localhost/cec";
		String driver ="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(Url, Username, Password);
			Statement st = con.createStatement();
			String query = "select * from signup where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ea);
			ps.setString(2, pas);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				response.sendRedirect("AddProduct.jsp");
			}
			else {
				out.print("Enter Valid Email And Password");
			}
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
