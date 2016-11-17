import java.util.Comparator;

public class CompareByWaitTime implements Comparator<CashRegister> {

	public int compare(CashRegister r1, CashRegister r2){ //ascending wait Time
		int waitTime1 = r1.avgWaitTime();
		int waitTime2 = r2.avgWaitTime();
		if (waitTime1 > waitTime2)
			return 1;
		else if (waitTime1 < waitTime2)
			return -1;
		else
			return 0;
	}
}




