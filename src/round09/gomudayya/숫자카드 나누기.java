import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int minA = Arrays.stream(arrayA).min().getAsInt();
        int minB = Arrays.stream(arrayB).min().getAsInt();
        
        List<Integer> listA = getDividibleNums(minA);
        List<Integer> listB = getDividibleNums(minB);
        
        listA = getAllDividibleNums(listA, arrayA);
        listB = getAllDividibleNums(listB, arrayB);
        
        listA = getAllIndividibleNums(listA, arrayB);
        listB = getAllIndividibleNums(listB, arrayA);

        return getMaxNumber(listA, listB);
    }
    
    List<Integer> getDividibleNums(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }
        return list;
    }
    
    List<Integer> getAllDividibleNums(List<Integer> nums, int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            boolean flag = true;
            for (int divide : arr) {
                if (divide % num != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(num);
        }
        return result;
    }
    
    List<Integer> getAllIndividibleNums(List<Integer> nums, int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            boolean flag = true;
            for (int divide : arr) {
                if (divide % num == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(num);
        }
        
        return result;
    }
    
    int getMaxNumber(List<Integer> listA, List<Integer> listB) {
        int max = 0;
        for (int num : listA) max = Math.max(num, max);
        for (int num : listB) max = Math.max(num, max);
        return max;
    }
}
