package icsd;

public class ClsSports 
{
	String strSportId,strSportname,strDescription,strLocation,strImage;

	
	@Override
	public String toString() {
		return "ClsSports [strSportId=" + strSportId + ", strSportname=" + strSportname + ", strDescription="
				+ strDescription + ", strLocation=" + strLocation + ", strImage=" + strImage + "]";
	}

	public ClsSports() {
		super();
	}

	public ClsSports(String strSportId, String strSportname, String strDescription, String strLocation,
			String strImage) {
		super();
		this.strSportId = strSportId;
		this.strSportname = strSportname;
		this.strDescription = strDescription;
		this.strLocation = strLocation;
		this.strImage = strImage;
	}

	public String getStrSportId() {
		return strSportId;
	}

	public void setStrSportId(String strSportId) {
		this.strSportId = strSportId;
	}

	public String getStrSportname() {
		return strSportname;
	}

	public void setStrSportname(String strSportname) {
		this.strSportname = strSportname;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}

	public String getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}
	
}
