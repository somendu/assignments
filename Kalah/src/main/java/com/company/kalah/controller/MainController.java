package com.company.kalah.controller;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.kalah.exception.GameNotFoundException;
import com.company.kalah.service.KalahService;
import com.company.kalah.support.GameCreation;
import com.company.kalah.support.GameMove;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller Class for creating end points
 * 
 * @author somendu
 *
 */
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MainController {

	private final KalahService mainControllerService;

	// private GameCreationAssembler assembler;

	// Sessions Method for Setting Session to Start
	@PostMapping("/uploadFile")
	@ApiOperation(value = "Upload File", notes = "Provide File ", response = ResponseEntity.class)
	public ResponseEntity<?> uploadFile(@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file,
			@RequestPart("searchText") String searchText, @RequestPart("replaceText") String replaceText) {

		try {
			System.out.println("File Here");
			System.out.println("searchText : " + searchText);
			System.out.println("replaceText : " + replaceText);
			mainControllerService.saveUploadedFile(file);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);

	}

	// POST Mapping to start Game

	@PostMapping("/games")
	@ApiOperation(value = "Create Game", notes = "Game Created with ID and URL", response = ResponseEntity.class)
	public ResponseEntity<?> createGame() {

//			uploadControllerService.saveUploadedFile(file);

		GameCreation gameCreation = mainControllerService.createNewGame();

		return new ResponseEntity<GameCreation>(gameCreation, HttpStatus.CREATED);

	}

	@PutMapping("/games/{gameId}/pits/{pitId}")
	@ApiOperation(value = "Play Game", notes = "Game to be Played with ID and URL", response = ResponseEntity.class)
	public ResponseEntity<?> playGame(@PathVariable("gameId") String gameId, @PathVariable("pitId") String pitId) {

		// PUT Mapping for game id to return moves

		GameMove gameMove = new GameMove();
		try {
			gameMove = mainControllerService.getMove(gameId, pitId);
		} catch (GameNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		// Return response number of pits
		return new ResponseEntity<GameMove>(gameMove, HttpStatus.OK);

	}

}
