package gc;

import java.io.IOException;

public class GCMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		byte[] b1 = new byte[1024 * 1024 / 2];
		byte[] b2 = new byte[1024 * 1024 * 8];
//		byte[] b3 = new byte[1024 * 1024 * 8];
//		byte[] b4 = new byte[1024 * 1024 * 8];
		b2 = null;
		b2 = new byte[1024 * 1024 * 8];
		System.gc();
		System.in.read();
		while(true);
	}

}
