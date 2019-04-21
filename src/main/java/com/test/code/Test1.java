package com.test.code;

import java.util.*;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("Enter your data [row,column,user]: ");
		Scanner in = new Scanner(System.in);
		String data = in.next();
		in.close();
		String[] temp = data.split(",");
		int row = Integer.valueOf(temp[0]);
		int column = Integer.valueOf(temp[1]);
		int user = Integer.valueOf(temp[2]);
		int counter = 0;
		String[][] meetings = new String[row][column];

		// 1st condition if row*column=users -> 2,6,12->16 --> default logic if
		// all users occupied all the rooms
		// 2nd condition if row*column>users

		// 2,3,6 -> 7 -> OK -> empty = 0
		// 3,3,8 -> 8 -> OK -> empty = 1
		// 5,2,8 -> 7 -> OK -> empty = 2
		// 2,4,6 -> 4 -> OK -> empty = 2
		// 5,3,12 -> 11 -> ERROR -> empty = 3
		// 4,3,8 -> 4 -> OK -> empty = 4

		int cells = row * column;
		int index = 0;
		int emptyCell = cells - user;
		int increment = 0;
		if (emptyCell > 0){
			increment = user / emptyCell;
		}
		int start = increment;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (counter <= user) {
					if (cells == user) {
						meetings[i][j] = "User " + (counter + 1) + " in row " + (i + 1) + " column " + (j + 1);
						counter++;
					} else {
						if (index == (start - 1) && emptyCell > 0) {
							meetings[i][j] = null;
							emptyCell--;
							if (emptyCell != 0)
								start += increment;
						} else {
							meetings[i][j] = "User " + (counter + 1) + " in row " + (i + 1) + " column " + (j + 1);
							counter++;
						}
					}
					// System.out.println(meetings[i][j]);

				}
				index++;
			}
		}

		int occurance = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				// To calculate the next column
				if (meetings[i][j] != null) {
					if (j < meetings[i].length - 1 && meetings[i][j + 1] != null) {
						occurance++;
					}
					// To calculate the next row
					if (i < meetings.length - 1 && meetings[i + 1][j] != null) {
						occurance++;
					}
				}
			}
		}
		System.out.print("Output " + occurance);
	}
}
