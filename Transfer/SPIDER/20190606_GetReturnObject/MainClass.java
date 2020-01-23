class MainClass 
{
	public static void main(String[] args) 
	{
		Sample s= new Sample();
		Demo d= s.getInstance();
		Test t= d.getObject();
		t.print();
		
		System.out.println("Calling Print by Single line ");
		new Sample().getInstance().getObject().print();

	}
}

class Test
{
	public void print()
	{
		System.out.println("Hello World");
	}
}

class Demo
{
	public Test getObject()
	{
		return new Test();
	}
}


class Sample
{
	public Demo getInstance()
	{
		return new Demo();
	}
}