package com.tyss.phonesimulator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tyss.phonesimulator.controller.DBConnection;
import com.tyss.phonesimulator.dto.Contact;

public class ContactDaoImpl implements ContactDao {
	static PreparedStatement pstmt = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	Contact contact = null;
	static Connection connection = DBConnection.getConnection();
	List<Contact> contactList = null;

	@Override
	public boolean addContact(Contact contact) {
		try {
			String addContactQuery = "insert into contact(contactName, contactNumber, contactGroup) VALUES(?, ?, ?)";
			pstmt = connection.prepareStatement(addContactQuery);
			pstmt.setString(1, contact.getContactName());
			pstmt.setString(2, contact.getContactNumber());
			pstmt.setString(3, contact.getContactGroup());
			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
		} catch (SQLException e) {
			System.out.println("Contact could not be added!!!!!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteContact(String contactName) {
		try {
			pstmt = connection.prepareStatement("delete from contact WHERE contactName=?");
			pstmt.setString(1, contactName);
			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modifyContact(String contactName, String contactGroup) {
		try {
			pstmt = connection.prepareStatement("UPDATE contact SET contactGroup =? WHERE contactName=?");
			pstmt.setString(1, contactGroup);
			pstmt.setString(2, contactName);
			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Contact> getAllContact() {
		try {
			contactList=new ArrayList<Contact>();
			stmt = connection.createStatement();
			String getAllQuery = "Select * from contact";
			rs = stmt.executeQuery(getAllQuery);
			while (rs.next()) {
				contact = new Contact();
				contact.setContactId(rs.getInt(1));
				contact.setContactName(rs.getString(2));
				contact.setContactNumber(rs.getString(3));
				contact.setContactGroup(rs.getString(4));
				contactList.add(contact);
			}
			return contactList;
		} catch (Exception e) {
			System.out.println("Contact List could not be fetched!!!!!");
			e.printStackTrace();
		}

		return null;
	}
}
