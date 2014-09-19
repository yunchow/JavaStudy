package gc;

import java.io.IOException;

public class ConstantsPoolGCMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String s = String.valueOf(i).intern();
		}
		System.gc();
		System.in.read();
	}

}
