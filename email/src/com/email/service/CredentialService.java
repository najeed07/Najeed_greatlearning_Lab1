package com.email.service;

import java.util.Random;

import com.email.model.Employee;

public class CredentialService {
	
	private static final String DOMAIN_NAME = "abc.com";
	private static final String DELIMITER = "";
	private static final String UPPER_CASE ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER_CASE ="abcdefghijklmnopqrstuvwxyz";
	private static final String NUMERICS ="1234567890";
	private static final String SPECIAL_CHARS ="!@#$%^&*()_-~";
	
	
	public String generatePassword(int length) {
		
		String value = UPPER_CASE+LOWER_CASE+NUMERICS+SPECIAL_CHARS;
		Random random = new Random();
		
		char[] password = new char[length];
		
		for(int i=0; i<length; i++) {
			password[i] = value.charAt(random.nextInt(value.length()));
		}
		System.out.println("Password generation is successfull!!\n "+String.valueOf(password));
		return String.valueOf(password);
	}
	
	//firtsname.lastname@dept.comp.com
	/**
	 * format:
	 * -firstname
	 * -lastname
	 * -department
	 * -company/domain- Fixed
	 * @return 
	 * 
	 */
	public String generateEmailAddress(String firstName, String lastName, String department) {
		String emailAddress = firstName+DELIMITER+lastName+"@"+department+DOMAIN_NAME;
		return emailAddress;
	}
	public static void showCredentials(Employee employee) {
		System.out.println("====Displaying the details of the employee - start ====");
		System.out.println("First Name :: "+employee.getFirstName());
		System.out.println("Last Name :: "+employee.getLastName());
		System.out.println("Email Address :: "+employee.getEmailAddress());
		System.out.println("Password :: "+employee.getPassword());
		if(employee.getDateOfBirth()!= null) {
			System.out.println("Date of Birth :: "+employee.getDateOfBirth());
		}
		System.out.println("==== Displaying the details of the employee - end ====");
		
		
	}
}