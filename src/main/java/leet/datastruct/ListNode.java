package leet.datastruct;

public class ListNode
{
	public int val;
	public ListNode next;

	public ListNode()
	{
	}

	public ListNode(int val)
	{
		this.val = val;
	}

	public ListNode(int val, ListNode next)
	{
		this.val = val; this.next = next;
	}

    public int getVal()
    {
        return this.val;
    }

    public ListNode getNext()
    {
        return this.next;
    }

	public void setVal(int val)
	{
		this.val = val;
	}

	public void setNext(ListNode next)
	{
		this.next = next;
	}
}
