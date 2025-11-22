package b;

import shared.Patient;

public class Main {

    public static void main(String[] args) {
        MedicalPractice practice = new MedicalPractice(2);

        Patient mueller = new Patient("Mueller", 1, 4);
        Patient mayer = new Patient("Mayer", 2, 3);
        Patient holger = new Patient("Holger", 1, 5);
        Patient horst = new Patient("Horst", 1, 7);
        Patient schulze = new Patient("Schulze", 2, 5);
        Patient hans = new Patient("Hans", 2, 2);

        PatientThread t1 = new PatientThread("T1", mueller, practice);
        PatientThread t2 = new PatientThread("T2", mayer, practice);
        PatientThread t3 = new PatientThread("T3", holger, practice);
        PatientThread t4 = new PatientThread("T4", horst, practice);
        PatientThread t5 = new PatientThread("T5", schulze, practice);
        PatientThread t6 = new PatientThread("T6", hans, practice);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
