package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class EmployeeDetails
 */
public class EmployeeDetails extends GenericServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	ResultSet rs;
	Statement st;
	 
    /**
     * @see GenericServlet#GenericServlet()
     */
    public EmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		  
		System.out.println("init()....");
		try {
			System.out.println("Trying to load the driver.......");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver() );
			System.out.println("Driver loaded....");

			//2nd step : connect to the database 
			System.out.println("Trying to connect to the database");
			//jdbc:oracle:thin:@localhost:1521:yourInstanceName XE/ORCL/OSE whaterver name found in tnsnames.ora file
			 conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			System.out.println("Connected to the database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			rs.close();
			conn.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("\tsevice()...."); 
		 try {
			    st = conn.createStatement(); 
			    // this is for DQL
			    System.out.println("Statement made....for DQL");
			    System.out.println("Trying to write a query and fire it... ");    //4th step : fire the statement and acquire result if any
			    rs = st.executeQuery("select empno,ename,job,mgr,sal,hiredate from emp"); 
			    // type the query here
			    System.out.println("Query fired...and got the result....");
			    System.out.println("Now processing the result....."); 
			    //5th step : process the result
			    PrintWriter pw=response.getWriter();
			    pw.println("<h1>Employee number and name</h1>");
			    pw.println("<table border=2>");
			    while(rs.next()) { // process the result set like a cursor program
			        int empno = rs.getInt(1);    
			        String ename = rs.getString(2); // dname
			        String job = rs.getString(3);
			        int mgr = rs.getInt(4);
			        int sal = rs.getInt(5);
			        Date d=rs.getDate(6) ;
			        //PrintWriter pw=response.getWriter();
			        //pw.println("For employee number:"+empno);
			       // pw.println("<table border=2>");
			        pw.println("<tr>");
			        pw.println("<td>employee number</td><td>"+empno+"</td>");
			       // pw.println("</tr>");
			        pw.println("<td>employee name</td><td>"+ename+"</td>");
			        pw.println("</tr>");
			        //pw.println("<td>salary</td><td>"+sal+"</td>");
			        //pw.println("</tr>");
			        //pw.println("</table>");
			        System.out.println("EMPNO    : "+empno);
			        System.out.println("ENAME    : "+ename);
			        System.out.println("Job      : "+job);
			        System.out.println("MGR      : "+mgr);
			        System.out.println("SALARY   : "+sal);
			        System.out.println("HIREDATE : "+d);
			        System.out.println("---------------------------");
			        System.out.println("-----------------------------");
			        System.out.println("------------------*-----------");
			        System.out.println("-*******************-*-----------");
			        System.out.println("------------------*---*************--------");
			        
			    }pw.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}

}
