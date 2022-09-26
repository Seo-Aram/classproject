package chapter08;

public class CalculatorMachine extends AbsCalculator {

	@Override
	public long add(long n1, long n2) {
		return n1 + n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1-n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}

	@Override
	public double divide(double n1, double n2) {
		if(n2 == 0) {
			System.out.println("나누는 값이 0이 될 수 없습니다.");
			return 0.0;
		}
		return n1 / n2;
	}

}
