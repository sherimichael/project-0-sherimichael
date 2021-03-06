package com.revature.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.services.TransaxnService;

public class TransaxnsScreen {
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	private static final Scanner scan = new Scanner(System.in);
	
	double amount;
	String s;
	MemberScreen ms = new MemberScreen();
	TransaxnService transaxn = new TransaxnService();
	
	public void depositApp(int userId) {
		log.info("@transaxnTypes in TransaxnsScreen");
		
		System.out.println("\nFor which account do you want to make a deposit?\n"
		          + "1. My checking account \n"
		          + "2. My savings account \n"
		          + "3. I do not want to make a deposit. Take me back to the Member Actions Screen.\n."
			);
			String choice = scan.nextLine(); 
			selectMenuDepositSwitch(choice, userId);
	}
		
	public void selectMenuDepositSwitch(String choice, int userId) {
				
				switch(choice){
					case "1": 
						log.info("@selectMenuDepositSwitch in TransaxnsScreen - deposit into checking");
						System.out.print("\nWhat is the amount you want to deposit into your checking? $");
						s = scan.nextLine();
						amount = Double.parseDouble(s);
						transaxn.depositChecking(userId, amount);
						ms.MoreMemberAxns(userId);
						break;
					case "2": 
						log.info("@selectMenuSwitch in TransaxnsScreen - deposit into savings");
						System.out.print("\nWhat is the amount you want to deposit into your savings? $");
						s = scan.nextLine();
						amount = Double.parseDouble(s);
						transaxn.depositSavings(userId, amount);
						ms.MoreMemberAxns(userId);
						break;
					case "3":
						log.info("@selectMenuSwitch in TransaxnsScreen - exit deposit menu");
						ms.MoreMemberAxns(userId);
						break;
					default:
						log.info("@selectMenuSwitch in TransaxnsScreen - invalid input");
						System.out.println("You have entered an incorrect value. Please try again.");
						depositApp(userId);
						break;
				}
	}
	
	public void withdrawApp(int userId) {
		log.info("@withdrawApp in TransaxnsScreen");
		
		System.out.println("\nFrom which account do you want to withdraw money?\n"
		          + "1. My checking account \n"
		          + "2. My savings account \n"
		          + "3. I do not want to make a deposit. Take me back to the Member Actions Screen.\n."
			);
			String choice = scan.nextLine(); 
			selectMenuWithdrawSwitch(choice, userId);
	}
		
	public void selectMenuWithdrawSwitch(String choice, int userId) {

				switch(choice){
					case "1": 
						log.info("@selectMenuWithdrawSwitch in TransaxnsScreen - withdraw from checking");
						System.out.print("\nWhat is the amount you want to withdraw from your checking? $");
						s = scan.nextLine();
						double amount = Double.parseDouble(s);
						transaxn.withdrawChecking(userId, amount);
						ms.MoreMemberAxns(userId);
						break;
					case "2": 
						log.info("@selectMenuWithdrawSwitch in TransaxnsScreen - withdraw from savings");
						System.out.print("\nWhat is the amount you want to withdraw your savings? $");
						s = scan.nextLine();
						amount = Double.parseDouble(s);
						transaxn.withdrawSavings(userId, amount);
						ms = new MemberScreen();
						ms.MoreMemberAxns(userId);
						break;
					case "3":
						log.info("@selectMenuWithdrawSwitch in TransaxnsScreen - exit withdraw menu");
						ms.MoreMemberAxns(userId);
						break;
					default:
						log.info("@selectMenuWithdrawSwitch in TransaxnsScreen - invalid input");
						System.out.println("You have entered an incorrect value. Please try again.");
						depositApp(userId);
						break;
				}
	}
	
	public void transferApp(int userId) {
		log.info("@TransferApp in TransaxnsScreen");
		System.out.println("\nYou may transfer money from your account to another member's account.\n"
						+ "What is the member id number you would like to deposit money into?");
		s = scan.nextLine();
		int toId = Integer.parseInt(s);
		System.out.print("\nWhat is the amount you would like to transfer?: ");
		s = scan.nextLine();
		amount = Double.parseDouble(s);
		transaxn.transferMoney(userId, toId, amount);
		ms.MoreMemberAxns(userId);
		
	}
}
