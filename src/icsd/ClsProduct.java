package icsd;

public class ClsProduct {
String strplnid,strplnname,strdesp,strprice;
public ClsProduct(){
	
}

public ClsProduct(String strplnid,String strplnname,String strdesp,String strprice){
	super();
	this.strplnid=strplnid;
	this.strplnname=strplnname;
	this.strdesp=strdesp;
	this.strprice=strprice;
}
public String toString(){
	return "ClsProduct[strplnid="+strplnid+",strplnname="+strplnname+",strdesp="+strdesp+",strprice="+strprice+"]";
}

public String getStrplnid() {
	return strplnid;
}

public void setStrplnid(String strplnid) {
	this.strplnid = strplnid;
}

public String getStrplnname() {
	return strplnname;
}

public void setStrplnname(String strplnname) {
	this.strplnname = strplnname;
}

public String getStrdesp() {
	return strdesp;
}

public void setStrdesp(String strdesp) {
	this.strdesp = strdesp;
}

public String getStrprice() {
	return strprice;
}

public void setStrprice(String strprice) {
	this.strprice = strprice;
}
}
