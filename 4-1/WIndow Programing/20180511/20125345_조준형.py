
def encoding_txt(textList) :
    temp1 = [];
    temp2 = [];

    for s1 in textList :
        for s2 in s1 :
            if ord(s2)  == 10 :
                temp2.append(chr(ord(s2)));
            else :
                temp2.append(chr(ord(s2) + 511));
        temp1.append(temp2);

    return temp2;

def decoding_txt(textList) :
    temp1 = [];
    temp2 = [];

    for s1 in textList :
        for s2 in s1 :
            if ord(s2) == 10 :
                temp2.append(chr(ord(s2)));
            else :
                temp2.append(chr(ord(s2) - 511));

        temp1.append(temp2);
        temp2 = []
        print(temp1)
    return temp1;

def save(textList , fileName) :
    outFp = open(fileName + ".txt", "w", encoding="UTF-8")
    for inStr in textList :
        outFp.writelines(inStr)
    outFp.close()

inputData = int(input("1. 암호화 2.암호화 해석 중 선택 : "));
normalName = str(input("입력파일을 입력하세요 : "))
securityName = str(input("출력파일을 입력하세요 : "))

text = []
inFp = open(normalName + ".txt", "r", encoding="UTF-8")
inList = inFp.readlines()

if inputData == 1 :
    text = encoding_txt(inList);
    save(text, securityName);

elif inputData == 2 :
    text = decoding_txt(inList);
    save(text ,securityName);

else :
    print("잘 못된 입력입니다.");

inFp.close();
