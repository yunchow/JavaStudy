package gc;

import java.util.Vector;

public class HeapMain {

	public static void main(String[] args) {
		Vector<byte[]> v = new Vector<byte[]>();
		for (int i = 1; i <= 4; i++) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			System.out.println(i + "M allocated");
		}
	}

}
