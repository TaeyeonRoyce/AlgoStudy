package Royce.week11;

//2022.09.02
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/9019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_9019 {

	private static String[] commandTypes = new String[] {"D", "S", "L", "R"};
	/*
	3
	1234 3412
	1000 1
	1 16
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String answer = mainSolution(br);
			System.out.println(answer);
		}

	}

	private static String mainSolution(BufferedReader br) throws IOException {
		String[] AB = br.readLine().split(" ");
		final int A = Integer.parseInt(AB[0]);
		final int B = Integer.parseInt(AB[1]);

		CommandStatus[] commandStatusBoard = new CommandStatus[10001];

		CommandStatus startNumber = new CommandStatus(A, 0, "");
		commandStatusBoard[startNumber.number] = startNumber;

		Deque<CommandStatus> deque = new ArrayDeque<>();
		deque.add(startNumber);

		while (!deque.isEmpty()) {
			CommandStatus standardStatus = deque.poll();
			for (int i = 0; i < 4; i++) {
				if (commandStatusBoard[B] != null) {
					return commandStatusBoard[B].commandLog;
				}
				String commandType = commandTypes[i];
				CommandStatus currentStatus = standardStatus.command(commandType);

				// 이미 계산했던 숫자인 경우
				if (commandStatusBoard[currentStatus.number] != null
					&& currentStatus.stackSize < commandStatusBoard[currentStatus.number].stackSize) {
						commandStatusBoard[currentStatus.number] = currentStatus;
						deque.add(currentStatus);
						continue;
				}

				if (commandStatusBoard[currentStatus.number] == null) {
					commandStatusBoard[currentStatus.number] = currentStatus;
					deque.add(currentStatus);
				}
			}

		}

		return commandStatusBoard[B].commandLog;
	}



}

class CommandStatus {
	int number;
	int stackSize;
	String commandLog;

	public CommandStatus(int number, int stackSize, String commandLog) {
		this.number = number;
		this.stackSize = stackSize;
		this.commandLog = commandLog;
	}

	public CommandStatus command(String commandType) {
		int updateNumber = 0;
		String updateCommandLog = this.commandLog + commandType;
		if (commandType.equals("D")) {
			updateNumber = commandD();
		} else if (commandType.equals("S")) {
			updateNumber = commandS();

		} else if (commandType.equals("L")) {
			updateNumber = commandL();

		} else if (commandType.equals("R")) {
			updateNumber = commandR();

		}

		return new CommandStatus(updateNumber, this.stackSize + 1, updateCommandLog);
	}


	private int commandD() {
		int afterCommand = (this.number * 2) % 10000;
		return afterCommand;
	}
	private int commandS() {
		int afterCommand = this.number - 1;
		if (afterCommand < 0) {
			afterCommand = 9999;
		}

		return afterCommand;
	}
	private int commandL() {
		//ex) 4231 -> 2314
		int upscale = this.number * 10; //42310
		int popFirst = upscale / 10000; //4
		int lefts = upscale % 10000; //2310
		int afterCommand = lefts + popFirst; //2314

		return afterCommand;
	}
	private int commandR() {
		//ex) 1234 -> 4123
		int pop = this.number % 10; // 4
		int lefts = this.number / 10; // 123

		// 1000 + 100
		int afterCommand = (pop * 1000) + lefts;

		return afterCommand;
	}
}
