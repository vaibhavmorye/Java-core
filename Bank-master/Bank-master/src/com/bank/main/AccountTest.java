package com.bank.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bank.model.BankAccount;

public class AccountTest {

	private class AccountComparator implements Comparator<BankAccount> {

		@Override
		public int compare(BankAccount o1, BankAccount o2) {
			BankAccount b1 = o1;
			BankAccount b2 = o2;
			return o1.getInterest() > o2.getInterest() ? 1 : 0;
		}

	}

	public double getMaxInterest(ArrayList<BankAccount> bankAccounts) {

		BankAccount bankAccount = Collections.max(bankAccounts, new AccountComparator());
		return bankAccount.getInterest();

	}

	public double getMinInterest(ArrayList<BankAccount> bankAccounts) {
		BankAccount bankAccount = Collections.min(bankAccounts, new AccountComparator());
		return bankAccount.getInterest();

	}

	public double calculateInterest(double amount) {
		double InterestRate = 0;

		if (amount >= 1001 && amount <= 5000) {
			InterestRate = 0.025;
		}
		if (amount >= 5001 && amount <= 10000) {
			InterestRate = 0.05;
		} else if (amount >= 10000) {
			InterestRate = 0.08;
		}

		return amount * InterestRate;
	}

	public int getTotalInterest(ArrayList<BankAccount> bankAccounts) {
		int i = 0;
		for (BankAccount bankAccount : bankAccounts) {
			i += bankAccount.getInterest();
		}
		return i;
	}

	public int getZeroBalAcc(ArrayList<BankAccount> bankAccounts) {

		List<BankAccount> zero = bankAccounts.stream()
				.filter(bankAccount -> 0 == bankAccount.getInterest())
				.collect(Collectors.toList());
		return zero.size();
	}

	public static void main(String[] args) {
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		AccountTest accountTest = new AccountTest();
		System.out.println("Welcome To Bank of Dev");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter number off account to enter details:");
		int numberOfAccounts = scanner.nextInt();
		if (numberOfAccounts < 0)
			throw new IllegalArgumentException("You can't have negative number");

		for (int i = 0; i < numberOfAccounts; i++) {
			System.out.println("Enter the amount for account number" + i + ": ");
			Double amount = scanner.nextDouble();
			if (amount < 0)
				throw new IllegalArgumentException("You can't have negative number balance");
			Double interest = accountTest.calculateInterest(amount);
			if (interest < 0)
				throw new IllegalArgumentException("You can't have negative number interest");
			BankAccount temp = new BankAccount(i, amount, interest);
			bankAccounts.add(temp);
		}

		/*for (BankAccount bankAccount : bankAccounts) {
			System.out.println(bankAccount);
		}*/

		System.out.println(
				" --------------------------------------------------Interest Details----------------------------------------------------");
		System.out.println("Total Interest: $" + accountTest.getTotalInterest(bankAccounts));
		System.out.println("Lowest Interest: $" + accountTest.getMinInterest(bankAccounts));
		System.out.println("Highest Interest: $" + accountTest.getMaxInterest(bankAccounts));
		System.out.println("Average Interest: $" + (accountTest.getTotalInterest(bankAccounts) / numberOfAccounts));
		System.out.println("Number of accounts with no interest: " + accountTest.getZeroBalAcc(bankAccounts));
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------");

		System.out.println("Bye from Bank of Dev");
	}

}
