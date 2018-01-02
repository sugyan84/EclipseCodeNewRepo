package com.restservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class UserModel
{
	String	name;
	int		num;

	public UserModel()
	{
		this.name = "Sugyan";
		this.num = 100;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

}
