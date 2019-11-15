package com.company.searchtext;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Test;

import com.company.searchtext.service.ReadFileService;

public class SearchReplaceTest {

	@Test
	public void testTextExtension() throws IOException {

		ReadFileService readFileService = new ReadFileService();

		assertFalse(!readFileService.checkFileExtension("Sample.txt"));

	}

	@Test
	public void testPdfExtension() throws IOException {

		ReadFileService readFileService = new ReadFileService();

		assertFalse(readFileService.checkFileExtension("Sample.pdf"));

	}

}
