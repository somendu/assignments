/**
 * 
 */
package com.company.kalah.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.company.kalah.exception.GameNotFoundException;
import com.company.kalah.support.GameCreation;
import com.company.kalah.support.GameMove;

/**
 * 
 * Service layer interface for the uploading of file
 * 
 * @author somendu
 *
 */
public interface KalahService {

	/**
	 * 
	 * Save the file
	 * 
	 * @param file
	 * @throws IOException
	 */
	public Path saveUploadedFile(MultipartFile file) throws IOException;

	public GameCreation createNewGame();

	public GameMove getMove(String gameId, String pitId) throws GameNotFoundException;

}
