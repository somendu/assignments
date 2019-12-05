/**
 * 
 */
package com.company.kalah.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.kalah.service.KalayPlayService;
import com.company.kalah.support.GameConstant;
import com.company.kalah.support.KeyValue;

/**
 * 
 * Service for game play
 * 
 * @author somendu
 *
 */
@Service
public class KalahPlayServiceImpl implements KalayPlayService {

	private static String PLAYER = "";

	private static int counter = 0;

	@Override
	public List<KeyValue> play(List<KeyValue> initStatus, String gameId, int pitId) {

		List<KeyValue> statusList = new ArrayList<KeyValue>();

		// TODO Based on pitID - check to throw exception player turn

		// TODO Based on pitID - check house

		// TODO initialize the game keep moving the stones

		Integer stoneToDistribute = initStatus.get(pitId).getNumberOfStones();
		initStatus.get(pitId - 1).setNumberOfStones(0);

		// TODO Distribute the stones to next .. to the right

		if (pitId < GameConstant.PIT_HOUSE_1) {

			for (int j = pitId; j <= GameConstant.PIT_HOUSE_1; j++)

//			currentPit = game.getBoard().getNextPit(currentPit);
//			log.debug("next pit {}", currentPit);
//			if (currentPit.isDistributable(game.getGameStatus())) {
				initStatus.get(j).setNumberOfStones(initStatus.get(j).getNumberOfStones() + 1);
			// } else {
			// i--;

		} else if (pitId < GameConstant.PIT_HOUSE_2 || pitId > GameConstant.PIT_HOUSE_1) {

			for (int j = pitId; j < GameConstant.PIT_HOUSE_2; j++)

//			currentPit = game.getBoard().getNextPit(currentPit);
//			log.debug("next pit {}", currentPit);
//			if (currentPit.isDistributable(game.getGameStatus())) {
				initStatus.get(j).setNumberOfStones(initStatus.get(j).getNumberOfStones() + 1);
			// } else {
			// i--;

		}

		// TODO Check empty pit condition

		// TODO last empty pit

		// TODO Set next player based on pit id throw execption

		// TODO Check Game over condition

		// TODO return proper list
		return initStatus;

	}

	@Override
	public List<KeyValue> initializeList() {

		List<KeyValue> initialList = new ArrayList<KeyValue>();

		List<KeyValue> initialPlayer1List = new ArrayList<KeyValue>();
		List<KeyValue> initialPlayer2List = new ArrayList<KeyValue>();

		for (int count = 1; count <= 7; count++) {
			KeyValue keyValue = new KeyValue();
			keyValue.setPitId(count);

			if (count != 7) {
				keyValue.setNumberOfStones(6);
			} else {
				keyValue.setNumberOfStones(0);
			}

			initialPlayer1List.add(keyValue);
		}

		for (int count = 8; count <= 14; count++) {
			KeyValue keyValue = new KeyValue();
			keyValue.setPitId(count);
			if (count != 14) {
				keyValue.setNumberOfStones(6);
			} else {
				keyValue.setNumberOfStones(0);
			}
			initialPlayer2List.add(keyValue);
		}

		initialList.addAll(initialPlayer1List);
		initialList.addAll(initialPlayer2List);

		return initialList;
	}

}
