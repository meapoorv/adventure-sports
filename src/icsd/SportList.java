package icsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * Servlet implementation class SportList
 */
@WebServlet("/SportList")
public class SportList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SportList() {
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
    		stmt=con.prepareStatement("select * from tblSports");
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
		//doGet(request, response);
	
		try{
		
		System.out.println("4444444");
		rset=stmt.executeQuery();
		System.out.println("1234");
		
		ClsProduct1 objProduct=null; 
		LinkedList<ClsProduct1>lst1=new LinkedList<>();
		while(rset.next()){
			System.out.println("3333333");
			String strsptid,strsptname ,strdesp,strsploc,strimg;
			strsptid=rset.getString("sportid");
			strsptname=rset.getString("sportname");
				strdesp=rset.getString("description");
			
			strsploc=rset.getString("location");
			strimg=rset.getString("img");
			objProduct=new ClsProduct1(strsptid,strsptname,strdesp,strsploc,strimg);
			System.out.println(objProduct);
			lst1.add(objProduct);
			
		}
		
		PrintWriter out=response.getWriter();
        out.println("<html><head><title>Planlist></title><link rel='stylesheet' href='css/bootstrap.min.css'><script src='js/bootstrap.min.js'></script></head>");
		out.println("<body>");
		out.println("<table class='table table-bordered'>");
		out.println("<tr class='bg-danger'>");
		out.println("<th>sportid</th>");
		out.println("<th>sportname</th>");
		out.println("<th>description</th>");
		out.println("<th>location</th>");
		out.println("<th>image</th>");

		
		out.println("</tr>");
		for(ClsProduct1 obj:lst1){
			
			
		
		    String strsptid=obj.getStrsptid();
			String strsptname=obj.getStrsptname();
			String strdesp=obj.getStrdesp();
			String strsploc=obj.getStrsploc();
			String strimg=obj.getStrimg();

			out.println("<tr>");
			out.println("<th>"+strsptid+"</th>");
			out.println("<th>"+strsptname+"</th>");
			
			out.println("<th>"+strdesp+"</th>");
			out.println("<th>"+strsploc+"</th>");
			out.println("<th>"+strimg+"</th>");
			
			out.println("</tr>");
			
		}
		

	}catch (SQLException e) {
		// TODO Auto-generated catch block
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
