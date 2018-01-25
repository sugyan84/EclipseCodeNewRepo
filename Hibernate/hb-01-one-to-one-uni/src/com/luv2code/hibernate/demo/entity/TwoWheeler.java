package com.luv2code.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TwoW")
public class TwoWheeler extends Vehicle
{
	private String SteeringHandle;

	public TwoWheeler()
	{
	}

	public TwoWheeler(String data)
	{
		this.SteeringHandle = "Bike-handle";
	}

	public String getSteeringHandle()
	{
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle)
	{
		SteeringHandle = steeringHandle;
	}

}
