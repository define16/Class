intab = "aeiou";
outtab = "12345";

trantab = str.maketrans(intab, outtab);

str1 = "this is string example....";

print(str1);
print(str1.translate(trantab));

