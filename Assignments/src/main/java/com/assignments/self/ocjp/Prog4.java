package com.assignments.self.ocjp;

import java.io.IOException;

public class Prog4 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		new Prog4().doIt();
		new Prog4().didIt();
	}

	static void doIt() throws java.io.IOException {
		throw new java.io.IOException();
	}

	static void didIt() throws ClassNotFoundException {
		throw new SecurityException();
	}
}
