package ups.edu.ec.Controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Calculadora {

	private int a;
	private int b;
	private int r;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public String sumar() {
		r=a+b;
		return null;
	}
}