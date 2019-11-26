

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;

public class myCollection <E> {

   // private final int sizeColl = 10;
    public   E[] array ;
    public   int count = 0;

    public myCollection(){
        array = (E[]) new Object[0];
    }

    public boolean add(E item){

        if (count == array.length) {
              E[] newArray = array;
              array = (E[]) new Object[newArray.length+1];
              System.arraycopy(newArray,0,array,0,newArray.length);
             // array = newArray;
              array[array.length-1] = item;
              count++;
        }
          return true;
    }


    public void delete(int index){
        E[] newArray = array;
        array = (E[]) new Object[newArray.length-1];
        System.arraycopy(newArray,0,array,0,index);
        int elemAfterIndex = newArray.length - index -1;
        count-=1;
        System.arraycopy(newArray,index+1 ,array, index,elemAfterIndex);

    }

    public E get (int index){
       return (E) array[index];
    }

    public int getsize(){
        return count;
    }

    public void clear() {
        final Object[] es = array;
        for (int to = count, i = count = 0; i < to; i++)
            es[i] = null;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        return indexOfRange(o, 0, count);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = array;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof List)) {
            return false;
        }
        boolean equal = (o.getClass() == myCollection.class)
                ? equalsArrayList((myCollection<?>) o)
                : equalsRange((List<?>) o, 0, count);
        return equal;
    }

    boolean equalsRange(List<?> other, int from, int to) {
        final Object[] es = array;
        if (to > es.length) {
            throw new ConcurrentModificationException();
        }
        var oit = other.iterator();
        for (; from < to; from++) {
            if (!oit.hasNext() || !Objects.equals(es[from], oit.next())) {
                return false;
            }
        }
        return !oit.hasNext();
    }

    private boolean equalsArrayList(myCollection<?> other) {
        final int s = count;
        boolean equal;
        if (equal = (s == other.count)) {
            final Object[] otherEs = other.array;
            final Object[] es = array;
            if (s > es.length || s > otherEs.length) {
                throw new ConcurrentModificationException();
            }
            for (int i = 0; i < s; i++) {
                if (!Objects.equals(es[i], otherEs[i])) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }
    @Override
    public String toString() {
        return "myCollection{" +
                "array=" + Arrays.toString(array) +
                '}';
    }


 public static void main(String[] args) {
        // write your code here
        //Collections col1= creatFirstCollections();

         myCollection MyCollection = new myCollection();
         MyCollection.add("1");
         MyCollection.add("2");
         MyCollection.add("3");
         MyCollection.add("4");
         MyCollection.add("5");
         MyCollection.add("6");
         MyCollection.add("7");
         MyCollection.add("8");
         MyCollection.add("9");
         MyCollection.add("10");
         MyCollection.add("11");
         MyCollection.add("12");
         MyCollection.add("13");

         myCollection newCollect = MyCollection;
         System.out.println(MyCollection.toString());
         System.out.println(MyCollection.getsize());
         System.out.println(MyCollection.get(5));
         MyCollection.delete(5);
         System.out.println(MyCollection.get(5));
         System.out.println(MyCollection.toString());
         System.out.println(MyCollection.contains("10"));
         System.out.println(MyCollection.indexOf("13"));
         System.out.println(MyCollection.equals(newCollect));
         MyCollection.clear();
         System.out.println(MyCollection.getsize());

    }

}
