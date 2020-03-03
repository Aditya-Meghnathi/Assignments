package com.aimdek.spring.MVC.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String address;
    public Employee() {
    }
 
    public Employee(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}