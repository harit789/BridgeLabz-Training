class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int  i = 0; 
        int j = 0;
        int k = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length){
            nums[k] = nums1[i];
            i++;
            k++;
        }
         while(j < nums2.length){
            nums[k] = nums2[j];
            j++;
            k++;
         }
         double result = 0.0;
         if(nums.length % 2 == 0){
            int mid = (nums.length-1)/2;
            result = (nums[mid] + nums[mid +1])/2.0;
         } else{
            result = nums[nums.length / 2];
         }
         return result;
    }
}