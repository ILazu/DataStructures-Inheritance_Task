package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	private Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue() throws IllegalStateException {
		if (!checkFirstValue) throw new IllegalStateException("nextValue(): First value was not initialized");

        double temp = current;
        current += prev;
        prev = temp;
		
		return current;
	}
	
	@Override	
	public double firstValue() { 
		double value = super.firstValue(); 
		prev = 0; 
		return value; 
	}

	@Override
	public boolean equals(Object o) {
		Fibonacci p2 = (Fibonacci) o;
		return (this.firstValue() == p2.firstValue() && this.prev == p2.prev);
	}
}
