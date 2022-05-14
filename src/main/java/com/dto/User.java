package com.dto;

import java.util.Date;

public class User {
private String name;
private String age;
private Date dob;
private String lang;
private String gender;
private String username;
private String password;
private String email;
private String contact;
private String address;
private String type;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getLang() {
	return lang;
}
public void setLang(String lang) {
	this.lang = lang;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public User() {
	super();
}
public User(String name, String age, Date dob, String lang, String gender, String username, String password,
		String email, String contact, String address, String type) {
	super();
	this.name = name;
	this.age = age;
	this.dob = dob;
	this.lang = lang;
	this.gender = gender;
	this.username = username;
	this.password = password;
	this.email = email;
	this.contact = contact;
	this.address = address;
	this.type = type;
}
@Override
public String toString() {
	return "User [name=" + name + ", age=" + age + ", dob=" + dob + ", lang=" + lang + ", gender=" + gender
			+ ", username=" + username + ", password=" + password + ", email=" + email + ", contact=" + contact
			+ ", address=" + address + ", type=" + type + "]";
}


}
