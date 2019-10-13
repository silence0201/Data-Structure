package com.Stack;

import java.util.HashMap;

/**
 * Created by silence on 2019/10/13.
 */
public class Solution {

    private HashMap<Character,Character> map = new HashMap<>();

    public Solution() {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0)
            return true;
        if ((length & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (map.get(left) != c) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]" ) || s.contains("()")) {
            s = s.replace("{}","");
            s = s.replace("[]","");
            s = s.replace("()","");
        }
        return s.isEmpty();
    }

}
