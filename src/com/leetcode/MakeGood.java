package com.leetcode;

import java.util.Stack;

public class MakeGood {
    /**
     * 输入：s = "leEeetcode"
     * 输出："leetcode"
     * @param s
     * @return
     */
    public String makeGood(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character lastChar = stack.peek();
                if (c != lastChar && Character.toLowerCase(c) == Character.toLowerCase(lastChar)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        stack.forEach(character -> {
            sb.append(character);
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MakeGood().makeGood("leEeetcode"));
    }
}
