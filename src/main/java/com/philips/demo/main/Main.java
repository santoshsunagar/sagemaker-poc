/*
  * (C) Koninklijke Philips Electronics N.V. 2020
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner.
  *
  * File name: Main.java
*/

package com.philips.demo.main;

public class Main {

	public Main() {
		try {
			testHai();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testHai() throws Exception {
		System.out.println("Hai");
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
