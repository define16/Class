#include<iostream>
#include<vector>
using namespace std;
class problem2{
public:
	vector<int> v;
	int big, small;
	int maxcDiv, mincMul;
	double mid;
	virtual void getInput() = 0;
	virtual void getBiggest() = 0;
	virtual void getSmallest() = 0;
	virtual void GcdLCM() = 0;
	virtual double getDeviation() = 0;
	virtual double getMid(double bunsan) = 0;
	virtual void Output() = 0;

};
class problem2_1 :public problem2{
public:
	void getInput(){
		int numberList[10] = {56, 80, 100, 89, 45, 79, 34, 89, 90, 75};
		for(int i = 0; i < 10; i++)
		{
			v.push_back(numberList[i]);
		}
	}
	void getBiggest(){
		big = 0;
		small = 0;
		for(int i=0; i<10; i++)
		{
		if(v[i]> big)
			big = v[i];
		}
	}
	void getSmallest(){
		small = v[0];
		for(int i = 0; i < 10; i++)
		{
		if(v[i]<small)
			small = v[i];
		}
	}
	void GcdLCM(){
		for(int i = small; i >= 1; i--)
		{
			if(big % i == 0 && small % i == 0){
				maxcDiv = i;
			break;
			}
		}
		mincMul = big * small / maxcDiv;
	}

	double getDeviation(){
		double dt, temp;
		double sum_1= 0, sum_2 = 0;						
		double pcsq[10];	

		for(int i = 0; i < v.size(); i++)
			sum_1 += v[i];

		for(int i = 0; i < 10; i++)
		{
			temp = v[i] - (sum_1 / 10);							
			pcsq[i] = (v[i] - (sum_1 / 10)) * (v[i] - (sum_1 / 10));	
			sum_2 += pcsq[i];	
		}
		dt = sum_2 / 10;									
		return dt;
	}

	double getMid(double temp){
		double front = 0;										
		double end = 50;

		while(front + 0.0001 < end){
			mid = (front + end) / 2;

			if((mid * mid) < temp)
				front = mid;

			else if((mid * mid) > temp)
				end = mid;
		}
		return mid;
	}

	void Output(){
		cout << "1) 가장 큰 수와 가장 작은 수를 출력하세요." << endl;
		cout << "가장 큰 수 : " << big << endl;
		cout << "가장 작은 수 : " << small << endl;
		cout << "2) 가장 큰 수와 가장 작은 수의 최대공약수와 최소공배수를 출력하세요." << endl;
		cout << "최대공약수 : " << maxcDiv << endl;
		cout << "최소공배수 : " << mincMul << endl;
		cout << "3) 표준 편차를 출력하세요." << endl;
		cout << "표준 편차 : " << mid << endl;
	}
};

int main_2(){
	problem2 *p = new problem2_1();
	p -> getInput();
	p -> getBiggest();
	p -> getSmallest();
	p -> GcdLCM();
	double temp = p -> getDeviation();
	p -> getMid(temp);
	p -> Output();

	delete p;
	return 0;
}