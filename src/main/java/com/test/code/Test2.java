package com.test.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Period{
	private Integer start;
	private Integer end;
	
	public Period(){}
	public Period(Integer start, Integer end){
		this.start = start;
		this.end = end;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	
}

class User {
	private String name;
	private Integer start;
	private Integer end;

	public User() {
	}

	public User(String name, Integer start, Integer end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

}

public class Test2 {
	public static void main(String[] args) {
		List<Period> periods = new ArrayList<Period>();
		for(int i=9;i<18;i++){
			Period period = new Period(i, i+1);
			periods.add(period);
		}
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter player number: ");
		String playersStr = in.nextLine();
		int players = Integer.valueOf(playersStr);
		System.out.print("Enter the time: ");
		String[] data = new String[players];
		//String[] data = {"9 10", "9 12", "13 15", "10 18"};
		//String[] data = {"9 10", "9 12"};
		//String[] data = {"9 11", "12 14", "13 15", "11 18", "14 18", "10 14", "15 18"};
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < players; i++) {
			data[i] = in.nextLine();
			String[] temp = data[i].split(" ");
			User user = new User("user-1", Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
			users.add(user);
		}

		in.close();
		
		
		int availableUsers = 0;
		int single = 0;
		int dou = 0;
		for (int i = 0; i < periods.size(); i++) {
			for (int j = 0; j < users.size(); j++) {
				if(users.get(j).getStart() <= periods.get(i).getStart() && users.get(j).getEnd() >= periods.get(i).getEnd()){
					availableUsers++;
				}
			}
			if(availableUsers >= 4){
				dou++;
			}else if(availableUsers >= 2 && availableUsers < 4){
				single++;
			}
			availableUsers = 0;
		}
		System.out.println("Total Double: "+dou);
		System.out.println("Total Single: "+single);
	}
}
