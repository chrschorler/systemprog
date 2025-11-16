package a;
import shared.Patient;

public class PatientThread extends Thread {
    private Patient patient;
    private MedicalPractice practice;

    public PatientThread(Patient patient, MedicalPractice practice) {
        this.patient = patient;
        this.practice = practice;
    }

    @Override
    public void run() {
        practice.treatPatient(patient);
    }
}
