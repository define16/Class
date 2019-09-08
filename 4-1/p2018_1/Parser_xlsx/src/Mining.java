import java.util.ArrayList;

public class Mining {

	private String[] newKeyword;
	private String[] count_string;

	static String remove_word[] = { "새해", "전년", "신년", "모양새", "행사", "확인", "가격", "다량", "이동", "관심", "여유", "계획", "내년", "한편",
			"당장", "포함", "이달", "얘기", "금액", "육박", "달러", "회의장", "명성", "신청", "그동안", "걱정", "구매", "시작", "일주일", "기준", "면적",
			"고사리", "도라지", "나물", "한우", "돼지고기", "계란", "동시", " " };
	// String remove_number[]= {};

	public String[] getNewKeyword() {
		return newKeyword;
	}

	public void setNewKeyword(String[] newKeyword) {
		this.newKeyword = newKeyword;
	}

	public String[] getCount_string() {
		return count_string;
	}

	public void setCount_string(String[] count_string) {
		this.count_string = count_string;
	}

	public ArrayList<String[]> repeated_NoQuarter(ArrayList<String[]> dataSet) {
		ArrayList<String[]> newKeySet = new ArrayList<String[]>();

		ArrayList<String> tempKey = new ArrayList<String>();
		ArrayList<String[]> tempKeySet = new ArrayList<String[]>();
		ArrayList<String> tempYear = new ArrayList<String>();
		ArrayList<String[]> tempYearSet = new ArrayList<String[]>();
		ArrayList<String> tempQuarter = new ArrayList<String>();
		ArrayList<String[]> tempQuarterSet = new ArrayList<String[]>();
		ArrayList<String> tempCategory = new ArrayList<String>();
		ArrayList<String[]> tempCategorySet = new ArrayList<String[]>();

		ArrayList<String[]> year_temp = new ArrayList<String[]>();
		ArrayList<String[]> quarter_temp = new ArrayList<String[]>();
		ArrayList<String[]> category_temp = new ArrayList<String[]>();
		ArrayList<String[]> keyword_temp = new ArrayList<String[]>(); // 보류
		ArrayList<String[]> count_temp = new ArrayList<String[]>();

		String[] year = null;
		String[] quarter = null;
		String[] category = null;
		String[] keyword = null;
		String[] count = null;

		String[] year_temp1 = null;
		String[] quarter_temp1 = null;
		String[] category_temp1 = null;
		String[] keyword_temp1 = null;
		String[] count_temp1 = null;

		String[] oldkeyword = null;

		String[] temp = null;
		int[] count_int = null;

		String checkQuarter = "4";
		int num = 0;
		int index = 0;

		System.out.println("마이닝 시작");
		
		for (int i = 0; i < dataSet.size(); i += 5) { // 이형태로 바꾸기
			oldkeyword = new String[dataSet.get(i).length];
			year_temp1 = new String[dataSet.get(i).length];
			quarter_temp1 = new String[dataSet.get(i).length];
			category_temp1 = new String[dataSet.get(i).length];
			count_temp1 = new String[dataSet.get(i).length];

			for (int j = 0; j < dataSet.get(i).length; j++) {
				oldkeyword[j] = dataSet.get(i + 3)[j];
				year_temp1[j] = dataSet.get(i)[j];
				quarter_temp1[j] = dataSet.get(i + 1)[j];
				category_temp1[j] = dataSet.get(i + 2)[j];
				count_temp1[j] = dataSet.get(i + 3)[j];
			}

			// 분기별로 데이터를 나눔.
			for (int k = 0; k < oldkeyword.length; k++) {
				tempKey.add(oldkeyword[k]);
				tempYear.add(year_temp1[k]);
				tempQuarter.add(quarter_temp1[k]);
				tempCategory.add(category_temp1[k]);
			}
			
		} // for dataSet.size() END
		
		keyword = new String[tempKey.size()];
		year = new String[tempYear.size()];
		quarter = new String[tempQuarter.size()];
		category = new String[tempCategory.size()];

		for (int l = 0; l < tempKey.size(); l++) {
			keyword[l] = tempKey.get(l);
			year[l] = tempYear.get(l);
			quarter[l] = tempQuarter.get(l);
			category[l] = tempCategory.get(l);
		}

		tempKeySet.add(keyword);
		year_temp.add(year);
		quarter_temp.add(quarter);
		category_temp.add(category);

		//System.out.println("분기별로 나누기 끝");
		
		oldkeyword = null;
		year_temp1 = null;
		quarter_temp1 = null;
		category_temp1 = null;
		count_temp1 = null;

		//System.out.println("데이터 정제중");
		for (int i = 0; i < tempKeySet.size(); i++) {
			keyword_temp1 = new String[tempKeySet.get(i).length];

			for (int j = 0; j < tempKeySet.get(i).length; j++) {
				keyword_temp1[j] = tempKeySet.get(i)[j];
			}

			year_temp1 = new String[keyword_temp1.length];
			quarter_temp1 = new String[keyword_temp1.length];
			category_temp1 = new String[keyword_temp1.length];
			count_temp1 = new String[keyword_temp1.length];
			count_int = new int[keyword_temp1.length];
			temp = new String[keyword_temp1.length];

			for (int j = 0; j < keyword_temp1.length; j++) {

				count_int[j] = 1;
				if (keyword_temp1[j].equals("0a0")) {
					continue;
				}

				for (int a = 0; a < tempKeySet.get(i).length; a++) {
					if (keyword_temp1[j].equals(keyword_temp1[a]) && j != a) {
						count_int[j] += 1;
						temp[j] = keyword_temp1[a];
						keyword_temp1[a] = "0a0";
					}
				}
				
//				System.out.println(temp[j]);

			}

			// for (int j = 0; j < keyword_temp1.length; j++)
			// System.out.println("temp : " + temp[j] + "\t빈도수 : " + count_int[j]);

			System.out.println("null 없애중!");

			num = 0;
			for (int a = 0; a < tempKeySet.get(i).length; a++) {
				if (temp[a] != null) {
					// System.out.println(num);
					year_temp1[num] = year_temp.get(i)[a];
					quarter_temp1[num] = quarter_temp.get(i)[a];
					category_temp1[num] = category_temp.get(i)[a];
					keyword_temp1[num] = temp[a];
					count_temp1[num] = String.valueOf(count_int[a]);
					num++;
				}
			}
			// System.out.println("for문 끝 " + num);

			year = new String[num];
			quarter = new String[num];
			category = new String[num];
			keyword = new String[num];
			count = new String[num];

			for (int a = 0; a < num; a++) {
				// System.out.println("for문 다른 " + num);
				year[a] = year_temp1[a];
				quarter[a] = quarter_temp1[a];
				category[a] = category_temp1[a];
				keyword[a] = keyword_temp1[a];
				count[a] = count_temp1[a];

//				 System.out.println("메소드 안 - 연도 : " + year[a] + "\t 분기 : "+ quarter[a] +
//				 "\t카테고리 : "+ category[a] + "\t키워드 : "+ keyword[a] + "\t빈도수 : " + count[a]);
			}

			newKeySet.add(year);
			newKeySet.add(quarter);
			newKeySet.add(category);
			newKeySet.add(keyword);
			newKeySet.add(count);

		} // for tempKeySet.size() END

		// for (int i = 0; i < newKeySet.size(); i+=5) {
		// for (int j = 0; j < newKeySet.get(i).length; j++) {
		// System.out.print("메소드 안 - 연도 : " + newKeySet.get(i)[j]);
		// System.out.print("\t분기 : " + newKeySet.get(i + 1)[j]);
		// System.out.print("\t종류 : " + newKeySet.get(i + 2)[j]);
		// System.out.print("\t키워드 : " + newKeySet.get(i + 3)[j]);
		// System.out.println("\t빈도수 : " + newKeySet.get(i + 4)[j]);
		// }
		// }

		return newKeySet;

	}

	public ArrayList<String[]> repeated(ArrayList<String[]> dataSet) {
		ArrayList<String[]> newKeySet = new ArrayList<String[]>();

		ArrayList<String> tempKey = new ArrayList<String>();
		ArrayList<String[]> tempKeySet = new ArrayList<String[]>();
		ArrayList<String> tempYear = new ArrayList<String>();
		ArrayList<String[]> tempYearSet = new ArrayList<String[]>();
		ArrayList<String> tempQuarter = new ArrayList<String>();
		ArrayList<String[]> tempQuarterSet = new ArrayList<String[]>();
		ArrayList<String> tempCategory = new ArrayList<String>();
		ArrayList<String[]> tempCategorySet = new ArrayList<String[]>();

		ArrayList<String[]> year_temp = new ArrayList<String[]>();
		ArrayList<String[]> quarter_temp = new ArrayList<String[]>();
		ArrayList<String[]> category_temp = new ArrayList<String[]>();
		ArrayList<String[]> keyword_temp = new ArrayList<String[]>(); // 보류
		ArrayList<String[]> count_temp = new ArrayList<String[]>();

		String[] year = null;
		String[] quarter = null;
		String[] category = null;
		String[] keyword = null;
		String[] count = null;

		String[] year_temp1 = null;
		String[] quarter_temp1 = null;
		String[] category_temp1 = null;
		String[] keyword_temp1 = null;
		String[] count_temp1 = null;

		String[] oldkeyword = null;

		String[] temp = null;
		int[] count_int = null;

		String checkQuarter = "4";
		int num = 0;
		int index = 0;

		// int pp = 0;

		for (int i = 0; i < dataSet.size(); i += 5) { // 이형태로 바꾸기
			oldkeyword = new String[dataSet.get(i).length];
			year_temp1 = new String[dataSet.get(i).length];
			quarter_temp1 = new String[dataSet.get(i).length];
			category_temp1 = new String[dataSet.get(i).length];
			count_temp1 = new String[dataSet.get(i).length];

			for (int j = 0; j < dataSet.get(i).length; j++) {
				oldkeyword[j] = dataSet.get(i + 3)[j];
				year_temp1[j] = dataSet.get(i)[j];
				quarter_temp1[j] = dataSet.get(i + 1)[j];
				category_temp1[j] = dataSet.get(i + 2)[j];
				count_temp1[j] = dataSet.get(i + 3)[j];
			}

			// 분기별로 데이터를 나눔.
			// System.out.println("oldkeyword.length : " + oldkeyword.length);
			for (int k = 0; k < oldkeyword.length; k++) {
				if (checkQuarter.equals(dataSet.get(i + 1)[k])) {
					tempKey.add(oldkeyword[k]);
					tempYear.add(year_temp1[k]);
					tempQuarter.add(quarter_temp1[k]);
					tempCategory.add(category_temp1[k]);

					// 마지막 분기 리스트에 저장
					if (k == oldkeyword.length - 1 && i == dataSet.size() - 5) {
						// System.out.println("분기바귐2");
						keyword = new String[tempKey.size()];
						year = new String[tempYear.size()];
						quarter = new String[tempQuarter.size()];
						category = new String[tempCategory.size()];

						for (int l = 0; l < tempKey.size(); l++) {
							keyword[l] = tempKey.get(l);
							year[l] = tempYear.get(l);
							quarter[l] = tempQuarter.get(l);
							category[l] = tempCategory.get(l);
						}

						tempKeySet.add(keyword);
						year_temp.add(year);
						quarter_temp.add(quarter);
						category_temp.add(category);

						checkQuarter = dataSet.get(i + 1)[0];

						tempKey = new ArrayList<String>();
						tempYear = new ArrayList<String>();
						tempQuarter = new ArrayList<String>();
						tempCategory = new ArrayList<String>();

						tempKey.add(oldkeyword[k]);
						tempYear.add(year_temp1[k]);
						tempQuarter.add(quarter_temp1[k]);
						tempCategory.add(category_temp1[k]);
					}
				} else { // 분기가 바뀌면 리스트에 저장
					// pp++;
					// System.out.println(pp + " 분기바귐1");
					keyword = new String[tempKey.size()];
					year = new String[tempYear.size()];
					quarter = new String[tempQuarter.size()];
					category = new String[tempCategory.size()];

					for (int l = 0; l < tempKey.size(); l++) {
						keyword[l] = tempKey.get(l);
						year[l] = tempYear.get(l);
						quarter[l] = tempQuarter.get(l);
						category[l] = tempCategory.get(l);
					}

					tempKeySet.add(keyword);
					year_temp.add(year);
					quarter_temp.add(quarter);
					category_temp.add(category);

					checkQuarter = dataSet.get(i + 1)[0];

					tempKey = new ArrayList<String>();
					tempYear = new ArrayList<String>();
					tempQuarter = new ArrayList<String>();
					tempCategory = new ArrayList<String>();

					tempKey.add(oldkeyword[k]);
					tempYear.add(year_temp1[k]);
					tempQuarter.add(quarter_temp1[k]);
					tempCategory.add(category_temp1[k]);
				}
			}
			checkQuarter = dataSet.get(i + 1)[0];
		} // for dataSet.size() END

		// System.out.println( tempKeySet.size());
		// pp = 0;
		// for (int i = 0; i < tempKeySet.size(); i++) {
		// for (int j = 0; j < tempKeySet.get(i).length; j++) {
		// System.out.println("키워드 : " + tempKeySet.get(i)[j] + "\t분기 : " +
		// quarter_temp.get(i)[j]);
		// }
		// pp++;
		// System.out.println(pp+"------------------------------------------------------------");
		// }

		oldkeyword = null;
		year_temp1 = null;
		quarter_temp1 = null;
		category_temp1 = null;
		count_temp1 = null;

		for (int i = 0; i < tempKeySet.size(); i++) {
			keyword_temp1 = new String[tempKeySet.get(i).length];

			for (int j = 0; j < tempKeySet.get(i).length; j++) {
				keyword_temp1[j] = tempKeySet.get(i)[j];
			}

			year_temp1 = new String[keyword_temp1.length];
			quarter_temp1 = new String[keyword_temp1.length];
			category_temp1 = new String[keyword_temp1.length];
			count_temp1 = new String[keyword_temp1.length];
			count_int = new int[keyword_temp1.length];
			temp = new String[keyword_temp1.length];

			for (int j = 0; j < keyword_temp1.length; j++) {

				count_int[j] = 1;
				if (keyword_temp1[j].equals("0a0")) {
					continue;
				}

				for (int a = 0; a < tempKeySet.get(i).length; a++) {
					if (keyword_temp1[j].equals(keyword_temp1[a]) && j != a) {
						count_int[j] += 1;
						temp[j] = keyword_temp1[a];
						keyword_temp1[a] = "0a0";
					}
				}

			}

			// for (int j = 0; j < keyword_temp1.length; j++)
			// System.out.println("temp : " + temp[j] + "\t빈도수 : " + count_int[j]);

			System.out.println("null 없애중!");

			num = 0;
			for (int a = 0; a < tempKeySet.get(i).length; a++) {
				if (temp[a] != null) {
					// System.out.println(num);
					year_temp1[num] = year_temp.get(i)[a];
					quarter_temp1[num] = quarter_temp.get(i)[a];
					category_temp1[num] = category_temp.get(i)[a];
					keyword_temp1[num] = temp[a];
					count_temp1[num] = String.valueOf(count_int[a]);
					num++;
				}
			}
			// System.out.println("for문 끝 " + num);

			year = new String[num];
			quarter = new String[num];
			category = new String[num];
			keyword = new String[num];
			count = new String[num];

			for (int a = 0; a < num; a++) {
				// System.out.println("for문 다른 " + num);
				year[a] = year_temp1[a];
				quarter[a] = quarter_temp1[a];
				category[a] = category_temp1[a];
				keyword[a] = keyword_temp1[a];
				count[a] = count_temp1[a];

				// System.out.println("메소드 안 - 연도 : " + year[a] + "\t 분기 : "+ quarter[a] +
				// "\t카테고리 : "+ category[a] + "\t키워드 : "+ keyword[a] + "\t빈도수 : " + count[a]);
			}

			newKeySet.add(year);
			newKeySet.add(quarter);
			newKeySet.add(category);
			newKeySet.add(keyword);
			newKeySet.add(count);

		} // for tempKeySet.size() END

		// for (int i = 0; i < newKeySet.size(); i+=5) {
		// for (int j = 0; j < newKeySet.get(i).length; j++) {
		// System.out.print("메소드 안 - 연도 : " + newKeySet.get(i)[j]);
		// System.out.print("\t분기 : " + newKeySet.get(i + 1)[j]);
		// System.out.print("\t종류 : " + newKeySet.get(i + 2)[j]);
		// System.out.print("\t키워드 : " + newKeySet.get(i + 3)[j]);
		// System.out.println("\t빈도수 : " + newKeySet.get(i + 4)[j]);
		// }
		// }

		return newKeySet;

	}

	public boolean Englishs(String s) {
		if (s.matches("^[a-zA-Z]*$"))
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
		if (s.matches(".*[0-9].*") || s.contains(".")) {
			return true;
		} else
			return false;
	}

	public ArrayList<String[]> correlation(DB db, ArrayList<String[]> dataSet, String filename, String tableName) {
		
		ArrayList<String[]> newKeySet = new ArrayList<String[]>();

		ArrayList<String> tempKey = new ArrayList<String>();
		ArrayList<String[]> tempKeySet = new ArrayList<String[]>();
		ArrayList<String> tempYear = new ArrayList<String>();
		ArrayList<String> tempQuarter = new ArrayList<String>();
		ArrayList<String> tempCategory = new ArrayList<String>();

		ArrayList<String[]> year_temp = new ArrayList<String[]>();
		ArrayList<String[]> quarter_temp = new ArrayList<String[]>();
		ArrayList<String[]> category_temp = new ArrayList<String[]>();

		String[] year = null;
		String[] quarter = null;
		String[] category = null;
		String[] keyword = null;
		String[] count = null;

		String[] year_temp1 = null;
		String[] quarter_temp1 = null;
		String[] category_temp1 = null;
		String[] keyword_temp1 = null;
		String[] count_temp1 = null;

		String[] oldkeyword = null;

		String[] temp = null;
		int[] count_int = null;

		int num = 0;

		System.out.println("정제 시작");
		
		for (int i = 0; i < dataSet.size(); i += 5) { // 이형태로 바꾸기
			oldkeyword = new String[dataSet.get(i).length];
			year_temp1 = new String[dataSet.get(i).length];
			quarter_temp1 = new String[dataSet.get(i).length];
			category_temp1 = new String[dataSet.get(i).length];
			count_temp1 = new String[dataSet.get(i).length];

			for (int j = 0; j < dataSet.get(i).length; j++) {
				oldkeyword[j] = dataSet.get(i + 3)[j];
				year_temp1[j] = dataSet.get(i)[j];
				quarter_temp1[j] = dataSet.get(i + 1)[j];
				category_temp1[j] = dataSet.get(i + 2)[j];
				count_temp1[j] = dataSet.get(i + 3)[j];
			}

			// 분기별로 데이터를 나눔.
			for (int k = 0; k < oldkeyword.length; k++) {
				tempKey.add(oldkeyword[k]);
				tempYear.add(year_temp1[k]);
				tempQuarter.add(quarter_temp1[k]);
				tempCategory.add(category_temp1[k]);
			}
			
		} // for dataSet.size() END
		
		keyword = new String[tempKey.size()];
		year = new String[tempYear.size()];
		quarter = new String[tempQuarter.size()];
		category = new String[tempCategory.size()];

		for (int l = 0; l < tempKey.size(); l++) {
			keyword[l] = tempKey.get(l);
			year[l] = tempYear.get(l);
			quarter[l] = tempQuarter.get(l);
			category[l] = tempCategory.get(l);
		}

		tempKeySet.add(keyword);
		year_temp.add(year);
		quarter_temp.add(quarter);
		category_temp.add(category);

		//System.out.println("분기별로 나누기 끝");
		
		oldkeyword = null;
		year_temp1 = null;
		quarter_temp1 = null;
		category_temp1 = null;
		count_temp1 = null;

		//System.out.println("데이터 정제중");
		for (int i = 0; i < tempKeySet.size(); i++) {
			keyword_temp1 = new String[tempKeySet.get(i).length];

			for (int j = 0; j < tempKeySet.get(i).length; j++) {
				keyword_temp1[j] = tempKeySet.get(i)[j];
			}

			year_temp1 = new String[keyword_temp1.length];
			quarter_temp1 = new String[keyword_temp1.length];
			category_temp1 = new String[keyword_temp1.length];
			count_temp1 = new String[keyword_temp1.length];
			count_int = new int[keyword_temp1.length];
			temp = new String[keyword_temp1.length];

			for (int j = 0; j < keyword_temp1.length; j++) {

				count_int[j] = 1;
				if (keyword_temp1[j].equals("0a0") || keyword_temp1[j].equals(tableName)) {
					continue;
				}

				for (int a = 0; a < tempKeySet.get(i).length; a++) {
					if (keyword_temp1[j].equals(keyword_temp1[a]) && j != a) {
						count_int[j] += 1;
						temp[j] = keyword_temp1[a];
						keyword_temp1[a] = "0a0";
					}

				}
				
//				System.out.println(temp[j]);

			}

			// for (int j = 0; j < keyword_temp1.length; j++)
			// System.out.println("temp : " + temp[j] + "\t빈도수 : " + count_int[j]);

			//System.out.println("null 없애중!");

			num = 0;
			for (int a = 0; a < tempKeySet.get(i).length; a++) {
				if (temp[a] != null) {
					// System.out.println(num);
					year_temp1[num] = year_temp.get(i)[a];
					quarter_temp1[num] = quarter_temp.get(i)[a];
					category_temp1[num] = category_temp.get(i)[a];
					keyword_temp1[num] = temp[a];
					count_temp1[num] = String.valueOf(count_int[a]);
					num++;
				}
			}
			// System.out.println("for문 끝 " + num);

			year = new String[num];
			quarter = new String[num];
			category = new String[num];
			keyword = new String[num];
			count = new String[num];

			for (int a = 0; a < num; a++) {
				// System.out.println("for문 다른 " + num);
				year[a] = year_temp1[a];
				quarter[a] = quarter_temp1[a];
				category[a] = category_temp1[a];
				keyword[a] = keyword_temp1[a];
				count[a] = count_temp1[a];

//				 System.out.println("메소드 안 - 연도 : " + year[a] + "\t 분기 : "+ quarter[a] +
//				 "\t카테고리 : "+ category[a] + "\t키워드 : "+ keyword[a] + "\t빈도수 : " + count[a]);
			}

			newKeySet.add(year);
			newKeySet.add(quarter);
			newKeySet.add(category);
			newKeySet.add(keyword);
			newKeySet.add(count);

		} // for tempKeySet.size() END

//		 for (int i = 0; i < newKeySet.size(); i+=5) {
//		 for (int j = 0; j < newKeySet.get(i).length; j++) {
//		 System.out.print("메소드 안 - 연도 : " + newKeySet.get(i)[j]);
//		 System.out.print("\t분기 : " + newKeySet.get(i + 1)[j]);
//		 System.out.print("\t종류 : " + newKeySet.get(i + 2)[j]);
//		 System.out.print("\t키워드 : " + newKeySet.get(i + 3)[j]);
//		 System.out.println("\t빈도수 : " + newKeySet.get(i + 4)[j]);
//		 }
//		 }

		return newKeySet;

	}

	
	public String Find_Quarter(String date) {
		String quarter = null;
		// 분기 계산
		if (Integer.parseInt(date.substring(4, 6)) < 4) {
			quarter= "1";
		} else if (Integer.parseInt(date.substring(4, 6)) > 3
				&& Integer.parseInt(date.substring(4, 6)) < 7) {
			quarter = "2";
		} else if (Integer.parseInt(date.substring(4, 6)) > 6
				&& Integer.parseInt(date.substring(4, 6)) < 10) {
			quarter = "3";
		} else {
			quarter = "4";
		}
		
		return quarter;
	}
	
	public String Find_Category(String fileName) {
		String category = null;
		// 신문 분류
		if (fileName.indexOf("정치") != -1) {
			category = "0";
		} else if (fileName.indexOf("경제") != -1) {
			category = "1";
		} else if (fileName.indexOf("IT과학") != -1) {
			category = "2";
		} else if (fileName.indexOf("문화") != -1) {
			category = "3";
		} else if (fileName.indexOf("사회") != -1) {
			category = "4";
		}
		
		return category;
	}

}
