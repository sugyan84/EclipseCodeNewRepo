package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle
{
	@Id
	@Column(name="vehicle_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vehicle_id;
	
	@Column(name="vehicle_name")
	private String vehicle_name;
	
	public Vehicle() {}
	
	public Vehicle(String vName) 
	{
		this.vehicle_name = vName;
	}

	public int getVehicle_id()
	{
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id)
	{
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_name()
	{
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name)
	{
		this.vehicle_name = vehicle_name;
	}
	
	

}
