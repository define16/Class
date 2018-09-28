outFp = None
outStr = ""

fName = input("파일명 입력 : ")

outFp = open(fName, "w", encoding="UTF-8")

while True :

    outStr = input("내용 입력 : ")
    if outStr != "" :
        outFp.writelines(outStr + "\n")
    else :
        break

outFp.close()

print("--- 정상적으로 파일에 씀 ---")
