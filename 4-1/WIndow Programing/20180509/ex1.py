import os
inFp = None
inList, inStr = [],""
num = 0;

fName1 = input("소스을 입력하세요 : ")
fName2 = input("타겟명을 입력하세요 : ")

if os.path.exists(fName1 + ".txt") :
    inFp = open(fName1 + ".txt","r", encoding="UTF-8")
    outFp = open(fName2 + ".txt", "w", encoding="UTF-8")

    inList = inFp.readlines()
    for inStr in inList :
        outFp.writelines(inStr + "\n")

    inFp.close()
else :
    print("%s 파일이 없습니다." % fName1)

print("%s 파일이 %s 파일로 복사되었음" % (fName1, fName2))


