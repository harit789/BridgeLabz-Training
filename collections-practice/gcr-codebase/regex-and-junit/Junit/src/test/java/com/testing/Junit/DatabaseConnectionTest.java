package com.testing.Junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {
	private DatabaseConnection db = new DatabaseConnection();
	
	@BeforeEach
	public void connectTest() {
		db.connect();
		Assertions.assertTrue(db.isConnected());
		System.out.println("Connectipon is : " + db.isConnected());
	}
	
	@Test
	public void dbConnection() {
		if(db.isConnected()) {
			System.out.println("Connection is established");
		} else {
			System.out.println("connection is not established");
		}
	}
	
	@AfterEach
	public void disconnectTest() {
		db.disconnect();
		Assertions.assertFalse(db.isConnected());
		System.out.println("Connection is : " + db.isConnected());
	}
	
	
}
