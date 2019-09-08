#include "config.h"

class SelectionSort {
private : 
	int n, *data;
public :
	SelectionSort(int n)
	{
		this->n = n;
		this->data = new int[n];
	}
	~SelectionSort()
	{
		delete[] data;
	}

	void Input()
	{			
		cout << "정렬할 데이터 입력: ";
		for(int i = 0;i <n;i++)
		cin >> data[i];
	}
	 void Output()
	 {
		 for(int i = 0;i<n;i++)
		{
			if(i > 0)
				cout << ", ";
			cout << data[i];
		}
				cout << endl;
	 }

	 
	void Sort_asc()
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

	void Sort_desc()
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
};



void main()
{
	int n;
	cout << "정렬할 데이터 개수: ";
	cin >> n;

	SelectionSort selectionsort(n);
	selectionsort.Input();
	selectionsort.Sort_asc();
	selectionsort.Output();
	selectionsort.Sort_desc();
	selectionsort.Output();
}