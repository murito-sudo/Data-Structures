//School System that let you know which school is  the nearest from you
//Using a binary search tree
import java.util.*;
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.insert(100, "Cochire");
    binaryTree.insert(600, "Cicre");
    binaryTree.insert(1000, "SEK");
    binaryTree.insert(800, "Palma Real");
    
    /*
    System.out.println(binaryTree.search("Cochire"));
    System.out.println(binaryTree.search("Cicre"));
    System.out.println(binaryTree.search("Palma Real"));
    System.out.println(binaryTree.search("SEK"));
    System.out.println(binaryTree.search("Cocire"));
    */

    binaryTree.sortNearest();

  }
}


class School{

  double distance;
  String schoolName;
  School right;
  School left;
  int schoolTotal;
  
  public School(double distance, String schoolName){
    this.distance = distance;
    this.schoolName = schoolName;
    this.schoolTotal = 0;

  }

  


}


class BinaryTree{
  

  School rootByName;
 


  public BinaryTree(){
    rootByName = null;

  }
  

  public void insert(double distance, String name){
    School school = new School(distance, name);
    school.right = null;
    school.left = null;

    if(rootByName == null){
      rootByName = school;

    }else{
      School reference = rootByName;
      while(reference != null){
        if(school.schoolName.compareTo(reference.schoolName) == -1){
          if(reference.left == null){
            reference.left = school;
            return;
          }
          reference = reference.left;

        }else{
          if(reference.right == null){
            reference.right = school;
            return;
          }
          reference = reference.right;
        }

      }


    }

    school.schoolTotal++;


  }

  public String search(String schoolName){
      if(rootByName == null){
        return "There are No School nearby";
      }else{
        School reference = rootByName;
        while(reference != null){
          if(reference.schoolName.equals(schoolName)){
            return "Found School: " + schoolName + " Distance: "
            + reference.distance;
          }

          if(reference.schoolName.compareTo(schoolName) == 1){
            reference = reference.left;

          }else{
            reference = reference.right;

          }


        }

      }
      return "School not found";
    
  }

  public void delete(String schoolName){
    School reference = rootByName;
    if(schoolName.equals(rootByName.schoolName)){
      if(reference.right == null && reference.left == null){
        rootByName = null;
      }else if(reference.right != null && reference.left == null){
        rootByName = reference.right;

      }else if(reference.right == null && reference.left != null){
        rootByName = reference.left;
      }else if(reference.right != null && reference.left != null){
         School previous = null;
          if(reference.left.right != null){
            reference = reference.left.right;
            while(reference != null){
              previous = reference;
              reference = reference.left;
            }
            reference = previous;
            rootByName.left.schoolName = reference.left.schoolName;
            rootByName.left.distance = reference.left.distance;
            reference.left = null;

          }else{
            rootByName.schoolName = reference.left.schoolName;
            rootByName.distance = reference.left.distance;
            reference.left = reference.left.left;
          }

          
          

      }

    


      //Below is the condition if the schoolName is not in the root


    }else{
      reference = rootByName;
      School previous = null;

      while(reference != null){
        if(reference.schoolName.equals(schoolName)){
           if(reference.right == null && reference.left != null){
             reference = previous;
             reference.left = reference.left.left;


           }else if(reference.left == null && reference.right != null){

             reference = previous;
             reference.right = reference.right.right;

           }else if(reference.left == null && reference.right == null){

             reference = previous;
             if(reference.right.schoolName.equals(schoolName)){
              reference.right = null;
             }else{
               reference.left = null;
             }

           }else if(reference.right != null && reference.left != null){
             School anotherReference = reference;
             anotherReference = anotherReference.right;

             while(anotherReference != null){
                previous = anotherReference;
                anotherReference = anotherReference.left;
             }

              reference.schoolName =anotherReference.schoolName;
              reference.distance = anotherReference.distance;
              anotherReference = previous;
              if(anotherReference.left == null){
                reference.right = reference.right.right;
              }else{
                anotherReference.left = null;
              }

           }


          break;
        }

        if(reference.schoolName.compareTo(schoolName) == 1){
            previous = reference;
            reference = reference.left;

         }else{
           previous = reference;
           reference = reference.right;
         }

      }
      
    }


    


  }


  public void sortNearest(){
    if(rootByName == null){
      System.out.println("No schools Available");
      return;
    }

    int count = 1;
    LinkedList<School> lista = new LinkedList<>();
    Queue<School> queue = new LinkedList<>();
    School reference = rootByName;
    lista.add(reference);
    queue.add(reference);

    while(queue.size() > 0){
      reference = queue.remove();
      if(reference.left != null){
        lista.add(reference.left);
        queue.add(reference.left);
        count++;
      }

      if(reference.right != null){
        lista.add(reference.right);
        queue.add(reference.right);
        count++;
      }
    }

    School[] array = new School[lista.size()];
    for(int x = 0; x < lista.size(); x++){
      array[x] = lista.get(x);
    }
    
   
    quickSort(array);

  }

  public void quickSort(School[] array){
    int pivot = array.length - 1;
    School pointer;
    School[] right;
    School[] left;

    if(array.length <= 1){
      return;
    }

    for(int x = pivot; x >= 0; x--){
      if(x == 0){
        break;
      }
      
      if(array[x].distance < array[x-1].distance){
        pointer = array[x];
        array[x] = array[x-1];
        array[x-1] = pointer;
      }else{
        int temporaryPivot = x-1;
        for(int y = temporaryPivot; y >= 0; y--){
          if(y == 0){
            break;
          }
          if(array[x].distance < array[x-1].distance){
              pointer = array[x];
              array[x] = array[x-1];
              array[x-1] = pointer;
          }

        }

      }

    }

    if(array.length % 2 == 0){
      right = new School[array.length / 2];
      left = new School[array.length / 2];
    }else{
      right = new School[(array.length / 2) + 1 ];
      left = new School[array.length / 2];
    }

    pivot = 0;
    for(int x = pivot; x < left.length; x++){
      left[pivot] = array[pivot];
      pivot++;
      
    }

    for(int x = 0; x < right.length; x++){
      right[x] = array[pivot];
      pivot++;
    }
    quickSort(left);
    quickSort(right);


   
    if(array.length-1 == rootByName.schoolTotal && array.length != 0){
      
        for(int x = 0; x < left.length; x++){
          System.out.println("School: " + left[x].schoolName);
          System.out.println("distance: " + left[x].distance);
          System.out.println("----------------------------");

      }


      for(int x = 0; x < right.length; x++){
          System.out.println("School: " + right[x].schoolName);
          System.out.println("distance: " + right[x].distance);
          System.out.println("----------------------------");

    

      }


    }
   



  }

}