package b;

import shared.Patient;

public class PatientThread extends Thread {

    private Patient patient;
    private MedicalPractice practice;

    public PatientThread(String name, Patient patient, MedicalPractice practice) {
        super(name);
        this.patient = patient;
        this.practice = practice;
    }

    @Override
    public void run() {
        practice.treatPatient(patient);
    }
}
