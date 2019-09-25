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
import javax.servlet.http.HttpSession;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class AdminCheck
 */
@WebServlet("/AdminCheck")
public class AdminCheck extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
      Connection con=null;
      ResultSet rset=null;
      PreparedStatement stmt=null;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
   
   
   public void init(ServletConfig config)throws ServletException{
		super.init(config);
		System.out.println("11");
//		ServletContext context=getServletContext();
//		con=(Connection)context.getAttribute("gCon");
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
			stmt=con.prepareStatement(" select * from tblAdminLogin where unm=? and pwd=? ");
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
		
	String strUnm=request.getParameter("txtUnm");
	String strPwd=request.getParameter("txtPwd");
	PrintWriter out=response.getWriter();
	try{
		System.out.println("11");
		stmt.setString(1,strUnm);
		stmt.setString(2,strPwd);
		System.out.println(strUnm+" "+ strPwd);
		rset=stmt.executeQuery();
		if(rset.next()){
			HttpSession session=request.getSession();
			session.setAttribute("unm", strUnm);
			response.sendRedirect(request.getContextPath()+"/AdminFunction.jsp");
			System.out.println("22");
		}else{
			response.sendRedirect(request.getContextPath()+"/ErrorPage");
		}
	}catch(SQLException e){
     e.printStackTrace();
	}
System.out.println("33");
	
	
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
