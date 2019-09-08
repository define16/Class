
int *Make_array(int n)
{
	return new int[n];
}

int Arraysize(int *data)
{
// _msize(포인터) : 포인터에 할당된 실제 메모리의 크기를 바이트 단위로 얻어온다.
		int n = _msize(data) /sizeof(data);
		return n;
}

void Input(int *data)
{
	int n = Arraysize(data);
	cout << "정렬할 데이터 입력: ";
	for(int i = 0;i <n;i++)
		cin >> data[i];
}

 void Output(int *data)
 {
	 for(int i = 0;i<Arraysize(data);i++)
	{
		if(i > 0)
			cout << ", ";
		cout << data[i];
	}
			cout << endl;
 }

void Sort_asc(int n, int *data)
{
	int temp;
	for(int i = 0;i<n-1;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(data[i]> data[j])
			{
				swap(data[i],data[j]);
			}
		}
	}
}

void Sort_desc(int n, int *data)
{
	int temp;
	for(int i = 0;i<n-1;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(data[i]<data[j])
			{
				swap(data[i],data[j]);
			}
		}
	}
}