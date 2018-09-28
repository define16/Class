import os
outFp = None
outStr = ""
inFp = None
inList, inStr = [], ""
num = 0;
fName = ""

fName = input("파일명을 입력하세요 : ")
if os.path.exists(fName):
    inFp = open(fName, "r")

    inList = inFp.readlines()
    for inStr in inList:
        outFp.writelines(inStr + "\n")

    inFp.close()
else:
    print("%s 파일이 없습니다." % fName)


outFp = open(fName, "w", encoding="UTF-8")


print("--- 정상적으로 파일에 씀 ---")
