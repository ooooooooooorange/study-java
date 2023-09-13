package exam.test20230912;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/12 19:55
 */
public class Test1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param st string字符串
     * @return string字符串
     */
    //现有一类加密后的密文字符串，
    // 其特征是字符串中相同字符不会连续出现超讨2次。
    // 为了加强网络间传输的加察效里，我们制定了一套混淆机制，
    // 在不影响原密文数据情况下向字符串中随机位置插入一些连续的相同字符
    // (至少3个》得到混淆后的字符串混淆后字符串的恢复方式是消除字符串中连续3个及以上的相同字符，
    // 消除后的字符串再拼接到一起继续消除，直到无法再消除。
    // 请编写一段代码，将混清后的字符串恢复为混清前的家文
    public String get_substr (String st) {
        // write code here
        int n = st.length();
        if(n < 3){
            return st;
        }
        char[] result = new char[n];
        result[0] = st.charAt(0);
        result[1] = st.charAt(1);
        int j = 1;
        for (int i = 2; i < n; i++) {
            char c = st.charAt(i);
            result[++j] = c;
            if(j >=2 && result[j] == result[j-1] && result[j-1] == result[j-2]) {
                j -=3;
            }
        }
        return new String(result, 0, j + 1);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.get_substr("222BCC111CB"));    }
}
