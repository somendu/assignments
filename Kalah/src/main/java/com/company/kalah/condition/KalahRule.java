package com.company.kalah.condition;

import com.company.kalah.support.Game;
import com.company.kalah.support.Pit;

public abstract class KalahRule {

	protected KalahRule next;

	public abstract void apply(Game game, Pit currentPit);

	public KalahRule setNext(KalahRule next) {
		this.next = next;
		return next;
	}

}
