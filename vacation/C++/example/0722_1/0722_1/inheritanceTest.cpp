#include "config.h"


class Parent{
	protected :
//		char name[21];
		string name;
		bool gender;
	public :
		Parent(char name[21] = "����", bool gender = false)
		{
			this->name = name;
			this->gender = gender;
		}
		string getName()
		{
			return name;
		}

		void setName(string name)
		{
			this->name = name;
		}

		 bool isgender()	
		 {
			 return gender;
		 }

		 void setGender(bool gender)
		 {
			 	this->gender = gender;
		 }

		void toString()
		{
			cout << name << "(" << (gender ? "��" : "��") << ")" << endl;
		}	 
};

class Child : public Parent {

	private : 
		int age;
		char nickName[21];
	public :

		Child(char name[21], bool gender, int age, char nickName[21] )
//	 �θ� Ŭ������ ���� ��ӹ��� private ����� setter�Լ��� �غ�Ǿ� �ִٸ� �θ� Ŭ������
// �����ڸ� ȣ������ �ʰ� setter �Լ��� �ʱ�ȭ ��ų �� �ִ�.

// �θ� Ŭ�����κ��� ��ӹ��� ��� ������ ���� ������ protected�� ��� this �ʱ�ȭ�� �����ϴ�.
		{
			this->name = name;
			this->gender = gender;
			this->age = age;
			strcpy_s(this->nickName,nickName);
		}


		void toString() 
		{
			cout << name << "(" <<( gender ? "��" : "��") << ") - " <<  age << ", "<< nickName<< endl;
// �θ� Ŭ������ ���� ��ӹ��� �Լ��� ����� �߰��ؼ� �����Ǹ� �ؾ� �� ��쿡��
// �θ� Ŭ������ ���� ��ӹ��� �Լ��� ������ ���� ���� �θ� Ŭ������ �Լ��� �����ϰ�
// �ڽ� Ŭ�������� �߰��Ǵ� ��ɸ� �־��ָ� �ȴ�.
			Parent::toString();		//�θ�(Parent) Ŭ������ toString() �Լ��� �����Ѵ�.
			cout << " - " << age << ", " << nickName << endl;		//�ڽ� Ŭ�������� ��� �߰�
		}	 


};
void main()
{
	class Parent parent1;
	parent1.toString();
	class Parent parent2("ȫ�浿", true);
	parent2.toString();

	parent2.setName("�Ӳ���");
	parent2.toString();

	cout << parent2.getName() << endl;

	class Child child1("������", false,16,"�̻���");
	child1.toString();
}
