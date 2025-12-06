package javacrud;
import java.sql.SQLException;
import java.util.Scanner;

public class menu {
	Scanner sc=new Scanner(System.in);
	public menu() throws SQLException
	{
		student st=new student();
		while(true)
		{
		System.out.println("dashboard\n1.add\n2.view\n3.update\n4.delete\n0.exite\nenter:");
		int m=sc.nextInt();
		if(m==0)
		{
			System.out.println("app closed");
			break;
		
		}
		if(m==1)
		{
			System.out.println("adding elemnts");
			System.out.println("enter a name");
			String name=sc.next();
			System.out.println("enter a  mark 1");
			float m1=sc.nextFloat();
			System.out.println("enter a mark 2");
			float m2=sc.nextFloat();
			System.out.println("enter a mark 3");
			float m3=sc.nextFloat();
			int r=st.insert(name,m1,m2,m3);
			}
		else if(m==2)
		{
			System.out.println("1.view\n2.view(id)");
			int c=sc.nextInt();
			if(c==1)
			{
				st.view();
			}
			else if(c==2)
			{
				System.out.print("Enter ID : ");
                int id=sc.nextInt();
				st.view(id);
				
			}
			else
			{
				System.out.print("invalid option ");

				
			}
		}
		else if(m==3)
		{
			System.out.println("engter id");
			int id=sc.nextInt();
			System.out.println("enter a  mark 1");
			float m1=sc.nextFloat();
			System.out.println("enter a mark 2");
			float m2=sc.nextFloat();
			System.out.println("enter a mark 3");
			float m3=sc.nextFloat();
			int s=st.update(m1, m2, m3, id);
			System.out.println(s!=0?"modify":"failed");
			
		}
		else if(m==4)
		{
			System.out.println("enter a id");
			int id=sc.nextInt();
			int v=st.delete(id);
			System.out.println(v!=0?"delete":"failed");
		}
		  else {
              System.out.println("Invalid option");
          }    
		
	}
	}
	

}
