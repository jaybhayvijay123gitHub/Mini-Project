package com.customerlogin;

import com.onlineshopping.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.onlineshopping.ConnectionTest;

public class BookProduct {

	public void bookProduct() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println(".................................\n");
		System.out.println("Plz enter your name To Book the product.... >");
		String cname = sc.next();
		System.out.println("Enter the product id which you want to Book...");
		int p = sc.nextInt();

		Connection con;
		PreparedStatement ps;
		try {

			ConnectionTest contest = new ConnectionTest();
			con = contest.getConnectionDetails();
			ps = con.prepareStatement("Select * from product where productid =? ");
			ps.setInt(1, p);
			ResultSet rs = ps.executeQuery();// when we want result/selection/retrive then we use
												// executeQuery()
			if (rs.next()) {
			} else {
				System.out.println("Theree is no element present");
			}

			String pname = rs.getString(2);

			int pprice = rs.getInt(4);

			ps = con.prepareStatement(
					"insert into cart (pid,cname,cproductname,cproductprice ) " + "values (?,?,?,?) ");

			ps.setInt(1, p);
			ps.setString(2, cname);
			ps.setString(3, pname);

			ps.setInt(4, pprice);

			int i = ps.executeUpdate();

			System.out.println("Product successfuly added to cart !");
			con.close();
			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void buykProduct() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Plz enter your name  To Buy the product.... >");
		String cname = sc.next();
		System.out.println("Plz enter product id to buy.... >");
		int p = sc.nextInt();
		int count = 0;
		int temp = 0;
		Connection con;
		PreparedStatement ps;
		try {

			ConnectionTest contest = new ConnectionTest();
			con = contest.getConnectionDetails();
			ps = con.prepareStatement("Select * from cart where cname =? ");
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String pname = rs.getString(4);
				System.out.println("product name > " + pname);
				count++;
				int pprice = rs.getInt(5);
				System.out.println("product price > " + pprice);
				temp = temp + pprice;
			}
			System.out.println();
			System.out.println("Total products Bought By " + cname + " are " + count);
			System.out.println("Total Price You have to pay is " + temp);
			System.out.println("Thanks For Buying this product !");
			con.close();
			rs.close();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
