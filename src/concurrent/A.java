package concurrent;


public class A {
	private String field;
	
	public void setv(String v) {
		this.field = v;
	}

	public void a() {
		System.out.println("value is " + field);
	}
	
}
