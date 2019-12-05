/**
 * 
 */
package com.company.kalah.dao;

import com.company.kalah.exception.GameNotFoundException;
import com.company.kalah.support.GameCreation;

/**
 * @author somendu
 *
 */
public interface KalahDao {

	public GameCreation createGame();

	public GameCreation findCreatedGame(String gameId) throws GameNotFoundException;
}
