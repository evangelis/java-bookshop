//OrderServlet.java
package mypkg;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.*;
import myutil.InputFilter;

public class OrderServlet extends HttpServlet{
	private String dbUrl, username, passwd;

	@Override
	protected void init(ServletConfig config) throws ServletException{
		super.init(config);
		ServletContext cntx = config.getServletContext();
		dbUrl = cntx.getInitialParameter("dbUrl");
		username = cntx.getInitialParameter("username");
		passwd = cntx.getInitialParameter("passwd");

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException{

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset =  null;
		String sqlStr = null;

		try{

			out.println("<html><head><title>Order Confirmation</title></head><body>");
			out.println("<h2>YAEBS - Order Confirmation</h2>");
			//Retrieve and process request parameters :id(s), cust_name, cust_email, cust_phone
			String[] ids = req.getParameter("id");
			String custName = req.getParameter("cust_name");
			String custEmail = req.getParameter("cust_email").trim();
			String custPhone =req.getParameter("cust_phone").trim();

			boolean hasName = custName != null && ((custName = InputFilter
				.htmlFilter(custName.trim())).length()>0);

			boolean hasEmail = custEmail != null &&
				((custEmail = InputFilter.htmlFilter(custEmail.trim()))length()>0);

			boolean hasPhone = custPhone != null && ((InputFilter.htmlFilter(custPhone.trim())).length())>0;
			//Validate inputs
			if(ids ==null || ids.length()==0)
				out.println("<h3>Please select a book.</h3>");
			else if (!hasName)
				out.println("<h3>Please enter your name.</h3>")
			else if(!hasPhone || !InputFilter.isValidPhone(custPhone))
				out.println("<h3>Please enter a valid 8-digit phone number.</h3>");
			else if(!hasEmail || (custEmail.indexOf('@')==-1))
				out.println("<h3>Please enter your email( user@host)</h3>");
			else{ // ok -->Build an output buffer (not to be interrupted by error messages)
				StringBuilder outBuf = new StringBuilder();
				outBuf.append("<table>");
				outBuf.append("<tr><td>Customer Name :</td><td>");
				outBuf.append(custName).append("</td></tr>");
				



			}






		}


	}
}