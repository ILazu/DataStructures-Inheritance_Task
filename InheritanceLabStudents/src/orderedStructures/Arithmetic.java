package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable{
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException {
		if (!checkFirstValue) throw new IllegalStateException("nextValue(): First value was not initialized");

		current = current + commonDifference; 
		return current;
	}

	@Override
	public String toString() {
		return "Arith(" + (int) super.getTerm(1) + ", " + (int) commonDifference + ")";
	}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		return this.firstValue() + (n-1)*commonDifference;
	}
	
	@Override
	public boolean equals(Object o) {
		Arithmetic p2 = (Arithmetic) o;
		return (this.firstValue() == p2.firstValue()) && (this.commonDifference == p2.commonDifference);
	}

	@Override
	public Progression add(Progression other) {
		Arithmetic p2 = (Arithmetic) other;
		double nFirst = this.firstValue() + p2.firstValue();
		double nDifference = this.commonDifference + p2.commonDifference;
		Arithmetic result = new Arithmetic(nFirst, nDifference);
		return result;
	}
}
