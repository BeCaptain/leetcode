import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/4/18 17:11
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
    }


    /**
     * @description 获取输入的一行数组
     * @creationTime 2023/7/30 14:31
     */
    public static int[] getInputArray() {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(" ");
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

}
