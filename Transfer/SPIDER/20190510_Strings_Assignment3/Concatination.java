//Printing vowel cons with array of the string

import java.util.Scanner;
class Concatination
	{
		public static void main(String [] args)
			{
			System.out.println("-----------------Hello World----------------");

			String str1= readString(); //Reading Input
			String str2= readString(); //Reading Input

			String res= concatString(str1, str2); // Concatination of both String inputs with 2 for loops
			System.out.println("\n**Output 1: with 2 for loops**");
			printResult(str1, str2, res); // Printing Result

			String res1= concatStringWithWhile(str1, str2);// Concatination of both String inputs with 2 for loops
			System.out.println("\n\n**Output 2: with 2 while loops**");
			printResult(str1, str2, res1); // Printing Result
			
			System.out.println("\n\n**Output 3: using SOP instead of SOPln**");
			directPrint(str1, str2); // Just Printing without "LN"
			

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


			//Method to concat with 2 for loops
			public static String concatString(String str1, String str2)
			{
				String s="";
				for(int i=0; i< str1.length() ;i++)
				{
					s=s + str1.charAt(i);
				}

				for(int i=0; i< str2.length() ;i++)
				{
					s=s + str2.charAt(i);
				}
				return s;
			}

			//Method to concat with 2 While Loops
			public static String concatStringWithWhile(String str1, String str2)
			{
				String s="";
				int i=0;
				int j=0;

				while(i<str1.length())
				{
					s=s + str1.charAt(i);
					i++;
				}

				while (j<str2.length())
				{
					s=s + str2.charAt(j);
					j++;
				}
					
				return s;
			}
			
			//Print Result Method
			public static void printResult(String str1, String str2, String res)
			{
			System.out.println("\nConcat of " +str1 + " and "+ str2+ " is: "+ res);		
			}

			//Method which is printing without using LN
			public static void directPrint(String str1, String str2)
			{
			System.out.print("Concat of " +str1 + " and "+ str2+ " is: "+ str1);
			System.out.print(str2);
			System.out.println('A'+20);
			}

	}	