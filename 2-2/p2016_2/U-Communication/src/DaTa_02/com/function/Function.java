package DaTa_02.com.function;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import DaTa_02.com.datatype.Member;


public class Function {
	private final String DATA_FILE = "data.txt";
	private BufferedReader in = null;
	private PrintWriter out = null;
	

	
	public boolean register(Member member)
	{
		try {
			if(login(member,false))
				return false;
			
			out = new PrintWriter(new FileWriter(DATA_FILE,true));
						
			out.println(member.getId() + "/" + member.getPasswd() + "/" +  member.getter() );
			
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
			return true;
		}
	
	public boolean login(Member member, boolean checkPasswd)
	{
		String line = null;
		File file = new File(DATA_FILE);
				
		try {

			
			if(!file.exists())
				file.createNewFile();
		} catch (Exception e) {
	
		} 
		
		try{
			in = new BufferedReader(new FileReader(DATA_FILE));
			
			while((line = in.readLine()) != null)
			{
				
				String[] split_line = line.split("/");
				
				String id = split_line[0];
				String passwd = split_line[1];
			
				if(id.equals(member.getId()))
				{
					if(checkPasswd)
					{
						if(passwd.equals(member.getPasswd()) )
						{
							in.close();
							return true;
						}
					}
					else
					{
						in.close();
						return true;
					}
				}
			}
			in.close();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Member> printMembers()
	{
		ArrayList<Member> list = new ArrayList<Member>();
		String line = null;
		
		try
		{
			in = new BufferedReader(new FileReader(DATA_FILE));
			
			while((line = in.readLine()) != null)
			{
				
				String[] split_line = line.split("/");
				
				String _id = split_line[0];
				String _passwd = split_line[1];
				
				list.add(new Member(_id,_passwd));
			}
			in.close();
		}catch(IOException e)
		{
			//
		}
		return list;
	}
	
	public int Confirm(String id,String pw, String pw2)
	{
		String data = "";
		
		try {
			in = new BufferedReader(new FileReader("data.txt")); 
			
			while((data=in.readLine())!=null)
			{
				String search[] = data.split("/"); 
				if(search[0].equals(id))
					return 1;
						
			} in.close();	
			
			if(pw.equals(pw2))
				return 0;
			else
				return 2;
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); }
	
		return 0;
	}
	
	public Vector Print(){
		
		Vector v=new Vector();
		v.clear();
		v.add("---------------------------회원목록---------------------------");
		
		try{
			in = new BufferedReader(new FileReader(DATA_FILE));
			int i=1;
			String data;
			
			while((data=in.readLine())!=null)
			{		
				String search[] = data.split("/"); 
				String id = search[0];
				String name=search[2];
				v.add(i+"번째 사람 - ID = "+id+" ,   Name = "+ name +"\n");
				i++;
			}
			}catch(IOException e2){
			
			}
		return v;
	}
	
}