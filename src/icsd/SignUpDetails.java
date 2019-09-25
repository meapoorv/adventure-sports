package icsd;

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
 * Servlet implementation class SignUpDetails
 */
@WebServlet("/SignUpDetails")
public class SignUpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
	
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
     * @see HttpServlet#HttpServlet()
     */
    public SignUpDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config)throws ServletException{
 	   super.init(config);
 	   ServletContext context=getServletContext();
 	 
 	   System.out.println("init fired");
 	   con=getDBCon();
 	   context.setAttribute("gCon", con);
 	   try{
 		   stmt=con.prepareStatement("insert into  tblUser3 values(?,?,?,?,?,?,?,?,?,?)");
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strUid=request.getParameter("txtUid");
		String strUnm=request.getParameter("txtUnm");
		String strGnd=request.getParameter("txtGnd");
		String strPwd=request.getParameter("txtPwd");
		String strResSt=request.getParameter("txtResSt");
		String strAdd=request.getParameter("txtAdd");
		String strIdProof=request.getParameter("txtIdProof");
		String strPno=request.getParameter("txtPno");
		String strPay=request.getParameter("txtPay");
		String strPid=request.getParameter("txtPid");
		try{
			stmt.setString(1,strUid);
			stmt.setString(2,strUnm);
			stmt.setString(3,strGnd);
			stmt.setString(4,strPwd);
			stmt.setString(5,strResSt);
			stmt.setString(6,strAdd);
			stmt.setString(7,strIdProof);
			stmt.setString(8,strPno);
			stmt.setString(9,strPay);
			stmt.setString(10,strPid);
			rset=stmt.executeQuery();
		
	}catch(SQLException e){
		e.printStackTrace();
	}

		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>yts</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("ID created");
		out.println("<br>");
		out.println("<br>");
		out.println("<a href='Login.jsp'>go to Login");
		
		out.println("</a>");
		out.println("</body></html>");
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
