#include < time.h >
#include <windows.h>



// epoch time���� ��ȯ�� ���
#if defined(_MSC_VER) || defined(_MSC_EXTENSIONS)
#define DELTA_EPOCH_IN_MICROSECS  11644473600000000Ui64
#else
#define DELTA_EPOCH_IN_MICROSECS  11644473600000000ULL
#endif

// for timezone
struct timezone
{
	int  tz_minuteswest; /* minutes W of Greenwich */
	int  tz_dsttime;     /* type of dst correction */
};

// gettimeofday in windows
int gettimeofday(struct timeval *tv, struct timezone *tz)
{
	FILETIME ft;
	unsigned __int64 tmpres = 0;
	static int tzflag;

	if (NULL != tv)
	{
		// system time�� ���ϱ�
		GetSystemTimeAsFileTime(&ft);

		// unsigned 64 bit�� �����
		tmpres |= ft.dwHighDateTime;
		tmpres <<= 32;
		tmpres |= ft.dwLowDateTime;

		// epoch time���� ��ȯ�ϱ�
		tmpres -= DELTA_EPOCH_IN_MICROSECS;

		// 100nano�� 1micro�� ��ȯ�ϱ�
		tmpres /= 10;

		// sec�� micorsec���� ���߱�
		tv->tv_sec = (tmpres / 1000000UL);
		tv->tv_usec = (tmpres % 1000000UL);
	}

	// timezone ó��
	if (NULL != tz)
	{
		if (!tzflag)
		{
			_tzset();
			tzflag++;
		}
		tz->tz_minuteswest = _timezone / 60;
		tz->tz_dsttime = _daylight;
	}

	return 0;
}