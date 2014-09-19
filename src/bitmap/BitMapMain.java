package bitmap;

import java.util.BitSet;

public class BitMapMain {

	static int[] list = {2, 3, 6, 3, 2, 5, 3, 2, 6, 6, 9, 9, 7, 7};
	
	public static void main(String[] args) {
		int len = list.length * 2;
		BitSet bs = new BitSet(len);
		System.out.println(len);
		System.out.println(bs.size());
		System.out.println(bs.length());
		for (int i = 0; i < list.length; i++) {
			int n = 2 * list[i];
			boolean b1 = bs.get(n);
			boolean b2 = bs.get(n + 1);
			if (!b1 && !b2) { // 00
				bs.set(n, true);
				bs.set(n + 1, false);
			}
			else if (b1 && !b2) { // 01
				bs.set(n + 1, true);
				bs.set(n, false);
			}
			else if (!b1 && b2) { // 10
				bs.set(n, n + 1, true);
			}
		}
		System.out.println(bs.size());
		System.out.println(bs.length());
		for (int i = 0; i < bs.length(); i += 2) {
			boolean b1 = bs.get(i);
			boolean b2 = bs.get(i + 1);
			if (!b1 && !b2) { // 00
				// 0次
			}
			else if (b1 && !b2) { // 01
				System.out.println(i / 2 + "一次");
			}
			else if (!b1 && b2) { // 10
				System.out.println(i / 2 + "两次");
			}
			else if (b1 && b2) { // 10
				System.out.println(i / 2 + "三次");
			}
		}
	}

}
