package A161110;

import java.util.*;

public class AVLTreeTester implements Process {

    protected final String PROMPT =
        "In the Input line, please enter the number of elements. ";
    protected GUI gui;
    protected AVLTree myTree;
    protected Random random;

    public AVLTreeTester() {
        myTree = new AVLTree();
        random = new Random (100000);
        gui = new GUI (this);
        gui.println (PROMPT);

    } // constructor

    // Postcondition: One line of input has been processed.
    public void processInput (String s) {
        final String SIZE_MESSAGE = "The tree size is ";
        final String CLOSE_WINDOW_MESSAGE =
            "Please close this window when you are ready.";
        Iterator itr;
        int num;
        int n = Integer.parseInt (s);

        while (myTree.size() < n)
           myTree.add (new Integer (random.nextInt()));

        if (myTree.isAVL())
            gui.println ("This AVLTree's height is " + myTree.height());
        else
            gui.println ("failure");
        gui.println (CLOSE_WINDOW_MESSAGE);
        gui.freeze();

    } // method processInput
} // class AVLTreeTester


