cnt = 1;

for i in [10, 2, 7] :
    print("%d : " % cnt , end = "" );

    for j in range(1, i+1, 1) :
        print("■", end = "");
        
    print(" (%d)" % i);
    cnt += 1;
