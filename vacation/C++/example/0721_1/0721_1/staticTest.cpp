#include "config.h"
class Memo{
	private : 
// ���� ��������� Ŭ���� �ܺο��� �ʱ�ȭ�� ���Ѿ��Ѵ�.
// ���� ��������� ���� Ŭ������ �����Ǵ� ��� ��ü���� �����ؼ� ���ȴ�.
// static�� ���� �ʴ� ��������� �ν��Ͻ� ��� ������ �θ��� ���� Ŭ������ �����Ǵ�
// ������ ��ü���� ������ ��� ������ ������.
		static int count;	//���� �������
		int no;		//�ڵ�����
		char name[21];
		char memo[101];
	public : 
		Memo(char name[21] = "����" , char memo[101] = "����")
		{
			no = ++count;
			strcpy_s(this->name,name); 
			strcpy_s(this->memo,memo); 	
		}

		void toString(char name[21] = "����" , char memo[101] = "����"){
			cout << no << ", " << name << "���� ���主 : " << memo << endl;
		}
};
// MemoŬ�������� ����� ���� ���� count�� �ʱ�ȭ
int Memo :: count = 0;

void main(){
	class Memo memo1;
	memo1.toString();
	class Memo memo2;
	memo2.toString("ȫ�浿","������");
	class Memo memo3;
	memo3.toString("�Ӳ���","������");
}