class Main {
  public static void main(String[] args) {
  
    LinkedList list = new LinkedList();
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.insert(6);
    list.insert(8);
    list.insert(100);


 
    list.show(); 
  }

}


class LinkedList{
  Node head;
  int index = 0;
 



  public void insert(int data){
    Node node = new Node();
    node.data = data;
    node.index = index;
    index++;
    

    if(head==null){
      head = node;
      head.reference = node;
    }else{
      Node n = head;
      n = head.reference;
      n.next = node;
      head.reference = node;
    }

    head.size++;
  }


  public int size(){
    return head.size;
  }


  public void insertAt(int index, int data){
    Node node = new Node();
    node.data = data;
    node.next = null;


    if(index == 0){
      insertAtFirst(data);
      return;
    }
    Node n = head;
    for(int i=0; i<index-1; i++){
      n = n.next;

    }

    node.next = n.next;
    n.next = node;
  }


  public void replaceAt(int index, int data){
    Node node = new Node();
    node.data = data;
    node.next = null;

    if(index == 0){
      replaceAtFirst(data);
      return;
    }

    Node n = head;
    for(int i = 0; i < index; i++){
      n = n.next;
    }

    n.data = node.data;
  }

  public void replaceAtFirst(int data){
    Node node = new Node();
    node.data = data;
    Node n = head;
    n = n.next;
    node.next = n;
    head = node;
  }

  public void insertAtFirst(int data){
    Node node = new Node();
    node.data = data;
    node.next = head;
    head = node;
  }

  public void removeAtFirst(){
    Node n = head;
    head = n.next;
  }

  public void updateAt(int index, int data){
    Node n = head;
    int count = 0;

    while(index != count){
      n = n.next;
      
    }    

  }


  public void show(){
    Node n = head;
    while(n.next != null){
      System.out.println(n.data);
      n = n.next;
    }
    System.out.println(n.data);
  }


  public int get(int index){
    Node n = head;

    if(index == 0){
      return head.data;
    }else{
      for(int x = 0; x < index ; x++){
        n = n.next;
      }

    }

    
    
    return n.data;
  }


  public boolean contains(int data){
    Node n = head;
    

    for(int x = 0; x < index; x++){
      if(n.data == data){
        return true;
      }
      n = n.next;
    }
    return false;
  }

  public void remove(int index){
    Node n = head;
    Node newN = null;
    if(index == 0){
      removeAtFirst();
    }else{
      for(int x = 0; x < index - 1; x++){
        n = n.next;
      }

      newN = n.next;
      n.next = newN.next;
    }

  }
  
}


class Node{
  int data;
  int index;
  int size = 0;
  Node next;
  Node reference;
}