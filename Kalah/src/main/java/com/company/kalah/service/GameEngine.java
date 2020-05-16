package com.company.kalah.service;

import org.springframework.stereotype.Component;

import com.company.kalah.condition.DistributePitStoneRule;
import com.company.kalah.condition.EndPitRule;
import com.company.kalah.condition.GameOver;
import com.company.kalah.condition.KalahRule;
import com.company.kalah.condition.StartPitRule;
import com.company.kalah.support.Game;
import com.company.kalah.support.Pit;

/**
 * This class represent the game rule chain.
 *
 * @author maruf
 */
@Component
public class GameEngine {

	private final KalahRule chain;

	public GameEngine() {

		this.chain = new StartPitRule();
		chain.setNext(new DistributePitStoneRule()).setNext(new EndPitRule()).setNext(new GameOver());
	}

	public void play(Game game, Pit pit) {
		this.chain.apply(game, pit);
	}

}
