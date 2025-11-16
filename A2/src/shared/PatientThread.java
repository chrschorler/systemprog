package shared;

import b.MedicalPractice;

public class PatientThread extends Thread {

    private Patient patient;
    private IMedicalPractice practice;

    public PatientThread(Patient patient, IMedicalPractice practice) {
        this.patient = patient;
        this.practice = practice;
    }

    @Override
    public void run() {
        practice.treatPatient(patient);
    }
}
