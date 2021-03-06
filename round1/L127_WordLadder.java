package round1;
/*
    @author: Xi Zhang
    @date:   2/4/19
    @time:   11:04 AM
 */
import org.junit.Test;

import java.util.*;

public class L127_WordLadder {
    // Solution 1: One end bfs, from start to end, using hashset to deduplicate
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return -1;

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] currentChars = cur.toCharArray();
                // change the characters one by one and check if the word is in the dictionary
                for (int i = 0; i < currentChars.length; i++) {
                    // cache the character being changed
                    char curC = currentChars[i];
                    // change the character at index i to other 25 lowercase letters
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentChars[i] = c;
                        String str = String.valueOf(currentChars);
                        // if the wordSet contains the letter, add to queue and remove from the wordSet to deduplicate
                        if (wordSet.contains(str)) {
                            if (str.equals(endWord)) return distance+1;
                            queue.offer(str);
                            wordSet.remove(str);

                        }
                    }
                    //change back the character
                    currentChars[i] = curC;
                }
            }
            distance++;
        }
        return 0;
    }

    // Solution 2: one end bfs from end to start, use remove to deduplicate
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if (wordSet.contains(endWord)) {
            queue.offer(endWord);
            wordSet.remove(endWord);
        }
        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] curChars = cur.toCharArray();
                for (int i = 0; i < curChars.length; i++) {
                    char curC = curChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curChars[i] = c;
                        String convertedStr = String.valueOf(curChars);
                        if (wordSet.contains(convertedStr)) {
                            if (convertedStr.equals(beginWord)) return distance + 1;
                            queue.offer(convertedStr);
                            wordSet.remove(convertedStr);
                        }
                    }
                    curChars[i] = curC;
                }
            }
            distance++;
        }

        return 0;
    }

    @Test
    public void test() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength2(beginWord, endWord, wordList));
    }
}
