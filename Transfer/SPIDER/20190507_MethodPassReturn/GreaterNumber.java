import java.util.Scanner;
class GreaterNumber
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Main method started");
		System.out.println("Please enter 1st number");
		int n1= sc.nextInt();

		System.out.println("Please enter 2nd number");
		int n2= sc.nextInt();

		checkGreaterNumber(n1,n2);

		System.out.println("Main method ended");
	}


	//To Check greater between 2
	public static void checkGreaterNumber(int n1, int n2)
	{
		boolean b;

		if(n1>n2)
		{
			b=true;
		}
		else
		{
			b=false;
		}

		printResult(b,n1,n2);
	}

	//To print the result
	public static void printResult(boolean b, int n1, int n2)
	{	if(b==true)
		{
		System.out.println("Biggest Number is: "+n1);
		}
		else
		{
		System.out.println("Biggest Number is: "+n2);
		}
	}

}
