package com.email.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.email.model.Employee;
import com.email.service.*;

public class EmailSeviceClient {
	
	private static CredentialService creds = new CredentialService();
	private static EmployeeService emp = new EmployeeService(creds);
	
	

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Please enter your first name ");
		String firstName = sc.next();
		
		System.out.println("Please enter your last name ");
		String lastName = sc.next();
		
		/**
		 * dd/MM/yy - 13/03/97 dd/MMM/yyyy - 13/OCT/1997
		 */
		
		System.out.println("Please enter your date of birth in dd/MM/yyyy format ");
		String strDOB = sc.next();
		LocalDate dob = null;
		Employee newHire = null;
		try {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dob = LocalDate.parse(strDOB, pattern);
		} catch (Exception exception) {
		
			System.out.println("Invalid date format passed, Example: 13/10/1997");	
		}
		if (dob != null) {
			newHire = new Employee(firstName, lastName, dob);
		}else {
            newHire = new Employee(firstName, lastName, dob);
		}
		
		
		
		System.out.println("Enter your department: ");
		String dept = sc.next();
		newHire.setDept(dept);
		emp.generateEmailAddress(firstName, lastName, dept, newHire);	
		
		System.out.println("Please enter your Option from the following: ");
		System.out.println("1) Generate Password ");
		System.out.println("2) Show Details ");
	
		int option = sc.nextInt();
		
		switch (option) {
		
		case 1:
			emp.saveCreds(8, newHire);
			emp.printEmployeeDetails(newHire);
			break;
		case 2:
			System.out.println("Password not generated!!");
			emp.printEmployeeDetails(newHire);
			break;				
			}
		sc.close();
		
		
	}
}