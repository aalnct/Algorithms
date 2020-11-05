package ds.leetcode.BinarySearchTree;

/**
 * Created by AmitAgarwal on 5/20/20.
 */
public class BST {

    Node root = null;

    Node xParent = null;
    Node yParent = null;

    int xDepth = -1;
    int yDepth = -1;

    // Will have actual logic for binary insert/ multiple operations

    // Will insert a new node
    public void insertNode(int key, String value){
        if(root == null){
            root = new Node(key, value); // in case root is null
            System.out.println(root.key);
            return;
        }

        Node newNode = new Node(key,value);// else find the right place to insert

        Node currentNode = root;
        Node parent;

        while(true){
            parent = currentNode; // setting a parent node // this is a reference variable, so that we don't get
                                                          // null pointer exception
            if(key < currentNode.key){ // If incoming key is less than currentNode key
                currentNode = currentNode.leftChild;
                if(currentNode == null){
                    //parent.leftChild = newNode; // once find left child as null, insert it
                    parent.leftChild = newNode; // once find left child as null, insert it
                    System.out.println(parent.leftChild.key);
                    return;
                }
            }else {
                currentNode = currentNode.rightChild;
                if(currentNode == null){
                    parent.rightChild = newNode;
                    System.out.println(parent.rightChild.key);
                    return;
                }
            }
        }
    }

    public Node findMin(){
        Node current = root;
        Node last = null;
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax(){
        Node current = root;
        Node last = null;
        while(current!=null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }


    // traverse a binary tree

    public boolean isCousins(Node root, int x, int y){
        // x,y - target
        Node current = root;
        Node parent_x = current;
        Node parent_y = current;
        int count_x = 0;
        int count_y = 0;
        if(root ==  null){
            return false;
        }

        if(root.key == x || root.key == y){
            return false;
        }

        while(current!=null  && x!=current.key){
            parent_x = current;
            //x is always a left child
            current = current.leftChild;
            if(current!=null){
                count_x++; // to measure depth
            }
        }

        //y is right child
        while(current!=null && y != current.key){
            parent_y = current;
            current = current.rightChild;
            if(current!=null){
                count_y++;
            }
        }

        if(count_x == count_y && parent_x.key != parent_y.key){
            // check the parent of x and y
            return true;
        }
        return false;
    }


    public boolean isCousins_1(Node root, int x, int y){
        getDepthAndParents(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent? true: false;
    }

    private void getDepthAndParents(Node root, int x, int y, int depth, Node parent){
        if(root == null){
            return;
        }

        if(root.key == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.key == y){
            yParent = parent;
            yDepth = depth;
        } else {
            getDepthAndParents(root.leftChild, x, y, depth+1, root);
            getDepthAndParents(root.rightChild, x, y, depth+1, root);
        }

    }


}
