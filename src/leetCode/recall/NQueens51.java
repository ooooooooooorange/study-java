package leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/5 14:08
 */
//N皇后
public class NQueens51 {
    int n;
    int[] board;
    boolean[] isUsed;
    boolean[] ijAdd;
    boolean[] ijSub;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new int[n];
        isUsed = new boolean[n];
        ijAdd = new boolean[n*2-1];
        ijSub = new boolean[n*2-1];//+n-1的偏量
        result = new ArrayList<>();
        dfs(0);
        return result;
    }

    public void dfs(int i){
        if (i == n) {
            result.add(printBoard());
            return;
        }
        for (int j = 0; j < n; j++) {
            //用canPut判断
//            if (!isUsed[j] && canPut(i, j)) {//如果这个数字还没被使用
//                board[i] = j;//位置i放上数字nums[j]
//                isUsed[j] = true;
//                dfs(i + 1);
//                isUsed[j] = false; // 恢复现场：因为path是不断替换的，所以不用恢复
//            }
            //用i-j、j-i判断
            if (!isUsed[j] && !ijAdd[i+j] && !ijSub[i-j+n-1]) {//如果这个数字还没被使用
                board[i] = j;//位置i放上数字nums[j]
                isUsed[j] = true;
                ijAdd[i+j] =true;
                ijSub[i-j+n-1] = true;
                dfs(i + 1);
                isUsed[j] = false; // 恢复现场：因为path是不断替换的，所以不用恢复
                ijAdd[i+j] = false;
                ijSub[i-j+n-1] = false;
            }
        }
    }


    //判断斜角是否冲突，只需要判断左上、右上
    public boolean canPut(int i, int j){
        //判断左上、右上
        for (int k = 1; k <= i  ; k++) {
            if(board[i - k] == j + k || board[i - k] == j - k){
                return false;
            }
        }
        return true;
    }

    //打印棋盘
    public List<String> printBoard(){
        List<String> boardString = new ArrayList<>();
        for (int i = 0; i < n; i++) {
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                if (board[i] == j) {
//                    sb.append("Q");
//                } else {
//                    sb.append(".");
//                }
//            }
//            boardString.add(sb.toString());
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[i]] = 'Q';
            boardString.add(new String(row));
        }
        return boardString;
    }

    public static void main(String[] args) {
        NQueens51 nQueens51 = new NQueens51();
        List<List<String>> lists = nQueens51.solveNQueens(4);
        System.out.println(lists);
    }
}
