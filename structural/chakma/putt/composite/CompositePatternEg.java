package chakma.putt.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositePatternEg {
	public static void main(String[] args) {
		Component l0Composit = new Composit("l0 composit", null);
		
		Component l1Leaf = new Leaf("l1 leaf");
		Component l1Composit = new Composit("l1 composit", null);
		Component l1Composit2 = new Composit("l1 composit2", null);
		
		((Composit) l0Composit).add(l1Leaf);
		((Composit) l0Composit).add(l1Composit);
		((Composit) l0Composit).add(l1Composit2);
		
		System.out.println(l0Composit.getData());
		
	}
}



/* ** is a tree structure : 
 * component is a starting node
	> leaf is a child that can't have more children
	> composit is a child that can can have more components
		i.e. either leaf or composit
 */

interface Component {
	String getData();
}

class Leaf implements Component {
	private String text;
	public Leaf(String text) {
		this.text = text;
	}
	@Override
	public String getData() {
		return " " + text + " > ";
	}
}

class Composit implements Component {
	private String text;
	private List<Component> children;
	public Composit(String text, List<Component> children) {
		this.text = text;
		this.children = children;
	}
	
	public void add(Component com) {
		if(this.children == null) {
			this.children = new ArrayList<>();
		}
		this.children.add(com);
	}
	
	@Override
	public String getData() {
		String temp = " " + this.text + " >> ";
		if(this.children != null) {
			for (Component child : children) {
				temp += child.getData();
			}
		} 
		return temp;
	}
}


















// EOF