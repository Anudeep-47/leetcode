class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0')return "0";
        num1 = reverse(num1);
        num2 = reverse(num2);
        StringBuilder prod = new StringBuilder("0");
        for(int i=0; i<num2.length(); i++){
            int n2 = num2.charAt(i)-'0';
            if(n2==0)continue;
            StringBuilder temp = new StringBuilder();
            for(int k=0; k<i; k++)temp.append('0');
            int carry = 0, n1, mul;
            for(int j=0; j<num1.length(); j++){
                n1 = num1.charAt(j)-'0';
                mul = n1*n2+carry;
                temp.append((char)(mul%10+'0'));
                carry = mul/10;
            }
            if(carry!=0)temp.append((char)(carry+'0'));
            addProds(prod, temp);
        }
        return reverse(prod.toString());
    }
    
    private void addProds(StringBuilder prod, StringBuilder temp){
        int i=0;
        int carry = 0;
        while(i<prod.length() || i<temp.length() || carry!=0){
            int sum = carry;
            if(i<temp.length()){
                sum += temp.charAt(i)-'0';
            }
            if(i<prod.length()){
                sum += prod.charAt(i)-'0';
                prod.setCharAt(i, (char)(sum%10+'0'));    
            }
            else prod.append((char)(sum%10+'0'));
            carry = sum/10;
            i++;
        }
        return;
    }
    
    private String reverse(String num){
        StringBuilder str = new StringBuilder();
        for(int i=num.length()-1; i>=0; i--){
            str.append(num.charAt(i));
        }
        return str.toString();
    }
}