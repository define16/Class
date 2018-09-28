a = [23, 12, 56, 9, 98, 73, 23, 56, 74, 19, 33, 20, 6, 100];

for i in range(0, len(a), 1) :
    for j in range(0, len(a)-(i+1), 1) :
        if a[j] > a[j+1] :
            temp = a[j];
            a[j] = a[j+1];
            a[j+1] = temp;

print(a);


