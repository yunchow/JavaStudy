package classloader.subpack;

import classloader.B;


class A {

	void a() {
		System.out.println("method a invoked");
		B b = new B();
		b.b();
		System.out.println("B's class loaer is " + b.getClass().getClassLoader());
		new VV();
	}
	
	protected class CCC {
		
	}
	
	private class VV {
		
	}
	
}

