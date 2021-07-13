package com.sunyk.base.learn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,9,8,7};
        int targrt = 9;
        int[] ret = twoSum(nums,targrt);
        int[] ret1 = twoSum1(nums,targrt);
        for (int each: ret1) {
            System.out.println(each);
        }
    }
    public static  int[] twoSum(int [] nums,int target){

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length; j++) {
                if(target - nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static  int[] twoSum1(int [] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int partNumber = target - nums[i];
            if(map.containsKey(partNumber)){
                return new int[]{map.get(partNumber),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
