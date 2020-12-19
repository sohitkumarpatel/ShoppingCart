package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class ProductBean implements Serializable{
   
	private String pcode,pName;
	private int pQty;
	public ProductBean() {}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	
	
	
}
