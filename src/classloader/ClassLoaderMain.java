package classloader;

import java.lang.reflect.Method;


public class ClassLoaderMain {

	public static void main(String[] args) throws Exception, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		MyClassLoader cl = new MyClassLoader();
		Class<?> clz = cl.loadClass("classloader.subpack.A");
		Method m = clz.getDeclaredMethod("a");
		m.setAccessible(true);
		m.invoke(clz.newInstance());
		
		/*System.out.println(" XX  " + A.class.getClassLoader());
		System.out.println(clz.getClassLoader());
		System.out.println(A.class == clz);
		
		System.out.println(Arrays.toString(((URLClassLoader)A.class.getClassLoader().getParent()).getURLs()));
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());*/
		
		//System.out.println(String.class.getClassLoader());
		
		System.out.println("String's class loader is " + String.class.getClassLoader());
		System.out.println("byte[]'s class loader is " + byte[].class.getClassLoader());
	}

}
