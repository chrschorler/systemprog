package c;

import shared.Patient;

public class TreatmentRoom {

    private int roomNumber;
    private Semaphore semaphore;

    public TreatmentRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.semaphore = new Semaphore(1); // only one patient at a time per room
    }

    public void registerPatient(Patient patient) {
        System.out.println(patient.getName() + " is waiting for treatment in Room " + roomNumber);
        patient.setAdmissionTime(System.currentTimeMillis());
    }

    public void startTreatment(Patient patient) {
        semaphore.p(); // acquire the semaphore

        try {
            patient.setTreatmentStart(System.currentTimeMillis());
            System.out.println("START >>> " + "ROOM " + roomNumber + " >>> Treatment of " + patient.getName() + " in Room " + roomNumber +
                    " started. Treatment time " + patient.getTreatmentDuration() + " seconds");

            Thread.sleep(patient.getTreatmentDuration() * 1000L);

            System.out.println("END   >>> " + "ROOM "  + roomNumber + " >>> Patient " + patient.getName() + " is done and had a waiting time of " +
                    patient.getWaitingTime() + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            semaphore.v(); // release the semaphore
        }
    }
}
