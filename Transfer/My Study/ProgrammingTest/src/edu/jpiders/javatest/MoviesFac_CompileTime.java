package edu.jpiders.javatest;

public class MoviesFac_CompileTime 
{
	public Horror getMovie(Horror r)
	{
		return new Horror();
	}
	
	public Comedy getMovie(Comedy c)
	{
		return new Comedy();
	}
	
	public Thriller getMovie(Thriller t)
	{
		return new Thriller();
	}
	
		
}
