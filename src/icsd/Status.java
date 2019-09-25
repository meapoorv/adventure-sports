package icsd;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
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

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class Status
 */
@WebServlet("/Status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
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
			stmt=con.prepareStatement("select * from signup ");
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Category></title><link rel='stylesheet' href='css/bootstrap.min.css'><script src='js/bootstrap.min.js'></script><style>tr:hover {background-color:#f5f5f5;}</style></head>");
		out.println("<body>");
		out.println("<table class='table table-bordered table-striped '>");
		out.println("<tr class='bg-danger'>");
		out.println("<th>FirstName</th>");
		out.println("<th>LastName</th>");
		out.println("<th>PhoneNo</th>");
		out.println("<th>Address</th>");
		out.println("<th>UserName</th>");
		out.println("<th>Package Days</th>");
		out.println("</tr>");
	 try {
	
		rset=stmt.executeQuery();
		while(rset.next()){
			String strFname,strLname,strPno,strAdd,strUname,strPkg;
			strFname=rset.getString("FIRSTNAME");
			strLname=rset.getString("LASTNAME");
			strPno=rset.getString("PHONENO");
			strAdd=rset.getString("ADDRESS");
			strUname=rset.getString("USERNAME");
			strPkg=rset.getString("PACKAGE");
			out.println("<tr>");
			out.println("<td>"+strFname+"</td>");
			out.println("<td>"+strLname+"</td>");
			out.println("<td>"+strPno+"</td>");
			out.println("<td>"+strAdd+"</td>");
			out.println("<td>"+strUname+"</td>");
			out.println("<td>"+strPkg+"</td>");
			out.println("</tr>");
		
			
		}
		

		out.println("</table></body></html>");
		System.out.println("hello");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
