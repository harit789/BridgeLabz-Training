import java.util.Stack;

public class BrowserBuddy {
	public static void main(String args[]) {
		Stack<TabHistory> st = new Stack<>();
		TabHistory tab1 = new TabHistory();
		tab1.newPage("www.google.com");
		tab1.newPage("www.youtube.com");
		
		st.push(tab1);
		
		System.out.println(tab1.getCurrentPage());
		tab1.back();
		System.out.println(tab1.getCurrentPage());
	}
}

class TabHistory {
	class HistoryNode {
		String url;
		HistoryNode next;
		HistoryNode prev;

		public HistoryNode(String url) {
			this.url = url;
			this.next = null;
			this.prev = null;
		}
	}

	private HistoryNode head;
	private HistoryNode tail;
	private HistoryNode curr;

	public void newPage(String url) {
		HistoryNode newPage = new HistoryNode(url);
		if (curr == null) {
			head = newPage;
			head.prev = null;
			curr = newPage;
			tail = newPage;
		} else if(curr.next != null){
			curr.next.prev = null;
			curr.next = null;
		}
			curr.next = newPage;
			newPage.prev = curr;
			curr = newPage;
			tail = newPage;
	}
	
	public void back() {
		if(curr != null && curr.prev != null) {
			curr = curr.prev;
		}
	}
	
	public void forward() {
		if(curr != null && curr.next != null) {
			curr = curr.next;
		}
	}
	
	public String getCurrentPage() {
		return curr != null? curr.url : null;
	}

}