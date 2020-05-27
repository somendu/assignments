package com.product.ecommerce;

import com.product.ecommerce.registration.EurekaServer;
import com.product.ecommerce.rest.admin.AdminServer;
import com.product.ecommerce.rest.customer.CustomerServer;
import com.product.ecommerce.web.WebServer;

/**
 * 
 * The entry point class for setting services
 * 
 * @author Somendu
 * @since Apr 2, 2020
 */
public class Main {

	public static void main(String[] args) {

		System.setProperty("oracle.net.tns_admin",
				"C:\\FortyTwo42\\Work-Area\\Soft\\WINDOWS.X64_193000_db_home\\network\\admin");

		String serverName = "";

		switch (args.length) {
		case 2:
			System.setProperty("server.port", args[1]);
		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			return;
		}

		if (serverName.equals("eureka")) {
			EurekaServer.main(args);
		} else if (serverName.equals("customer")) {
			CustomerServer.main(args);
		} else if (serverName.equals("admin")) {
			AdminServer.main(args);
		} else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
		}
	}
}
