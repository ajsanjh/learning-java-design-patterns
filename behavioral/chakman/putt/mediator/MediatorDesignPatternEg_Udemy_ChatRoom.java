package chakman.putt.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorDesignPatternEg_Udemy_ChatRoom {
	public static void main(String[] args) {
		ChatRoom room = new ChatRoom();
		
		Person john= new Person("John");
		Person jane = new Person("Rachel");
		
		room.join(john);
		room.join(jane);
		
		john.say("hi room");
		jane.say("hello everyone");
		
		Person simon = new Person("Simon");
		
		room.join(simon);
		
		simon.say("hi everyone!");
		
		jane.privateMessage("Simon", "glad you could join !");
		
	}
}

// our objects
class Person {
	public String name;
	public ChatRoom room;
	private List<String> chatLog = new ArrayList<>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public void receive(String sender, String message) {
		String s = sender + ": '" + message + "'";
		System.out.println("["+ this.name + "'s chat Session] "+ s);
		chatLog.add(s);
	}
	
	public void say(String message ) {
		room.broadcast(name, message);
	}
	
	public void privateMessage(String who, String message) {
		room.message(name, who, message);
	}
	
}

// our mediator
class ChatRoom {
	private List<Person> people = new ArrayList<>();  // note how the objects are not shared by marking private, since each person has a reference to ChatRoom object.
	
	// people can join here
	public void join(Person p) {
		String joinMsg = p.name + " joined the room.";
		this.broadcast("room", joinMsg); // message is broadcasted when someone joins
		
		p.room = this;  // each Person maintain when room they joined so setting that up.
		this.people.add(p);	// at to list
	}
	
	
	// broadcast a message to all but the source person
	public void broadcast(String source, String message ) {
		for(Person person: people) {
			if(!person.name.equals(source)) {
				person.receive(source, message);
			}
		}
	}
	
	// chat room handling private messaging 
	public void message(String source, String destinamtion, String message) {
		people.stream()
				.filter(p -> p.name.equals(destinamtion))
				.findFirst()
				.ifPresent(p -> p.receive("[private] "+source, message));
	}
	
}
