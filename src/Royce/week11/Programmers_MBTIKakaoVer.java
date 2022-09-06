package Royce.week11;

//2022.09.02
//Created by TaeyeonRoyce
//https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java

import java.util.LinkedHashMap;
import java.util.Map;

public class Programmers_MBTIKakaoVer {
	public static void main(String[] args) {
		String answer = solution(new String[] {"AN", "CF", "MJ", "RT", "NA"},
			new int[] {5, 3, 2, 7, 5});

		System.out.println(answer);
	}

	public static String solution(String[] survey, int[] choices) {
		String answer = "";
		Subject subject = new Subject();
		for (int i = 0; i < survey.length; i++) {
			subject.updateBySurvey(survey[i], choices[i]);
		}

		subject.decideTotalPersonality();
		answer = subject.totalPersonality;
		return answer;
	}
}

class Subject {
	Map<Character, Integer> personalityMap = new LinkedHashMap<>();
	String totalPersonality = "";

	public Subject() {
		personalityMap.put('R', 0);
		personalityMap.put('T', 0);
		personalityMap.put('C', 0);
		personalityMap.put('F', 0);
		personalityMap.put('J', 0);
		personalityMap.put('M', 0);
		personalityMap.put('A', 0);
		personalityMap.put('N', 0);
	}

	public void updateBySurvey(String surveyType, int choice) {
		int score = Math.abs(choice - 4);
		if (choice < 4) {
			char personalityType = surveyType.charAt(0);
			personalityMap.put(
				surveyType.charAt(0),
				personalityMap.get(personalityType) + score
			);
		} else {
			char personalityType = surveyType.charAt(1);
			personalityMap.put(
				personalityType,
				personalityMap.get(personalityType) + score
			);
		}
	}

	public void decideTotalPersonality() {
		decideOneType('R', 'T');
		decideOneType('C', 'F');
		decideOneType('J', 'M');
		decideOneType('A', 'N');
	}

	private void decideOneType(char typeA, char typeB) {
		char decidedType;
		if (personalityMap.get(typeA) > personalityMap.get(typeB)) {
			decidedType = typeA;
		} else if (personalityMap.get(typeA) < personalityMap.get(typeB)){
			decidedType = typeB;
		} else { //동일한 경우 알파벳 순
			if (typeA < typeB) {
				decidedType = typeA;
			} else {
				decidedType = typeB;
			}
		}

		totalPersonality += String.valueOf(decidedType);
	}
}