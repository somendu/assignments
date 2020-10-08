/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

/**
 * @author Somendu
 *
 * @since 22-Sep-2020
 */
public class RunnableLambaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				System.out.println("Running ");

			}
		};

		new Thread(runnable).start();

		Runnable runnable1 = () -> System.out.println("Running second time");

		new Thread(runnable1).start();

		new Thread(() -> System.out.println("Running Third time")).start();
	}

}
