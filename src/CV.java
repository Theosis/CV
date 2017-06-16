
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	ResultSet rs = null;
	String psql;
	PreparedStatement pst = null;
		
    public CV() {
        super();        
    }
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//fVariables are for form-filling:
		String fName, fEmail; 
		String fEdAch, fEdAchOrg, fEdAchYr; 
//		String fWrkXp, fWrkXpOrg, fWrkXpYrs; 
//		ArrayList<String> duties = new ArrayList<String>();
//		String fSkill, fSkillLvl;
//		boolean done;
//		int numItems;
//		Person fPerson;
//		
//		fPerson = new Person();
		
		String nextURL = "/view.jsp";
		
		fName = request.getParameter("fName");
		fEmail = request.getParameter("fEmail");		
		
		Connection con = cm.getConnection();
		String cv = "";	
		
		try{		
			psql = "select concat('=============================================================  \n<br>', p.name, '\n<br>', p.email, '\n<br>\n<br>') as pers_info from person p where id = 1";
			pst = con.prepareStatement(psql);
			fName = "%"+fName+"%" ;
//			println(fName);
//			pst.setString(1, fName);
//			println(psql);
//			println(pst.toString());
			rs = pst.executeQuery();
		
			while(rs.next()){
			cv = cv.concat(rs.getString(1));
			}
			
			psql = "select concat('Education  \n<br>', (select group_concat(e.ach, ',  \n<br>', e.org, ', ', e.yr, '  \n<br>\n<br>' separator '') from edu e where persId = 1)) as edu_info";
			pst = con.prepareStatement(psql);
			rs = pst.executeQuery();
			while(rs.next()){
			cv = cv.concat(rs.getString(1));
			}
			
			psql = "select distinct w.role, w.org, w.era, (select concat('\n<br>\n<br>- ', (select group_concat(d.duty separator '\n<br>- ') from dty d where d.wrkId = w.id))) as duty_list from wrk w left outer join dty d on w.id = d.wrkId where persId = 1";
			pst = con.prepareStatement(psql);
			rs = pst.executeQuery();
			cv = cv.concat("Experience  \n<br>");
			while(rs.next()){
			cv = cv.concat(rs.getString(1)+"\n<br>"+rs.getString(2)+", "+rs.getString(3)+""+rs.getString(4)+"\n<br>\n<br>");
			}
			
			psql = "select concat('Skills\n<br>', (select group_concat(s.skl, ', ', s.lvl, '\n<br>' separator '') from skl s where s.persId = 1) ) as skl_list";
			pst = con.prepareStatement(psql);
			rs = pst.executeQuery();
			while(rs.next()){
			cv = cv.concat(rs.getString(1));
			}
			
//			println(cv);
			request.setAttribute("msg", cv);
			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		   }catch(Exception e){e.printStackTrace();}		
		
	}
	//****************************************************************************************
	
	
	//**************************		
	//***  AUX DEV FUNCTIONS ***		
	//**************************
	
	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static void print(String msg) {
		System.out.println(msg);
		
	}
	
}
