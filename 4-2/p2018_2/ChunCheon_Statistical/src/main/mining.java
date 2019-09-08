package main;

public class mining {
	//문자 구별
	public boolean isEnglishs(String s) {
		if (s.matches("^[a-zA-Z]*$"))
			return true;
		else
			return false;
	}

	public boolean isStringDouble(String s) {
		if (s.matches(".*[0-9].*")) {
			return true;
		} else
			return false;
	}
	
	public boolean isHyphen(String s) {
		if (s.contains("-")) {
			return true;
		} else
			return false;
	}
	
	public boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
}
