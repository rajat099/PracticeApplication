
public class DetectingAndRemovingCircleFromLinkedList {
	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	private int detectAndRemoveLoop(Node node) {
		Node slow = node, fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				System.out.println("Circle found.");
				System.out.println("found at : " + slow.data);
				// removeLoop(slow, node);
				return 1;
			}
		}
		return 0;
	}

	/*
	 * private void removeLoop(Node loop, Node current) { Node ptr1 = null, ptr2 =
	 * null; ptr1 = current; while(true) { ptr2 = loop; while(ptr2.next != loop &&
	 * ptr2.next != ptr1) { ptr2 = ptr2.next; }
	 * 
	 * if(ptr2.next == ptr1) { break; }
	 * 
	 * ptr1 = ptr1.next; } ptr2.next = null; }
	 */

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		DetectingAndRemovingCircleFromLinkedList list = new DetectingAndRemovingCircleFromLinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		list.head.next.next.next.next.next = list.head.next;
		list.detectAndRemoveLoop(list.head);
		// System.out.println("Linked List after removing loop : ");
		// list.printList(list.head);
	}
}
