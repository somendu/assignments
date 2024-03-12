/**
 * 
 */
package com.practice.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 27-Jul-2023
 */
public class CompanyGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Address address = new Address("High Street", 1000);
		Company company = new Company(address);

		// Address address2 =

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Company company1 = context.getBean("company", Company.class);
		company1.getAddress();
		// assertEquals("High Street", company.getAddress().getStreet());
		// assertEquals(1000, company.getAddress().getNumber());

	}

}
