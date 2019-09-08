//����Ÿ�� �Լ��̸� ([�μ�,..]) { - �Լ��� �Ӹ� 
//   �Լ��� ������ ����;  - �Լ��� ��ü
//    .... ;
//   [return ��;]
//   } return�� �����Ǹ� ���� Ÿ�Կ� void��� ���´�.
// �Լ��� ȣ��Ǹ� ���α׷��� ȣ��� �Լ��� �б��ؼ� �Լ��� �����Ѵ�.
// return�� �����ų� "}"�� ������ �Լ��� ȣ��� ������ �ǵ��ư���.

int unixTime()
{
	return (unsigned)time(NULL);
}

//���ϵǴ� ���� �ּ�(������,�迭��,���ڿ�)�� ��� �Լ��� �տ� "*"�� �ٿ��ش�.
tm *getUnixTime()
{
	time_t timer = (unsigned)time(NULL);
	 struct tm *t = localtime(&timer); 
// struct tm t;
// localtime(&t ,&timer);

	 return t;
}

//���� ��¥���� �⵵�� �����ϴ� �Լ�
int getYear()
{
	  return getUnixTime()->tm_year + 1900;
}

int getMonth()
{
	 return getUnixTime()->tm_mon + 1;
}

int getDay()
{
	 return getUnixTime()->tm_mday;
}

int getHour()
{
	 return getUnixTime()->tm_hour;
}

int getMin()
{
	 return getUnixTime()->tm_min;
}

int getSec()
{
	 return getUnixTime()->tm_sec;
}

char *getWday()
{
	//������ ������ ����� ���ڿ� �迭�� ������ش�.
	char *week[] = {"��","��","ȭ","��","��","��","��"};
	 return week[getUnixTime()->tm_wday];
}

int getYday()
{
	 return getUnixTime()->tm_yday;
}

int getIsdst()
{
	 return getUnixTime()->tm_isdst;
}