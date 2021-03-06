package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        int startIndex = 0;
        combinationSumUtil(candidates,target,result,tempList,startIndex);
        return  result;
    }

    public void combinationSumUtil(int [] candidates,int target,List<List<Integer>> result,List<Integer> tempList
            ,int startIndex){
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }else if(target<0){
            return;
        }else{
            for(int i=startIndex;i<candidates.length;i++){
                if(candidates[i]>target){
                    break;
                }
                tempList.add(candidates[i]);
//                if(target < 0){
//                    continue;
//                }
                combinationSumUtil(candidates,target-candidates[i],result,tempList,i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

//    public List<List<Integer>> combinationSum(int[] nums, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, target, 0);
//        return list;
//    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String args[]){
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSum cs = new CombinationSum();
        List<List<Integer>> combinations = cs.combinationSum(candidates,target);
        for(List<Integer> combination:combinations){
            System.out.println(combination);
        }
    }
}
