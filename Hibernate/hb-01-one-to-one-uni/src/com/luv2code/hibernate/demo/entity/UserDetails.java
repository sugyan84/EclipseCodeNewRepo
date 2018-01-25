package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name="UserDetails.byId", query="from UserDetails where id > :userId")
@Table(name="USER_DETAILS")
public class UserDetails
{
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_name")
	private String name;
	
	
	
	@Column(name="Age")
	private int age;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Vehicle_id")
	private Vehicle veh;*/
	
	public UserDetails()
	{
		
	}

	public UserDetails(String name)
	{
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	/*public Vehicle getVeh()
	{
		return veh;
	}

	public void setVeh(Vehicle veh)
	{
		this.veh = veh;
	}*/

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	
}
