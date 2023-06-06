import tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/4/18 17:11
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // while (in.hasNextLine()) {
        //     String next = in.nextLine();
        //     System.out.println(next);
        //     // String input = in.nextLine();
        //     // System.out.println(Arrays.stream(input.split(" ")).sorted().collect(Collectors.joining(" ")));
        // }


        while (in.hasNextLine()) {
            String[] arr = in.nextLine().split(" ");
            int[] ints = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
            Arrays.stream(ints)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            // System.out.println(Arrays.stream(arr).mapToInt(Integer::valueOf).sum());
        }

    }


}
