number <- seq(1:4)
name <- c("정우성","김철수", "송중기","김영희")
kor <- c(80, 60, 90, 70)
eng <- c(70, 50, 100, 80)
mat <- c(95, 70, 95, 80)
grade <- c("B", "D", "A", "C")
stuInfo <- data.frame(번호 = number, 이름 = name, 국어 = kor, 영어 = eng, 수학 = mat, 등급 = grade, stringsAsFactors = FALSE)
#태그값으로 이름 설정시 태그를 쓰기, 만약 안쓰면 변수명을 입력
stuInfo$국어[3] <- 85 # 3번학생의 점수를 수정
stuInfo[3,3] <- 90 # 3번학생의 3번째 과목의 점수를 수정
scoKor <- stuInfo$국어 # 국어 점수를 추출하여 변수에 저장
stuOne <- stuInfo[3,] # 3번 학생 데이터를 추출하여 변수 벡터에 저장
scores <- stuInfo[,c(3:5)] # 국어, 영어, 수학 세 과목 성정을 변수 데이터 프레임에 저장
students <- stuInfo[c(2:3),] # 2번과 3번 학생 데이터를 추출하여 변수 데이터 프레임에 저장

res <- stuInfo["이름"]; print(res)