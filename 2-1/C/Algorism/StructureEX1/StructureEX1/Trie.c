#include <stdio.h>
#include <stdlib.h>
#include <string>

// 출처: http://ingyeoking13.tistory.com/193 [못해요, 코딩]

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
추천어 기능을 트라이로 줄건데, 이것은 showtree와 크게 다를바없다. 
내가 입력한 검색어까지만 노드를 이동하고, 
그 뒤에 해당노드를 showtree의 인자로 넘겨준다.  
showtree함수의 인자였던 node는 root 노드였음을 기억하자. 
그렇다면 이번엔 내가 입력한 노드에서부터 모든 단어를 검색해서 제시해준다.
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

