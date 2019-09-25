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
import javax.servlet.http.HttpSession;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class PlanDescription
 */
@WebServlet("/PlanDescription")
public class PlanDescription extends HttpServlet {
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
 public void init(ServletConfig config)throws ServletException{
 	super.init(config);
 	 Connection con=getDBCon();
 	try{
 		stmt=con.prepareStatement("select P.planid,P.planname,P.description,P.price,sp.sportid,sp.sportname,sp.description,sp.location,sp.img from tblPlanDescription tpd,tblPlan P,tblSports sp where tpd.planid=P.planid and tpd.sportid=sp.sportid and P.planid=?");
 	}catch(SQLException e){
 		e.printStackTrace();
 	}
 	
 }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanDescription() {
        super();
        // TODO Auto-generated constructor stub
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
		out.println("<th>Plan Id</th>");
		out.println("<th>Plan Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Price</th>");
		out.println("<th>View Sports</th>");

		out.println("</tr>");
		
		String strPlanId=request.getParameter("selPlansAvail");
		try {
			System.out.println(strPlanId);
	
			stmt.setString(1,strPlanId);
			rset=stmt.executeQuery();
			if(rset.next())
			{
				String strPlanName,strDes,strPrice;
				strPlanName=rset.getString("planname");
				strDes=rset.getString("description");
				strPrice=rset.getString("price");
				
				out.println("<tr>");
				out.println("<td>"+strPlanId+"</td>");
				out.println("<td>"+strPlanName+"</td>");
				out.println("<td>"+strDes+"</td>");
				out.println("<td>"+strPrice+"</td>");
				HttpSession ssn=request.getSession();
				ssn.setAttribute("price",strPrice );
				out.println("<td><a href=ViewSports?planid="+strPlanId+">View Sports</a></td>");
				out.println("</tr>");
				out.println("</table>");
				
				
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
