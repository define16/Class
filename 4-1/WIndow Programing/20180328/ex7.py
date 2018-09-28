myTuple = (10, 20, 30)
myList = list(myTuple);
myList.append(40);
myTuple = tuple(myList);
print(myTuple)