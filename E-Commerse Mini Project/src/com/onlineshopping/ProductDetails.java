package com.onlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetails {
	Connection con;
	PreparedStatement ps;

	public void getProductDeatails() {
		try {
			ConnectionTest contest = new ConnectionTest();
			con = contest.getConnectionDetails();
			ps = con.prepareStatement("Select * from product ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Product Id :-" + rs.getInt(1) + " Name>> " + rs.getString(2) + " Description>> "
						+ rs.getString(3) + " Price>> " + rs.getString(4));
			}
			con.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
