package com.diskbackedmap;

import java.io.Serializable;

class Food implements Serializable {

	int dishRating;
	String dishName;
	int dishCost;

	Food(int dishRating, String dishName, int dishCost) {
		this.dishRating = dishRating;
		this.dishName = dishName;
		this.dishCost = dishCost;
	}

}
