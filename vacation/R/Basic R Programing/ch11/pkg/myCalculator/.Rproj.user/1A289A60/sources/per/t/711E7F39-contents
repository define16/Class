url <- "http://media.daum.net/ranking/popular"
#html에 접근
daumSrc <- read_html(url)
print(daumSrc)
#요소에 접근
rankNewsTagTemp <- html_nodes(daumSrc,".tit_thumb")
rankNewsTag <- html_nodes(rankNewsTagTemp,".link_txt")
print(rankNewsTag)

rankNewsText <- html_text(rankNewsTag)
print(rankNewsText)
