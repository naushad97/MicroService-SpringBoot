package com.cts.product.rental.util;

import java.util.Random;

public class CommonUtils {

	public static long generateReservationId() {
		long result = 0;
		Random randomGenerator = new Random();
		for (int idx = 1; idx <= 10; ++idx) {
			long randomInt = randomGenerator.nextInt(1000000000);
			result = result + randomInt;
		}
		return result;

	}

}
