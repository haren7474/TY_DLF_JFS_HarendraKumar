//Printing vowel cons with array of the string

import java.util.Scanner;
class NextChar
	{
		public static void main(String [] args)
			{
			System.out.println("-----------------Hello World----------------");

			String str= readString(); //Reading Input

			String res= nextCharOfEachLetter(str);// Calculating next letter
			printResult(str, res); // Printing Result	
			
					
			nextCharDirectPrint(str); // Shifting letter and print directly

			System.out.println("\n---------------Bye World-----------------");
			}


			//Mehotd to read input string
			public static String readString()
			{
			Scanner sc= new Scanner(System.in);
			System.out.println("Please enter a String");
			String str= sc.nextLine();
			return str;
			}

			public static String nextCharOfEachLetter(String str)
			{
				String s="";
				for(int i=0; i< str.length() ;i++)
				{
					if(str.charAt(i)=='z')
					{
						s=s+'a';
					}
					else if(str.charAt(i)=='Z')
					{
						s=s+'A';
					}
					else
					{
					char ch= str.charAt(i);
					ch++;
					s=s + ch;
					}
				}
				return s;
			}


			//Print Result Method
			public static void printResult(String str, String res)
			{
				System.out.println("\nOutput 1 of " +str + " is: "+ res);		
			}

			public static void nextCharDirectPrint(String str)
			{
				System.out.print("\n\nOutput 2 of " +str + " is: ");
				
				int i=0;
				while(i< str.length())
				{
					if(str.charAt(i)=='z')
					{
						System.out.print('a');
					}

					else if(str.charAt(i)=='Z')
					{
						System.out.print('A');
					}
					
					else
					{
						System.out.print((char)(1+str.charAt(i)));	
					}

					i++;				
				}
			}
			

	}	