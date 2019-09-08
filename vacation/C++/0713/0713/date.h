//	 �Լ��̸�([�μ�, ...]) {	// �Լ��� �Ӹ�
//		�Լ��� ������ ����;				// �Լ��� ��ü
//		...;
//		[return ��;]
//	}
//	return�� �����Ǹ� ���� Ÿ�Կ� void�� ���´�.
//	�Լ��� ȣ��Ǹ� ���α׷��� ȣ��� �Լ��� �б��ؼ� �Լ��� �����Ѵ�.
//	return�� �����ų� "}"�� ������ �Լ��� ȣ��� ������ �ǵ��ư���.

int unixTime() {
	return time(NULL);
}

//	���ϵǴ� ���� �ּ�(������, �迭��, ���ڿ�)�� ��� �Լ��� �տ� "*"�� �ٿ��ش�.
tm *getUnixTime() {
	time_t timer = time(NULL);
	struct tm *t = localtime(&timer);
	return t;
}

//	���� ��¥���� �⵵�� �����ϴ� �Լ�
int getYear() {
	return getUnixTime()->tm_year + 1900;
}

//	���� ��¥���� ���� �����ϴ� �Լ�
int getMonth() {
	return getUnixTime()->tm_mon + 1;
}

//	���� ��¥���� �ϸ� �����ϴ� �Լ�
int getDate() {
	return getUnixTime()->tm_mday;
}
//	���� ��¥���� ���ϸ� ���ڷ� �����ϴ� �Լ�
int getDay1() {
	return getUnixTime()->tm_wday;
}
//	���� ��¥���� ���ϸ� ���ڿ��� �����ϴ� �Լ�
char *getDay2() {
//	������ ������ ����� ���ڿ� �迭�� �����.
	char *week[] = {"�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����"};
	return week[getUnixTime()->tm_wday];
}
//	���� ��¥���� �ð��� �����ϴ� �Լ�
int getHour() {
	return getUnixTime()->tm_hour;
}
//	���� ��¥���� �и� �����ϴ� �Լ�
int getMinute() {
	return getUnixTime()->tm_min;
}
//	���� ��¥���� �ʸ� �����ϴ� �Լ�
int getSecond() {
	return getUnixTime()->tm_sec;
}