setwd("D:/Programing Folder/R/Class/Edwith/Basic R Programing/ch09/Data") # 폴더 주소 입력
lyrics <- readLines("ch9_2_jingle_bells.txt")

lyrics <- gsub(",","",lyrics)
lyrics <- gsub("\\.","",lyrics)
lyrics <- gsub("-"," ",lyrics)

#lyrics <- tolower(lyrics)
#lyricsWord <- strsplit(lyrics, " ")
#lyricsWordList <- unlist(lyricsWord)

symNotUsed <- c(",","\\.","-")
for (ch in symNotUsed) {
  lyrics <- gsub(ch, "", lyrics)
}
#print(lyricsWordList)

lyrics <- tolower(lyrics)
lyricsWord <- strsplit(lyrics, " ")
lyricsWordList <- unlist(lyricsWord)
print(lyricsWordList)

lyricsCount <- table(lyricsWordList)
lyricsCount <- sort(lyricsCount, decreasing = TRUE)
lyricsCount <- lyricsCount[lyricsCount >= 2]
print(lyricsWordList) 

 barplot(lyricsCount, horiz = TRUE, las = 1, xlim = c(0,7),
        col = "green", main = "Jingle bells"
        )

# 불용어를 삭제 tm패키지를 사용(removeWords)
lyricsWordLististNotUsed <- removeWords(lyricsWordList, stopwords("en"))

lyricsWordLististNotUsed <- lyricsWordLististNotUsed[nchar(lyricsWordLististNotUsed) >=1]
lyricsCountNotUsed <- table(lyricsWordLististNotUsed)
lyricsCountNotUsed <- sort(lyricsCountNotUsed, decreasing = TRUE)
lyricsCountNotUsed <- lyricsCountNotUsed[lyricsCountNotUsed >= 2]

barplot(lyricsCountNotUsed, horiz = TRUE, las = 2, xlim = c(0,7), col = "mediumseagreen", main = "Jingle bells")
 
 