a = input("2개 입력")
a1 = a.split()
a1[0] = int(a1[0])
a1[1] = int(a1[1])

print("%d, %d, %d" % (a1[0], a1[1], a1[1] + a1[0]))
