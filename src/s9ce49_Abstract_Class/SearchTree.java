package s9ce49_Abstract_Class;

public class SearchTree implements NodeList {

    private ListItem root = null;


    public SearchTree(ListItem root) {
        this.root = root;
    }


    @Override
    public ListItem getRoot() {
        return this.root;
    }


    @Override
    public boolean addItem(ListItem newItem) {
        if (root == null) {
            root = newItem;
            return true;
        }

        ListItem currentItem = root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                }
                else {
                    currentItem.setNext(newItem);
                    return true;
                }
            }
            else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                }
                else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }
            else {
                System.out.println(newItem.getValue() + " is already present, don't add.  ");
                return false;
            }
        }
        return false;
    }


    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
            else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
            else {
                // Equal: we've found the item so remove it.
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }


    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            }
            else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            }
            else {
                root = item.previous();
            }
        } else if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                root = item.next();
            }
        }
        else {
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());
            if (leftmostParent == item) {
                item.setNext(current.next());
            }
            else {
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}