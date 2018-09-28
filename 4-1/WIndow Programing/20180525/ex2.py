name = input("이름을 입력하세요 : ");
kor = input("국어점수를 입력하세요 : ")
eng = input("영어점수를 입력하세요 : ")
mth = input("수학점수를 입력하세요 : ")

outFp = open("data2.txt", "w", encoding="UTF-8")

outFp.writelines(name + "  " + kor +  "  "  + eng + "  " + mth)

outFp.close()

print("--- 정상적으로 파일에 씀 ---")