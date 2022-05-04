import java.util.Stack;

public class LeetcodeProblem844 {
    public Stack<Character> processStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = processStack(s);
        Stack<Character> stack2 = processStack(t);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek() != stack2.peek()) {
                return false;
            }
            stack1.pop();
            stack2.pop();
        }

        return stack1.size() == stack2.size();
    }
}
