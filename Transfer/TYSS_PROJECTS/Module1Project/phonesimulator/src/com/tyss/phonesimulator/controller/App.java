package com.tyss.phonesimulator.controller;

import java.util.List;
import java.util.Scanner;

import com.tyss.phonesimulator.dto.Contact;
import com.tyss.phonesimulator.factory.ContactFactory;
import com.tyss.phonesimulator.services.ContactServices;

public class App {
	static ContactServices ser = ContactFactory.instanceOfCustomerServices();
	static Scanner sc = new Scanner(System.in);
	static Contact contact = null;

	public static void main(String[] args) {
		System.out.println("\t\t*******************Welcome to Contact Manager*******************");

		while (true) 
		{
			int dashboardChoice = ContactIO.dashbaord();

			switch (dashboardChoice) 
			{
			case 1:
				displayAll();
				break;

			case 2:
				SearchAndOperate.searchContact();
				break;

			case 3:
				SearchAndOperate.PerformCrud();
				break;
			case 4:
				System.exit(0);
				break;

			default:
				System.out.println("Inlavid Choice, please try again!!!!");
			}
		}

	}
	public static void displayAll()
	{
		List<Contact> contactList = ser.getAllContact();
		if (contactList.size() > 0) {
			System.out.println("\n--------------Here is the complete contact details:-------------");
			System.out.println("ID\tName\tNumber\t\tGroup");
			for (Contact contact : contactList) {
				System.out.println(contact);
			}
		} else {
			System.out.println("Do data present for contact, please add the data first");
		}
	}

}
