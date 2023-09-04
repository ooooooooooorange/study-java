package leetCode.reduceRange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters3 {
    //集合存放子串
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int pl = 0;
        int len = chars.length;
        for (int pr = 0; pr < len; pr++) {
            if(set.contains(chars[pr])){
                while(true){
                    if(chars[pl] == chars[pr]){
                        pl++;
                        break;
                    }
                    set.remove(chars[pl++]);//left右滑来删除，直到没有重复的
                }
            }
                set.add(chars[pr]);
                maxLen = Math.max(maxLen, pr - pl + 1);
        }
        return maxLen;
    }

    //int[]存放子串,下标对应char的ascll码，内容是出现次数
    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] charCount = new int[128];
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int pl = 0;
        for (int pr = 0; pr < s.length(); pr++) {
            char cur = s.charAt(pr);
            charCount[cur]++;
            while(charCount[cur] > 1){//说明有重复元素
                charCount[s.charAt(pl++)]--;//left右滑来删除，直到没有重复的
            }
            maxLen = Math.max(maxLen, pr - pl + 1);
        }
        return maxLen;
    }

    //hashMap存放子串
    public static int lengthOfLongestSubstring3(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int pl = 0;
        int len = s.length();
        for (int pr = 0; pr < len; pr++) {
            char cur = s.charAt(pr);
            if(map.containsKey(cur)){
                pl = Math.max(pl, map.get(cur) + 1);//因为没有删除，所以要取max
            }
            map.put(cur, pr);
            maxLen = Math.max(maxLen, pr - pl + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
