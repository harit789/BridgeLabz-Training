public class MakeTheStringGreat {
	class Solution {
		public String makeGood(String s) {
			Stack<Character> st = new Stack<>();
			for (char curr : s.toCharArray()) {
				int ascii = (int) curr;
				if (ascii < 97 && !st.isEmpty()) {
					char ch = st.peek();
					if (ch == (char) (ascii + 32)) {
						st.pop();
					} else {
						st.push(curr);
					}
				} else if (ascii > 96 && !st.isEmpty()) {
					char ch = st.peek();
					if (ch == (char) (ascii - 32)) {
						st.pop();
					} else {
						st.push(curr);
					}
				} else {
					st.push(curr);
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!st.isEmpty()) {
				sb.append(st.pop());
			}
			sb.reverse();
			return sb.toString();
		}
	}
}