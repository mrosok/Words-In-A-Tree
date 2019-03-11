package no.martr;

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    private boolean isEmpty() {
        return (root == null);
    }

    void insert(String word) {
        Node newNode = new Node(word);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node current = root;
        boolean finished = false;

        //Setter inn nye ord som blader i treet
        while (!finished) {
            
            //hvis ordet er alfabetisk før ordet i noden
            if (word.compareTo(current.word) < 0) {
                if(current.left == null) {
                    current.left = newNode;
                    finished = true;
                } else
                    current = current.left;

              //hvis ordet er likt ordet i noden
            } else if (word.compareTo(current.word) == 0) {
                current.count++;
                finished = true;

                //hvis ordet er alfabetisk etter ordet i noden
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    finished = true;
                } else
                    current = current.right;
            }
        }
    }

    void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            root.write();
            inorder(root.right);
        }
    }

    private class Node {
        String word;
        int count;
        Node left, right;

        Node(String word) {
            this.word = word;
            this.count = 1;
            left = right = null;
        }

        void write() {
            System.out.println(word + " " + count + " ");
        }
    }
}
