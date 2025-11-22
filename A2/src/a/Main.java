package a;

import shared.Patient;
import shared.PatientThread;

public class Main {

    public static void main(String[] args) {
        MedicalPractice practice = new MedicalPractice(2);

        Patient mueller = new Patient("Mueller", 1, 3);
        Patient mayer = new Patient("Mayer", 2, 4);
        Patient holger = new Patient("Holger", 1, 5);
        Patient horst = new Patient("Horst", 2, 6);
        Patient schulze = new Patient("Schulze", 1, 7);
        Patient hans = new Patient("Hans", 2, 8);

        PatientThread t1 = new PatientThread(mueller, practice);
        PatientThread t2 = new PatientThread(mayer, practice);
        PatientThread t3 = new PatientThread(holger, practice);
        PatientThread t4 = new PatientThread(horst, practice);
        PatientThread t5 = new PatientThread(schulze, practice);
        PatientThread t6 = new PatientThread(hans, practice);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}