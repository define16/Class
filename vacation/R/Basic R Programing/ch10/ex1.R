#library(wordcloud);
#library(KoNLP);
#library(NIADic);
#library(Sejong);
#useNIDic();
#useSejongDic();
#library(RColorBrewer)

# 텍스트를 줄단위로 읽ㄱ
setwd("D:/Programing Folder/R/Class/Edwith/ch10/Data") # 폴더 주소 입력
proper_noun <- c('문대통령','문재인');
set_proper_noun <- data.frame(proper_noun, tag='ncn');
dics <- c("Sejong","insigher","woorimalsam");

news <- readLines("ch10_1_news.txt")

#news <- gsub("문재인 대통령", "문대통령", news);
#news <- gsub("文대통령",문대통령",news);

# 텍스트 전처리하기
#buildDictionary(dics,"",set_proper_noun,replace_usr_dic = TRUE)
#buildDictionary(dic,"",user_dic=data.frame(), replace_usr_dic = TRUE)
buildDictionary("DIADic","",data.frame("문대통령","ncn")) # 문대통령을 명사로 추가
buildDictionary("DIADic","",set_proper_noun,replace_usr_dic = TRUE) # 문대통령을 명사로 추가

noun1 <- extractNoun(news)
noun2 <- unlist(noun1)
# noun2에서 단어의 글자 수가 2이상인 단어 추출
noun3 <- noun2[nchar(noun2) >= 2]

# 단어의 빈도수 계산
nounCount1 <- table(noun3)
nounCount <- head(sort(nounCount1, decreasing = TRUE), 15)
print(nounCount)

#워드클라우드를 컬러로 바꾸기
palete <- brewer.pal(9,"Set1")
# wordCloud 형태로 보기(흑백)
wordcloud(names(nounCount),
          freq = nounCount,
          scale =  c(4,1),
          rot.per = 0.25,
          min.freq = 2,
          random.order = FALSE, random.color = TRUE, colors = palete)


