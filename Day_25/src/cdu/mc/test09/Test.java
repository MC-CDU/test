package cdu.mc.test09;

import java.util.Arrays;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 9)java实现二分查找
         */
        int[] nums = {1,4,5,8,7,9,6,3,2,10,78,99,0,-12};
        Arrays.sort(nums);
        //查找nums中的8的下标
        int first = 0;
        int last = nums.length - 1;
        int mod = (last - first) / 2;
        int index = -1;
        boolean control = true;
        while (control) {
            //判断边界值
            if (nums[first] == 8) {
                index = first;
                break;
            }
            if (nums[last] == 8) {
                index = last;
                break;
            }
            if (nums[mod] == 8) {
                index = mod;
                break;
            }

            if (nums[mod] < 8) {
                first = mod;
                mod = (last - first) / 2 + first;
            }else if (nums[mod] > 8) {
                last = mod;
                mod = (last - first) / 2;
            }else {
                index = mod;
                break;
            }
            //特殊情况处理
            if (first + 2 == last) {
                index  = first + 1;
                control = false;
            }
        }
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println("\n8的下标为：" + index);
    }
}
