class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        while(a > 0 || b > 0 || c > 0) {
            if (a >= b && a >= c) {
                if (sb.length() >= 2 && sb.charAt(sb.length()-1) == 'a' && sb.charAt(sb.length()-2) == 'a'){
                    if (b > 0) {
                        sb.append('b');
                        b--;
                    } else if (c > 0) {
                        sb.append('c');
                        c--;
                    } else {
                        break;
                    }
                } else {
                    sb.append('a');
                    a--;
                }
            } else if (b >= a && b >= c) {
                if (sb.length() >= 2 && sb.charAt(sb.length()-1) == 'b' && sb.charAt(sb.length()-2) == 'b'){
                    if (a > 0) {
                        sb.append('a');
                        a--;
                    } else if (c > 0) {
                        sb.append('c');
                        c--;
                    } else {
                        break;
                    }
                } else {
                    sb.append('b');
                    b--;
                }
            } else {
                if (sb.length() >= 2 && sb.charAt(sb.length()-1) == 'c' && sb.charAt(sb.length()-2) == 'c'){
                    if (a > 0) {
                        sb.append('a');
                        a--;
                    } else if (b > 0) {
                        sb.append('b');
                        b--;
                    } else {
                        break;
                    }
                } else {
                    sb.append('c');
                    c--;
                }
            }
        }
        return sb.toString();
    }
}