import java.util.Comparator;
import java.util.*;

public class DiningHall {
	private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.
	private static int NUM_REGISTERS;        // There are N+M cash registers.

	private CashRegister[] registers;

	public DiningHall(int normalN, int fastN, String disType, int distSize) {
		NUM_REGISTERS = normalN + fastN; //could be any number of registers
		registers = new CashRegister[NUM_REGISTERS];
		for (int r=0; r<NUM_REGISTERS; r++){
			if (r<normalN){
				registers[r] = new CashRegister(r, "normal", disType, distSize);
			}
			else{
				registers[r] = new CashRegister(r, "fast", disType, distSize);
			}
		}
	}

	public void elapseOneSecond(int t) {
		if (aCustomerArrives()) {
			// The new customer goes into the smaller line.
			CashRegister chosenRegister = smallestLine(); 
			chosenRegister.addCustomer(t);
		}
		for (int r=0; r<NUM_REGISTERS; r++)
			registers[r].elapseOneSecond(t);  // Simulate each register for one second.
	}

	public void printStatistics(String sortType) {
		if ("w".equals(sortType)){ //sort by average wait time
			Comparator<CashRegister> cmp1 = new CompareByWaitTime();
			Arrays.sort(registers, cmp1);
		}
		if ("s".equals(sortType)){ //sort by number of customers served
			Comparator<CashRegister> cmp1 = new CompareByCustsServed();
			Arrays.sort(registers, cmp1);
		}
		for (int r=0; r<NUM_REGISTERS; r++) {
			CashRegister reg = registers[r];
			System.out.println("Register " + reg.whoAmI() + ": " + reg.getSpeed());
			System.out.println("\tNumber served = " + reg.customersServed());
			System.out.println("\tAverage wait time = " + reg.avgWaitTime());
		}
	}

		

	private boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}

	private CashRegister smallestLine() {
		CashRegister currentSmallest = registers[0];
		for (int r=1; r<NUM_REGISTERS; r++) {
			CashRegister cr = registers[r];
			if (cr.size() < currentSmallest.size())
				currentSmallest = cr;
		}
		return currentSmallest;	
	}
}
