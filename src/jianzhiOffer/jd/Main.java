package jianzhiOffer.jd;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int max = scanner.nextInt();
		int[] arr = new int[max];
		int[] sort = new int[max];
		for (int i = 0; i < max; i++) {
			arr[i] = scanner.nextInt();
			sort[i] = i;
		}

		int count = 0;

		boolean flag = false;
		for (int i = 0; i < max - 1; ++i) {
            int temp = arr[i];
            if(temp > arr[i + 1]) {
            	if(flag) {
            		count++;
            	}else {
            		
            		flag = false;
            	}
            }else {
            	flag = false;
            }
        }

		
		System.out.println(count);

	}

	
}
