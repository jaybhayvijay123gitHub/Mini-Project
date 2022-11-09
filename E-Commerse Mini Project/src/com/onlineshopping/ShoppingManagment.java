package com.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class ShoppingManagment {
	Connection con;
	PreparedStatement ps;
	String userName;
	String userPassword;

	public void insertCustomerLoginData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name");
		String userName = sc.nextLine();
		System.out.println("Create Password");
		String userPassword = sc.nextLine();
		try {
			ConnectionTest contest = new ConnectionTest();
			con = contest.getConnectionDetails();
			ps = con.prepareStatement("insert into customer(customername,customerpassword)" + "values(?,?)");
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			int i = ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("Record is inserted succesfully in mysqldatabase.....");
			System.out.println("You Have Succefully Created An Account ");
			System.out.println("Now you can enjoy our exclusive services ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ShoppingManagment sm = new ShoppingManagment();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name:");
		String userName = sc.nextLine();
		System.out.println("Create Password:");
		String userPassword = sc.nextLine();
		System.out.println("You Have Succesfully Created An Account.");
		System.out.println("Thank You For Visiting Us !");

		sm.insertCustomerLoginData();

	}
}
