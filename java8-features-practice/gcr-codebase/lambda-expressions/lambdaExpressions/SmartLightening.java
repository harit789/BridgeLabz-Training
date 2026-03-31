package lambdaExpressions;

@FunctionalInterface
interface Motion{
	void activate();
}

@FunctionalInterface
interface Voice {
	void activate();
}

@FunctionalInterface
interface TimeOfDay{
	void activate();
}

public class SmartLightening {
	public static void main(String[] args) {
		 Motion motion = () -> System.out.println("Motion detected : Lights are ON");
		 Voice voice = () -> System.out.println("Voice Heared : Lights turned to Ward effect");
		 TimeOfDay time = () -> System.out.println("Night time : Lights turned dimmed");
		 
		 motion.activate();
		 voice.activate();
		 time.activate();
	}
}
