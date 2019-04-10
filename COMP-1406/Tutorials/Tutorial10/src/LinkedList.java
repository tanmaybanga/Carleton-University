public class LinkedList {
    Item head;
    Item tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    // Add an item to the end of the list
    public void add(Item x) {
        if (tail == null) {
            tail = x;
            head = x;
        }
        else {
            tail.next = x;
            x.previous = tail;
            tail = x;
        }
    }

    // Remove the given item from the list
    public void remove(Item x) {
        if (x == head) {
            if (x == tail) {
                head = tail = null;
            }
            else {
                head = x.next;
                head.previous = null;
            }
        }
        else {
            if (x == tail) {
                tail = x.previous;
                tail.next = null;
            }
            else {
                x.previous.next = x.next;
                x.next.previous = x.previous;
            }
        }
    }

    // Return a string representation of the list
    public String toString() {
        if (head == null)
            return "[EMPTY]";

        String s = "[H:";
        Item currentItem = head;
        while (currentItem != null) {
            s += currentItem.data;
            if (currentItem != tail)
                s += "]<==>[";
            currentItem = currentItem.next;
        }
        return s + ":T]";
    }

    // Add up the total data in the list
    public int totalData() {
        if (head == null)
            return 0;

        int  total = 0;
        Item currentItem = head;
        while (currentItem != null) {
            total += currentItem.data;
            currentItem = currentItem.next;
        }
        return total;
    }

    // Add up the total data in the list using recursion
    public int totalDataRecursive() {
        return totalDataRecursive(head);
    }

    // Add up the total data in the list using recursion
    private int totalDataRecursive(Item start) {
        if (start == null)
            return 0;
        return start.data + totalDataRecursive(start.next);
    }

    // Return a new linked list containing all items with odd data from this list using recursion
    public LinkedList oddItems() {
        return oddItems(head);
    }

    // Return all items with odd data in the list using recursion
    private LinkedList oddItems(Item start) {
        if (start == null)
            return new LinkedList();

        LinkedList result = oddItems(start.next);

        if (start.data %2 != 0)
            result.add(new Item(start.data));

        return result;
    }

    // Return all items with odd data in the list using recursion
    private LinkedList oddItems2(Item startItem, LinkedList resultList) {
        if (startItem == null)
            return resultList;

        if (startItem.data %2 != 0)
            resultList.add(new Item(startItem.data));

        return oddItems2(startItem.next, resultList);
    }

    // Return a new linked list containing all common elements of the two lists
    public LinkedList inCommon(LinkedList aList) {
        return inCommon(this.head, aList.head, new LinkedList());
    }

    // Return all items which are common between the two lists
    private LinkedList inCommon(Item start1, Item start2, LinkedList result) {
        if ((start1 == null) || (start2 == null))
            return result;

        if (contains(start1,start2.data))
            result.add(new Item(start2.data));

        return inCommon(start1, start2.next, result);
    }

    // Return a boolean indicating whether or not the list contains a given item's data
    public boolean contains(Item startItem, byte data) {
        if (startItem == null)
            return false;
        if (startItem.data == data)
            return true;
        else
            return contains(startItem.next, data);
    }

    public boolean isInIncreasingOrder() {
        return false;  //. Replace this code with your own
    }
}
