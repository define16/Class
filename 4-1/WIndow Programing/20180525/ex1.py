inFp = None;
InStr = "";
lineNum = 1;

inFp = open("data1.txt", "r", encoding="UTF-8");


while True :
    inList = inFp.readlines()
    if inList == "" :
        break;

    print(lineNum + ":" + inList[lineNum-1] , end="");
    lineNum += 1;




inFp.close();
