//Printing Manu based all programs

 
import java.util.Scanner;
class StringWithMenu
	{
		public static Scanner sc= new Scanner(System.in);
		public static void main(String [] args)
			{
			System.out.println("Main Method statrs\n");
			
			System.out.println("Please enter a String");
			String str= sc.nextLine();
			
			display(str);

			System.out.println("\nMain Method ends");
			}

		public static void display(String str)
			{
			while(true)
				{
				System.out.println("\n1. Print Char by char\n2. Print Reverse of String\n3. Print Alternate char\n4. List Vowels and consonants\n5. Display all\n6. Exit");
				
				System.out.println("Please enter your choice");
				int choice= sc.nextInt();
				int len= str.length();
				
				switch(choice)
					{
					case 1: printCharByChar(str,len);
							break;
					
					case 2: reverseString(str,len);
							break;
					
					case 3: printAlternateChar(str,len);
							break;
					
					case 4: printOnlyVowel(str,len);
							break;
					
					case 5: printCharByChar(str,len);
							reverseString(str,len);
							printAlternateChar(str,len);
							printOnlyVowel(str,len);
							break;
							
					case 6: System.exit(0);
							break;
							
					
					default: System.out.println("Invalid Choice");
					}
					}
				}

		
		public static void printOnlyVowel(String str, int len)
			{
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
			System.out.print("\n***Vowel List of " + str + " is:\n");
			System.out.print(vow +"***\n");

			System.out.print("\nCons List of " + str + " is:\n");
			System.out.print(cons+"***\n");
			}



		public static void printCharByChar(String str, int len)
			{
			System.out.print("\n***Char by Char data of " + str + " is:\n");
			
			for(int i= 0;i< len;i++)
				{
				System.out.print(str.charAt(i)+" ");
				}
				
			
			System.out.print("***\n");
			}


		public static void reverseString(String str, int len)
			{
			System.out.print("\n***Reverse String of " + str + " is: \n");
			for(int i= len-1;i>=0;i--)
				{
				System.out.print(str.charAt(i)); 
				}
			
			System.out.print("***\n");
			}

		
		public static void printAlternateChar(String str, int len)
			{
			System.out.print("\n***Alternate char data of " + str + " is:\n");
			
			for(int i= 0;i< len;i+=2)
				{
				System.out.print(str.charAt(i)+" ");
				}
				
			System.out.print("***\n");
			}

	}
