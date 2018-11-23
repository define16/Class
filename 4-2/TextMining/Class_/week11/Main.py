import re
from nltk.tag import pos_tag
from nltk.stem.snowball import SnowballStemmer

# Read TextFile
def read_txt():
    txt_path = "dataSet\\pos_data.txt"
    txtFile = []
    f = open(txt_path, 'r')
    lines = f.readlines()
    for line in lines:
        txtFile.append(line)
    f.close()

    return txtFile

if __name__ == "__main__":
    dataset = read_txt()
    print("----- Tokenization -----")
    tokenize_data = []

    # 단어별로 끊기
    for i in dataset :
        i = i.lower()
        j = re.sub('[.]', ' .', i)
        j = re.sub('[,]', ' ,', j)
        j = j.strip().split(' ')
        tokenize_data.append(j)

    for i in tokenize_data:
        print(i)

    print("\n----- POS Tagging -----")
    tagged_data = []
    pos_dict = {}
    for i in tokenize_data:
        tagged = pos_tag(j)
        tagged_data.append(tagged)

        for j in tagged:
            pos_dict[j] = 0

    for sentence in tagged_data:
        for info in sentence:
            pos_dict[info] += 1

    print(pos_dict)
    pos_dict = sorted(pos_dict.items())

    print()
    print("===== Result =====")
    print("Word\t\t\tTag\t\t\tFreq")

    for i in pos_dict:
        word, tag = i[0]
        freq = i[1]

        if len(word) > 7:
            print('{}\t\t\t{}\t\t\t{}'.format(word, tag, freq))
        elif len(word) < 4 and len(word) >= 1 :
            print('{}\t\t\t{}\t\t\t{}'.format(word, tag, freq))
        else :
            print('{}\t\t\t{}\t\t\t{}'.format(word, tag, freq))

    print()
    print("===== HomeWork =====")
    print("Stem\t\t\tWord\t\t\tTag\t\t\tFreq")
    for i in pos_dict:
        word, tag = i[0]
        freq = i[1]
        # Steming 작업
        stemmer = SnowballStemmer('english') # 영어 단어

        if len(word) > 7:
            print('{}\t\t\t{}\t\t\t{}\t\t\t{}'.format(stemmer.stem(word), word, tag, freq))
        elif len(word) < 4 and len(word) >= 1 :
            print('{}\t\t\t{}\t\t\t{}\t\t\t{}'.format(stemmer.stem(word), word, tag, freq))
        else :
            print('{}\t\t\t{}\t\t\t{}\t\t\t{}'.format(stemmer.stem(word), word, tag, freq))
