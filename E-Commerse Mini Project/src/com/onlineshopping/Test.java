package com.onlineshopping;
import com.customerlogin.*;
import com.onlineshopping.*;

public class Test {
 	public static void main(String[] args) throws Exception {
		try {
			 	OnlineShopTest os = new OnlineShopTest();
			 	os.signOrLogin();
			 } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
