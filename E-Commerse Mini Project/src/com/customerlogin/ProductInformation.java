package com.customerlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.onlineshopping.*;

public class ProductInformation {
	public void selectProduct() {
		Connection con;
		PreparedStatement ps;
		int p;
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("Enter the product id to get more details > ");
		p = sc.nextInt();

		if (p <= 10) {
			try {
				ConnectionTest contest = new ConnectionTest();
				con = contest.getConnectionDetails();
				ps = con.prepareStatement("Select * from product where productid=? ");
				ps.setInt(1, p);
				System.out.println("Info get succesfully");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println("Product Id :-" + rs.getInt(1) + ", Name>> " + rs.getString(2)
							+ ", Description>> " + rs.getString(3) + ", Price>> " + rs.getString(4));
				}
				con.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Sorry For Inconvenience This product id is not available in our ProductList.");
		}
	}

}
