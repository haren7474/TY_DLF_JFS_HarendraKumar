package com.tyss.phonesimulator.controller;

import java.util.List;
import java.util.Scanner;

import com.tyss.phonesimulator.dto.Contact;
import com.tyss.phonesimulator.factory.ContactFactory;
import com.tyss.phonesimulator.services.ContactServices;

public class SearchAndOperate {
	static Scanner sc = new Scanner(System.in);
	static ContactServices ser = ContactFactory.instanceOfCustomerServices();

	public static void searchContact() {
		while (true) {

			List<Contact> contactList = ser.getAllContact();
			System.out.println("\n----------List of Contacts---------");
			for (Contact contact : contactList) {
				System.out.println(contact.getContactName());
			}

			int todoChoice = ContactIO.contactMenu();
			switch (todoChoice) {

			case 1:
				char ch;
				if (ContactIO.checkPresence()) {
					System.out.println("calling......");
					do {
						System.out.println("Please press C to cancel the call ");
						ch = sc.next().charAt(0);
					} while (ch != 'c');
					{
						System.out.println("----------\nCall ended\n------");
					}

				} else
					System.out.println("-----------------\nContact not found\n---------------");
				break;

			case 2:
				if (ContactIO.checkPresence()) {
					System.out.println("Please enter a message to send");
					String msg = sc.next();
					System.out.println("Sending message......" + msg + ".....");
					System.out.println("\nMessage has been sent\n");

				} else
					System.out.println("-----------------\nContact not found\n---------------");

				break;

			case 3:
				return;

			case 4:
				System.exit(0);
				break;

			default:
				System.out.println("Inlavid Choice, please try again!!!!");
			}
		}
	}

	public static void PerformCrud() {
		while (true) {
			int crudChoice = ContactIO.crudMenu();
			switch (crudChoice) {
			case 1:
				if (ser.addContact(ContactIO.readContact()))
					System.out.println("New contact has been added");
				else
					System.err.println("Coult not add contact!!!");
				break;

			case 2:
				App.displayAll();
				String name = ContactIO.deleteContact();
				if (ser.deleteContact(name))
					System.out.println(name + " has been deleted");
				else
					System.err.println("Could not be deleted!!!");

				break;

			case 3:
				App.displayAll();
				System.out.println("Please enter Name");
				String nameToUpdate = sc.next();
				System.out.println("Please enter new group name");
				String groupName = sc.next();
				if (ser.modifyContact(nameToUpdate, groupName))
					System.out.println(nameToUpdate + " has been modified");
				else
					System.err.println("Coult not be found!!!");

				break;

			case 4:
				return;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Inlavid Choice, please try again!!!!");
			}
		}

	}
}
