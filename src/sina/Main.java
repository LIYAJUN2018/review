package sina;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public String getMinVersion(String[] list) {

		ArrayList<String[]> arrayList = new ArrayList<String[]>();

		for (String strings : list) {
			String[] split = strings.split("\\.");
			arrayList.add(split);
		}

		int min = 0;
		for (int i = 1; i < arrayList.size(); i++) {
			int com1 = Integer.valueOf(arrayList.get(min)[0]);
			int com2 = Integer.valueOf(arrayList.get(i)[0]);
			int count = 0;
			while (com1 <= com2 && (count + 1) < arrayList.get(min).length && (count + 1) < arrayList.get(i).length) {
				com1 = Integer.valueOf(arrayList.get(min)[count + 1]);
				com2 = Integer.valueOf(arrayList.get(i)[count + 1]);
				count++;
			}
			if (com1 > com2) {
				min = i;
			}

		}
		StringBuffer stringBuffer = new StringBuffer();
		for (String strings : arrayList.get(min)) {
			stringBuffer.append(strings + ".");
		}
		String substring = stringBuffer.substring(0, stringBuffer.length() - 1);

		return substring;
	}

	

	public static void main(String[] args) {
		String[] list = { "3", "4.3.5.4", "2.10.3", "2.4" };
		int[] a = { 1, 9, 5, 6, 7 };
		Main main = new Main();
		String minVersion = main.getMinVersion(list);
		System.out.println(minVersion);
		
	}

}
