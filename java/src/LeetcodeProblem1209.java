import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class LeetcodeProblem1209 {
    class StackEntry {
        char c;
        int count;

        public StackEntry(char c, int i) {
            this.c = c;
            this.count = i;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<StackEntry> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(new StackEntry(s.charAt(i), 1));
            } else {
                StackEntry b = stack.peek();
                if (b.c == s.charAt(i)) {
                    int newCount = b.count + 1;
                    stack.pop();
                    if (newCount < k) {
                        stack.push(new StackEntry(b.c, newCount));
                    }
                } else {
                    stack.push(new StackEntry(s.charAt(i), 1));
                }
            }
        }

        StringBuilder st = new StringBuilder();
        while (!stack.isEmpty()) {
            StackEntry b = stack.pop();
            for (int i = 0; i < b.count; i++) {
                st.append(b.c);
            }
        }
        return st.reverse().toString();
    }
}
