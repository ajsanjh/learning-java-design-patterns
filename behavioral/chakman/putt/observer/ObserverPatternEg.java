package chakman.putt.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternEg {

	public static void main(String[] args) {
		WeatherStation ws = new WeatherStation();
		ws.add(new PhoneApp(ws));
		ws.add(new WindowApp(ws));
		ws.setState(45);
		ws.notifyObservers();
	}
	
}


interface IObservable {
	void add(IObserver observer);  // register
	void remove(IObserver observer);
	void notifyObservers();  // will notify all added observers when change occurs
	
	
}

class WeatherStation implements IObservable{
	List<IObserver> observers = new ArrayList<>();
	private Integer temp;
	
	@Override
	public void add(IObserver observer) {
		if(observer != null) this.observers.add(observer);
	}
	@Override
	public void remove(IObserver observer) {
	}
	@Override
	public void notifyObservers() {
		for (IObserver observers : observers) {
			observers.update();
		}
	}
	// another important method in concrete class only
	public Integer getState() {
		return this.temp;
	}
	
	public void setState(Integer temp) {
		this.temp = temp;
	}
}


interface IObserver {
	void update();  // observable will call this when notifying changes
}

class PhoneApp implements IObserver, IDisplay {
	WeatherStation weatherStation = new WeatherStation();
	public PhoneApp(IObservable observable) {
		this.weatherStation = (WeatherStation) observable;
	}
	@Override
	public void update() {
		this.display();
	}
	@Override
	public void display() {
		System.out.println("Phone Says Weather is: " + this.weatherStation.getState() + " F");
	}
}

class WindowApp implements IObserver, IDisplay {
	private WeatherStation ws = new WeatherStation();
	
	public WindowApp(WeatherStation ws) {
		this.ws = ws;
	}
	
	
	@Override
	public void update() {
		this.display();
	}
	@Override
	public void display() {
		System.out.println("Window app says: "+ this.ws.getState());
	}
}


/** * not related to observer pattern, just a display contract for our apps */
interface IDisplay {
	void display();
}










