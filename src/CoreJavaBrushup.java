import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup {

	public static void main(String[] args) {

		// int, float, double, bool
		int intNum = 5;
		String someString = "Some String";
		float floatVar = 2.34f;
		char characther = 'c';
		boolean isTrue = false;

		// Arrays - []

		int[] array1 = new int[5];
		array1[0] = 1;
		array1[1] = 2;
		array1[2] = 3;
		array1[3] = 4;
		array1[4] = 5;
		int[] array2 = { 12, 9, 8, 6, 7 };
		int[] array3 = { 1, 2, 4, 5, 6, 7, 8, 9, 10, 122 };

		// Loops

		for (int i = 0; i < array1.length; i++) {
			System.out.println("array1[" + i + "]: " + array1[i]);
		}

		for (int i : array2) {
			System.out.println("array2[]: " + i);
		}

		for (int i : array3) {
			if ((i % 2) == 0) {
				System.out.println(i + "\t");
			} else {
				System.out.println(i + " is not multiple of two");
			}
		}

		// ArrayList
		ArrayList<String> list = new ArrayList<>();
		list.add("Cristian");
		list.add("Dolinta");
		list.add("loves");
		list.add("Daniela");
		list.add("Dolinta");

		System.out.println(list.get(3));

		for (String string : list) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.println(list.contains("Daniela" ));
		
		String[] stringArr = {"Selenium", "Learning", "Fast"};
		List<String> stringArrayListConverted =  Arrays.asList(stringArr);
		boolean isPresent = stringArrayListConverted.contains("Selenium");
		System.out.println(isPresent);
		
		//String operations
		
		String s = "Some String to be splitted";
		String[] splittedArray = s.split(" ");
		
		for (String string : splittedArray) {
			System.out.print(string + " ");
		}
	}

}
