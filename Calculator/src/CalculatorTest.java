
public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
        c.setOp1(10);
        c.setOp("+");
        c.setOp2(5);
        c.performOperation();
        int result = c.getResults();
        System.out.println(result);
	}

}
