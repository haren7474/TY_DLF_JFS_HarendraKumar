//Printing Vowel and cons of the string

import java.util.Scanner;
class Vowels
{
	public static void main(String [] args)
		{
		System.out.println("Main Method statrs\n");
		Scanner sc= new Scanner(System.in);

		System.out.println("Please enter a String");
		String str= sc.nextLine();

		printOnlyVowel(str);
		System.out.println("\nMain Method ends");
		
		}



	public static void printOnlyVowel(String str)
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

	printResult(vow, cons, str);

	}



	public static void printResult(String vow, String cons, String str)
	{
		System.out.print("\nVowel List of " + str + " is:\n");
		System.out.print(vow);
		System.out.print("\nCons List of " + str + " is:\n");
		System.out.print(cons);
	}

}