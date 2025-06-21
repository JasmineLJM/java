//---------------------------------
//assignment 3
//Written by Jiemin Liang 40262509
//----------------------------------

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CellListUtilization {
	/**
	 * Name and ID: Jiemin liang 40262509 
	 * COMP 249 Assignment 3 
	 * Due Date: Dec 2,2024
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to CellListUtilization --- by Jiemin Liang 40262509");
		System.out.println("===========================================================");
		System.out.println("");

		Scanner sc = new Scanner(System.in);

		CellList cl = new CellList();
		CellList cl1 = new CellList();
		CellList serNumList = new CellList();

		System.out.println("Task 1: Open the Cell_Info.txt, read its line by line and initialize CellList. ");
		System.out.println("===========================================================");
		System.out.println("");

		Scanner sc1 = null;
		PrintWriter pw = null;

		try {
			sc1 = new Scanner(
					new FileInputStream("/Users/jieminliang/eclipse-workspace/Assignment3COMP249/src/Cell_Info.txt"));
			pw = new PrintWriter(new FileOutputStream(
					"/Users/jieminliang/eclipse-workspace/Assignment3COMP249/src/SerialNum_Info.txt", true));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(-1);
		}

		while (sc1.hasNextLine()) {

			long serialNum;
			String brand;
			int year;
			double price;

			serialNum = sc1.nextLong();
			brand = sc1.next();
			price = sc1.nextDouble();
			year = sc1.nextInt();

			pw.println(serialNum);
			CellPhone c = new CellPhone(serialNum, brand, price, year);

			if (!cl.contains(serialNum)) {
				cl.addToStart(c);
			}
		}
		sc1.close();
		pw.close();
		System.out.println(cl);

		System.out.println("");
		System.out.println("Test copy constructor for CellList Method.");
		System.out.println("---------------------------------");
		CellList temp1 = new CellList(cl);
		System.out.println(temp1);

		System.out.println("");
		System.out.println("Test equals for CellList Method.");
		System.out.println("---------------------------------");
		if (cl.equals(temp1)) {
			System.out.println("Two CellList are equals. ");
		} else {
			System.out.println("Two CellList are NOT equals. ");
		}

		System.out.println("");
		System.out.println("Task 2: Prompt the user to enter a few serial numbers and search the list. ");
		System.out.println("===========================================================");

		System.out.println("");
		System.out.println("Test clone() Method in CellPhone.");
		System.out.println("---------------------------------");
		CellPhone c1 = new CellPhone(435978, "XiaoMi", 876.38, 2024);
		CellPhone c2 = null;
		System.out.println(c1);
		System.out.println("Please enter Serial Number to clone the cellphone:");
		long sn = sc.nextLong();
		try {
			c2 = c1.clone(sn);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("Clone c1:");
		System.out.println(c2);

		System.out.println("");
		System.out.println("Test find() Method.");
		System.out.println("---------------------------------");
		System.out.println("Please enter Serial Number to find the cellphone:");
		sn = sc.nextLong();
		CellList temp = new CellList();
		temp.setHead(cl.find(sn));
		System.out.println(temp);

		System.out.println("");
		System.out.println("Task 3: Test the rest Methods. ");
		System.out.println("===========================================================");

		System.out.println("");
		System.out.println("Test AddToStart() Method.");
		System.out.println("---------------------------------");

		cl1.addToStart(c1);
		System.out.println(cl1);

		System.out.println("");
		System.out.println("Test DeletFromStart() Method.");
		System.out.println("---------------------------------");
		cl1.deleteFromStart();
		System.out.println(cl1);

		System.out.println("");
		System.out.println("Test InsertAtIndex() Method: beginning, middle and the end of CellList.");
		System.out.println("---------------------------------");
		System.out.println("");
		cl.insertAtIndex(c1, 0);
		cl.insertAtIndex(c1, 5);
		cl.insertAtIndex(c1, cl.getSize() - 1);
		System.out.println(cl);

		System.out.println("");
		System.out.println("Test DeleteFromIndex() Method: beginning, middle and the end of CellList.");
		System.out.println("---------------------------------");
		cl.deleteFromIndex(0);
		cl.deleteFromIndex(4);
		cl.deleteFromIndex(cl.getSize() - 1);
		System.out.println(cl);

		System.out.println("");
		System.out.println("Test ReplaceAtIndex() Method: beginning, middle and the end of CellList.");
		System.out.println("---------------------------------");
		cl.replaceAtIndex(c1, 0);
		cl.replaceAtIndex(c1, 5);
		cl.replaceAtIndex(c1, cl.getSize() - 1);
		System.out.println(cl);

		sc.close();
		System.out.println("");
		System.out.println("========================");
		System.out.println("CellListUtilization terminates.");
	}

}
