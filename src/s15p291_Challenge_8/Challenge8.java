package s15p291_Challenge_8;

/* 1.  The Tutor thread calls tutor.studyTime().
* 2.  The Tutor thread dgets the lock for the Tutor object (because the studyTime() method is synchronized).  It prints
* "Tutor has arrived" and waits for the student, which we've simulated by calling sleep().
* 3.  The Student thread runs and calls handInAssignment().  Since the method is synchronized, it gets the lock for the
* Student object.  It calls tutor.getProgressReport(), but the Tutor thread is holding the lock for the tutor object,
* so the Student thread blocks.
* 4.  The Tutor thread wakes up and runs, and calls student.startStudy().  But the method is synchronized, and the
* Student thread is holding the lock for the Student object, so the Tutor thread blocks.
* 5.  We have a deadlock.  Neither thread will ever release the lock that the other thread is waiting for.
* Deadlock!  Essentially, the threads are trying to acqquire the same set of locks in different order.  The tutor thread
* gets the Tutor lock and then wants the Student lock.  The student thread gets the Student lock and then wants the
* Tutor lock.  */

public class Challenge8 {

    public static void main(String[] args) {
        final Tutor tutor = new Tutor();
        final Student student = new Student(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }

}



class Tutor {

    private Student student;


    public synchronized void setStudent(Student student) {
        this.student = student;
    }


    public synchronized void studyTime() {
        System.out.println("Tutor has arrived");
        try {
            // wait for student to arrive and hand in assignment
            Thread.sleep(300);
        }
        catch (InterruptedException e) {
        }
        student.startStudy();
        System.out.println("Tutor is studying with student");
    }


    public synchronized void getProgressReport() {
        // Get progress report.
        System.out.println("Tutor gave progress report");
    }

}



class Student {

    private Tutor tutor;


    Student(Tutor tutor) {
        this.tutor = tutor;
    }


    public synchronized void startStudy() {
        // study
        System.out.println("Student is studying");
    }


    public synchronized void handInAssignment() {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }

}