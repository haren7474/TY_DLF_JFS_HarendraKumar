class Main 
{
	
	static
	{
		int x=60;
		double y=60.33;
		System.out.println("Values of x in static Block of Main is: "+ x);
		System.out.println("Values of y in static Block of Main is: "+ y);
	}


	{
		int x=70;
		double y=70.33;
		System.out.println("Values of x in Non static Block of Main is: "+ x);
		System.out.println("Values of y in Non static Block of Main is: "+ y);
	}

	public static void main(String[] args) 
	{
		System.out.println("Main Method Begins");
		Test t= new Test();	
		Test.m1();
		t.m2();
		new Main();
	}
	
}

class Test
{
	int x=10;
	double y=10.11;

	public static void m1()
	{
		int x=20;
		double y=20.22;
		System.out.println("Values of x in m1 is: "+ x);
		System.out.println("Values of y in m1 is: "+ y);
	}

	static
	{
		int x=30;
		double y=30.33;
		System.out.println("Values of x in static Block of Test is: "+ x);
		System.out.println("Values of y in static Block of Test is: "+ y);
	}

	public void m2()
	{
		int x=40;
		double y=40.22;
		System.out.println("Values of x in m2 is: "+ x);
		System.out.println("Values of y in m2 is: "+ y);
	}

	
	{
		int x=50;
		double y=50.33;
		System.out.println("Values of x in Non static Block of Test is: "+ x);
		System.out.println("Values of y in Non static Block of Test is: "+ y);
	}

}
