package leetCode.recall;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 19:41
 */
//电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber17 {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    //借助队列实现
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Deque<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {//遍历key
            Character digit = digits.charAt(i);
            int size = result.size();
            for (int j = 0; j < size; j++) {//给每一个结果加上新的字母
                String s = result.remove();
                String letters = phoneMap.get(digit);
                for (int k = 0; k < letters.length(); k++) {//遍历value
                    Character letter = letters.charAt(k);
                    result.add(s + letter);
                }
            }
        }
        return new ArrayList<>(result);
    }

    List<String> result = new ArrayList<>();
    //递归实现深度遍历
    public List<String> letterCombinations2(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        dfs(digits, 0, "");
        return result;
    }

    public void dfs(String digits, int i, String path){
        if(i == digits.length()){
            result.add(path);
            return;
        }
        String letters = phoneMap.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            dfs(digits, i + 1, path + letters.charAt(j));
        }
    }

    String digits = "";
    char[] path;
    //递归实现深度遍历
    public List<String> letterCombinations3(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        this.digits = digits;
        path = new char[digits.length()];

        dfs1(0);
        return result;
    }

    public void dfs1(int i){
        if(i == digits.length()){
            result.add(String.valueOf(path));
            return;
        }
        String letters = phoneMap.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            path[i] = letters.charAt(j);
            dfs1(i + 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber17 l = new LetterCombinationsOfAPhoneNumber17();
        System.out.println(l.letterCombinations2("23"));
    }
}
