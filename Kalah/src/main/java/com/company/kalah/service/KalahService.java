/**
 * 
 */
package com.company.kalah.service;

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

	public GameCreation createNewGame();

	public GameMove getMove(String gameId, int pitId) throws GameNotFoundException;

}
