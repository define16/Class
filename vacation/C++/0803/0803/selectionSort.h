int *make_array(int n) {
	return new int[n];
}

int array_size(int *data) {
//	_msize(������) : �����Ϳ� �Ҵ�� ���� �޸��� ũ�⸦ ����Ʈ ������ ���´�.
	return _msize(data) / sizeof(data);
}

void sort_asc(int *data) {
	int n = array_size(data);
	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++) {
			if(data[i] > data[j]) {
				swap(data[i], data[j]);
			}
		}
	}
}

void sort_desc(int *data) {
	int n = array_size(data);
	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++) {
			if(data[i] < data[j]) {
				swap(data[i], data[j]);
			}
		}
	}
}

void input(int *data) {
	cout << "������ ������ �Է� : ";
	for(int i=0 ; i<array_size(data) ; i++) {
		cin >> data[i];
	}
}

void output(int *data) {
	cout << array_size(data) << endl;
	cout << "���� ��� : ";
	for(int i=0 ; i<array_size(data) ; i++) {
		if(i > 0) {
			cout << ", ";
		}
		cout << data[i];
	}
	cout << endl;
}