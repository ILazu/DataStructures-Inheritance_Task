package orderedStructures;

public class Geometric extends Progression {

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException {
		if (!checkFirstValue) throw new IllegalStateException("nextValue(): First value was not initialized");
			
		current = current * commonFactor; 
		return current;
	}

	@Override
	public String toString() {
		return "Geom(" + (int) super.getTerm(1) + ", " + (int) commonFactor + ")";
	}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		return Math.pow(commonFactor, n-1) * this.firstValue();
	}
	
	@Override
	public boolean equals(Object o) {
		Geometric p2 = (Geometric) o;
		return (this.firstValue() == p2.firstValue()) && (this.commonFactor == p2.commonFactor);
	}
}
