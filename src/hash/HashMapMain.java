package hash;

import java.util.HashMap;
import java.util.Map;

import classloader.MyClassLoader;

public class HashMapMain {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = new MyClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		System.out.println(cl.getParent());
		System.out.println(cl.loadClass("HashMapMain").getClassLoader());
		System.out.println(new HashMapMain().getClass().getClassLoader());
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		map.put(null, null);
		System.out.println(map);
	}

}
