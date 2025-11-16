import java.util.*;

class Student implements Comparable<Student>{
    int rollNo;
    String name;

    Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }

    // compare by roll number when sort is called
    @Override
    public int compareTo(Student s){
        return Integer.compare(this.rollNo, s.rollNo);
    }

    public String toString(){
        return rollNo + " - "  + name;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.name.compareToIgnoreCase(s2.name);
    }
}

public class j1 {
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student(103, "Apeksha"));
        list.add(new Student(101, "Rohit"));
        list.add(new Student(104, "Sneha"));
        list.add(new Student(102, "Vivek"));

        System.out.println("Original List: ");
        for(Student s: list){
            System.out.println(s);
        }

        Collections.sort(list);
        System.out.println("\nSorted by Roll Number: ");
        for(Student s: list){
            System.out.println(s);
        }

        Collections.sort(list, new NameComparator());
        System.out.println("\nSorted by Name: " );
        for(Student s: list){
            System.out.println(s);
        }

        System.out.println("\nUsing Iterator: ");
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Map<Integer, Student> map = new HashMap<>();
        for(Student s:list){
            map.put(s.rollNo, s);
        }

        System.out.println("\nMap Contents: ");
        for(Map.Entry<Integer, Student> e:map.entrySet()){
            System.out.println(e.getKey() + " => " + e.getValue());
        }

        
        if(list instanceof RandomAccess){
            System.out.println("\nAccess element at index 2: "+ list.get(2));
        }
    }
}