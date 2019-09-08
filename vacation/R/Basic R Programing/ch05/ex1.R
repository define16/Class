# 리스트는 하나의 객체를 관리하는데 주로 사용한다.
# 데이터프레임은 여러개의 객체를 관리하는데 주로 사용한다.
stuOneData <- list(Number = 1, Name = "김철수", scoKor=60, scoEng=50,scoMat=70, grade="D")
stuOneData$scoEng <- 60 # 기존 리스트의 영어항목에 대입하여 데이터 수정
stuOneData$scoSci <- 90 # 과학 성적  추가, 기존에 없는 항목에 값을 대입할 경우 추가됨
stuOneData$grade <- NULL # 기존 리스트 항목에 Null 값을 대입하면 삭제