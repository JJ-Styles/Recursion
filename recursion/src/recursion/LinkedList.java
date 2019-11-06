// LinkedList.java
// program demonstrating the implementation and use of a linked-list in java
// taken from Problem Solving with Java by Elliot Koffman and Ursula Woltz
// ADS class
// January 2015

package recursion;

public class LinkedList
{
    // Data fields (member variable)
    private ListNode head;	// pointer to first node in list

    // Methods
    // default constructor - creates an empty list
    public LinkedList()
    {
        head = null;
    }
    
    
    // Constructor - creates a list from an array. The array is passed as a parameter
    public LinkedList(int[] a)
    {
        int size = a.length;
        ListNode newNode = null;
        ListNode prev = null;
        for (int i = 0; i < size; i++)
        {
            newNode = new ListNode(a[size-1 - i], prev);
            prev = newNode;
        }
        head = newNode;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }
    
    // postcondition: Returns the length of this list.
    public int getSize()
    {
        ListNode ptr = head;
       int counter = 0;
       
       while (ptr != null)
       {
           counter ++;
           ptr = ptr.getLink();
       }
       
       return counter;
    }

    
    // postcondition: Adds a node storing obj at front of this list.
    public void addFirst(int obj)
    {
        head = new ListNode(obj,head);
    }
    
    
    // precondition: The last link node has a null link.
    // postcondition: Returns a string formed by concatenating the 
    //	data fields of all list nodes.
    @Override
    public String toString()
    {
        String print = "";
        ListNode ptr = head;
      
        for (int i = 1; i <= getSize(); i++)
        {
            print += ptr.getData() + " ";
            ptr = ptr.getLink();
        }
        
        return print;
    }

    
    // postcondition: Returns int stored at head of this list.
    public int getFirst()
    {
        return head.getData();
    }

    
    // postcondition: Returns int stored at end of this list.
    public int getLast()
    {
        ListNode ptr = head;
       
       while(ptr.getLink() != null)
       {
           ptr = ptr.getLink();
       }
       
       return ptr.getData();
    }
    
       
    // postcondition: Adds a node storing obj at end of this list.
    public void addLast(int obj)
    {
            ListNode ptr = head;
            if (ptr != null)
            {
                while (ptr.getLink() != null)
                {
                    ptr = ptr.getLink();
                }
                ptr.setLink(new ListNode(obj,null));   
            }
            else
            {
                head = new ListNode(obj,head);
            }
    }
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a pointer to node containing a desired value, or null if not found
    public ListNode searchPointer(int n)
    {
        ListNode ptr = head;
        
        while(ptr.getData() != n && ptr.getLink() != null)
        {
            ptr = ptr.getLink();
        }
        
        return ptr.getLink();
    } // end of method searchPointer()
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: returns a one-based index to node containing a desired value, or -1 if not found
    public int searchIndex(int n)
    {
        ListNode ptr = head;
        int index = 1;
        
        while (ptr.getData() != n && ptr.getLink() != null)
        {
            index += 1;
            ptr = ptr.getLink();
        }
        
        return index;
    }// end of method searchIndex()
    
    
    // precondition: list is pointed to by head; last node, if any, points to null
    // postcondition: nth node is deleted if it exists. A 1-based index is used
    public boolean delete(int n)
    {
        ListNode ptr = head;
        ListNode ptr1 = head;
        
        if (n < getSize() && n > 1)
        {
            for (int i = 1; i < n; i++) 
            {
               ptr = ptr.getLink(); 
            }
            for (int i = 1; i <= n; i++) 
            {
                ptr1 = ptr.getLink();
            }
            ptr.setLink(ptr1.getLink());
            ptr1.setLink(null);
            ptr1 = null;
            ptr = null;
            return true;
        }
        else if (n == getSize())
        {
            for (int i = 1; i < n; i++) 
            {
                ptr = ptr.getLink();
            }
            ptr.setLink(null);
            ptr = null;
            return true;
        }
        else if (n == 1)
        {
            head = head.getLink();
            ptr.setLink(null);
            ptr = null;
            return true;
        }
        return false;
    }// end of delete() method
    
    
    // postcondition: retrieves the data stored in node at position index of list.
    public int getAtPos(int index)
    {
        ListNode ptr = head;
       
       if (index <= getSize())
       {
           for (int i = 1; i <=index; i++)
           {
               ptr = ptr.getLink();
           }
           return ptr.getData();
       }
       return -999;
    }

    
    // precondition: a list must exist with at least one node
    // postcondition: Adds a node storing obj after position index in list.
    public boolean addAfterPos(int value, int index)
    {
        if (head != null)
        {
            if (index > getSize())
            {
               ListNode ptr = head;

               while(ptr.getLink() != null)
               {
                   ptr = ptr.getLink();
               }

               ptr.setLink(new ListNode(value,null));
               return true;
            }
            else if (index <= getSize() && index > 0)
            {
               ListNode ptr = head;

               for(int i = 1; i < index; i++)
               {
                   ptr = ptr.getLink();
               }

               ListNode insert = new ListNode(value, ptr.getLink());
               ptr.setLink(insert);
               return true;
            }       
        }
       return false;
    }
    
    
    // Method used in print statements - DO NOT ALTER !
    public String ordinality(int n)
    {
        String pos;
          
        if ((n%10 == 1) && (n != 11))
            pos = "st";
        else if ((n%10 == 2) && (n != 12))
            pos = "nd";
        else if ((n%10 == 3) && (n != 13))
            pos = "rd";
        else
            pos = "th";
        
        return pos;
    }
    
    ListNode toEndOfList(ListNode node)
    {
        if (node.getLink() == null)
            return node;
        else 
            return toEndOfList(node.getLink());
    }
    
    int getSize(ListNode node)
    {
        if (node == null)
            return 0;
        else
            return 1 + getSize(node.getLink());
    }
    
    ListNode toNodeWithVal(int sval, ListNode node)
    {
        if (node == null)
            return node;
        else if (node.getData() == sval)
            return node;
        return toNodeWithVal(sval,node.getLink());
    }
    
    void deleteNodeWithValueRec(int sval, ListNode ptr)
    {
        if (ptr.getLink().getData() == sval)
        {
            ListNode ptr1 = ptr.getLink();
            ptr.setLink(ptr1.getLink());
            ptr1.setLink(null);
            ptr1 = null;
        }
        else
            deleteNodeWithValueRec(sval,ptr.getLink());
    }
        
} // end of class LinkedList
