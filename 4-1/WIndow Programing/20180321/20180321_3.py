score = int(input("1. 이수한 학점을 입력하세요 : "));
avg = float(input("2. 평점을 입력하세요 : "));

if score < 140 or avg < 2.0 :
    print("학생은 졸업이 힘들겠습니다.");
else :
    print("졸업이 가능합니다");
