
package com.comblinks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Loops {

	public static void main(String[] args) {

		// Simple For loop
		int[] numbers = { 1, 2, 3, 4, 5 };
		for (int num : numbers) {
			System.out.println(num);
		}

		// Loop an Array and filter
		String[] array = { "one", "two", "three" };
		Arrays.stream(array).filter(a -> a.contains("o"))
				.forEach(element -> System.out.println(triggerMethod(element)));

		// Collect array of method returns
		List<String> originalList = Arrays.asList("one", "two", "baz");
		List<String> modifiedList = originalList.stream().map(element -> triggerMethod(element))
				.collect(Collectors.toList());
		System.out.println(modifiedList.toString());

	}

	private static String triggerMethod(String temp) {
		return temp;

	}

}
