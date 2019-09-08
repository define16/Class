# 전자제품 코드에서 위치 1 ~ 5까지의 문자열만 추출
elec_code <- substr("LEDTV-48-B",1,5); print(elec_code)
#문자열을 분할
list_word <- strsplit("7-24-2017",split = "-"); print(list_word)
 #벡터로 변환
vec_word <- unlist(list_word); print(vec_word)
# .을 구분자로 반호로 분할 fixed옵션으로 지
list_word <- strsplit("7.24.2017",split = ".", fixed = TRUE); print(list_word)
# .을 구분자로 단위로 분할
list_word <- strsplit("7.24.2017",split = "\\."); print(list_word)
#문자열 붙이기 
pword <- paste("2017", "5","30"); print(pword)
#문자열에 -을 붙이기 
pword <- paste("2017", "5","30", sep = "-"); print(pword)

txt <- " Text Analytics is useful. Text Analytics is also interesting"
#txt안에 있는 Text중 처음 부분만 대체
new_txt <- sub("Text", "Data", txt); print(new_txt)
#txt안에 있는 Text를 모두 변경해준다.
new_txt <- gsub("Text", "Data", txt); print(new_txt)
# 모두 소문자
small_txt <- tolower(txt); print(small_txt)
# 모두 대문자로
capital_txt <- toupper(txt); print(capital_txt)