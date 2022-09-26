package com.email.service;

import com.email.model.Employee;

public class EmployeeService {
	
	private final CredentialService creds;
	
	public EmployeeService( CredentialService creds) {
		this.creds = creds;
	}

	public void generateEmailAddress(String firstName, String lastName, String dept, Employee employee) {
		String emailAddress = this.creds.generateEmailAddress(employee.getFirstName(), employee.getLastName(), employee.getDept());
		employee.setEmailAddress(emailAddress);
		
	}
	
	public Employee saveCreds(int length, Employee emp) {
		String password = this.creds.generatePassword(length);
		emp.setPassword(password);
		return emp;
	}
	
	public void printEmployeeDetails (Employee emp) {
		CredentialService.showCredentials(emp);
	}
	
	
}