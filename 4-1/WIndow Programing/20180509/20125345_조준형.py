import os
inFp = None
inList, inStr = [],""
inScore = ""
num = 0;


inFp = open("name"  + ".txt","r", encoding="UTF-8")
outFp = open("name_result"  + ".txt", "w", encoding="UTF-8")

inList = inFp.readlines()

for inStr in inList :

    msg = inStr.replace("\n", "") + "님의 점수는 : "
    inScore = input(msg);
    outFp.writelines(inStr.replace("\n", "") + " - " + inScore + "\n")

outFp.close()
inFp.close()

print("복사되었음")


