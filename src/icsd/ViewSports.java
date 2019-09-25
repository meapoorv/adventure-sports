package icsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class ViewSports
 */
@WebServlet("/ViewSports")
public class ViewSports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSports() {
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
 public void init(ServletConfig config)throws ServletException{
 	super.init(config);
 	 Connection con=getDBCon();
 	try{
 		stmt=con.prepareStatement("select P.planid,sp.sportid,sp.sportname,sp.description,sp.location,sp.img from tblPlanDescription tpd,tblPlan P,tblSports sp where tpd.planid=P.planid and tpd.sportid=sp.sportid and P.planid=?");
 	}catch(SQLException e){
 		e.printStackTrace();
 	}
 	
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
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Category></title><link rel='stylesheet' href='css/bootstrap.min.css'><script src='js/bootstrap.min.js'></script><style>tr:hover {background-color:#f5f5f5;}</style></head>");
		out.println("<body>");
		out.println("<table class='table table-bordered table-striped '>");
		out.println("<tr class='bg-danger'>");
		out.println("<th>Sport Id</th>");
		out.println("<th>Sport Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Location</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");
		
		String strPlanId=request.getParameter("planid");
		try {
			System.out.println(strPlanId);
	
			stmt.setString(1,strPlanId);
			rset=stmt.executeQuery();
			while(rset.next())
			{
				String strSportId,strSportName,strdesc,strloc,strimg;
				strSportId=rset.getString("sportid");
				strSportName=rset.getString("sportname");
				strdesc=rset.getString("description");
				strloc=rset.getString("location");
				strimg=rset.getString("img");
					
				out.println("<tr>");
				out.println("<td>"+strSportId+"</td>");
				out.println("<td>"+strSportName+"</td>");
				out.println("<td>"+strdesc+"</td>");
				out.println("<td>"+strloc+"</td>");
				out.println("<td>"+strimg+"</td>");
				out.println("</tr>");
				
				
				
			}out.println("</table>");
             out.println("<button type='submit'  class='btn btn-outline-secondary ' ><a href=Booking.jsp?planid="+strPlanId+">book</a></button>");
			
			out.println("</body></html>");
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void destroy(){
		try{
			if(con!=null){
				
			}if(rset!=null){
				rset.close();
				
				
			}if(stmt!=null){
				stmt.close();
				
			}
		}catch(SQLException e){
		e.printStackTrace();	
		}
	
	}


}
