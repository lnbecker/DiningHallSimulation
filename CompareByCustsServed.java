import java.util.Comparator;

public class CompareByCustsServed implements Comparator<CashRegister> {
	
	public int compare(CashRegister r1, CashRegister r2){ //descending customers served
		int custsServed1 = r1.customersServed();
		int custsServed2 = r2.customersServed();
		if (custsServed1 > custsServed2)
			return -1;
		else if (custsServed1 < custsServed2)
			return 1;
		else
			return 0;
	}
}
