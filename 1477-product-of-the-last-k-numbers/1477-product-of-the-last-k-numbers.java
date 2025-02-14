class ProductOfNumbers {
    static ArrayList<Integer> lst;

    public ProductOfNumbers() {
        lst = new ArrayList<>() ;
    }
    
    public void add(int num) {
        lst.add(num);
    }
    
    public int getProduct(int k) {
        int kProduct = 1;
        int size = lst.size() -k;
        for(int i = lst.size() -1; i >= size;i--) {
            kProduct *= lst.get(i);
        }
        return kProduct;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */