#Arrays LinkedList & SkipList
<br></br>
##Look into java source code: ArrayList, LinkedList
<br></br>
##Array - Search(Time Complexity: O(1)) - PC create memory address for each item in the array, memory controller can easily visit item by memory address
![Image of /array](imgs//array.jpg)
##Array - Insert(TC: O(1) -> O(n) => O(n)) - insert D:  move E, F, G down first, then insert D
![Image of /array_1](imgs//array_1.jpg)
##Array - Delete(TC: O(1) -> O(n) => O(n)) - delete Z:  delete Z first, then move E, F, G Up
![Image of /array_2](imgs//array_2.jpg)
```
Source Code: ArrayList.java
    /**
     * This helper method split out from add(E) to keep method
     * bytecode size under 35 (the -XX:MaxInlineSize default value),
     * which helps when add(E) is called in a C1-compiled loop.
     */
    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean add(E e) {
        modCount++;
        add(e, elementData, size);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                         elementData, index + 1,
                         s - index);
        elementData[index] = element;
        size = s + 1;
    }
```
<br></br>
##LinkedList - element normally defined by Class
![Image of /linkedlist](imgs//linkedlist.jpg)
```
Source Code: LinkedList.java

public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
    transient int size = 0;

    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;

... more

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

... more
}
```
##LinkedList - Insert(TC: O(1))
![Image of /linkedlist_1](imgs//linkedlist_1.jpg)
##LinkedList - Delete(TC: O(1))
![Image of /linkedlist_2](imgs//linkedlist_2.jpg)
##LinkedList - Search(TC: O(1) -> O(n) => O(n))
##LinkedList - TC Summary:
![Image of /linkedlist_3](imgs//linkedlist_3.jpg)
<br></br>
##SkipList - (Improving LinkedList: 升维思想 + 空降换时间) - Add layers of indexing
![Image of /skiplist](imgs//skiplist.jpg)
##SkipList - normally add log(2n) indexing
![Image of /skiplist_1](imgs//skiplist_1.jpg)
##SkipList - (TC: O(logN))
![Image of /skiplist_2](imgs//skiplist_2.jpg)
![Image of /skiplist_3](imgs//skiplist_3.jpg)
##SkipList - (SC: O(n))
![Image of /skiplist_4](imgs//skiplist_4.jpg)
<br></br>
##Industry
![Image of /industry](imgs//industry.jpg)