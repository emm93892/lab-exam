import MeCab


def print_words_and_results(raw_text: str = 'すもももももももものうち'):
   tagger = MeCab.Tagger('/usr/local/lib/mecab/dic/mecab-ipadic-neologd')
   print(tagger.parse(raw_text))


def print_morpheme(raw_text: str = 'すもももももももものうち'):
    tagger = MeCab.Tagger('/usr/local/lib/mecab/dic/mecab-ipadic-neologd')
    tagger.parse('')
    result = tagger.parseToNode(raw_text)

    select = ['名詞']
    terms = []

    while result:
        term = result.surface
        pos = result.feature.split(',')[0]

        if pos in select:
            terms.append(term)

        result = result.next

    text_result = ' '.join(terms)
    return text_result

if __name__ == '__main__':
    print_words_and_results()

    print(print_morpheme())
