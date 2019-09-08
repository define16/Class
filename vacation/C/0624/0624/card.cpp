#include "config.h"

void main() {

	char *number[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	char *symbol[] = {"¢¼","¡Þ","¢¾","¢¿"};
	int card[52];
	for(int i=0 ; i<52 ; i++) {
		card[i] = i;
	}
	for(int i=0 ; i<52 ; i++) {
//		cout << setw(2) << number[card[i]%13] << " ";			// ¼ýÀÚ¸¸ Ãâ·Â
//		cout << setw(2) << symbol[card[i]/13] << " ";			// ¹«´Ì¸¸ Ãâ·Â
		cout << symbol[card[i]/13] << setw(2) << number[card[i]%13] << " ";
		if((i + 1) % 13 == 0) {
			cout << endl;
		}
	}
	cout << "============================ ¼¯±âÀü ============================" << endl;

	srand((unsigned)time(NULL));
	for(int i=0 ; i<1000000 ; i++) {
		int r = rand() % 51 + 1;
		swap(card[0], card[r]);
	}
	for(int i=0 ; i<52 ; i++) {
		cout << symbol[card[i]/13] << setw(2) << number[card[i]%13] << " ";
		if((i + 1) % 13 == 0) {
			cout << endl;
		}
	}
	cout << "============================ ¼¯ÀºÈÄ ============================" << endl;


}