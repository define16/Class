void input(int *data, int n)
{
	cout << "������ ������ �Է� : ";
	for( i=0 ; i<n ; i++) {
		cin >> data[i];
	}
}


void selectionsort(int *data, int n)
{
	for(int i=0 ; i<n-1 ; i++) 
		for(int j=i+1 ; j<n ; j++)	
				if(data[i] > data[j]) 
					swap(data[i], data[j]);
}

void output(int *data, int n)
{
	cout << i + 1 << "���� ��� : ";
		for(int j=0 ; j<n ; j++) {
			cout << data[j] << " ";
		}
				cout << endl;
}