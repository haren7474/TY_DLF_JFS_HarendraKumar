package edu.jpiders.javatest;

import java.util.Scanner;

public class MoviesApp
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("1.Horror\n2.Comedy\n3.Thriller\n\nPlease enter your choice");
		
		int choice= sc.nextInt();
		MoviesFactory mf= new MoviesFactory();
		
		
		switch(choice)
		{
		case 1: System.out.println(mf.getMovies("horror").getName());				
				break;
				
		case 2: System.out.println(mf.getMovies("comedy").getName());
				break;
		
		case 3: System.out.println(mf.getMovies("thriller").getName());
				break;
		
		case  4: System.exit(0);
			break;
				
		
		}

	}
}
