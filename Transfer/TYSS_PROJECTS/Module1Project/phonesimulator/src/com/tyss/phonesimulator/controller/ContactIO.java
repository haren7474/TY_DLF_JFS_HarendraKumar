package com.tyss.phonesimulator.controller;

import java.util.List;
import java.util.Scanner;

import com.tyss.phonesimulator.dto.Contact;
import com.tyss.phonesimulator.factory.ContactFactory;
import com.tyss.phonesimulator.services.ContactServices;

public class ContactIO {
	static Scanner sc = new Scanner(System.in);
	static Contact contact = null;
	static ContactServices ser = ContactFactory.instanceOfCustomerServices();

	// Displays the Dashboard and takes choice from user
	public static int dashbaord() {
		System.out.println("\n************************");
		System.out.println("1. Show all contacts\n2. Search for Contact (Using Name)\n3. Operate on Contact\n4. Exit");
		System.out.println("\n************************\n");
		System.out.println("Please enter your choice: ");
		return sc.nextInt();
	}

	// Displays the Sub Menu to call and message. Then Takes user's choice.
	public static int contactMenu() {
		System.out.println("\n************************");
		System.out.println("1. Call Person\n2. Send Message to Person\n3. Go to MainMenu\n4. Exit");
		System.out.println("\n************************");
		System.out.println("Please enter your choice: ");
		return sc.nextInt();
	}

	// Displays the Sub Menu to Add, Delete and Edit. Then Takes user's choice.
	public static int crudMenu() {
		System.out.println("\n************************");
		System.out.println("1. Add Contact\n2. Delete Contact\n3. Edit Contact\n4. Go to MainMenu\n5. Exit");
		System.out.println("\n************************");
		System.out.println("Please enter your choice: ");
		return sc.nextInt();
	}

	// Takes input from all fields of Customer to insert
	public static Contact readContact() {
		contact = new Contact();

		String cname;
		do {
			System.out.println("Please enter Contact Name: ");
			cname = sc.next();
		} while (!Validation.checkName(cname));
		contact.setContactName(cname);

		System.out.println("Please enter Number: ");
		contact.setContactNumber(sc.next());

		String gname;
		do {
			System.out.println("Please enter Group name: ");
			gname = sc.next();
		} while (!Validation.checkName(gname));
		contact.setContactGroup(gname);

		return contact;
	}

	public static String deleteContact() {
		System.out.println("Please enter Contact Name to be deleted: ");
		return sc.next();
	}

	// Show the list of contact and takes input name from user also makes sure that
	// name is present in DB
	public static boolean checkPresence() {
		List<Contact> contactList = ser.getAllContact();
		int flag = 0;

		System.out.println("Please enter a name");
		String callerName = sc.next();

		for (Contact contact : contactList) {
			if (contact.getContactName().equalsIgnoreCase(callerName)) {
				flag++;
				break;
			}
		}

		if (flag > 0)
			return true;
		else
			return false;
	}
}
