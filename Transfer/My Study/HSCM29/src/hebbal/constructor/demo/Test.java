package hebbal.constructor.demo;

public class Test 
{
	Test()
	{
		this(10,20);
		System.out.println("No agr ");
	}
	
	Test(int x, double y)
	{
		this("Hello ");
		System.out.println("int/double agr "+x+" "+y);
	}
	
	Test(String s)
	{
		System.out.println("String agr"+ s);
	}
}
