/**
 * 
 */
package com.assignments.self.j8.diamond;

/**
 * @author Somendu
 *
 * @since 06-Aug-2020
 */
public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub

	}

	@Override
	public void log(String str) {
		System.out.println("MyClass logging::" + str);
		Interface1.print("abc");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("My Runnable");
			}
		};

		Runnable r2 = () -> {
			System.out.println("R2 Runnable");
		};

//		r.run();
//		r2.run();

		Interface1 i1 = (str) -> System.out.println(str);

		i1.log("abc");

		Interface1.print("Test");
	}

}
