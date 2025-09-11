class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        List<Character> vowels = new ArrayList<>();
        for(char ch : arr){
            if(isVowel(ch)){
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        int idx = 0;
        for(int i = 0;i < n;i++){
            if(isVowel(arr[i])){
                arr[i] = vowels.get(idx++);
            }
        }
        return new String(arr);
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}