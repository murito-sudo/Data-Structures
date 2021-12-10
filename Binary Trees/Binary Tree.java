import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(5);
    tree.insert(55);
    tree.insert(44);
    tree.insert(10);
    tree.insert(3);
    tree.insert(21);
    tree.insert(4);
    tree.insert(2);
    tree.insert(13);
    tree.insert(25);
    tree.insert(16);
    tree.insert(7);
    tree.insert(12);
    tree.insert(11);


    tree.lookup(19);
    tree.remove(10);
    tree.lookup(11);

  
    
  

  }
}

class Node{
  Node left, right;
  int value;

  public Node(int value){
    this.left = null;
    this.right = null;
    this.value = value;
  }
}

class BinarySearchTree{
  Node root;
  
  public BinarySearchTree(){
    this.root = null;
  }




  //Breadth first search

  public void BFS(){
    Node node = root;
    Queue<Node> queue = new LinkedList<>(); 
    LinkedList<Integer> list = new LinkedList<>();
    queue.add(node);

    while(queue.size() > 0){
      node = queue.remove();
      System.out.println(node.value);
      list.add(node.value);
      if(node.left != null){
        queue.add(node.left);

      }

      if(node.right != null){
      queue.add(node.right);

      }
    }
  
  }


  public void insert(int value){
    Node newNode = new Node(value);
    if(root == null){
      root = newNode;
    }else{
      
    
        Node dropout = root;
        Node tracker = null;

        while(true){
         /*
          if(dropout.right == null || dropout.left == null){

            if(dropout.right == null && dropout.left != null){
              dropout.right = newNode;
            }else if(dropout.left == null && dropout.right != null){
              dropout.left = newNode;
            }else if(dropout.left == null && dropout.right == null){
              
              if(value < dropout.value){
                dropout.right = newNode;
              }else{
                dropout.left = newNode;
              }
            }
            break;
          }
          */
         

          if(dropout != null){
            if(value < dropout.value){
              tracker = dropout;
              dropout = dropout.left;
            }else{
              tracker = dropout;
              dropout = dropout.right;
            }   
            
          }else{
            if(value < tracker.value){
              dropout = tracker;
              dropout.left = newNode;

            }else{
              dropout = tracker;
              dropout.right = newNode;
            }
            break;
          }
         

          
        }


    }

    System.out.println("Item Added to the Tree" + value);
  }

  public void lookup(int value){
    Node dropout = root;
    //While
    while(dropout != null){
      if(dropout.value == value){
        System.out.println("Leaf Found");
        if(dropout.right == null && dropout.left != null){
          System.out.println("Branch: ");
          System.out.println("    " + dropout.value);
          System.out.print(dropout.left.value);

        }else if(dropout.right != null && dropout.left == null){
          System.out.println("Branch: ");
          System.out.println("    " + dropout.value);
          System.out.print("       " + dropout.right.value);

        }else if(dropout.right != null && dropout.left != null){
           System.out.println("Branch: ");
          System.out.println("    " + dropout.value);
          System.out.println(dropout.left.value + "     " + dropout.right.value);

        }else{
          System.out.println("Branch: ");
          System.out.println("    " + dropout.value);

        }
        break;
      }

      if(value < dropout.value){
        dropout = dropout.left;
      }else{
        dropout = dropout.right;
      }
      

    }
  }


  public boolean remove(int value){
    boolean end = false;
    if(root.right == null && root.left == null){
      root = null;
    }else{
      Node dropout = root;
      Node prev = null;
      while(true){

        if(value == dropout.value){
          if(dropout.right == null && dropout.left == null){
            dropout = prev;
            if(dropout.right.value == value){
              dropout.right = null;
            }else if(dropout.left.value == value){
              dropout.left = null;
            }
          }else if(dropout.left != null && dropout.right == null){
            dropout = prev;
            dropout.left = dropout.left.left;
          }else if(dropout.left == null && dropout.right != null){
            dropout = prev;
            dropout.right = dropout.right.right;
          }else if(dropout.right != null && dropout.left != null){
              Node prev2 = null;
              prev = dropout;
              dropout = dropout.right;

              while(dropout.left != null){
                prev2 = dropout;
                dropout = dropout.left;
              

              }


              if(prev2 == null){
                dropout = prev;
                dropout.right = dropout.right.right;
              }else{
                int reserve = dropout.value;
                
                dropout.left = null;
                dropout = prev;
                dropout.value = reserve;

              }

            
          }else{
              dropout.right = null;
          }

            break;
          }


    
        if(end == true){
          break;
        }

        if(value < dropout.value){
          prev = dropout;
          dropout = dropout.left;
        }else{
          prev = dropout;
          dropout = dropout.right;
        }

        if(dropout.right == null && dropout.left == null){
          end = true;
        }

      }

    }

    

    return true;


  }

  public void printRoot(){
     System.out.println("Branch: ");
      System.out.println("    " + root.value);
      System.out.println(root.left.value + "     " + root.right.value);

  }

}

