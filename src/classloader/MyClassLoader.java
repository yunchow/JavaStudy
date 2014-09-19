package classloader;

import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {

	public MyClassLoader() {
		super(MyClassLoader.class.getClassLoader());
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("×¼±¸¼ÓÔØ " + name);
		String name1 = name.replaceAll("\\.", "/");
		String path = "G:/workspace/ZZZ/bin/" + name1 + ".class";
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			byte[] b = new byte[fis.available()];
			fis.read(b, 0, b.length);
			fis.close();
			if (b.length > 0)
				return defineClass(name, b, 0, b.length);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return null;
	}

	protected Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		Class<?> cl = findClass(name);
		if ( cl != null) {
			return cl;
		}
		return super.loadClass(name, resolve);
	}

	@Override
	public String toString() {
		return "####### MyClassLoader ###";
	}
}
