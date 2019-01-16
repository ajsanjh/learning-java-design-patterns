package chakma.putt.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FullDemo {
	public static void main(String[] args) {
		new FullDemoClient().execute();
	}
}

/* ** our driver client ** */
class FullDemoClient {
	public void execute() {
		DemoList<Entity> col = new DemoList<>();
		col.add(new Entity("data1"));
		col.add(new Entity("data2"));
		col.add(new Entity("data3"));
		
		System.out.println("iterating using iterator ......");
		Iterator<Entity> itr = col.iterator();				// <<<<<<<< demo 1
		while(itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
		
		System.out.println("iterating using iterable ......");
		for (Entity e : col) {								// <<<<<<<< demo 2
			System.out.print(e.toString() + ", ");
		}
	}
}

/* ** our entity ** */
class Entity {
	private String value;
	public Entity(String value) { this.value = value; }
	public String value() { return this.value; }
	@Override
	public String toString() {
		return "Entity [value=" + value + "]";
	}
}

/* ** collection interface ** */
interface DemoCollection<T> extends Iterable<T> { // iterable is reason we can use this collection in for loops
}

/* ** list impl ** */
class DemoList<T> implements DemoCollection<T> {
	private List<T> list;
	public DemoList() {
		this.list = new ArrayList<>();
	}
	public boolean add(T t) { return this.list.add(t); }

	@Override
	public Iterator<T> iterator() {
		return new DemoCollectionIterator<T>(this.list);
	}
}

/* ** custom iterator ** */
class DemoCollectionIterator<T> implements Iterator<T> {
	private List<T> list;
	private int size;
	private int currenIndex;
	public DemoCollectionIterator(List<T> list) {
		this.list = list;
		this.size = this.list.size();
		this.currenIndex = 0;
	}

	@Override
	public boolean hasNext() {
		return currenIndex >= size? false : true;
	}

	@Override
	public T next() {
		return this.list.get(currenIndex++);
	}
}
