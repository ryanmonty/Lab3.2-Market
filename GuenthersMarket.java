import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GuenthersMarket {
	
	private static Scanner scnr;
	private static Map<String, Double> items = new TreeMap<>();
	private static List<String> orderNames = new ArrayList<>();
	private static List<Double> orderPrices = new ArrayList<>();
	
	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		fillItemsMap();
		printMenu();
		System.out.println();
		userOrder(orderNames, orderPrices);
		
		scnr.close();

	}
	
	private static void fillItemsMap() {
		items.put("mango", .99);
		items.put("starfruit", 2.25);
		items.put("lychee", .40);
		items.put("durian", 5.69);
		items.put("dragon fruit", 5.99);
		items.put("persimmon", 2.99);
		items.put("guava", 1.82);
		items.put("prickly pear", 3.80);
	}

	private static void printMenu() {
		System.out.printf("%-15s%-15s%n","Item", "Price");
		System.out.println("=====================");
		
		for (Map.Entry<String, Double> entry : items.entrySet()) {
            System.out.printf("%-15s%-15s%n",entry.getKey(), "$"+entry.getValue());
		}
		System.out.println("What item would you like to order? ");
	}
	
	private static void userOrder(List<String> orderNames, List<Double> orderPrices) {
		
		while(items != null) {
		String itemName = scnr.next();
		Double itemPrice = items.get(itemName);
		
		
			if(items.containsKey(itemName)) {
				orderNames.add(itemName);
				orderPrices.add(itemPrice);
				System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
				System.out.println("Would you like to order anything else? (y/n) ");
			}
			else {
				System.out.println("We don't carry that item");
				System.out.println("What item would you like to order? ");
				userOrder(orderNames, orderPrices);
			}
		
		
		String answer = scnr.next();
		
		if(answer.equalsIgnoreCase("y")) {
			printMenu();
			continue;
		}
		else if(answer.equalsIgnoreCase("n")) {
			receipt();
			break;
		}
		else {
			System.out.println("Great, now you have to restart. Please follow the directions");
			break;
		}
		}
	}
	private static void receipt() {
		System.out.println("Thanks for your order! \nHere's what you got: ");
		for(int i=0; i < orderNames.size(); i++) {
			System.out.printf("%-15s%-15s%n",orderNames.get(i), "$"+orderPrices.get(i));
		}
		average();
		max();
		min();
	}
	
	private static void average() {
		double sum = 0;
		
		for(int i = 0; i < orderPrices.size(); i++)
		    sum += orderPrices.get(i);
		
		double avg = (sum / orderNames.size());
		
		System.out.println("Average price per item in order was $" + avg);
	}
	
	private static void max() {
		Double max = Collections.max(orderPrices);
		System.out.println("Highest priced item is $" + max);

	}
	private static void min() {
		Double max = Collections.min(orderPrices);
		System.out.println("Lowest priced item is $" + max);
		
	}
}
	
	
