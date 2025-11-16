package a;

import shared.Patient;

class TreatmentRoom {

    private int roomNumber;

    public TreatmentRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void registerPatient(Patient patient) {
        System.out.println(patient.getName() + " is waiting for treatment in Room " + roomNumber);
        patient.setAdmissionTime(System.currentTimeMillis());
    }

    public void startTreatment(Patient patient) {
        patient.setTreatmentStart(System.currentTimeMillis());
        System.out.println("START >>> " + "ROOM " + roomNumber + " >>> Treatment of " + patient.getName() + " in Room " + roomNumber +
                " started. Treatment time " + patient.getTreatmentDuration() + " seconds");

        try {
            Thread.sleep(patient.getTreatmentDuration() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("END   >>> " + "ROOM "  + roomNumber + " >>> Patient " + patient.getName() + " is done and had a waiting time of " +
                patient.getWaitingTime() + " seconds");
    }
}

