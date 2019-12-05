package com.company.kalah.condition;

import com.company.kalah.exception.GameException;
import com.company.kalah.support.Board;
import com.company.kalah.support.Game;
import com.company.kalah.support.GameStatus;
import com.company.kalah.support.Pit;
import com.company.kalah.support.Player;

import lombok.extern.slf4j.Slf4j;

/**
 * This class check starting rules for the distributing stones.
 *
 * @author maruf
 */
@Slf4j
public class StartPitRule extends KalahRule {

	@Override
	public void apply(Game game, Pit startPit) {
		log.debug("check rules for the start pit {}", startPit);

		try {
			checkPlayerTurnRule(game, startPit);
			checkEmptyStartRULE(startPit);
		} catch (GameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.next.apply(game, startPit);
	}

	private void checkPlayerTurnRule(Game game, Pit startPit) throws GameException {

		if (game.getGameStatus().equals(GameStatus.INIT)) {
			GameStatus gameStatus = startPit.getPlayerIndex().equals(Player.PLAYER1_INDEX) ? GameStatus.PLAYER1_TURN
					: GameStatus.PLAYER2_TURN;
			game.setGameStatus(gameStatus);
		}

		if ((game.getGameStatus().equals(GameStatus.PLAYER1_TURN) && startPit.getPitIndex() >= Board.PLAYER1_HOUSE)
				|| (game.getGameStatus().equals(GameStatus.PLAYER2_TURN)
						&& startPit.getPitIndex() <= Board.PLAYER1_HOUSE)) {
			throw new GameException("Incorrect pit to play");
		}
	}

	private void checkEmptyStartRULE(Pit startPit) throws GameException {

		if (startPit.getStoneCount() == 0) {
			throw new GameException("Can not start from empty pit");
		}
	}
}
