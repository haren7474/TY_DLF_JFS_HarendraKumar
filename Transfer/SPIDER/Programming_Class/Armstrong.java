class  Armstrong
{
	public static void main(String[] args) 
	{
		
	int n=153;
	int num=n;
	int digit=0;
	int sum=0;
	int rem=0;

		while( num>0)
		{
			num= num/10;
			digit++;
		}
		
		num=n;

		while(num>0)
		{
		  rem= num%10;
		  
			int product=1;
			for(int i=0; i<digit;i++)
			{
				product= product*rem;
			}

		  sum= sum+ product;	
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
}