package icsd;

public class ClsProduct1 {

		String strsptid,strsptname,strdesp,strsploc,strimg;
		public ClsProduct1(){
			
		}

		public ClsProduct1(String strsptid,String strsptname,String strdesp,String strsploc,String strimg){
			super();
			this.strsptid=strsptid;
			this.strsptname=strsptname;
			this.strdesp=strdesp;
			this.strsploc=strsploc;
			this.strimg=strimg;
		}

		public String getStrsptid() {
			return strsptid;
		}

		public void setStrsptid(String strsptid) {
			this.strsptid = strsptid;
		}

		public String getStrsptname() {
			return strsptname;
		}

		public void setStrsptname(String strsptname) {
			this.strsptname = strsptname;
		}

		public String getStrdesp() {
			return strdesp;
		}

		public void setStrdesp(String strdesp) {
			this.strdesp = strdesp;
		}

		public String getStrsploc() {
			return strsploc;
		}

		public void setStrsploc(String strsploc) {
			this.strsploc = strsploc;
		}

		public String getStrimg() {
			return strimg;
		}

		public void setStrimg(String strimg) {
			this.strimg = strimg;
		}
	
}
