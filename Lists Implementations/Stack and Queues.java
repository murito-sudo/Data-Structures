class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
      Queue queue = new Queue();
      queue.enqueue("ss");
      queue.enqueue("aa");
      System.out.println(queue.peek());
      queue.dequeue();
      System.out.println(queue.peek());
      queue.dequeue();
      System.out.println(queue.peek());

    

  }
}



// Stack Implementation with Nodes

class Stack{

  Node stack;
  private int index = 0;

  public Stack(){
    stack = new Node();

  }

  public String peek(){
    Node n = stack;
    for(int x = 0; x < index; x++){
      n = n.stack;
    }

    return n.data;
  }

  public void push(String data){
    Node node = new Node();
    node.data = data;
    node.stack = null;
    node.index = index;
    index++;

    if(isEmpty()){
      node.stack = stack;
      stack = node;
    }else{
      Node n = stack;
      for(int x = 0; x < index - 1; x++){
        n = n.stack;
      }
      n.stack = node;

    }


  }

  public void pop(){
    Node n = stack;
    for(int x = 0; x < index - 1; x++){
      	n = n.stack;
    }

    n.stack = null;
    index--;

  }

  public boolean isEmpty(){
    if(stack.stack == null){
        return true;
    }
    return false;

  }

  public int getLength(){
    Node n = stack;
    int count = 0;
    while(n.stack != null){
      n = n.stack;
      count++;
    }
    return count;
  }

}

class Node{
  Node stack;
  String data;
  int index;
}


//Queue Implementation
class Queue{

  QNode first, last;
  QNode queue;
  private int count = 0;

  public Queue(){
    this.first = null;
    this.last = null;
    queue = new QNode();
  }

  public String peek(){
    if(count == 0){
      return "No elements";
    }
    
    return first.data;
  }

  public void enqueue(String data){
    QNode qnode = new QNode();
    qnode.data = data;
    qnode.queue = null;
    if(isEmpty()){
        queue= qnode;
        first = queue;
      

    }else{
      QNode q = queue;

      for(int x = 0; x < count - 1; x++){
        q = q.queue;
      }

      q.queue = qnode;
      last = qnode;
    }

    count++;
    

  }

  public void dequeue(){
    if(count == 0){
      System.out.println("Queue Empty");

    }else if(count == 1){
      first = null;
      queue = new QNode();
      count--;

    }else{
      QNode q = queue;
      queue = q.queue;
      first = queue;
      count--;
    }

  }

  public boolean isEmpty(){
    if(count == 0){
      return true;
    }
    return false;

  }


}

class QNode{
  QNode queue;
  String data;
  

}
