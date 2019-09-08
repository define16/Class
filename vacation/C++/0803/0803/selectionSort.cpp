#include "config.h"
#include "selectionSort.h"

void main() {

	int n;
	cout << "정렬할 데이터 개수 : ";
	cin >> n;

	int *data = make_array(n);
	input(data);
	sort_asc(data);
	output(data);
	sort_desc(data);
	output(data);

}