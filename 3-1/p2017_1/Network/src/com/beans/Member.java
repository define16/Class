package com.beans;

public class Member {
	private String id, name, passwd;
	
	public Member(String id, String name, String passwd)
	{
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPasswd()
	{
		return passwd;
	}
	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}
	
	public boolean equals(Object obj)
	{
		Member m = (Member)obj;
		return m.getId().equals(id) &&
				m.getName().equals(name) &&
				m.getPasswd().equals(passwd);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Id : %s, Name : %s, Password : %s",id,name,passwd);
	}
}
	

