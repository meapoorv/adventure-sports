package icsd;

public class ClsPlan 
{
	String strPlanId,strPlanName,strDesc,strPrice;

	public ClsPlan() {
		super();
	}

	@Override
	public String toString() {
		return "ClsPlan [strPlanId=" + strPlanId + ", strPlanName=" + strPlanName + ", strDesc=" + strDesc
				+ ", strPrice=" + strPrice + "]";
	}

	public ClsPlan(String strPlanId, String strPlanName, String strDesc, String strPrice) {
		super();
		this.strPlanId = strPlanId;
		this.strPlanName = strPlanName;
		this.strDesc = strDesc;
		this.strPrice = strPrice;
	}

	public String getStrPlanId() {
		return strPlanId;
	}

	public void setStrPlanId(String strPlanId) {
		this.strPlanId = strPlanId;
	}

	public String getStrPlanName() {
		return strPlanName;
	}

	public void setStrPlanName(String strPlanName) {
		this.strPlanName = strPlanName;
	}

	public String getStrDesc() {
		return strDesc;
	}

	public void setStrDesc(String strDesc) {
		this.strDesc = strDesc;
	}

	public String getStrPrice() {
		return strPrice;
	}

	public void setStrPrice(String strPrice) {
		this.strPrice = strPrice;
	}
}
