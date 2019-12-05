/**
 * 
 */
package com.company.kalah.service;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

import org.junit.Test;

import com.company.kalah.service.impl.KalahServiceImpl;

/**
 * @author somendu
 *
 */

public class MainControllerServiceTest {

	private KalahServiceImpl mainControllerServiceImpl = new KalahServiceImpl();

	@Test
	public void testRandomNumber() throws URISyntaxException {

		try {

			Method getRandomNumber = KalahServiceImpl.class.getDeclaredMethod("getRandomNumber");

			getRandomNumber.setAccessible(true);

			Object result = getRandomNumber.invoke(mainControllerServiceImpl);

			assertEquals(String.valueOf(111111).length(), String.valueOf(result).length());

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testPathString() throws URISyntaxException {

		String path = "/api/games/242737/pits/13";
		try {

			Class<String>[] classArg = new Class[1];

			classArg[0] = String.class;

			Method getReducedPath = KalahServiceImpl.class.getDeclaredMethod("getReducedPath", classArg);

			getReducedPath.setAccessible(true);

			Object result = getReducedPath.invoke(mainControllerServiceImpl, path);

			assertEquals("/api/games/242737", result);

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
