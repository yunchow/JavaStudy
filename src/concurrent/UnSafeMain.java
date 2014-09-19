package concurrent;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import classloader.MyClassLoader;
import sun.misc.Unsafe;

public class UnSafeMain {
	static Unsafe unsafe;
	
	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(Unsafe.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		InputStream is = UnSafeMain.class.getResourceAsStream("/classloader/subpack/FriendlyA.class");
		byte[] buffer = new byte[is.available()];
		is.read(buffer, 0, buffer.length);
		Class<?> cl = unsafe.defineClass("classloader.subpack.FriendlyA", buffer, 0, buffer.length, new MyClassLoader(), null);
		System.out.println(cl.getClassLoader());
		Method m = cl.getDeclaredMethod("a");
		m.setAccessible(true);
		m.invoke(unsafe.allocateInstance(cl));
	}
	
	static void b () {
		unsafe.throwException(new Throwable("Test Exception"));
	}
	
}
