package icsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import icsd.ClsPlan;
import icsd.ClsSports;
import oracle.jdbc.pool.OracleDataSource;

public class DBHandler {
	
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
	
	  
	  
	  
	  
	  public int getMaxId(String strTblName,String strColName)
	  {
		  int id=0;
		  	Connection con=getDBCon();
		  	try {
				PreparedStatement stmt=con.prepareStatement("select max("+strColName+") as id from "+ strTblName);
				ResultSet rset=stmt.executeQuery();
				if(rset.next())
				{
					id=rset.getInt("id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  id=id+1;
		  return id;
	  }
	  public int getMaxId2(String strTblName,String strColName)
	  {
		  int Bid=0;
		  	Connection con=getDBCon();
		  	try {
				PreparedStatement stmt=con.prepareStatement("select max("+strColName+") as Bid from "+ strTblName);
				ResultSet rset=stmt.executeQuery();
				if(rset.next())
				{
					Bid=rset.getInt("Bid");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  Bid=Bid+1;
		  return Bid;
	  }
	  public int getMaxId3(String strTblName,String strColName)
	  {
		  int Bookid=0;
		  	Connection con=getDBCon();
		  	try {
				PreparedStatement stmt=con.prepareStatement("select max("+strColName+") as Bookid from "+ strTblName);
				ResultSet rset=stmt.executeQuery();
				if(rset.next())
				{
					Bookid=rset.getInt("Bookid");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  Bookid=Bookid+1;
		  return Bookid;
	  }
	 
	 
	  public void insertIntoTblPlanDescription(String strPlanID,String strSportsID)
	  {
		  int id=getMaxId("tblPlanDescription", "id");
		  Connection con=getDBCon();
		  try {
			PreparedStatement stmt=con.prepareStatement("insert into tblPlanDescription values (?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, strPlanID);
			stmt.setString(3, strSportsID);
			stmt.executeUpdate();
			con.close();
			
			System.out.println(strSportsID +" sport inserted into plan "+ strPlanID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	 
	  public int insertIntoTblBooking2(String strUid,String strPid,Integer intPrs,String strBookDate)
	  {
		  int Bid=getMaxId2("tblBooking", "Bid");
		  Connection con=getDBCon();
		  
		  try {
			PreparedStatement stmt=con.prepareStatement("insert into tblBooking values (?,?,?,?,?)");
			stmt.setInt(1, Bid);
			stmt.setString(2, strUid);
			stmt.setString(3, strPid);
			stmt.setInt(4, intPrs);
			stmt.setString(5, strBookDate);
			stmt.executeUpdate();
	
			con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return Bid;
	  }
	 
	  public void insertIntoTblBooking3(int Bid, String strFname,String strLname,String strAge,String strGnd)
	  {
		  int Bookid=getMaxId3("tblBookingdetails", "Bookid");
		  //////////////////////int Bid=getMaxId2("tblBooking", "Bid");
		  //Bid=Bid-1;
		  Connection con=getDBCon();
		  try {
			  
			  System.out.println(Bid);
			PreparedStatement stmt=con.prepareStatement("insert into tblBookingdetails values (?,?,?,?,?,?)");
			stmt.setInt(1, Bookid);

			System.out.println("11111");
			stmt.setInt(2, Bid);
			stmt.setString(3, strFname);
			stmt.setString(4, strLname);
			stmt.setString(5,strAge);
			stmt.setString(6, strGnd);
			stmt.executeUpdate();
	
			con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  public LinkedList<ClsSports> getTblSports()
	  {
		  LinkedList<ClsSports> lst=new LinkedList<>();
		  Connection con=getDBCon();
		  try {
			PreparedStatement stmt=con.prepareStatement("select * from tblsports");
			ResultSet rset=stmt.executeQuery();
			System.out.println("get tblSPORTS start************ ");
			while(rset.next())
			{
				String strSportId=rset.getString("sportid"),
						strSportname=rset.getString("sportname"),
						strDescription=rset.getString("description"),
						strLocation=rset.getString("location"),
						strImage=rset.getString("img");
				ClsSports obj=new ClsSports(strSportId, strSportname, strDescription, strLocation, strImage);
				lst.add(obj);
				System.out.println(obj);
			}
			System.out.println("get tblSPORTS end *************");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return lst;
	  }
	  
	  
	  public LinkedList<ClsPlan> getTblPlan()
	  {
		  LinkedList<ClsPlan> lst=new LinkedList<>();
		  Connection con=getDBCon();
		  try {
			PreparedStatement stmt=con.prepareStatement("select * from tblplan");
			ResultSet rset=stmt.executeQuery();
			System.out.println("get tblplan start************ ");
			while(rset.next())
			{
				String strPlanId,strPlanName,strDesc,strPrice;
				
				strPlanId=rset.getString("planid");
				strPlanName=rset.getString("planname");
				strDesc=rset.getString("description");
				strPrice=rset.getString("price");
				ClsPlan obj=new ClsPlan(strPlanId, strPlanName, strDesc, strPrice);
				System.out.println(obj);
				lst.add(obj);
			}
			System.out.println("get tblplan end *************");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return lst;
	  }
	  
	  
	  
	  public void Admin(String strUnm, String strPwd){
		    
		  Connection con=getDBCon();
		  try{
			  PreparedStatement stmt=con.prepareStatement("select * from tblAdminLogin");
			  stmt.setString(2, strUnm);
			  stmt.setString(3, strPwd);
			  ResultSet rset=stmt.executeQuery();
			  if(rset.next()){
				  
				
			  }else{
				  
			  }
			 
			 
		  }catch(SQLException e)
		  {
			  e.printStackTrace();
		  }
		 
	  }
	  
	 
	  
	  public void Sports(String strSportname){
		    
		  Connection con=getDBCon();
		  
		  try{
			  PreparedStatement stmt=con.prepareStatement("select * from tblSports where sportname=?");
			  stmt.setString(1,strSportname);
			  ResultSet rset=stmt.executeQuery();
			  while(rset.next())
				{
					String strSportId,strDescription,strLocation,strImage;
					strSportId=rset.getString("sportid");
					strDescription=rset.getString("description");
					strLocation=rset.getString("location");
					strImage=rset.getString("image");
				//	ClsSports obj=new ClsSports(strSportId,strSportname,strDescription,strLocation,strImage);
				}
			 
			 
		  }catch(SQLException e)
		  {
			  e.printStackTrace();
		  }
	
	  }
	  
	  public ClsPrice Balance(String strPlanId){
		    
		  Connection con=getDBCon();
		  ClsPrice obj1 = null;
		  String strPlnPrice;
		try{
			  
			  PreparedStatement stmt=con.prepareStatement("select price from tblPlan where planid=?");
			  stmt.setString(1,strPlanId);
			  ResultSet rset=stmt.executeQuery();
			  while(rset.next())
				{
					
				 strPlnPrice=rset.getString("price");
				System.out.println(strPlnPrice);
				 obj1=new ClsPrice();
				obj1.setStrPlnPrice(strPlnPrice);
					}
			 
			 
		  }catch(SQLException e)
		  {
			  e.printStackTrace();
		  }
		
	return obj1;
	  }
	  
	  public void plans(String strplnid,String strplnname,String strdesp,String strprice){
		 con=getDBCon();
		  
			  PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("insert into tblPlan values(?,?,?,?)");
				  stmt.setString(1,strplnid );
				  stmt.setString(2, strplnname);
				  stmt.setString(3, strdesp);
				  stmt.setString(4, strprice);
				  stmt.executeUpdate();
				  con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	  }
	  
	  
	  public void AdminCheck(HttpServletRequest request, HttpServletResponse response,String strUnm,String strPwd) throws IOException{
		  con=getDBCon();
		  PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("select * from tblAdminLogin where unm=? and pwd=?");
				 stmt.setString(2, strUnm);
				 stmt.setString(3, strPwd);
				 ResultSet rset=stmt.executeQuery();
				 if(rset.next()){
					System.out.println("111111");
					HttpSession session=request.getSession();
					session.setAttribute("unm", strUnm);
						response.sendRedirect(request.getContextPath()+"/AdminFunction.jsp");
						
					}else{
						response.sendRedirect(request.getContextPath()+"/ErrorPage");
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  

	  public void UserCheck(HttpServletRequest request, HttpServletResponse response,String strUnm,String strPwd) throws IOException{
		  con=getDBCon();
		  PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("select * from tblUser3  where unm=? and pwd=?");
				 stmt.setString(1, strUnm);
				 stmt.setString(2, strPwd);
				 ResultSet rset=stmt.executeQuery();
				 if(rset.next()){
					
						response.sendRedirect(request.getContextPath()+"/Status");
						
					}else{
						response.sendRedirect(request.getContextPath()+"/ErrorPage");
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	
}
}

