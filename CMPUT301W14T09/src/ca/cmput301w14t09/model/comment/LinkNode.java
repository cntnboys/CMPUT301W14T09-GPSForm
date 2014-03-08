package ca.cmput301w14t09.model.comment;

/*
 * LinkedNode encloses any data object node, to be used as a Node for LinkedList.
 */
final class LinkNode {
	private Object node;
	private LinkNode next;
	private LinkNode prev;
	
	public LinkNode(Object node) {
		this(null, node, null);
	}

	public LinkNode(LinkNode prev, Object node, LinkNode next) {
		this.prev = prev;
		this.node = node;
		this.next = next;
	}
	
	public Object getNode() { return node; }
	public LinkNode getNext() { return next; }
	public LinkNode getPrev() { return prev; }
	
	public void setNext(LinkNode next) { this.next = next; }
	public void setPrev(LinkNode prev) { this.prev = prev; }
}