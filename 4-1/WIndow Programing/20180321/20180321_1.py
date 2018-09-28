s = "The Central Character1";

slen = len(s);

if slen % 2 == 0 :
    want = slen//2;
    print("중앙글자는 [ %s%s ] 입니다.." % (s[want], s[want+1]));
else :
    want = slen//2;
    print("중앙글자는 [ %s ] 입니다.." % s[want]);

