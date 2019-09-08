#include "config.h"

//�θ�(����, ����, ���)Ŭ����
class Parent{
	private :
		char name[21];
		bool gender;
	public :
		Parent(char name[21] = "����", bool gender = false)
		{
			strcpy_s(this->name ,name);
			this->gender = gender;
		}
		char *getName()
		{
			return name;
		}

		void setName(char name[21])
		{
			strcpy_s(this->name, name);
		}

		 bool isgender()	// returnŸ���� bool�̸� is�� ���̴� ���� �����̴�.
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

// �ڽ�(����, ����, �Ļ�) Ŭ����
// ����� ����
// Class �ڽ�Ŭ�����̸� : ��ӱ��������� �θ�Ŭ�����̸�
// ��� ���� ������
//	 private : �θ� Ŭ���� ����� ���� ���ѿ� ������� ��� private���� ��ӵȴ�.
//	 protected : �θ� Ŭ���� ����� ���� ���ѿ� private�� private�� �������� protected�� ��ӵȴ�.
//	 public : �θ� Ŭ���� ����� ���� ���� �״�� ��ӵȴ�.

// parent Ŭ������ ��� �޾� Child Ŭ������ �����.
class Child : public Parent {
// parent Ŭ������ ��� �޾����Ƿ� Parent Ŭ������ ��� ��� ������ �Լ��� �������� �ʾƵ�
// ������ �� ó�� private�� ���� ����� �� �ִ�.
// �θ� Ŭ������ ���� ��ӹ��� ��������� ���� ������ private�� ���
//	 this �ʱ�ȭ�� �� �� ���� �θ�Ŭ������ �����ڸ� �����ؼ� �ʱ�ȭ���Ѿ��Ѵ�.
	private : 
		int age;
		char nickName[21];
	public :
// �ڽ�Ŭ������ �����ڴ� �ڽ� Ŭ������ ��������� �ʱ�ȭ ��ų ���� ������ �ȵǰ�
// �θ�Ŭ������ �پ� ��ӹ��� ��� ������ �ʱ�ȭ ��ų ���� �޾���� �Ѵ�.
		Child(char name[21], bool gender, int age, char nickName[21] ) : Parent(name, gender)
		{
			this->age = age;
			strcpy_s(this->nickName,nickName);
		}
// Parent Ŭ�����κ��� ��ӹ��� toString()�Լ��� �̸��� ������ ����� �� �����Ƿ�
// �ڽ�Ŭ������ ��� ���� ����� �� ����.
// �θ� Ŭ�����κ��� ��ӹ��� �Լ��� ������ ���� ������ �ڽ� Ŭ�������� �ٽ� ����
// ����ϸ� �Ǵµ� �̸� �Լ��� override��� �θ���.

		//���� : ������(��) - 16, �̻���
		void toString() 
		{
			cout << name << "(" << (gender ? "��" : "��") << ") - " <<  age << ", "<< nickName<< endl;
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
