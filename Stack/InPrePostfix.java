package stack;

public class InPrePostfix{
    static int prec(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    static int calc(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return a / b;
    }

    static String postfix(String s) {
        char[] st = new char[s.length()];
        int top = -1;
        String r = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                String n = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    n += s.charAt(i++);
                i--;
                r += n + " ";
            } else if (c == '(') st[++top] = c;
            else if (c == ')') {
                while (st[top] != '(') r += st[top--] + " ";
                top--;
            } else {
                while (top >= 0 && st[top] != '(' &&
                        prec(st[top]) >= prec(c))
                    r += st[top--] + " ";
                st[++top] = c;
            }
        }

        while (top >= 0) r += st[top--] + " ";
        return r;
    }

    static String prefix(String s) {
        String[] t = postfix(s).trim().split(" ");
        String r = "";

        // Build prefix using postfix tokens in reverse
        for (int i = t.length - 1; i >= 0; i--) {
            if ("+-*/^".contains(t[i]))
                r += t[i] + " ";
            else
                r += t[i] + " ";
        }

        // Proper prefix conversion using operator/operand stacks
        String[] p = new String[t.length];
        int top = -1;

        for (int i = 0; i < t.length; i++) {
            if (!"+-*/^".contains(t[i]))
                p[++top] = t[i];
            else {
                String b = p[top--], a = p[top--];
                p[++top] = t[i] + " " + a + " " + b;
            }
        }
        return p[top];
    }

    static int evaluate(String exp, boolean pre) {
        String[] a = exp.trim().split(" ");
        int[] st = new int[a.length];
        int top = -1;

        for (int i = pre ? a.length - 1 : 0;
             pre ? i >= 0 : i < a.length;
             i += pre ? -1 : 1) {

            if (Character.isDigit(a[i].charAt(0)))
                st[++top] = Integer.parseInt(a[i]);
            else {
                int x = st[top--], y = st[top--];
                st[++top] = pre ? calc(x, y, a[i].charAt(0))
                        : calc(y, x, a[i].charAt(0));
            }
        }
        return st[top];
    }

    public static void main(String[] args) {
        String exp = "12+5*(80-30)/2";

        String pre = prefix(exp);
        String post = postfix(exp);

        System.out.println("Infix   : " + exp);
        System.out.println("Prefix  : " + pre);
        System.out.println("Answer  : " + evaluate(pre, true));
        System.out.println("Postfix : " + post);
        System.out.println("Answer  : " + evaluate(post, false));
    }
}
