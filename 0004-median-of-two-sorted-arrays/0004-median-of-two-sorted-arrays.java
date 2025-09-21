class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int req = (n+m)/2;
        double med1 = findMedian(nums1,n,nums2,m,req);
        System.out.println(med1);
        if((n+m) % 2 == 0){
            double med2 = findMedian(nums1,n,nums2,m,req-1);
            return (med2 + med1) / 2.0;
        }
        return med1;
    }

    private static double findMedian(int[] nums1,int n,int[] nums2,int m,int req){
        int p1 = 0,p2 = n - 1;
        int p3 = 0,p4 = m - 1;
        while(p1 <= p2){
            int mid = (p1 + p2) / 2;
            int key = nums1[mid];
            int gt = findGreaterTerms(nums1,n,key) + findGreaterTerms(nums2,m,key);
            int eq = Math.abs((n + m) - (gt + findLesserTerms(nums1,n,key) + findLesserTerms(nums2,m,key))) - 1;
            if(gt == req || (gt < req && gt + eq >= req)) return nums1[mid];
            if(gt < req){
                p2 = mid - 1;
            }else{
                p1 = mid + 1;
            }
        }

        while(p3 <= p4){
            int mid = (p3 + p4) / 2;
            int key = nums2[mid];
            int gt = findGreaterTerms(nums1,n,key) + findGreaterTerms(nums2,m,key);
            int eq = Math.abs((n + m) - (gt + findLesserTerms(nums1,n,key) + findLesserTerms(nums2,m,key))) - 1;
            if(gt == req || (gt < req && gt + eq >= req)) return nums2[mid];
            if(gt < req){
                p4 = mid - 1;
            }else{
                p3 = mid + 1;
            }
        }
        return -1;
    }

    private static int findGreaterTerms(int[] nums, int n,int key){
        int low = 0, high = n-1;
        int ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > key){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return n - ans;
    }

    private static int findLesserTerms(int[] nums, int n,int key){
        int low = 0, high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < key){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans + 1;
    }
}

// 0 1
// 0 1
// 0 0 1 1 1
// mid = 0 -> lt = 0, gt = 3, eq = 2

// 0 0 1 2 2
// lt == gt -> eq = 0 : return mid
// lt < gt ->