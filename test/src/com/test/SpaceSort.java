package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 以空间换时间，牺牲更多的空间换取更快的时间
 */
public class SpaceSort {
	public static int arrayLen = 10000000;

	public static void main(String[] args) {
		int[] a = new int[arrayLen];
		int[] old = new int[arrayLen];
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		int count = 0;
		while (count < arrayLen) {
			int value = (int) (Math.random() * arrayLen * 10) + 1;
			if (map.get(value) == null) {
				map.put(value, value);
				a[count] = value;
				count++;
			}
		}
		System.arraycopy(a, 0, old, 0, a.length);
		long start = System.currentTimeMillis();
		Arrays.sort(a); //默认的效率低
		System.out.println("Arrays sort spend:"
				+ (System.currentTimeMillis() - start) + "ms");
		System.arraycopy(old, 0, a, 0, a.length);
		start = System.currentTimeMillis();
		spaceToTime(a);
		System.out.println("Arrays sort spend:"
				+ (System.currentTimeMillis() - start) + "ms");
	}

	public static void spaceToTime(int[] array) {
		int i = 0;
		int max = array[0];
		int l = array.length;
		for (i = 1; i < l; i++) {
			if (array[i] > max) {
				max = array[i]; // 找出最大的值
			}

		}
		int[] temp = new int[max + 1]; //分配临时空间
		for (i = 0; i < l; i++) {
			temp[array[i]] = array[i]; //以索引下标来标识数字大小 ,此时已排好序
		}
		int j = 0;
		int max1 = max + 1;
		for (i = 0; i < max1; i++) {
			if (temp[i] > 0) {
				array[j++] = temp[i];  //将排序后的数值顺序放回原数组
			}
		}

		/*for (i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}*/
		/**
		 * 以时间换空间 两数交换 a=a+b;b=a-b;a=a-b;
		 */
	}
}
