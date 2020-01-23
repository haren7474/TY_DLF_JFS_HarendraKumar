class MainReassinment
{
	static int x= 10;
	double y= 10.11;
	
	static
	{
		System.out.println("\n***Static Block Execution in Main***");
		x=20;		
	}


	{
		x=30;
		y=30.33;		
	}

	public static void main(String[] args) 
	{
		System.out.println("\nMain Method Begins");
		System.out.println("Values of x in static Block of Main is: "+ x);
		
		MainReassinment mr= new MainReassinment();
		System.out.println("Values of x in Non static Block of Main is: "+ x);
		System.out.println("Values of y in Non static Block of Main is: "+ mr.y);
		
		System.out.println("Values of x in static Block of Demo is: "+ Demo.x);		
		Demo d= new Demo();	
		System.out.println("Values of x in static Block of Demo is: "+ Demo.x);
		System.out.println("Values of x in Non static Block of Demo is: "+ d.x);
		System.out.println("Values of y in Non static Block of Demo is: "+ d.y);
		

	}
	
}

class Demo
{
	static int x= 50;
	double y= 50.11;
	
	static
	{
		x=60;		
	}


	{
		x=70;
		y=70.33;		
	}

}
