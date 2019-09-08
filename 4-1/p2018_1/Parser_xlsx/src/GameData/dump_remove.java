package GameData;
public class dump_remove {
	public boolean Englishs(String s) {
		if(s.matches("^[a-zA-Z]*$"))
			return true;
		else
			return false;

	}
	public boolean Chinese_Character(String target) {
		String regEx = ".*[\u2e80-\u2eff\u31c0-\u31ef\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fbf\uf900-\ufaff].*";

		if (target.matches(regEx)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isStringDouble(String s) {
		if(s.matches(".*[0-9].*")) {
			return true;
		}
		else
			return false;

	}

	public boolean Month_name(String s) {
		if(s.contains("March")|| s.contains("April")|| s.contains("February")
				|| s.contains("January")|| s.contains("December")|| s.contains("November")
				|| s.contains("October")|| s.contains("September")|| s.contains("August")
				|| s.contains("July")|| s.contains("June")|| s.contains("May")) {
			
			return true;
		}
		else {
			return false;
		}
	}
	public int Month_collection(String s) {
		int bungi = 0;
		if(s.contains("February") || s.contains("January") || s.contains("March"))
			bungi= 1;
		else if(s.contains("April")||s.contains("May")|| s.contains("June"))
			bungi= 2;
		else if(s.contains("September")|| s.contains("August")|| s.contains("July"))
			bungi= 3;
		else if(s.contains("December")|| s.contains("November")|| s.contains("October"))
			bungi= 4;

		return bungi;

	}
	public boolean Korean(String s) {
		if(s.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {

			return true;

		} else {
			return false;
		}

	}
	public String comas (String s) {
		int count = 0;
		String temp = null;
		if(s.contains(",")) {
			for(int i = 0; i < s.length(); i++)
				if(s.equals(","))
					count ++;

		}
		System.out.println(" < "+count + " >" );

		if(count == 0)
			temp = s;
		else if(count == 1)
			temp = s.split(",")[1];
		else if(count == 2)
			temp = s.split(",")[2];
		return temp;
	}
}
