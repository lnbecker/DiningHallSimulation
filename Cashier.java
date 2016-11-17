
public interface Cashier {
	public int elapseASecond(int st); //returns new serviceTime to customer
	public String identifyMyself();
	
}

class NormalSpeed implements Cashier{
	private String cashierType = "normal";
	
	public int elapseASecond(int serviceTime){
	     serviceTime--;
	     return serviceTime;
	}
	
	public String identifyMyself(){
		return cashierType;
	}
	
}


class Fast implements Cashier{
	private String cashierType = "fast";
	
	public int elapseASecond(int serviceTime){
		serviceTime-=2; //because class does things twice as fast;
		return serviceTime;
	}
	
	public String identifyMyself(){
		return cashierType;
	}
}
