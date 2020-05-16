/**
 * 
 */
package com.company.kalah.service;

import java.util.List;

import com.company.kalah.support.KeyValue;

/**
 * @author somendu
 *
 */
public interface KalayPlayService {

	List<KeyValue> play(List<KeyValue> initStatus, String gameId, int pitId);

	List<KeyValue> initializeList();

}
