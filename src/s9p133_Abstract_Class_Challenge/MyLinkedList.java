package s9p133_Abstract_Class_Challenge;

public class MyLinkedList implements NodeList {

    private ListItem root = null;


    public MyLinkedList(ListItem root) {
        this.root = root;
    }


    @Override
    public ListItem getRoot() {
        return root;
    }


    @Override
    public boolean addItem(ListItem newItem) {
        /* If the list is empty, this item becomes the head of the list.  */
        if(root == null) {
            root = newItem;
            return true; // Represents new item.
        }

        /* Set currentItem to head of the list.  */
        ListItem currentItem = root;
        /* While currentItem is not null, compare items in the list one by one.  If currentItem = null, that means
        * there is no more entries.  */
        while(currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            /* If currentItem (value) happens alphabetically before newItem (item), such as currentItem is "a" and
            newItem is "b", or if newItem is null, return negative number.  Insert newItem after.  */
            if (comparison < 0) {
                /* If next item (rightLink) is not null, and newItem is a null or alphabetically after currentItem,
                call the next() method move to the right of the list (set currentItem = rightLink), means currentItem
                is now the next item.  */
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                }
                /* There is no next item, so insert at end of the list.  */
                else {
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }
            /* If currentItem (value) happens alphabetically after newItem (item), such as currentItem is "b" and
            newItem is "a", return positive number.  Insert newItem before.  */
            else if (comparison > 0) {
                /* If previous item (leftLink) is not null, and newItem is alphabetically before currentItem.  */
                if(currentItem.previous() != null) {
                    /* Insert newItem before the currentItem.  */
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }
                else {
                    /* The node with a previous is the root.  Set newItem point to root, root is now the rightLink.  */
                    newItem.setNext(root).setPrevious(newItem);
                    root = newItem;
                }
                return true;
            }
            /* If newItem and currentItem share the same String value, means newItem already exist.  */
            else {
                System.out.println(newItem.getValue() + " is already present, not added.  ");
                return false;
            }
        }

        /* If currentItem is null and root is not null, return false.  */
        return false;
    }


    @Override
    public boolean removeItem(ListItem item) {
        /* If item is not null, print out a message that says the item will be deleted.  */
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        /* Set currentItem to root.  */
        ListItem currentItem = root;

        /* While currentItem is not null.  */
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            /* If currentItem and item share the same value, that means item exists in the list, that means we should
            * delete it.  */
            if(comparison == 0) {
                /* If currentItem is the root, set root equal to the next item, since currentItem will be deleted.  */
                if (currentItem == root) {
                    root = currentItem.next();
                }
                else {
                    /* Look at what the previous entry is, set that point to what the current item next.  */
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                /* Return true because I find the record and made those changes.  */
                return true;
            }
            /* If I can't find the matching item yet, I want to continue to navigate through link list.  */
            else if (comparison < 0) {
                /* Start checking the next item.  */
                currentItem = currentItem.next();
            }
            /* comparison > 0.  We are at an item greater than the one to b edeleted, so the item is not in the list.  */
            else {
                return false;
            }
        }

        // We have reached the end of the list without finding the item on the list.
        return false;
    }


    /* Check the root and see if the list is empty, if it is, return a message.  */
    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            System.out.println("The list is empty.  ");
        }
        else {
            /* If root is not null, print out every element of the list.  */
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next(); // Set root to next item every iteration.
            }
        }
    }

}
