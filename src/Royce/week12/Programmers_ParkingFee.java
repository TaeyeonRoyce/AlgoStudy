package Royce.week12;

//2022.09.11
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_ParkingFee {
	public static void main(String[] args) {
		ParkingFeeSolution solution = new ParkingFeeSolution();
		int[] answer = solution.solution(new int[] {180, 5000, 10, 600},
			new String[] {
				"05:34 5961 IN", "06:00 0000 IN",
				"06:34 0000 OUT", "07:59 5961 OUT",
				"07:59 0148 IN", "18:59 0000 IN",
				"19:09 0148 OUT", "22:59 5961 IN",
				"23:00 5961 OUT"});

		System.out.println(Arrays.toString(answer));
	}
}

class ParkingFeeSolution {

	private Map<String, Car> carMap = new HashMap<>();

	public int[] solution(int[] fees, String[] records) {
		for (String record : records) {
			String[] recordInfo = record.split(" ");
			String time = recordInfo[0];
			String carNumber = recordInfo[1];
			String action = recordInfo[2];

			Car car = carMap.getOrDefault(carNumber, new Car(carNumber, 0, false));
			if (action.equals("IN")) {
				car.parking(time);
			} else if (action.equals("OUT")) {
				car.exit(time);
			}

			carMap.put(carNumber, car);
		}

		List<Car> cars = new ArrayList<>();
		for (String carNumber : carMap.keySet()) {
			cars.add(carMap.get(carNumber));
		}

		Collections.sort(cars);

		int[] answer = new int[cars.size()];
		int i = 0;
		for (Car car : cars) {
			car.calculateParkingFee(fees);
			answer[i++] = car.parkingFee;
		}
		return answer;
	}
}

class Car implements Comparable<Car> {
	String carNumber;
	int parkingAmount;
	LocalTime parkedAt;
	boolean isParking;

	int parkingFee;

	public Car(String carNumber, int parkingAmount, boolean isParking) {
		this.carNumber = carNumber;
		this.parkingAmount = parkingAmount;
		this.isParking = isParking;
	}

	public void parking(String time) {
		isParking = true;
		parkedAt = LocalTime.parse(time);
	}

	public void exit(String time) {
		isParking = false;
		LocalTime exitAt = LocalTime.parse(time);

		int amount = (int)Duration.between(parkedAt, exitAt).toMinutes();
		parkingAmount += amount;
	}

	public void calculateParkingFee(int[] fees) {
		int basicTime = fees[0];
		int basicPrice = fees[1];
		int unitTime = fees[2];
		int unitPrice = fees[3];

		if (this.isParking) {
			exit("23:59");
		}

		if (parkingAmount > 0) {
			parkingFee += basicPrice;
			parkingAmount -= basicTime;
		}

		if (parkingAmount > 0) {
			int units = parkingAmount / unitTime;
			parkingFee += units * unitPrice;
			if (parkingAmount % unitTime != 0) {
				parkingFee += unitPrice;
			}
		}
	}

	@Override
	public int compareTo(Car o) {
		return this.carNumber.compareTo(o.carNumber);
	}
}