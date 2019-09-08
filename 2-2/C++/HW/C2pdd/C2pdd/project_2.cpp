#include <iostream>
#include <vector>
using namespace std;


class ExVector{
protected :
	vector<double> vec;
	int max;
	int min;
	int gdc; 
	int lcm; 
	double delta;

public :
	void Input(int num[]){
		for(int i=0;i<10;i++)
			vec.push_back(num[i]);
	}

	void Print()
	{
		cout << "1) 가장 큰 수와 가장 작은 수를 출력하세요." << endl;
		cout << "-가장 큰 수는 " << max << " 가장 작은 수는 " << min << " 입니다." << endl << endl;
		cout << "가장 큰 수와가장 작은 수의 최대공약수와 최소공배수를 출력하세요." << endl;
		cout << "-가장 큰 수와가장 작은 수의 최대공약수는 " << gdc << " 최소공배수는 " << lcm << " 입니다." << endl << endl;
		cout << "표준편차를 출력하세요." << endl;
		cout << "-표준편차는 " << delta <<  " 입니다." << endl<< endl;
	}

	virtual void getMaxMin() = 0;
	virtual void Greatest() = 0;
	virtual void Least() = 0;
	virtual void Standard() = 0;
};

class Calculator : public ExVector
{
public :
	void getMaxMin()
	{
		min = vec[0];
		max = vec[0];
		
		vector<double>::iterator iter; 

		for(iter=vec.begin();iter!=vec.end();iter++)
			if(min>*iter)
				min = *iter;

		for(iter=vec.begin();iter!=vec.end();iter++)
			if(max<*iter)
				max = *iter;
	}

	void Greatest()
	{
		for(int i=1;i<min;i++)
			if((min%i==0) && (max%i==0))
				gdc = i;
	}

	void Least(){
		lcm = (min/gdc) * (max/gdc) * gdc;

	}

	void Standard()
	{
		double sum = 0, avg = 0 , j =0;

		vector<double>::iterator iter; 


		for(int i=0;i<10;i++)
			sum += vec[i];
		avg = sum/10;

		for(int i=0;i<10;i++)
		{
			vec[i] -= avg;
			vec[i] = vec[i] * vec[i];
		}

		sum = 0;
		avg = 0;

		for(int i=0;i<10;i++)
			sum += vec[i];

		avg = sum/10;
		delta = avg;

		cout << endl;
		
		for(int i=0;;i++)
		{
			if(delta <= i*i)
			{
				j=i;
				break;
			}
		}

		
	for(int i=0;;i++){
		if(delta <= j*j)
			j -= 0.01;
		else{
			delta = j;
			break;
		}
	}
		
	}

};
int main()
{
	int num[] = {56,80,100,89,45,79,34,89,90,75};

	ExVector *exv = new Calculator();

	exv->Input(num);
	exv->getMaxMin();
	exv->Greatest();
	exv->Least();
	exv->Standard();
	exv->Print();

	return 0;
}