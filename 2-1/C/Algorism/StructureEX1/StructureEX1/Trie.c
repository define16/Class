#include <stdio.h>
#include <stdlib.h>
#include <string>

// ��ó: http://ingyeoking13.tistory.com/193 [���ؿ�, �ڵ�]

typedef struct node{
	struct node *child[26];
	int word;
}node;

node* newNode() {
	node* new = (node *)malloc(sizeof(node));
	new->word = 0;
	for (int i = 0; i < 26; i++)
		new->child[i] = 0;
	return new;
}

void insert(node* root, const char* str) {
	int len = strlen(str);
	node* now = root;

	for (int i= 0; i < len;i++) {
		if (!now->child[str[i] - 'a'])
			now->child[str[i] - 'a'] = newNode();
		now = now->child[str[i] - 'a'];
	}
	now->word = 1;
}

void showtree(node* now, char* str, int depth) {
	if (now->word)
		printf("%s\n", str);

	for (int i = 0; i < 26; i++) {
		if (now->child[i]) {
			str[depth] = i + 'a';
			str[depth + 1] = 0;
			showtree(now->child[i], str, depth + 1);
		}
	}
}

int search(node*  root, const char* str) {
	int len = strlen(str);
	node* now = root;

	for (int i = 0; i < len; i++) {
		if (!now->child[str[i] - 'a'])
			return 0;
		now = now->child[str[i] - 'a'];
	}
	return now->word;
}

int delete(node* now, const char* str, int i) {
	if (i == strlen(str)) {
		int chk = 0;
		for (int i = 0; i<26; i++) {
			if (now->child[i]) chk = 1;
		}
		if (chk) return 0;
		return 1;
	}

	if (now->child[str[i] - 'a']) {
		if (delete(now->child[str[i] - 'a'], str, i + 1)) {
			free(now->child[str[i] - 'a']);
			now->child[str[i] - 'a'] = 0;

			int chk = 0;
			for (int i = 0; i<26; i++) {
				if (now->child[i]) chk = 1;
			}

			if (chk) return 0;
			return 1;
		}
	}
	return 0;
}
/*
��õ�� ����� Ʈ���̷� �ٰǵ�, �̰��� showtree�� ũ�� �ٸ��پ���. 
���� �Է��� �˻�������� ��带 �̵��ϰ�, 
�� �ڿ� �ش��带 showtree�� ���ڷ� �Ѱ��ش�.  
showtree�Լ��� ���ڿ��� node�� root ��忴���� �������. 
�׷��ٸ� �̹��� ���� �Է��� ��忡������ ��� �ܾ �˻��ؼ� �������ش�.
*/
void recommend(node* root, char* str) {
	int len = strlen(str);

	node* now = root;
	for (int i = 0; i<len; i++) {
		if (!now->child[str[i] - 'a']) 
			return;
		now = now->child[str[i] - 'a'];
	}

	showtree(now, str, len);
}

void printhead(const char* str) {
	printf("\n==============%s=================\n\n", str);
}


int main() {

	char data[][8] = {
		"below","blue",
		"ban","bzak", "bzu", "a",
		"im","i"
	};

	node* root = newNode();

}

