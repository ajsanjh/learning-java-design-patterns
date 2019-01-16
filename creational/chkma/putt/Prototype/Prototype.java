package chkma.putt.Prototype;

public class Prototype {
	public static void main(String[] args) {
		Prototype p = new Prototype();
		Demo d1 = p.new Demo();
		d1.init();
		System.out.println(d1.getData());
		
		
		Demo d2 = d1.clone();
		d1.setData("d1 updated data");
		
		System.out.println(d2);
	}
	
	private class Demo implements Cloneable {
		private void init() {
			this.setData("init data");
		}
		
		private String data;
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "Demo [data=" + data + "]";
		}
		@Override
		protected Demo clone() {
			Demo d = new Demo();
			d.setData(new String(this.getData()));
			return d;
		}
	}
	
}
