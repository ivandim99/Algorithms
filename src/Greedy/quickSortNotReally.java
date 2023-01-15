package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class quickSortNotReally {

    public static void studentSort(ArrayList<Student> students,ArrayList<Student> newStudents) {
        Collections.sort(students);
        for(int i = 0 ; i < newStudents.size();i++) {
            students.add(newStudents.get(i));
        }
//        Collections.sort(students);
        Collections.sort(students, Comparator.comparingInt(Student::getStart));
    }

    public static class Student implements Comparable<Student>{
        int id;

        public int getStart() {
            return start;
        }

        int start;

        public Student(int id, int start) {
            this.id = id;
            this.start = start;
        }

        @Override
        public int compareTo(Student o) {
            if (this.start == o.start) {
                return o.id - this.id;
            }
            return this.start - o.start;
        }
    }
}
