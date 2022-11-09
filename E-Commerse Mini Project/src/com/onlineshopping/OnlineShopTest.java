package com.onlineshopping;

import com.customerlogin.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.customerlogin.BookProduct;
import com.customerlogin.ProductInformation;

public class OnlineShopTest {
	ProductDetails pd = new ProductDetails();
	ProductInformation pdinfo = new ProductInformation();

	public static void signOrLogin() {
		System.out.println("......................-: Welcome To E-Commerse Services :-....................");
		System.out.println();
		OnlineShopTest ons = new OnlineShopTest();
		ShoppingManagment shopmanag = new ShoppingManagment();
		Scanner sc = new Scanner(System.in);
		System.out.println("Create Account : Type 1");
		System.out.println("Login In       : Type 2");
		int x = sc.nextInt();
		if (x == 1) {
			shopmanag.insertCustomerLoginData();
			Scanner sc1 = new Scanner(System.in);
			System.out.println("..........................................................."); // for space purpose on
			System.out.println("Enter Your Details For LogIn>>");
			System.out.println("Enter Your Name:>");
			String name = sc1.nextLine();
			System.out.println("Enter Password:>");
			String password = sc1.nextLine();
			ons.customerLogin(name, password);
		} else if (x == 2) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter Your Details For LogIn>>");
			System.out.println("Enter Your Name:>");
			String name = sc1.nextLine();
			System.out.println("Enter Password:>");
			String password = sc1.nextLine();
			ons.customerLogin(name, password);
		}
	}

	public void customerSign() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Details For SignIn>>");
		System.out.println("Enter Your Name:>");
		String name = sc.nextLine();
		System.out.println("Enter Password:>");
		String password = sc.nextLine();
	}

	public void customerLogin(String name, String password) {
		try {
			ConnectionTest ctest = new ConnectionTest();
			Connection con;
			con = ctest.getConnectionDetails();
			PreparedStatement ps = con.prepareStatement("Select * from customer ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String existname = rs.getString(2);
				String existpassword = rs.getString(3);
				while (name.equals(existname) && password.equals(existpassword)) {
					System.out.println();
					System.out.println("Login Succesfull !");
					System.out.println("    Welcome " + name);
					System.out.println("Now you can enjoy our exclusive services ");
					System.out.println();
					pd.getProductDeatails();
					pdinfo.selectProduct();
					BookProduct bp = new BookProduct();
					bp.bookProduct();
					BookProduct.buykProduct();
					break;
				}
			}
			con.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 	public static void main(String[] args) {
		 signOrLogin();  
	}
}
