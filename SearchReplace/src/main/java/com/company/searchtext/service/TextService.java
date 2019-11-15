/**
 * 
 */
package com.company.searchtext.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

/**
 * 
 * Text Service Class
 * 
 * @author somendu
 *
 */
public class TextService {

	// java -jar build/libs/SearchReplace.jar --fileType txt --searchString customer
	// --replaceString client --sourceFile SampleText.txt --targetFile Result.txt

	private ReplaceTextService replaceTextService = new ReplaceTextService();

	/**
	 * 
	 * Read the text file using File.lines creating a string stream
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param searchString
	 * @param replaceString
	 * @param targetFile
	 * @throws IOException
	 */
	public void readTextFile(String sourceFile, String fileType, String searchString, String replaceString,
			String targetFile) throws IOException {

		Path paths = Paths.get(sourceFile);

		Stream<String> stringStream = Files.lines(paths, Charset.forName("UTF-8"));

		// Calling common factory method
		List<String> fileLinesList = stringStream
				.map(line -> replaceTextService.replaceText(line, searchString, replaceString))
				.collect(Collectors.toList());

		Path targetFilePath = Paths.get(targetFile);
		Files.write(targetFilePath, fileLinesList, Charset.forName("UTF-8"));

		stringStream.close();

	}

	/**
	 * 
	 * Read the text file with concurrent threads
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param searchString
	 * @param replaceString
	 * @param targetFile
	 * @throws IOException
	 */
	public void concurrentReadWriteFile(String sourceFile, String fileType, String searchString, String replaceString,
			String targetFile) throws IOException {

		Path paths = Paths.get(sourceFile);

		Vector<String> fileContents = new Vector<>(Collections.nCopies(1, sourceFile));

		CountDownLatch countDownLatch = new CountDownLatch(1);

		final int writerId = 0;

		// Text File Reading
		new Thread(() -> {
			try {

				Stream<String> stringStream = Files.lines(paths, Charset.forName("UTF-8"));

				// Calling common factory method
				List<String> fileLinesList = stringStream
						.map(line -> replaceTextService.replaceText(line, searchString, replaceString))
						.collect(Collectors.toList());

				String content = String.join("\n", fileLinesList);

				fileContents.set(writerId, content);
				countDownLatch.countDown();
				stringStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

		// Text File Writing
		new Thread(() -> {
			try {

				countDownLatch.await();

				Path targetFilePath = Paths.get(targetFile);

				synchronized (this) {

					Files.write(targetFilePath, fileContents, Charset.forName("UTF-8"));

					notifyAll();
				}
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	/**
	 * Read using File.readAllLines
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param searchString
	 * @param replaceString
	 * @param targetFile
	 * @throws IOException
	 */
	public void readUsingReadAllLines(String sourceFile, String fileType, String searchString, String replaceString,
			String targetFile) throws IOException {

		File file = new File(sourceFile);

		List<String> fileLinesList = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));

		for (String line : fileLinesList) {
			replaceTextService.replaceText(line, searchString, replaceString);
		}

		// Writing the target file
		Path newFilePath = Paths.get(targetFile);
		Files.write(newFilePath, fileLinesList, Charset.forName("UTF-8"));

	}

	/**
	 * Read file using File Utils from Apache
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param searchString
	 * @param replaceString
	 * @param targetFile
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void readUsingFileUtils(String sourceFile, String fileType, String searchString, String replaceString,
			String targetFile) throws IOException, InterruptedException {

		File file = new File(sourceFile);

		List<String> fileLinesList = FileUtils.readLines(file, "UTF-8");

		for (String line : fileLinesList) {
			replaceTextService.replaceText(line, searchString, replaceString);
		}

		// Writing the target file
		Path newFilePath = Paths.get(targetFile);
		Files.write(newFilePath, fileLinesList, Charset.forName("UTF-8"));

	}

}
