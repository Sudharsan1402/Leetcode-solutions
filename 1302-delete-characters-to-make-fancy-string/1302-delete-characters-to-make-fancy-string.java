class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder sb=new StringBuilder();
        Stack<Character> st = new Stack<>();
        int count=1;
        sb.append(s.charAt(0));
        st.push(s.charAt(0));
        for (int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(c!=st.peek()){
                sb.append(c);
                st.push(c);
                count=1;
            }
           else{
            st.push(c);
            count++;
            if(count<3){
                 sb.append(c);
            }
           }
        }
        String str = sb.toString();
        return str;
    }
}