package Greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class quickSortNotReallyTest {

    @Test
    public void test() {
        ArrayList<quickSortNotReally.Student> students = new ArrayList<>();
        students.add(new quickSortNotReally.Student(1, 2004));
        students.add(new quickSortNotReally.Student(2, 2004));
        students.add(new quickSortNotReally.Student(3, 2022));
        ArrayList<quickSortNotReally.Student> newStudents = new ArrayList<>();
        students.add(new quickSortNotReally.Student(3, 1999));
        students.add(new quickSortNotReally.Student(4, 2003));
        quickSortNotReally.studentSort(students,newStudents);
        for(quickSortNotReally.Student x : students) {
            System.out.println(x.id);
        }
    }

}