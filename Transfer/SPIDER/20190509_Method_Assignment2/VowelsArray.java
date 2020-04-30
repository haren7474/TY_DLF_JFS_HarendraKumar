//Printing vowel cons with array of the string

import java.util.Scanner;
class VowelsArray
	{
		public static void main(String [] args)
			{
			System.out.println("Main Method statrs\n");
			Scanner sc= new Scanner(System.in);

			System.out.println("Please enter a String");
			String str= sc.nextLine();

			String [] arr= str.split(" ");
			printVowels(arr);

			System.out.println("\nMain Method ends");

			}

		public static void printVowels(String [] arr)
		{
			System.out.println("\nEntered data is: ");
			int size= arr.length;

			for(int i= 0;i< size;i++)
				{
				System.out.println(arr[i]);
				}
			System.out.println("\n**Vowel** and **Cons**\n");

			for(int i= 0;i< size;i++)
				{
				String s= arr[i];
				String res= printOnlyVowel(s);
				System.out.println(res);
				}
		}


		public static String printOnlyVowel(String str)
			{
			int len = str.length();
			String vow="";
			String cons="";
			for(int i= 0;i< len;i++)
				{
				char ch= str.charAt(i);
				if(ch=='A'|| ch=='a'||ch=='E'|| ch=='e'||ch=='I'|| ch=='i'||ch=='O'|| ch=='o'||ch=='U'|| ch=='u')
					{
					vow += ch;
					}
				else
					{
					cons += ch;
					}
				}
		
			return vow + " " + cons;
			}

}