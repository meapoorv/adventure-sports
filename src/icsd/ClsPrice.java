package icsd;

public class ClsPrice {
String strPlnPrice;

public String getStrPlnPrice() {
	return strPlnPrice;
}

public void setStrPlnPrice(String strPlnPrice) {
	this.strPlnPrice = strPlnPrice;
}

@Override
public String toString() {
	return "ClsPrice [strPlnPrice=" + strPlnPrice + "]";
}

public ClsPrice() {
	super();
	// TODO Auto-generated constructor stub
}
public ClsPrice( String strPlnPrice) {
	super();
	this.strPlnPrice = strPlnPrice;

}}
