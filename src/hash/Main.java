package hash;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("key1".getBytes());
		byte[] bytes = md.digest();
		System.out.println(Integer.toBinaryString(bytes[0]));
		System.out.println(bytes[0]);
		System.out.println((byte)(bytes[0] & 0xFF));
		System.out.println(Integer.toBinaryString(-(int)(bytes[0] & 0xFF)));
		/*System.out.println(new BASE64Encoder().encode("hel".getBytes()));
		System.out.println(new String(new BASE64Decoder().decodeBuffer("aGVs")));*/
	}

}
