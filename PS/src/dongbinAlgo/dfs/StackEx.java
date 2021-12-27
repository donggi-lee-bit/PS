package dongbinAlgo.dfs;

import java.util.Stack;

public class StackEx {

    public static void main(String[] args) {
        Stack st = new Stack();

        st.add(5);
        st.add(2);
        st.add(3);
        st.add(7);
        st.pop();
        st.add(1);
        st.add(4);
        st.pop();

        System.out.println(st);
    }
}
