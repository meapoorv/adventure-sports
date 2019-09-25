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
 * Servlet implementation class Sports
 */
@WebServlet("/Sports")
public class Sports extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sports() {
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
  		stmt=con.prepareStatement("select * from tblSports where sportname=?");
  	}catch(SQLException e){
  		e.printStackTrace();
  	}
  	
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
		
		String strSportname=request.getParameter("txtUnm");
		try {
			System.out.println(strSportname);
	
			stmt.setString(1,strSportname);
			rset=stmt.executeQuery();
			while(rset.next())
			{
				String strSportId,strdesc,strloc,strimg;
				strSportId=rset.getString("sportid");
				strdesc=rset.getString("description");
				strloc=rset.getString("location");
				strimg=rset.getString("img");
					
				out.println("<tr>");
				out.println("<td>"+strSportId+"</td>");
				out.println("<td>"+strSportname+"</td>");
				out.println("<td>"+strdesc+"</td>");
				out.println("<td>"+strloc+"</td>");
				out.println("<td>"+strimg+"</td>");
				out.println("</tr>");
				out.println("</table>>");
				out.println("<button type='submit'  class='btn btn-outline-secondary ' ><a href='Login.jsp'>Login to see Plans</a></button>");
				
				out.println("</body></html>");
				
				
			}
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
