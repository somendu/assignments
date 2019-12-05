package com.company.kalah.condition;

import com.company.kalah.exception.GameException;
import com.company.kalah.support.Game;
import com.company.kalah.support.GameStatus;
import com.company.kalah.support.Pit;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is responsible to check the last stone placing rules.
 *
 * @author maruf
 */
@Slf4j
public class EndPitRule extends KalahRule {

	@Override
	public void apply(Game game, Pit endPit) {
		log.debug("checking end rule for the last pit {}", endPit);

		try {
			lastEmptyPitRule(game, endPit);
		} catch (GameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextPlayerTurnRue(game, endPit);
		this.next.apply(game, endPit);
	}

	private void lastEmptyPitRule(Game game, Pit endPit) throws GameException {

		if (!endPit.isHouse() && endPit.isPlayerPit(game.getGameStatus()) && endPit.getStoneCount().equals(1)) {
			Pit oppositePit = game.getBoard().getOppositePit(endPit);
			if (oppositePit.getStoneCount() > 0) {
				Pit house = game.getBoard().getPlayerHouse(endPit.getPlayerIndex());
				house.setStoneCount((house.getStoneCount() + oppositePit.getStoneCount()) + endPit.getStoneCount());
				oppositePit.setStoneCount(0);
				endPit.setStoneCount(0);
			}
		}
	}

	private void nextPlayerTurnRue(Game game, Pit endPit) {

		if (endPit.isPlayer1House() && game.getGameStatus().equals(GameStatus.PLAYER1_TURN)) {
			game.setGameStatus(GameStatus.PLAYER1_TURN);
		} else if (endPit.isPlayer2House() && game.getGameStatus().equals(GameStatus.PLAYER2_TURN)) {
			game.setGameStatus(GameStatus.PLAYER2_TURN);
		} else {
			GameStatus changeStage = game.getGameStatus() == GameStatus.PLAYER1_TURN ? GameStatus.PLAYER2_TURN
					: GameStatus.PLAYER1_TURN;
			game.setGameStatus(changeStage);
		}
		game.updateTime();
	}
}
