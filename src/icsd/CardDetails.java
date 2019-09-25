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
 * Servlet implementation class CardDetails
 */
@WebServlet("/CardDetails")
public class CardDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
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
      		stmt=con.prepareStatement("insert into tblCardDetails values(?,?,?,?,?) ");
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
		
		try {
			String strUnm,strEx,strNo,strCvv,strBal;;
			
		
			strUnm=request.getParameter("txtUnm");
            strNo=request.getParameter("txtNo");
			strCvv=request.getParameter("txtCvv");
			strEx=request.getParameter("txtEx");
			strBal=request.getParameter("txtBal");
			System.out.println(strUnm +" "+ strNo+" "+ strCvv+" "+strEx+" "+strBal);
			
			stmt.setString(1, strUnm);
			stmt.setString(2, strNo);
			stmt.setString(3, strCvv);
			stmt.setString(4, strEx);
			stmt.setString(5, strBal);
			stmt.executeUpdate();
			
			HttpSession ssn=request.getSession(false);
			String strPlanId=(String) ssn.getAttribute("pln");
		    String strPrs=(String) ssn.getAttribute("prs");
		System.out.println(strPlanId+"you"+strPrs);
		response.sendRedirect(request.getContextPath()+"/Balance.jsp?no="+strPrs+ "&planid="+strPlanId+"&accbalance="+strBal);
			
		} catch (SQLException e) {
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
