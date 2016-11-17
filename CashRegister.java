import java.util.*;

public class CashRegister { 
	private int whoami;  // identifies the cash register
	private List<Customer> custs = new LinkedList<Customer>();
	private int numServed = 0;
	private int totalWaitTime = 0;
	public Customer currentCust = null;
	private Cashier cashier; //
	private static String distType;
	private static int itemRange;
	private String mySpeed;

	public CashRegister(int n, String speed, String type, int distSize) { //added parameter
		whoami = n;
		distType = type;
		itemRange = distSize;
		mySpeed=speed;
		if (speed=="normal") //tells cash register how fast cashier is and creates object accordingly
			cashier = new NormalSpeed();
		else
			cashier = new Fast();
	}
	
	public void addCustomer(int t) {
		Customer c = new Customer(t, cashier, distType, itemRange); //Customer now takes two arguments to know speed of cashier
		custs.add(c);
		if (currentCust == null)
			currentCust = c;
	}

	public void elapseOneSecond(int currentTime){
		// Return if there is no current customer.
		if (currentCust == null)
			return;

		// Otherwise, process the current customer.
		currentCust.elapseOneSecond();
		if (currentCust.isFinished()) {
			numServed++;
			totalWaitTime += currentTime - currentCust.arrivalTime();

			// Remove the finished customer and make the next customer current.
			custs.remove(0);
			currentCust = custs.size() > 0 ? custs.get(0) : null;
		}
	}

	public int size() { 
		return custs.size(); 
	}

	public int customersServed() { 
		return numServed; 
	}

	public int avgWaitTime() { 
		return totalWaitTime / numServed; 
	}
	
	public int whoAmI() {
		return whoami;
	}
	
	public String getSpeed(){
		return mySpeed;
	}
}
