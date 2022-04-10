import java.util.Stack;

public class LeetcodeProblem682 {
    public int calPoints(String[] ops) {
        Stack<Integer> a = new Stack<>();
        
        for(String s: ops) {
            if(s.equals("C")) {
                a.pop();
            } else if(s.equals("D")) {
                a.push(a.peek()*2);
            } else if(s.equals("+")) {
                int first = a.pop();
                int temp = a.peek() + first;
                a.push(first);
                a.push(temp);
            } else {
                a.push(Integer.parseInt(s));
            }
        }

        System.out.println(a.toString());
        int total = 0;
        while(!a.isEmpty()) {
            total += a.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        LeetcodeProblem682 l = new LeetcodeProblem682();

        l.calPoints(new String[]{"5","2","C","D","+"});
    }
}
