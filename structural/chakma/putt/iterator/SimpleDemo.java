package chakma.putt.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator pattern is the reason we are able to use
 * loops like for and while on arrays, collections and other
 * custom data structures like linked list or binary search tree. 
 * 
 * iterator pattern is already implemented in java collection DS
 * 
 * demo: here is an example to include iterator pattern in a custom DS
 * 
 * @author AJ
 *
 */
public class SimpleDemo {
	public static void main(String[] args) {
		MyList<String> s = new MyList();
		s.add("ajay");
		s.add("renee");
		
		for (String str : s) {
			System.out.println(str);
		}
	}
}



class MyList<T> implements Iterable<T>{
	private List<T> list;
	
	public MyList() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(T t) {
		return this.list.add(t);
	}
	
	public T get(int index) {
		return this.list.get(index);
	}
	
	public boolean remove(T t) {
		return this.list.remove((Object) t);
	}

	@Override
	public Iterator<T> iterator() {
		// custom code
		System.out.println("iterator called !!");
		// will return a custom iterator object
		// that iterator will implement hasnext and next etc.
		return null;
	}
}
