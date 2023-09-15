package exam.test20230912;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/14 19:17
 */
public class Test5 {
    //快速排序倒序排序
    public int[] quickSort (int[] arr) {
        // write code here
        sort(arr, 0, arr.length-1);
        return arr;
    }
    //快速排序倒序排序
    public void sort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while(i < j){
            while(i < j && arr[j] <= temp){
                j--;
            }
            while(i < j && arr[i] >= temp){
                i++;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
