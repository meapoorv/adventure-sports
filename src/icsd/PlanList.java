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
 * Servlet implementation class PlanList
 */
@WebServlet("/PlanList")
public class PlanList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanList() {
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
    		stmt=con.prepareStatement("select * from tblPlan");
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
		
		ClsProduct objProduct=null; 
		LinkedList<ClsProduct>lst=new LinkedList<>();
		while(rset.next()){
			System.out.println("3333333");
			String strplnid,strplnname ,strdesp,strprice;
			strplnid=rset.getString("planid");
				strplnname=rset.getString("planname");
			
			strdesp=rset.getString("description");
			strprice=rset.getString("price");
			objProduct=new ClsProduct(strplnid,strplnname,strdesp,strprice);
			System.out.println(objProduct);
			lst.add(objProduct);
			
		}
		//HttpSession session=request.getSession(false);
//		ServletContext context=getServletContext();
//		
//		if(lst==null){
//			lst=new LinkedList<ClsProduct>();
//			System.out.println("linked list created");
//			
//			context.setAttribute("ABC", lst);
//			//session.setAttribute("ABC",lst);
//		}
//		
//		response.sendRedirect(request.getContextPath()+"/ShowPlanDetails");
		PrintWriter out=response.getWriter();
        out.println("<html><head><title>Planlist></title><link rel='stylesheet' href='css/bootstrap.min.css'><script src='js/bootstrap.min.js'></script></head>");
		out.println("<body>");
		out.println("<table class='table table-bordered'>");
		out.println("<tr class='bg-danger'>");
		out.println("<th>planid</th>");
		out.println("<th>planname</th>");
		out.println("<th>description</th>");
		out.println("<th>price</th>");

		
		out.println("</tr>");
		for(ClsProduct obj:lst){
			
			
		
		    String strplnid=obj.getStrplnid();
			String strplnname=obj.getStrplnname();
			String strdesp=obj.getStrdesp();
			String strprice=obj.getStrprice();

			out.println("<tr>");
			out.println("<th>"+strplnid+"</th>");
			out.println("<th>"+strplnname+"</th>");
			
			out.println("<th>"+strdesp+"</th>");
			out.println("<th>"+strprice+"</th>");
			
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
