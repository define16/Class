
int *Make_array(int n)
{
	return new int[n];
}

int Arraysize(int *data)
{
// _msize(������) : �����Ϳ� �Ҵ�� ���� �޸��� ũ�⸦ ����Ʈ ������ ���´�.
		int n = _msize(data) /sizeof(data);
		return n;
}

void Input(int *data)
{
	int n = Arraysize(data);
	cout << "������ ������ �Է�: ";
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