/**
 * 
 */
package com.company.kalah.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.kalah.dao.KalahDao;
import com.company.kalah.exception.GameNotFoundException;
import com.company.kalah.service.KalahService;
import com.company.kalah.support.GameCreation;
import com.company.kalah.support.GameMove;

/**
 * Service layer implementation class for handling all business logic
 * 
 * @author somendu
 *
 */
@Service
public class KalahServiceImpl implements KalahService {

	@Autowired
	private KalahDao kalahDao;

	@Override
	public Path saveUploadedFile(MultipartFile file) throws IOException {

		Path path = null;

		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			path = Paths.get("file/" + file.getOriginalFilename());

			System.out.println("Path Parent: " + path.getParent());
			System.out.println("File Name: " + path.getFileName());

			try (OutputStream os = Files.newOutputStream(path)) {
				os.write(bytes);
				os.close();
			}

		}

		return path;

	}

	@Override
	public GameCreation createNewGame() {

		GameCreation gameCreation = kalahDao.createGame();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(gameCreation.getId()).toUri();

		gameCreation.setUri(location);

		ResponseEntity.created(location).build();

		return gameCreation;

	}

	@Override
	public GameMove getMove(String gameId, String pitId) throws GameNotFoundException {

		GameCreation gameCreation = kalahDao.findCreatedGame(gameId);

		GameMove gameMove = new GameMove();

		int gameInt = Integer.parseInt(gameId);

		gameMove.setId(gameInt);

		String path = getReducedPath(ServletUriComponentsBuilder.fromCurrentRequest().build().getPath());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build("").resolve(path);

		gameMove.setUri(location);

		// TODO Create Status here

		return gameMove;
	}

	/**
	 * Reducing the path
	 * 
	 * @param path
	 * @return
	 */
	private String getReducedPath(String path) {

		final int secondLast = path.length() - 5;

		final String output = path.substring(0, path.lastIndexOf("/", secondLast));

		return output;
	}

}
