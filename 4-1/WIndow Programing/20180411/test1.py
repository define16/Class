s = str(input("문자"))

for i in range(0,len(s)) :
    for j in range(0, i+1) :
        print("%s" % s[j], end="")
    print("")

