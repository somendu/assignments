/**
 * 
 */
package com.company.kalah.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.kalah.dao.KalahDao;
import com.company.kalah.exception.GameNotFoundException;
import com.company.kalah.service.GameEngine;
import com.company.kalah.service.KalahService;
import com.company.kalah.service.KalayPlayService;
import com.company.kalah.support.Game;
import com.company.kalah.support.GameCreation;
import com.company.kalah.support.GameMove;
import com.company.kalah.support.Pit;

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

	@Autowired
	private KalayPlayService playService;

	@Autowired
	private GameEngine gameEngine;

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
	public GameMove getMove(String gameId, int pitId) throws GameNotFoundException {

		GameCreation gameCreation = kalahDao.findCreatedGame(gameId);

		GameMove gameMove = new GameMove();

		gameMove.setId(gameCreation.getId());

		String path = getReducedPath(ServletUriComponentsBuilder.fromCurrentRequest().build().getPath());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build("").resolve(path);

		gameMove.setUri(location);

		// TODO Create Status here

		Game game = new Game(6);

		Pit pit = game.getBoard().getPitByPitIndex(pitId);

		gameEngine.play(game, pit);

//		gameMove.setStatus(initStatus);

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
