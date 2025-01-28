class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num < 5){
                if (num == 4){
                    sb.append("IV");
                    num -= 4;
                }else{
                    sb.append("I");
                    num -= 1;
                }
            }
            else if(num < 10){
                if (num == 9){
                    sb.append("IX");
                    num -= 9;
                }else{
                    sb.append("V");
                    num -= 5;
                }
            }
            else if(num < 50){
                if(num >= 40){
                    sb.append("XL");
                    num -= 40;
                }else{
                    sb.append("X");
                    num -= 10;
                }
            }
            else if(num < 100){
                if(num >= 90){
                    sb.append("XC");
                    num -= 90;
                }else{
                    sb.append("L");
                    num -= 50;
                }
            }
            else if(num < 500){
                if(num >= 400){
                    sb.append("CD");
                    num -= 400;
                }else{
                    sb.append("C");
                    num -= 100;
                }
            }
            else if(num < 1000){
                if(num >= 900){
                    sb.append("CM");
                    num -= 900;
                }else{
                    sb.append("D");
                    num -= 500;
                }
            }else{
                sb.append("M");
                num -= 1000;
            }
        }
        return sb.toString();
    }
}