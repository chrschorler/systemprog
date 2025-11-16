package shared;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Patient mueller = new Patient("Mueller", 1, 2);
        Patient mayer = new Patient("Mayer", 2, 3);
        Patient holger = new Patient("Holger", 1, 4);
        Patient horst = new Patient("Horst", 2, 5);
        Patient schulze = new Patient("Schulze", 1, 6);
        Patient hans = new Patient("Hans", 2, 7);

        Patient[] patients = {mueller, mayer, holger, horst, schulze, hans};

        // solution a
        System.out.println("---- Solution a: Synchronized Block ----\n");
        IMedicalPractice practiceA = new a.MedicalPractice(2);
        Thread[] threadsA = new Thread[patients.length];
        for (int i = 0; i < patients.length; i++) {
            threadsA[i] = new PatientThread(patients[i], practiceA);
            threadsA[i].start();
        }
        for (Thread t : threadsA) {
            t.join();
        }

        // solution b
        System.out.println("\n\n---- Solution b: Synchronized Method ----\n");
        IMedicalPractice practiceB = new b.MedicalPractice(2);
        Thread[] threadsB = new Thread[patients.length];
        for (int i = 0; i < patients.length; i++) {
            threadsB[i] = new PatientThread(patients[i], practiceB);
            threadsB[i].start();
        }
        for (Thread t : threadsB) {
            t.join();
        }

        // solution c
        System.out.println("\n\n---- Solution c: Semaphore ----\n");
        IMedicalPractice practiceC = new c.MedicalPractice(2);
        Thread[] threadsC = new Thread[patients.length];
        for (int i = 0; i < patients.length; i++) {
            threadsC[i] = new PatientThread(patients[i], practiceC);
            threadsC[i].start();
        }
        for (Thread t : threadsC) {
            t.join();
        }
    }
}