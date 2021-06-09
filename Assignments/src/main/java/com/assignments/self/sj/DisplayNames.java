/**
 * 
 */
package com.assignments.self.sj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @Since 19-Apr-2021
 */
public class DisplayNames {

	public static void main(String[] args) throws IOException {

		Path name1Path = Paths.get("Names1.txt");
		Path name2Path = Paths.get("Names2.txt");

		HashSet<String> stringSet = new HashSet<String>();

		try (Stream<String> stream = Files.lines(name1Path)) {
			stream.forEach(stringSet::add);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (Stream<String> stream = Files.lines(name2Path)) {
			stream.forEach(stringSet::add);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Sorting HashSet using List
		List<String> list = new ArrayList<String>(stringSet);
		Collections.sort(list);

		list = list.stream().sorted().collect(Collectors.toList());

		File f = new File("Names.txt");
		if (f.exists()) {
			f.delete();
		}
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		for (String s : list) {
			fw.write(s + "\r\n");
		}
		fw.close();
	}

}
