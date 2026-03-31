package com.testing.Junit;

public class DatabaseConnection {
	private boolean connection;
	
	public void connect() {
		 connection = true;
	}
	
	public void disconnect() {
		connection = false;
	}
	
	public boolean isConnected() {
		return connection;
	}
}
