/**
 * 
 */
package com.company.kalah.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.company.kalah.dao.KalahDao;
import com.company.kalah.exception.GameNotFoundException;
import com.company.kalah.support.GameCreation;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Storage
 * 
 * @author somendu
 *
 */
@Slf4j
@Component
public class KalahDaoImpl implements KalahDao {

	private static final Map<Integer, GameCreation> gameCreationMap = new HashMap<Integer, GameCreation>();

	@Override
	public GameCreation createGame() {

		int minimum = 1;

		int maximum = 999999;

		int randomNumber = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);

		GameCreation gameCreation = new GameCreation();

		gameCreation.setId(randomNumber);

		gameCreationMap.put(randomNumber, gameCreation);

		return gameCreationMap.get(randomNumber);

	}

	/**
	 * Change this comment This method will return the game object by id.
	 *
	 * @param id is the game id.
	 * @return Game
	 * @throws GameNotFoundException
	 */
	@Override
	public GameCreation findCreatedGame(String gameId) throws GameNotFoundException {

		GameCreation gameCreation = gameCreationMap.get(Integer.parseInt(gameId));

		if (gameCreation == null) {
			throw new GameNotFoundException("Game " + gameId + " is not found");
		}
		return gameCreation;
	}

}
