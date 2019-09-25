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
 * Servlet implementation class AddFunction3
 */
@WebServlet("/AddFunction3")
public class AddFunction3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con=null;
     ResultSet rset=null;
     PreparedStatement stmt=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFunction3() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init(ServletConfig config)throws ServletException{
 		super.init(config);
 		System.out.println("11");
 		 Connection con=null;
 		   OracleDataSource ods;
 		   try{
 			   
 			   ods=new OracleDataSource();
 			   ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
 			   con=ods.getConnection("apoorv","icsd");
 			   System.out.println("Connection established successfully");
 		   }catch(SQLException  e1){
 			   e1.printStackTrace();
 		   }
 		try{
 			stmt=con.prepareStatement(" insert into tblSports values(?,?,?,?,?) ");
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String strsptid=request.getParameter("txtsptid");
		String strsptname=request.getParameter("txtsptname");
		String strdesp=request.getParameter("txtDsp");
		String strsploc=request.getParameter("txtsploc");
		String strsimg=request.getParameter("txtsimg");
		
		try{
			stmt.setString(1,strsptid);
			stmt.setString(2,strsptname);
			stmt.setString(3,strdesp);
			stmt.setString(4,strsploc);
			stmt.setString(5,strsimg);
			stmt.executeUpdate();
			System.out.println("23456");
			
				response.sendRedirect(request.getContextPath()+"/AdminFunction.jsp");
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
	