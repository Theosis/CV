
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CV")
public class CV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionManager cm = new ConnectionManager();
	Statement stm;
	ResultSet rs;
		
    public CV() {
        super();        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextURL = "/view.jsp";
		String formName = request.getParameter("webName");
		
		//System.out.println("\n**************\n"+formName+"\n**************\n");
		
		Connection con = cm.getConnection();
		
		String query = "SELECT name, email FROM person WHERE name = '"+ formName + "'";
		try{
			
			stm = con.createStatement();
			rs = stm.executeQuery(query);
			String personData = "";
		
			while(rs.next()){
				
				String personRow = rs.getString(1) + "<br>"	+ rs.getString(2);
				personData = personData.concat(personRow);
				request.setAttribute("msg", personData);
			}
			
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
			
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
