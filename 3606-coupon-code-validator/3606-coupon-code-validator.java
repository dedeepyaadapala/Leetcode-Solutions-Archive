class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String> ans = new ArrayList<>();
        PriorityQueue<CouponDetails> pq = new PriorityQueue<>(
            new Comparator<CouponDetails>(){
                public int compare(CouponDetails coupon1,CouponDetails coupon2){
                    if(coupon1.category.equals(coupon2.category)){
                        return coupon1.code.compareTo(coupon2.code);
                    }else if(coupon1.category.equals("electronics")){
                        return -1;
                    }else if(coupon2.category.equals("electronics")){
                        return 1;
                    }else if(coupon1.category.equals("grocery")){
                        return -1;
                    }else if(coupon2.category.equals("grocery")){
                        return 1;
                    }else if(coupon1.category.equals("pharmacy")){
                        return -1;
                    }else if(coupon2.category.equals("pharmacy")){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            });
        for(int i = 0;i < n;i++){
            if(isActive[i] && isValidBusinessLine(businessLine[i]) && isValidCode(code[i])){
                pq.add(new CouponDetails(code[i],businessLine[i]));
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll().code);
        }
        return ans;
    }

    private static boolean isValidCode(String code){
        int length = code.length();
        for(int i = 0;i < length;i++){
            char ch = code.charAt(i);
            if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '_' || (ch >= '0' && ch <= '9'))){
                return false;
            }
        }
        return true && length > 0;
    }

    private static boolean isValidBusinessLine(String category){
        return category.equals("electronics") || category.equals("grocery") || category.equals("pharmacy") || category.equals("restaurant");
    }
}

class CouponDetails{
    String code,category;
    CouponDetails(String code,String category){
        this.code = code;
        this.category = category;
    }
}