import java.util.*;

public interface ItemDistribution {
	public int getItems();
}

class Uniform implements ItemDistribution{
	int range;
	
	public Uniform(int n){
		range = n;
	}
	
	public int getItems(){
		 int howmanyItems = 1 + (int)(Math.random() * range);
		 return howmanyItems;
		 
	}
	
}

class Bimodal implements ItemDistribution{
	int range;
	
	public Bimodal(int n){
		range = n;
	}
	
	//to generate random number between inclusive range: ((max - min) + 1) + min;
	public int getItems(){
		Random r = new Random();
		int smallOrLarge = r.nextInt((2 - 1) + 1) + 1; //generates either integers 1 or 2
		Random itemNumber = new Random();
		int howmanyItems;
		if (smallOrLarge==2){
			howmanyItems = itemNumber.nextInt((range - ((3*range)/4) + 1) + ((3*range)/4));
		}
		else{ //automatically normal distribution
			howmanyItems = itemNumber.nextInt(((range/4) - 1) + 1) + 1;
		}
		return howmanyItems;
	}
	
}