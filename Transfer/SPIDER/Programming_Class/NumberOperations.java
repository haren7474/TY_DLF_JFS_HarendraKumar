import java.util.Scanner;

public class NumberOperations
{
	static Scanner sc= new Scanner(System.in);
	public static int readInput()
	{
		System.out.println("Please enter a number");
		int input= sc.nextInt();		
		return input;
	}
 
   public static void main(String [] args)
     {	
		while(true)
		{
		System.out.println("\n\n*****************\n1. Check Prime\n2. Print Factors\n3. Check Perfect\n4. Check Armstrong\n5. Calculate Factorial \n6. Sum of Digits\n7. Check Special Number\n8. Greatest Odd Digit in a number\n9. Cloud and Nix\n10. Fibonacci\n11. Print odd numger in given range from Fibonacci\n20. Exit\n*****************\n");
		
		System.out.println("Please enter your choice");
		int choice = sc.nextInt();

		switch(choice)
			{
			case 1: 
				int n= readInput();
				checkPrime(n);
				break;

			case 2: 
				n= readInput();
				printFactors(n);
				break;

			case 3: 
				n= readInput();
				checkPerfect(n);
				break;
			
			case 4: 
				n= readInput();
				checkArmstrong(n);
				break;

			case 5: 
				n= readInput();
				calculateFactorial(n);
				break;

			case 6: 
				n= readInput();
				digitSum(n);
				break;

			case 7: 
				n= readInput();
				checkSpecialNumber(n);
				break;

			case 8: 
				n= readInput();
				findGreatestOddDigit(n);
				break;

			case 9:	
				n= readInput();
				int m= readInput();
				printCloudNix(n,m);
				break;

			case 10: 
				System.out.println("Please enter Length");
				int len = sc.nextInt();
				printFibonacci(len);
				break;

			case 11:
				System.out.println("Please enter Length");
				len = sc.nextInt();
				printOddFromRangeInFibonacci(len);
				break;
			
			case 20: System.exit(0);
					break;
			
			default: System.out.println("Incorrect Choice");
						break;
			}
		}
	}

   public static void checkPrime(int n)
      {	
	int count=0;
	for(int i=2; i<=n/2;i++)
	{
		if(n%i==0)
		{
		count++;
		break;
		}
	}

	if(count==0)
	{
	System.out.println(n+ " is a Prime Number");
	}
	else
	{
	System.out.println(n+ " is a not Prime Number");
	}

   }

   public static void printFactors(int n)
     {
	for(int i=1;i<=n/2;i++)
	{
	   if(n%i==0)
		{
		System.out.println(i+ " is a factor of " + n);
		}
	}
     }

   public static void checkPerfect(int n)
     {
	int sum=0;
	for(int i=1;i<=n/2;i++)
	{
	   if(n%i==0)
		{
		  sum= sum+i;
		}
	}

	if(sum==n)
	{
	System.out.println(n+ " is a perfect number");
	}
	else
	{
	System.out.println(n+ " is a not perfect number");
	}
     }

   public static void checkArmstrong(int n)
     {
	int num=n;
	int digit=0;
	int sum=0;
	int rem=0;

		while( num != 0)
		{
			num= num/10;
			digit++;
		}
		
		num=n;

		while(num!=0)
		{
		  rem= num%10;

		  sum= sum+ powerOfDigit(digit, rem);	
		  num=num/10;
		}
		 
		if(sum==n)
		{
			System.out.println(n+ " is an armstrong number");
		}

		else
		{
			System.out.println(n+ " is not an armstrong number");
		}
     }

	 public static int powerOfDigit(int digit, int rem)
		{
			int product=1;
			for(int i=0; i<digit;i++)
			{
				product= product*rem;
			}
				return product;
		}

	public static int calculateFactorial(int num)
	{	int n=num;
		int fact=1;

		while(n>1)
		{
		fact=fact*n;
		n--;
		}
		System.out.println("Factorial of "+num + " is "+ fact);
		return fact;
	}

	public static void digitSum(int num)
	{
		int sum=0;
		int rem;
		int n= num;
		while(n>0)
		{
			rem= n%10;
			sum= sum+rem;
			n/=10;
		}

		System.out.println("Sum of digits of "+num + " is "+ sum);	

	}

	public static void checkSpecialNumber(int num)
	{
		int sum=0;
		int rem;
		int n= num;
		while(n>0)
		{
			rem= n%10;
			sum= sum+ calculateFactorial(rem);
			n/=10;
		}

		if(num==sum)
		{
			System.out.println(num+ " is a special number");
		}

		else
		{
			System.out.println(num+ " is not a special number");
		}	
	}

	public static void findGreatestOddDigit(int num)
	{	
		int n= num;
		int greatest=0;
		while(n>0)
		{
			int rem= n%10;
			if(rem%2!=0)
			{
				if(rem> greatest)
				{
				greatest=rem;
				}
			}
			n/=10;	
		}

		System.out.println("Greatest Odd Digit in number "+ num+ " is :"+ greatest);
	}

	public static void printCloudNix(int n, int m)
	{
	   System.out.println("List of Cloud and Nix between "+ n+ " and "+ m); 
           for(int i=n; i<=m;i++)
	     {
		if(i%3==0 && i%7==0)
		{
		System.out.println("cloud nix");
		}
		else if(i%3==0)
		{
		System.out.println("cloud");
		}
		else if(i%7==0)
		{
		System.out.println("nix");
		}
		else 
		{
		System.out.println(i);
		}
	   }
    }

	public static void printFibonacci(int len)
	{	
		int n1=0, n2=1;
		int [] a=new int[len];
			
		if(len==1)
		{
			System.out.println(n1);
		}

		else if(len==2)
		{
			System.out.println(n1+" "+n2);
		}

		else
		{
			System.out.print(n1+" "+n2+" ");
			
			a[0]=n1;
			a[1]=n2;
		
			for(int i=3; i<len;i++)
			{
			int n3= n1+n2;
			a[i]=n3;
			
			System.out.print(n3+" ");
			
			n1=n2;
			n2=n3;
			}	
		}


		System.out.println("\nPlease enter the position to check number is series");
		int position= sc.nextInt();
		System.out.println(a[position]);

		System.out.println("Please enter the lower range");
		int low= sc.nextInt();

		System.out.println("Please enter the upper range");
		int up= sc.nextInt();
		int count=0;
		for(int i=0; i< a.length;i++)
		{
			if(a[i]%2==1)
			{
				if(a[i]> low && a[i]< up)
				{
					System.out.println("Numbers in given range "+ a[i]);
					count++;
				}
			}
			
		}

		if (count==0)
			{
				System.out.println("No odd number is present between "+low+" and "+up);
			}
	}


	public static void printOddFromRangeInFibonacci(int len)
	{		
		System.out.println("Please enter the lower range");
		int low= sc.nextInt();

		System.out.println("Please enter the upper range");
		int up= sc.nextInt();
		
			int count=0;
			int n1=0, n2=1;
			System.out.print(n1+" "+n2+" ");
			
			for(int i=3; i<=len;i++)
			{
			int n3= n1+n2;
			System.out.print(n3+" ");
			
				if(n3%2==1 && n3> low && n3< up)
				{
					System.out.println("Numbers in given range "+ n3+" ");
					count++;
				}

			n1=n2;
			n2=n3;
			}	
		
		if (count==0)
			{
				System.out.println("No odd number is present between "+low+" and "+up);
			}
	}


}