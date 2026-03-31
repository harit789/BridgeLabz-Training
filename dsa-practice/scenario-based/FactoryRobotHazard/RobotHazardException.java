package FactoryRobotHazard;

class RobotSafetyException extends Exception {
	String message;

	public RobotSafetyException(String message) {
		super(message);
	}
}

