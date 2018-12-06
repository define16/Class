# 음절 단위로 끊기
import csv

def make_syllable(sentences):
    sentence = []
    for sent in sentences:
        sent = sent.replace("\n", "")
        sent = sent.replace(" ", "")
        sent = sent.replace(",", "")
        sentence.append(sent)

    return sentence

def save_scv(data):
    f = open('koreanLabling.csv', 'w', encoding='utf-8', newline='')
    wr = csv.writer(f)
    for key in data.keys():
        wr.writerow([key, data[key]])

    f.close()


if __name__ == "__main__":
    inFp = open("dataSet/한글.txt", "r")
    words = inFp.readlines()
    words = make_syllable(words)
    print(words)
    word = []
    for w in words:
        for _ in w:
            word.append(_)

    print(word)

    print(len(word))
    words_dic = dict(zip(word, [i for i in range(0, len(word))]))
    # print(index)
    print(words_dic)

    save_scv(words_dic)

