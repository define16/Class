package DaTa_02.com.datatype;

import DaTa_02.com.function.Function;

public class Member {
	private String id;
	private String passwd;
	private String name;
	
	public Member(String id, String passwd)
	{
		this.id = id;
		this.passwd = passwd;
	}
	public Member(String id, String passwd, String name)
	{
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getPasswd()
	{
		return passwd;
	}
	public void setPasswd(String passwd){
		this.passwd = passwd;
	}
	
	public String getter()
	{
		return name;
	}

	public void setter(String name)
	{
		this.name = name;
	}

}
