package lamda_expression;

interface LightAction{
	void execute();
}

//class Motion{
//	void execute() {
//		System.out.println("light on ");
//	}
//}

public class SmartHome {
	public static void main(String[] args) {
		LightAction motion = ()->System.out.println("Light on (Motion detected)");
//		Motion motion = new Motion();
//		motion.execute();
		LightAction voice = () -> System.out.println("Light on (voice command)");
		motion.execute();
	}

}
