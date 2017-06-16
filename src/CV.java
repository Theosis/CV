
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
	ResultSet rs;
	
//	//DB handles
//	Connection con = null;
//	Statement stmt = null;
//	String sql, psql;
//	PreparedStatement pst = null;
//	ResultSet rs = null;
		
    public CV() {
        super();        
    }
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//fVariables are for form-filling:
		String fName, fEmail, fEdAch, fEdAchOrg, fEdAchYr; 
		String fWrkXp, fWrkXpOrg, fWrkXpYrs; 
		ArrayList<String> duties = new ArrayList<String>();
		String fSkill, fSkillLvl;
		boolean done;
		int numItems;
		Person fPerson;
		
		fPerson = new Person();
		
		String nextURL = "/view.jsp";
		
		fName = request.getParameter("fName");
		fEmail = request.getParameter("fEmail");
		
		//println("\n**************\n"+fName+"\n**************\n");
		
		
		Connection con = cm.getConnection();
		String query = "";
		String cv = "";
		
		query = "SELECT name, email FROM person WHERE name like '%"+ fName + "%'";
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
		   }catch(Exception e){e.printStackTrace();}
		
////		WEB CV PERSONAL INFO
//		
//		query = "select concat('\n=============================================================  \n', p.name, '\n', p.email, '\n\n') as pers_info from person p where id = 1;" ;
//		try{		
//			stm = con.createStatement();
//			rs = stm.executeQuery(query);
//					
////			while(rs.next()){
//				
//				cv = cv.concat(request.getParameter("pers_info"));
////				String personRow = rs.getString(1) + "<br>"	+ rs.getString(2);
////				personData = personData.concat(personRow);
//				println(cv);
//				request.setAttribute("msg", cv);
////			}
//			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
//		   }catch(Exception e){e.printStackTrace();}
		
//		WEB CV EDUCATION
		
//		query = "select concat('Education  \n', (select group_concat(e.ach, ',  \n', e.org, ', ', e.yr, '  \n\n' separator '') from edu e where persId = 1)) as edu_info;" ;
//		try{		
//			stm = con.createStatement();
//			rs = stm.executeQuery(query);
//			String personData = "";
//		
//			while(rs.next()){
//				
//				String personRow = rs.getString(1) + "<br>"	+ rs.getString(2);
//				personData = personData.concat(personRow);
//				request.setAttribute("msg", personData);
//			}
//			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
//		   }catch(Exception e){e.printStackTrace();}
//		
////		WEB CV EXPERIENCE
//		
//		query = "select distinct w.role, w.org, w.era, (select concat('\n\n- ', (select group_concat(d.duty separator '\n- ') from dty d where d.wrkId = w.id))) as duty_list from wrk w left outer join dty d on w.id = d.wrkId where persId = 1;" ;
//		try{		
//			stm = con.createStatement();
//			rs = stm.executeQuery(query);
//			String personData = "";
//		
//			while(rs.next()){
//				
//				String personRow = rs.getString(1) + "<br>"	+ rs.getString(2);
//				personData = personData.concat(personRow);
//				request.setAttribute("msg", personData);
//			}
//			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
//		   }catch(Exception e){e.printStackTrace();}
//		
////		WEB CV SKILLS
//		
//		query = "select concat('Skills\n', (select group_concat(s.skl, ', ', s.lvl, '\n' separator '') from skl s where s.persId = 1) ) as skl_list;" ;
//		try{		
//			stm = con.createStatement();
//			rs = stm.executeQuery(query);
//			String personData = "";
//		
//			while(rs.next()){
//				
//				String personRow = rs.getString(1) + "<br>"	+ rs.getString(2);
//				personData = personData.concat(personRow);
//				request.setAttribute("msg", personData);
//			}
//			getServletContext().getRequestDispatcher(nextURL).forward(request,response);
//		   }catch(Exception e){e.printStackTrace();}
		
		
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
