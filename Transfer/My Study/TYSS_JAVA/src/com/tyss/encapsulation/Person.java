package com.tyss.encapsulation;

import java.io.Serializable;

public class Person implements Serializable
{
	private int age;
	private String name;
	
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
}
