package javacrud;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class student<prepared, person> {
	String url="jdbc:mysql://localhost/gopi";
	String user="root";
	String pass="jagan123";
	Connection con;
	public student () throws SQLException
	{
		con=DriverManager.getConnection(url, user, pass);
	}
	
	public boolean login(String uname,String upass) throws SQLException
	{
		boolean r=false;
		String q="select * from login where uname=? and upass=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, uname);
		pst.setString(2, upass);
		ResultSet rs=pst.executeQuery();
		int k=0;
		while(rs.next())
		{
			k++;
		}
		if(k>0)
		{
			return r=true;
		}
		else
		{
			return r= false;
		}
		
	}
	public int insert(String name,float m1,float m2,float m3) throws SQLException
	{
		float t=m1+m2+m3;
		float a=(m1+m2+m3)/3;
		String q="insert into student (name,m1,m2,m3,t,a) values (?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, name);
		pst.setFloat(2, m1);
		pst.setFloat(3, m2);
		pst.setFloat(4, m3);
		pst.setFloat(5, (m1+m2+m3));
		pst.setFloat(6, (m1+m2+m3)/3);
		int r=pst.executeUpdate();
		return r;
		}
	public int update(float m1,float m2,float m3,int id) throws SQLException
	{
		int r=0;
		String q="update student set m1=?,m2=?,m3=? where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setFloat(1, m1);
		pst.setFloat(2, m2);
		pst.setFloat(3, m3);
		pst.setInt(4, id);
		r=pst.executeUpdate();
		return r;
	}
	public int delete(int id) throws SQLException
	{
		String q="delete from student where id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1,id);
		int r=pst.executeUpdate();
		return r;
	}
	public void view() throws SQLException
	{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()) 
		{
			System.out.println("student informatin list ");
			System.out.println("-----------------------------");
			System.out.println("id"+rs.getInt("id"));
			System.out.println("name"+rs.getString("name"));
			System.out.println("course 1"+rs.getFloat("m1"));
			System.out.println("course 2"+rs.getFloat("m2"));
			System.out.println("course 3"+rs.getFloat("m3"));
			System.out.println("total"+rs.getFloat("t"));
			System.out.println("avg"+rs.getFloat("a"));
		}
	}
	
	public void view(int id) throws SQLException
	{
		PreparedStatement pst=con.prepareStatement("select * from student where id=?");
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		int k=0;
		while(rs.next())
		{
			System.out.println("student informatin list ");
			System.out.println("-----------------------------");
			System.out.println("id"+rs.getInt("id")+"   "+"name"+rs.getString("name"));
			System.out.println("course 1"+rs.getFloat("m1"));
			System.out.println("course 2"+rs.getFloat("m2"));
			System.out.println("course 3"+rs.getFloat("m3"));
			System.out.println("total"+rs.getFloat("t"));
			System.out.println("avg"+rs.getFloat("a"));
			System.out.println("\n");
			k++;
		}
		if(k==0)
		{
			System.out.println("no data to display");
		}
	}
		
	}
