package module_14_streams_and_pagination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamsRecap {

//	@Test
	public void regular() {

		ArrayList<String> names = new ArrayList<>();
		names.add("Cristian");
		names.add("Daniela");
		names.add("Madalina");
		names.add("Liudmila");
		names.add("Vitalie");
		names.add("Vasile");
		int wordCount = 0;

		for (String name : names) {
			if (name.startsWith("C")) {
				wordCount++;
			}
		}
		System.out.println(wordCount);
	}

//	@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<>();
		names.add("Cristian");
		names.add("Daniela");
		names.add("Madalina");
		names.add("Liudmila");
		names.add("Vitalie");
		names.add("Vasile");
		names.add("Eva");
		names.add("Ami");
		names.add("Lacy");
		names.add("Tuzea");

		Long count = names.stream().filter(s -> s.startsWith("V")).count();
		System.out.println(count);
		names.stream().filter(s -> (s.length() <= 4)).forEach(s -> System.out.println(s));
		names.stream().filter(s -> (s.length() <= 4)).limit(1).forEach(s -> System.out.println(s));

	}

//	@Test
	public void streamMap() {

		ArrayList<String> names = new ArrayList<>();
		names.add("Cristian");
		names.add("Daniela");
		names.add("Madalina");
		names.add("Liudmila");
		names.add("Vitalie");
		names.add("Vasile");
		names.add("Eva");
		names.add("Ami");
		names.add("Lacy");
		names.add("Tuzea");

		names.stream().filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}

//	@Test
	public void streamMapSorted() {

		List<String> names = new ArrayList<>();
		names.add("Cristian");
		names.add("Daniela");
		names.add("Madalina");
		names.add("Liudmila");
		names.add("Vitalie");
		names.add("Vasile");
		names.add("Eva");
		names.add("Ami");
		names.add("Lacy");
		names.add("Tuzea");

		names.stream().filter(s -> s.length() > 1).sorted().map(s -> s.toLowerCase())
				.forEach(s -> System.out.println(s));

	}

//	@Test
	public void streamMergeLists() {
		List<String> names1 = new ArrayList<>();
		names1.add("Cristian");
		names1.add("Daniela");
		names1.add("Madalina");
		names1.add("Liudmila");
		names1.add("Vitalie");
		names1.add("Vasile");
		names1.add("Eva");
		names1.add("Ami");
		names1.add("Lacy");
		names1.add("Tuzea");

		ArrayList<String> names2 = new ArrayList<>();
		names2.add("Valera");
		names2.add("Tolea");
		names2.add("Daniel");
		names2.add("Petru");
		names2.add("Vitalie");
		names2.add("Vasile");

		Stream<String> concatStream = Stream.concat(names1.stream(), names2.stream());
		System.out.println("============================");
//		concatStream.forEach(s -> System.out.println(s));
		boolean isPresent = concatStream.anyMatch(s -> s.equalsIgnoreCase("Valera"));
		System.out.println("isPresent: " + isPresent);
	}
	

	
//	@Test
	public void streamCollect() {
		List<String> names1 = new ArrayList<>();
		names1.add("Cristian");
		names1.add("Daniela");
		names1.add("Madalina");
		names1.add("Liudmila");
		names1.add("Vitalie");
		names1.add("Vasile");
		names1.add("Eva");
		names1.add("Ami");
		names1.add("Lacy");
		names1.add("Tuzea");

		ArrayList<String> names2 = new ArrayList<>();
		names2.add("Valera");
		names2.add("Tolea");
		names2.add("Daniel");
		names2.add("Petru");
		names2.add("Vitalie");
		names2.add("Vasile");
		
		Stream<String> concatStream = Stream.concat(names1.stream(), names2.stream());
		System.out.println("============================");
		List<String> concatedList = concatStream.collect(Collectors.toList());
		System.out.println(concatedList.get(0));
		Assert.assertEquals(concatedList.get(0), "Cristian");
	}
	
	@Test
	public void distinctSorting() {
		List<Integer> values = Arrays.asList(1,2,2,2,3,3,5,6,8,7,4,5,4,5,85,1,6,2,2);
		System.out.println("---------------------------------------------------------");
		values.stream().distinct().sorted().forEach(s -> System.out.println(s));
	}
	

}
