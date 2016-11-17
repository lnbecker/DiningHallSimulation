public class Customer {
   private int arrivalTime;
   private int serviceTime;
   public Cashier cashier;
   private static ItemDistribution dstType;
   
   public Customer(int t, Cashier cashiertype, String type, int itemRange) {
      arrivalTime = t;
      cashier = cashiertype;
      if (type=="b")
    	  dstType = new Bimodal(itemRange);
      else //defaults to uniform distribution
    	  dstType = new Uniform(itemRange);
      serviceTime = 2*dstType.getItems()+10;
      
   }
   
   public void elapseOneSecond() {
   		serviceTime = cashier.elapseASecond(serviceTime);
   }
   
   public boolean isFinished() {
   		return serviceTime == 0;
   }
   
   public int arrivalTime() {
      return arrivalTime;
   }
}