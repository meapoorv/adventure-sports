package icsd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String strUid=request.getParameter("txtUid");
		String strPid=request.getParameter("txtPid");
		System.out.print(strPid);
		int intPrs=Integer.parseInt(request.getParameter("txtPrs"));
		String strPrs=request.getParameter("txtPrs");
		System.out.print(intPrs);
		String strBookDate=request.getParameter("txtBookDate");
		System.out.println(strBookDate);
		DBHandler obj=new DBHandler();
		int Bid= obj.insertIntoTblBooking2(strUid, strPid, intPrs, strBookDate);
		HttpSession session =request.getSession(false);
		session.setAttribute("BID", Bid);
		
		//String strPlanId=request.getParameter("planid");
	
			response.sendRedirect(request.getContextPath()+"/BookingDetails.jsp?no="+strPrs+ "&planid="+strPid);
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
