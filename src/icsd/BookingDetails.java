package icsd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class BookingDetails
 */
@WebServlet("/BookingDetails")
public class BookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	  public Connection getDBCon(){
		   Connection con=null;
		   OracleDataSource ods;
		   try{
			   
			   ods=new OracleDataSource();
			   ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			   con=ods.getConnection("apoorv","icsd");
			   System.out.println("Connection established successfully");
		   }catch(SQLException  e){
			   e.printStackTrace();
		   }
		return con;
	   }
	 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	
		
		
		HttpSession ssn=request.getSession(false);
		String strPlanId=(String) ssn.getAttribute("pln");
	    String strPrs=(String) ssn.getAttribute("prs");
	
		int intPrs=Integer.parseInt(strPrs);
	    System.out.println(intPrs);
	    HttpSession session =request.getSession(false);
		int i=1;
		while(i<=intPrs){
			
			int Bid=(int) session.getAttribute("BID");
		String strFname=request.getParameter("txtFname"+i);
		String strLname=request.getParameter("txtLname"+i);
		String strAge=request.getParameter("txtAge"+i);
		String strGnd=request.getParameter("txtGnd"+i);
		System.out.println(strFname+" "+strLname+" "+strAge+" "+strGnd);
		DBHandler objDB=new DBHandler();
		objDB.insertIntoTblBooking3(Bid,strFname, strLname, strAge, strGnd);
		i++;
		}


		response.sendRedirect(request.getContextPath()+"/CardDetails.jsp?no="+strPrs+ "&planid="+strPlanId);
	
	}

	
public void destroy(){
	System.out.print("destroy fired");
	try{
		if(con!=null){
			
		}if(rset!=null){
			rset.close();
		}if(stmt!=null){
			stmt.close();
		}
	
	}catch(SQLException se){
		System.out.println(se.getMessage());
	}
}

}
