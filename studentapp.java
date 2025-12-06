package javacrud;
import java.sql.SQLException;
import java.util.Scanner;

public class studentapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		try
		{
			System.out.println("Welcome");
	           System.out.println("Enter Username : ");
	           String uname=sc.next();
	           System.out.println("Enter Password : ");
	           String upass=sc.next();
	           student st=new student();
	            if (st.login(uname, upass)) 
	            {
	                menu 
	                m = new menu();
	            } else
	            {
	                System.out.println("Invalid Passcode/Username");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            sc.close(); // close the scanner
	        }

}
}
