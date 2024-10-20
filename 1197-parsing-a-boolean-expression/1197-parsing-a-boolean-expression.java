class Solution {
    public boolean parseBoolExpr(String expression) {
    Stack<Character> st = new Stack<>();
    char temp = ' ', op = ' ';

    for(char ch : expression.toCharArray())
    {
      if(ch=='(' || ch==',')
      continue; 
      if(ch=='t' || ch=='f' || ch=='!' || ch=='&' || ch=='|') 
      st.push(ch);
      else if (ch==')')
      {
         boolean hasTrue = false, hasFalse=false;
         while(st.peek()!='!' && st.peek()!='&' && st.peek()!='|')
         {
           char val = st.pop();
           if(val=='t')hasTrue = true;     
           if(val=='f')hasFalse=true;     
         }
        if(!st.isEmpty())
        op = st.pop();
         if(op=='!')
         {
            if(hasTrue)
            temp = 'f';
            else
            temp = 't';
         }
         else if(op=='&')
         {
           if(hasTrue==true && hasFalse==false)
           temp = 't';
           else temp = 'f';
         }  
         else if(op=='|')
         {
           if(hasTrue==true)
           temp = 't';
           else temp = 'f';
         }
         st.push(temp);
      } 
    }   
    return st.peek()=='t';
    }
}