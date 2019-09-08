package A161110;

import java.util.*;

public class AVLTreeRemove extends AbstractSet {

    protected Entry root;

    protected int size;

    public boolean remove (Object elem) {
        Entry e = getEntry (elem);
        if (e == null)
            return false;
        deleteEntry (e);
        return true;

    } // method remove

      // Postcondition: the Entry p has been removed from this
    //                BinSearchTree.
    private void deleteEntry (Entry p) {
         size--;

               if (p.left != null && p.right != null) {

             Entry s = successor (p);
             p.element = s.element;
             p = s;
            // swapPositions (s, p);

         } // p has two children

         Entry replacement;

         if (p.left != null)
             replacement = p.left;
         else
             replacement = p.right;

         // If p has at least one child, link replacement to p.parent.
               if (replacement != null) {

                 replacement.parent = p.parent;
                   if (p.parent == null)
                             root = replacement;
                   else if (p == p.parent.left)
                             p.parent.left  = replacement;
                   else
                             p.parent.right = replacement;

          } // p has at least one child
                else if (p.parent == null)
                    root = null;
                else {

                          if (p == p.parent.left)
                              p.parent.left = null;
                          else if (p == p.parent.right)
                              p.parent.right = null;

                } // p has a parent but no children
                fixAfterDeletion(p.element, p.parent);


    } // method deleteEntry

     // Postcondition: if there is an Entry whose element is elem, such an
    //                Entry has been returned.  Otherwise, null has been
    //                returned.
    private Entry getEntry (Object elem) {

        int comp;

              Entry e = root;
              while (e != null) {

                  comp = ((Comparable)elem).compareTo (e.element);
                  if (comp == 0)
                            return e;
                  else if (comp < 0)
                            e = e.left;
                  else
                            e = e.right;

              } // while
              return null;

    } // method getEntry


    protected void fixAfterDeletion (Object elem, Entry ancestor) {

        boolean heightHasDecreased = true;

        while (ancestor!=null && heightHasDecreased) {

            int comp =  ((Comparable)elem).compareTo (ancestor.element);

            if (comp >= 0) {

                if (ancestor.balanceFactor == '=') {

                    ancestor.balanceFactor = 'L';
                    heightHasDecreased = false;

                } // ancestor's balance factor is '='
                else if (ancestor.balanceFactor == 'R') {

                    ancestor.balanceFactor = '=';
                    ancestor=ancestor.parent;

                } // ancestor's balance factor is 'R'
                else if (ancestor.balanceFactor == 'L') {

                    if (ancestor.left.balanceFactor == '=') {

                        ancestor.left.balanceFactor = 'R';
                        ancestor.balanceFactor = 'L';
                        rotateRight (ancestor);
                        heightHasDecreased = false;

                    } // ancestor.left's balance factor is '='
                    else if (ancestor.left.balanceFactor == 'L') {

                        Entry p=ancestor.parent;
                        ancestor.balanceFactor = '=';
                        ancestor.left.balanceFactor = '=';
                        rotateRight (ancestor);
                        ancestor=p;

                    } // ancestor.left's balance is 'L'
                    else if (ancestor.left.balanceFactor == 'R') {

                        Entry p=ancestor.parent;
                        if (ancestor.left.right.balanceFactor == 'L') {

                            ancestor.balanceFactor='R';
                            ancestor.left.balanceFactor = '=';

                        }
                        else if (ancestor.left.right.balanceFactor == 'R') {

                            ancestor.balanceFactor = '=';
                            ancestor.left.balanceFactor = 'L';

                        }
                        else {

                            ancestor.balanceFactor = '=';
                            ancestor.left.balanceFactor='=';

                        }
                        ancestor.left.right.balanceFactor='=';
                        rotateLeft(ancestor.left);
                        rotateRight(ancestor);
                        ancestor=p;
                    }
                }

            }//removed From the right subtree

            else if (comp < 0) {

                if (ancestor.balanceFactor=='=') {

                    ancestor.balanceFactor='R';
                    heightHasDecreased = false;
                }
                else if (ancestor.balanceFactor=='L') {

                    ancestor.balanceFactor='=';
                    ancestor=ancestor.parent;

                }
                else if (ancestor.balanceFactor=='R') {

                    if (ancestor.right.balanceFactor=='=') {

                        ancestor.balanceFactor='R';
                        ancestor.right.balanceFactor='L';
                        rotateLeft(ancestor);
                        heightHasDecreased =false;

                    }
                    else if (ancestor.right.balanceFactor=='R') {

                        Entry p=ancestor.parent;
                        ancestor.balanceFactor = '=';
                        ancestor.right.balanceFactor='=';
                        rotateLeft(ancestor);
                        ancestor=p;

                    }
                    else if (ancestor.right.balanceFactor=='L') {

                        Entry p=ancestor.parent;
                        if (ancestor.right.left.balanceFactor == 'R') {

                            ancestor.balanceFactor='L';
                            ancestor.right.balanceFactor = '=';

                        }
                        else if (ancestor.right.left.balanceFactor == 'L') {

                            ancestor.balanceFactor = '=';
                            ancestor.right.balanceFactor = 'R';

                        }
                        else {

                            ancestor.balanceFactor = '=';
                            ancestor.right.balanceFactor='=';

                        }
                        ancestor.right.left.balanceFactor='=';
                        rotateRight(ancestor.right);
                        rotateLeft(ancestor);
                        ancestor=p;

                    }

                }

            }//removed From the left subtree

        }

    } // method fixAfterDeletion



    // Postcondition: The height of this AVL tree has been returned. The
    //                worstTime (n) is O (log n).
    public int heightIter() {

        int height = -1;
        for (Entry temp = root; temp != null; height++)
            if (temp.balanceFactor == 'L')
                temp = temp.left;
            else
                temp = temp.right;
        return height;

     } // method heightIter



    // Postcondition: the number of elements in this AVLTree has been
    //                returned.
	  public int size() {

	      return size;

	  } // method size()


   protected static int h (Entry p) {

        if (p == null)
            return -1;
        return 1 + Math.max (h (p.left), h (p.right));

    } // method h


    public int height() {

        return h (root);

    } // method height


    public boolean isAVL () {

       return checkAVL (root);

    } // method isAVL


    public static boolean checkAVL (Entry p) {

        if (p == null)
            return true;
        return (Math.abs (h (p.left) - h (p.right)) <= 1 &&
                checkAVL (p.left) && checkAVL (p.right));

    } // method checkAVL


    // Postcondition: an iterator positioned at the first entry in
    //                this AVLTree has been returned.
    public Iterator iterator() {

        return new TreeIterator();

    } // method iterator


    // Postcondition: true has been returned if there is an element e in this
    //                AVLTree such that o.equals (e).  Otherwise, false
    //                has been returned.
    public boolean contains (Object o)  {

        Entry e = root;

        int comp;

        while (e != null) {

            comp =  ((Comparable)o).compareTo (e.element);
            if (comp == 0)
                return true;
            else if (comp < 0)
                e = e.left;
            else
                e = e.right;

        } // while
        return false;
    } // contains


    // Postcondition: if this AVLTree contains an element equal to o,
    //                then false has been returned.  Otherwise, o has been
    //                inserted where it belongs in this AVLTree and
    //                true has been returned.
	  public boolean add (Object o) {

        if (root == null) {

            root = new Entry (o, null);
            size++;
            return true;

        } // empty tree
        else {

            Entry temp = root,
                  ancestor = null;  // nearest ancestor of o
                                    // with balanceFactor not '='

            int comp;

            while (true) {

                comp = ((Comparable)o).compareTo (temp.element);
                if (comp == 0)
                    return false;
                if (comp < 0) {

                    if (temp.balanceFactor != '=')
                        ancestor = temp;
                    if (temp.left != null)
                        temp = temp.left;
                    else {
                        temp.left = new Entry (o, temp);
                        fixAfterInsertion (ancestor, temp.left);
                        size++;
                        return true;

                    } // temp.left == null
                } // comp < 0
                else {

                    if (temp.balanceFactor != '=')
                        ancestor = temp;
                    if (temp.right != null)
                        temp = temp.right;
                    else {

                        temp.right = new Entry (o, temp);
                        fixAfterInsertion (ancestor, temp.right);
                        size++;
                        return true;

                    } // temp.right == null
                } // comp > 0

            } // while

        } // root not null

    } // method add


    // Postcondition: the AVL property has been restored, if
    //                necessary, by rotations and balance-factor
    //                adjustments between the inserted Entry and
    //                its nearest ancestor with a balanceFactor of
    //                'L' or 'R'.
    protected void fixAfterInsertion (Entry ancestor, Entry inserted) {

        Object o = inserted.element;

        if (ancestor == null) {

            if (((Comparable)o).compareTo (root.element) < 0)
                root.balanceFactor = 'L';
            else
                root.balanceFactor = 'R';
            adjustPath (root, inserted);

        } // Case 1: all ancestors of inserted have balanceFactor of '='
        else if ((ancestor.balanceFactor == 'L' &&
                  ((Comparable)o).compareTo (ancestor.element) > 0) ||
                 (ancestor.balanceFactor == 'R' &&
                  ((Comparable)o).compareTo (ancestor.element) < 0)) {

            ancestor.balanceFactor = '=';
            adjustPath (ancestor, inserted);

        } // Case 2: insertion in opposite subtree of ancestor's balanceFactor
        else if (ancestor.balanceFactor == 'R' &&
                 ((Comparable)o).compareTo (ancestor.right.element) > 0) {

            ancestor.balanceFactor = '=';
            rotateLeft (ancestor);
            adjustPath (ancestor.parent, inserted);

        } // Case 3: ancestor's balanceFactor = 'R' and o > ancestor's right element
        else if (ancestor.balanceFactor == 'L' &&
                  ((Comparable)o).compareTo (ancestor.left.element) < 0) {

            ancestor.balanceFactor = '=';
            rotateRight (ancestor);
            adjustPath (ancestor.parent, inserted);

        } // Case 4: ancestor's balanceFactor = 'L' and o < ancestor's left element
        else if (ancestor.balanceFactor == 'L' &&
                  ((Comparable)o).compareTo (ancestor.left.element) > 0) {

            rotateLeft (ancestor.left);
            rotateRight (ancestor);
            adjustLeftRight (ancestor, inserted);

        } // Case 5: ancestor's balanceFactor = 'L' and o > ancestor's left element
        else {

            rotateRight (ancestor.right);
            rotateLeft (ancestor);
            adjustRightLeft (ancestor, inserted);

        } // Case 6: ancestor.balanceFactor = 'R' and o < ancestor.right.element

    } // method fixAfterInsertion


    // Postcondition: the balanceFactors of all entries between the
    //                inserted entry (exclusive) and the to entry (exclusive)
    //                have been adjusted, if necessary.
    private void adjustPath (Entry to, Entry inserted) {

        Object o = inserted.element;

        Entry temp = inserted.parent;
        while (temp != to) {

            if (((Comparable)o).compareTo (temp.element) < 0)
                temp.balanceFactor = 'L';
            else
                temp.balanceFactor = 'R';
            temp = temp.parent;

        } // while

    } // method adjustPath


    private void adjustLeftRight (Entry ancestor, Entry inserted) {

        Object o = inserted.element;

        if (ancestor.parent == inserted) // case 5a
            ancestor.balanceFactor = '=';
        else if (((Comparable)o).compareTo (ancestor.parent.element) < 0) {

            // case 5b
            ancestor.balanceFactor = 'R';
            adjustPath (ancestor.parent.left, inserted);

        }
        else { // case 5c

            ancestor.balanceFactor = '=';
            ancestor.parent.left.balanceFactor = 'L';
            adjustPath (ancestor, inserted);

        } // o > ancestor's parent

    } // method adjustLeftRight


    private void adjustRightLeft (Entry ancestor, Entry inserted) {

        Object o = inserted.element;

        if (ancestor.parent == inserted) // case 6a
            ancestor.balanceFactor = '=';
        else if (((Comparable)o).compareTo (ancestor.parent.element) > 0) {

            // case 6b
            ancestor.balanceFactor = 'L';
            adjustPath (ancestor.parent.right, inserted);

        } // o > ancestor's parent
        else {

            // case 6c
            ancestor.balanceFactor = '=';
            ancestor.parent.right.balanceFactor = 'R';
            adjustPath (ancestor, inserted);

        } // o < ancestor's parent

    } // method adjustRightLeft

     /** From CLR **/
    private void rotateLeft(Entry p) {
	Entry r = p.right;
	p.right = r.left;
	if (r.left != null)
	    r.left.parent = p;
	r.parent = p.parent;
	if (p.parent == null)
	    root = r;
	else if (p.parent.left == p)
	    p.parent.left = r;
	else
	    p.parent.right = r;
	r.left = p;
	p.parent = r;
    }

    /** From CLR **/
    private void rotateRight(Entry p) {
	Entry l = p.left;
	p.left = l.right;
	if (l.right != null) l.right.parent = p;
	l.parent = p.parent;
	if (p.parent == null)
	    root = l;
	else if (p.parent.right == p)
	    p.parent.right = l;
	else p.parent.left = l;
	l.right = p;
	p.parent = l;
    }


 /*   // Postcondition: if, before this call, this AVLTree contained an
    //                element equal to elem, then an element equal to elem
    //                has been removed from this AVLTree and true has
    //                been returned. Otherwise, false has been returned.
    public boolean remove (Object elem) {

        throw new UnsupportedOperationException();

    } // method remove
  */

    // Postcondition: if e has a successor, that successor Entry has been
    //                returned.  Otherwise, null has been returned.
     private Entry successor (Entry e) {

	       if (e == null)
	           return null;
	       else if (e.right != null) {

             // successor is leftmost Entry in right subtree of e
	           Entry p = e.right;
	           while (p.left != null)
		             p = p.left;
	           return p;

	      } // e has a right child
        else {

            // go up the tree to the left as far as possible, then go up
            // to the right.
	          Entry p = e.parent;
	          Entry ch = e;
	          while (p != null && ch == p.right) {

		            ch = p;
		            p = p.parent;

	          } // while
	          return p;

	      } // e has no right child

    } // method successor

     private static class Entry {

        Object element;

        char balanceFactor = '=';

        Entry left = null,
              right = null,
              parent;

        // Postcondition: this Entry has been initialized from element and
        //                parent.
        Entry (Object element, Entry parent) {

            this.element = element;
            this.parent = parent;

        } // constructor

    } // class Entry


    private class TreeIterator implements Iterator {

	      private Entry lastReturned = null;
	      private Entry next;


        // Postcondition: next has been initialized to the smallest
        //                Entry in this AVLTree.
	      TreeIterator() {

            next = root;
            if (next != null)
                while (next.left != null)
                    next = next.left;

        } // default constructor


        // Postcondition: true has been returned if this TreeIterator
        //                is not positioned beyond the end of the
        //                binary search tree.  Otherwise, false
        //                has been returned.
	      public boolean hasNext() {

	          return next != null;

	      } // method hasNext


        // Postcondition: the next element in the binary search tree
        //                has been returned.
	      public Object next() {

	          lastReturned = next;
	          next = successor(next);
	          return lastReturned.element;

	      } // method next


        // Precondition: the element that was last returned
        //               by this TreeIterator is still in this AVLTree. 
        // Postcondition: the element last returned by this TreeIterator
        //                has been removed from the binary search tree.
 	      public void remove() {

            if (lastReturned.left != null && lastReturned != null)
                next = lastReturned;
	          deleteEntry(lastReturned);
	          lastReturned = null;

	      } // method remove

    } // class TreeIterator


} // class AVLTree

