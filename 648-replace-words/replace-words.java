class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] arr = sentence.split(" ");
        Word[] words = new Word[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Word curr = new Word(arr[i], i);
            words[i] = curr;
        }

        Arrays.sort(words, new sortByValue());

        int dictSize = dictionary.size();
        int i = 0;
        int j = 0;
        while (i < dictSize && j < arr.length) {
            String dict = dictionary.get(i);
            String word = words[j].str;
            if (word.indexOf(dict) == 0) {
                words[j].str = dict;
                j++;
            } else {
                if (dict.compareTo(word) < 0) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        Arrays.sort(words, new sortByIndex());

        StringBuilder result = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            String word = words[k].str;
            if (k == arr.length - 1) {
                result.append(word);
            } else {
                result.append(word + " ");
            }
        }

        return result.toString();
    }
}

class Word {
    String str;
    int index;

    public Word(String s, int i) {
        str = s;
        index = i;
    }
}

class sortByValue implements Comparator<Word> {
    public int compare(Word a, Word b) {
        return a.str.compareTo(b.str);
    }
}

class sortByIndex implements Comparator<Word> {
    public int compare(Word a, Word b) {
        return Integer.compare(a.index, b.index);
    }
}