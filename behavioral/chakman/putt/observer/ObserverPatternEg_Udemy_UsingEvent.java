package chakman.putt.observer;

import java.util.Arrays;
import java.util.List;

public class ObserverPatternEg_Udemy_UsingEvent {
	public static void main(String[] args) {
		new Demo_().execute();
	}
}



class Demo_ {
	public void execute() {
		
		List<String> list = Arrays.asList("stephen", "kd", "dremond", "klay");
		
		list.forEach(System.out::println);
		
	}
}