/** ListNode.java
 * class ListNode representing a node with information and link fields
 * taken from Problem Solving with Java by Elliot Koffman and Ursula Woltz
 * ADS class
 * January 2015
 */

package recursion;

public class ListNode
{
    // Data fields
    private int		data;	// data stored in the node
    private ListNode	link;	//link to link node

    // Methods
    //Constructors
    // postcondition: Creates a new empty node
    public ListNode()
    {
            data = 0;
            link = null;
    }

    // postcondition: Creates a new node storing obj
    public ListNode(int obj)
    {
            data = obj;
            link = null;
    }

    // postcondition: Creates a new node storing obj
    // and linked to node referenced by link.
    public ListNode(int obj, ListNode nxt)
    {
            data = obj;
            link = nxt;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getLink() {
        return link;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }
    
    
} // end of class ListNode