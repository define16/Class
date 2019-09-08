package beans;

public class check {

	String agreeable;
	String disagreeable;
	int agree;
	int disagree;
	
	public void parseInt_s() {
		if(agreeable == "") {
			agree = 0;
			disagree = 1;
		}
		else if(disagreeable == "") {
			disagree = 0;
			agree = 1;
		}

	}
	
	public String getAgreeable() {
		return agreeable;
	}

	public void setAgreeable(String agreeable) {
		this.agreeable = agreeable;
	}

	public String getDisagreeable() {
		return disagreeable;
	}

	public void setDisagreeable(String disagreeable) {
		this.disagreeable = disagreeable;
	}

	public int getAgree() {
		return agree;
	}

	public void setAgree(int agree) {
		this.agree = agree;
	}

	public int getDisagree() {
		return disagree;
	}

	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}

}
