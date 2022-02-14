package com.zenvia.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;


import org.junit.jupiter.api.Test;

class AtmServiceTest {

	@Test
	void testWithdraw() {
		AtmService atm = new AtmService();
		Map<Integer, Integer> result;
		try {
			result = atm.withdraw(470);
			Map<Integer, Integer> expectedResult = new HashMap<Integer, Integer>();
			expectedResult.put(10, 0);
			expectedResult.put(20, 1);
			expectedResult.put(50, 1);
			expectedResult.put(100, 4);
			assertTrue(result.equals(expectedResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
