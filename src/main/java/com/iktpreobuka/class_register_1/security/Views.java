package com.iktpreobuka.class_register_1.security;

public class Views {
	
	public static class Public {}
	public static class Student extends Public {}
	public static class Parent extends Public {}
	public static class Teacher extends Public {}
	public static class Admin extends Teacher {}

}
