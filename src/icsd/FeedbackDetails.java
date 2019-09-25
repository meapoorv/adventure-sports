package icsd;

import java.io.IOException;
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
 * Servlet implementation class FeedbackDetails
 */
@WebServlet("/FeedbackDetails")
public class FeedbackDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
    /**
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackDetails() {
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
	    		stmt=con.prepareStatement("insert into tblFeedback values(?,?,?,?)");
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
		String strFid=request.getParameter("txtFid");
		String strFd=request.getParameter("txtFd");
		String strUid=request.getParameter("txtUid");
		String strRt=request.getParameter("txtRt");
		
		try{
			stmt.setString(1,strFid);
			stmt.setString(2,strFd);
			stmt.setString(3,strUid);
			stmt.setString(4,strRt);
			stmt.executeUpdate();
		
			System.out.println("23456");
			
				response.sendRedirect(request.getContextPath()+"/UserPanel.jsp");
						}catch(SQLException e){
						     e.printStackTrace();
						}
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
