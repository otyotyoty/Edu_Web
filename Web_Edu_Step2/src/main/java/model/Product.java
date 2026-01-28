package model;

public class Product {
	// 상품 목록을 보관할 배열
	private String[] productList = { "item1", "item2", "item3", "item4", "item5" };

	// 웹 테스트를 위한 변수값
	private int num1 = 10;
	private int num2 = 20;
	private int num3 = 30;
	private int num4 = 40;
	private int num5 = 50;
	
	public String[] getProductList() {
		return productList;
	}
	public void setProductList(String[] productList) {
		this.productList = productList;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public int getNum4() {
		return num4;
	}
	public void setNum4(int num4) {
		this.num4 = num4;
	}
	public int getNum5() {
		return num5;
	}
	public void setNum5(int num5) {
		this.num5 = num5;
	}
	
	
	
}
