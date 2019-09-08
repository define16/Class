#include "config.h"
#include "SelectionSort.h"



void main()
{
	int n;
	cout << "정렬할 데이터 개수: ";
	cin >> n;

	int *data = Make_array(n);
	Input(data);
	Sort_asc(n, data);
	Output(data);		
	Sort_desc(n, data);
	Output(data);
}
