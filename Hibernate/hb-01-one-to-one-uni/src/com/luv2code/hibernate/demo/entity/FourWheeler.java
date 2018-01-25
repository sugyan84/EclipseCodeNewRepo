package com.luv2code.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FourW")
public class FourWheeler extends Vehicle
{
	private String steeringWheel;
	
	public FourWheeler() {}
	
	public FourWheeler(String data) {
		this.steeringWheel = data;
	}

	public String getSteeringWheel()
	{
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel)
	{
		this.steeringWheel = steeringWheel;
	}
	
	
	
}
