package A161124_1;

/****************************  SplayTree.java  ************************
 *                     generic splaying tree class
 */

public class SplayTree extends BST {
    public SplayTree() {
        super();
    }
    private void continueRotation(BSTNode gr, BSTNode par,
                                  BSTNode ch, BSTNode desc) {
        if (gr != null) {                    // if p has a grandparent;
             if (gr.right == ((SplayTreeNode)ch).parent)
                  gr.right = ch;
             else gr.left  = ch;
        }
        else root = ch;
        if (desc != null)
             ((SplayTreeNode)desc).parent = par;
        ((SplayTreeNode)par).parent = ch;
        ((SplayTreeNode)ch).parent = gr;
    }
    private void rotateR(SplayTreeNode p) {
        p.parent.left = p.right;
        p.right = p.parent;
        continueRotation(((SplayTreeNode)p.parent).parent,p.right,p,p.right.left);
    }
    private void rotateL(SplayTreeNode p) {
        p.parent.right = p.left;
        p.left = p.parent;
        continueRotation(((SplayTreeNode)p.parent).parent,p.left,p,p.left.right);
    }
    private void semisplay(SplayTreeNode p) {
        while (p != root) {
            if (((SplayTreeNode)p.parent).parent == null) // if p's parent is 
                 if (p.parent.left == p)              // the root;
                      rotateR(p);
                 else rotateL(p);
            else if (p.parent.left == p)     // if p is a left child;
                 if (((SplayTreeNode)p.parent).parent.left == p.parent) {
                      rotateR((SplayTreeNode)p.parent);
                      p = (SplayTreeNode)p.parent;
                 }
                 else {
                      rotateR((SplayTreeNode)p); // rotate p and its parent;
                      rotateL((SplayTreeNode)p); // rotate p and its new parent;
                 }
            else                             // if p is a rigth child;
                 if (((SplayTreeNode)p.parent).parent.right == p.parent) {
                      rotateL((SplayTreeNode)p.parent);
                      p = (SplayTreeNode)p.parent;
                 }
                 else {
                      rotateL(p);            // rotate p and its parent;
                      rotateR(p);            // rotate p and its new parent;
                 }
                 if (root == null)           // update the root;
                      root = p;
        }
    }
}

