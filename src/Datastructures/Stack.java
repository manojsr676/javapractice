package Datastructures;

public class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size){
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    void push(int val){
        if(top == size-1){
            System.out.println("Overflow");
            return;
        }
        top++;
        arr[top] = val;
    }

    void pop(){
        if(top==-1){
            System.out.println("Underflow");
            return;
        }
        top--;
    }

    int Top(){
        if(top==-1){
            System.out.println("Underflow");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty(){
        return top == -1;
    }
}

class ParenthesisChecker {
    public static boolean isBalanced(String expression) {
        Stack st = new Stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                st.push(1); // Push any dummy value
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    return false; // More closing brackets
                }
                st.pop();
            }
        }

        return st.isEmpty(); // True if all open brackets are closed
    }
}

class DriverCode {
    public static void main(String[] args) {
        String expr1 = "((()))";
        String expr2 = "(()))";
        String expr3 = "(()(()))";

        System.out.println("Expression 1 is balanced: " + ParenthesisChecker.isBalanced(expr1));
        System.out.println("Expression 2 is balanced: " + ParenthesisChecker.isBalanced(expr2));
        System.out.println("Expression 3 is balanced: " + ParenthesisChecker.isBalanced(expr3));
    }
}