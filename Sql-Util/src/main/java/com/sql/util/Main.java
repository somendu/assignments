package com.sql.util;

import com.sql.util.registration.EurekaServer;
import com.sql.util.rest.sql.UtilServer;
import com.sql.util.web.WebServer;

/**
 * 
 * The entry point class for setting services
 * 
 * @author Somendu
 * @since Apr 2, 2020
 */
public class Main {

	public static void main(String[] args) {

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
		} else if (serverName.equals("sql")) {
			UtilServer.main(args);
		} else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
		}
	}
}
