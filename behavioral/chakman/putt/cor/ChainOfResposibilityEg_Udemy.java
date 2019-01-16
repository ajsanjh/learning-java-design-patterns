package chakman.putt.cor;

/**
 * Method chain example using a sample computer game
 * @author AJ
 *
 */
public class ChainOfResposibilityEg_Udemy {
	public static void main(String[] args) {
		ChainOfResposibilityEg_Udemy crDemo = new ChainOfResposibilityEg_Udemy();
		
		Creature goblin = crDemo.new Creature("Goblin", 5, 2);
		System.out.println(goblin);

		CreatureModifier root = crDemo.new CreatureModifier(goblin);
		root.add(crDemo.new DobleAttackModifier(goblin)); // add modifier
		root.add(crDemo.new IncreaseDefenceModifier(goblin)); // Ideally these modifiers are generated with a logic 
		root.add(crDemo.new DobleAttackModifier(goblin));
		root.add(crDemo.new PowerLimitAdjusterModifier(goblin)); // this is where 
							// chain of responsibility patter shines. We can accidently 
							// make our creature too powerful. But keeping our power 
							// adjuster at the end i.e. top of the chain can put a 
							// 'responsible' logical check on our creature's power.
		root.handle();
		
		System.out.println(goblin);
	}
	
	
	class Creature {
		public String name;
		public int attack, defence;
		public Creature(String name, int attack, int defence) {
			this.name = name;
			this.attack = attack;
			this.defence = defence;
		}
		@Override
		public String toString() {
			return "Creature [name=" + name + ", attack=" + attack + ", defence=" + defence + "]";
		}
	}
	
	
	class CreatureModifier {
		protected Creature creature;
		protected CreatureModifier next;
		public CreatureModifier(Creature creature) {
			this.creature = creature;
		}
		
		public void add(CreatureModifier cm) {
			if(this.next != null) {
				this.next.add(cm);
			} else {
				this.next = cm;
			}
		}
		
		public void handle() {
			if(this.next != null) {
				this.next.handle();
			}
		}
	}
	
	class DobleAttackModifier extends CreatureModifier{
		public DobleAttackModifier(Creature creature) {
			super(creature);
		}
		@Override
		public void handle() {  // this class's responsibility impl.
			System.out.println("Doubling " + super.creature.name +"'s attack.");
			super.creature.attack *= 2;
			super.handle();
		}
	}
	
	
	class IncreaseDefenceModifier extends CreatureModifier {
		public IncreaseDefenceModifier(Creature creature) {
			super(creature);
		}
		@Override
		public void handle() {	// this class's responsibility impl.
			System.out.println("Increasing " + super.creature.name + "'s defence.");
			super.creature.defence += 1;
			super.handle();   // NOTE: that any any point, any impl can terminate the chain by not calling super.handle()
		}
	}
	
	class PowerLimitAdjusterModifier extends CreatureModifier {
		public PowerLimitAdjusterModifier(Creature creature) {
			super(creature);
		}

		@Override
		public void handle() {
			System.out.println("Chekcing and adjusting " + super.creature.name + "'s power");
			System.out.println("Before adjust: " + super.creature.toString());
			if(super.creature.attack*super.creature.defence >= 25) {  // our logical check on creatures's power.
				super.creature.attack = 8;
				super.creature.defence = 3;
			}
			super.handle();
		}
	}
	
	
	
	
	
	
	
	
	

	
	
//	// our creature's attack and defence can be chaged by other objects
//	class Creature {
//		String name;
//		int attack, defence;
//		public Creature(String name, int attack, int defence) {
//			this.name = name;
//			this.attack = attack;
//			this.defence = defence;
//		}
//		@Override
//		public String toString() {
//			return "Creature [name=" + name + ", attack=" + attack + ", defence=" + defence + "]";
//		}
//	}
//	
//	class CreatureModifier {
//		protected Creature creature;
//		protected CreatureModifier next;  // this is what links a chain
//		public CreatureModifier(Creature creature) {
//			this.creature = creature;
//		}
//		
//		public void add(CreatureModifier cm) {
//			if(this.next != null) {
//				 this.next.add(cm); // this builds a chain. adding 'cm' to the end where next is null
//			} else {
//				this.next = cm;
//			}
//		}
//		
//		public void handle() {
//			if(this.next != null) 
//				next.handle(); // this traverse the chain that we build with add()
//		}
//	}
//	
//	class DoubleAttack extends CreatureModifier {
//		public DoubleAttack(Creature creature) {
//			super(creature);
//		}
//		@Override
//		public void handle() {
//			System.out.println("Doubling " + creature.name + " attack.");
//			super.creature.attack *= 2;
//			super.handle();
//		}
//	}
//	
//	class IncreaseDefenceModifier extends CreatureModifier {
//		public IncreaseDefenceModifier(Creature creature) {
//			super(creature);
//		}
//		@Override
//		public void handle() {
//			System.out.println("Increasing " + creature.name + " defence.");
//			super.creature.defence += 1;
//			super.handle();
//		}
//	}
//	
//	class Demo {
//		void execute() {
//			Creature goblin = new Creature("Goblin", 2, 2);
//			Creature oger = new Creature("Oger", 5, 3);
//			System.out.println(goblin);
//			System.out.println(oger);
//			
//			CreatureModifier root = new CreatureModifier(goblin);
//			
//			System.out.println("Let's double goblin's attach...");
//			root.add(new DoubleAttack(goblin));
//			
//			
//			// apply modifier
//			root.handle();
//			System.out.println(goblin);
//			System.out.println(oger);
//			
//			
//		}
//	}
//	
//	
	
}
