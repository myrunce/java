
public class Calculator implements java.io.Serializable{
	private int op1;
	private String op;
	private int op2;
	private int result;
	
	public Calculator(int oper1, String oper, int oper2) {
		this.op1 = oper1;
		this.op = oper;
		this.op2 = oper2;
	}
	
	public Calculator() {
		
	}
	
	public int getOp1() {
		return this.op1;
	}
	
	public String getOp() {
		return this.op;
	}
	
	public int getOp2() {
		return this.op2;
	}
	
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	
	public void setOp(String op) {
		this.op = op;
	}
	
	public void performOperation(){
		if (this.op == "+") {
			result = op1 + op2;
		}
		else if (this.op == "-") {
			result = this.op1 - this.op2;
		}
	}
	
	public int getResults() {
		return result;
	}
}
