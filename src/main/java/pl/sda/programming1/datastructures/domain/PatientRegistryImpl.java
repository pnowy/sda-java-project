package pl.sda.programming1.datastructures.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PatientRegistryImpl implements PatientRegistry {

    private Map<Pesel, Patient> records = new HashMap<>();

    @Override
    public void add(Patient patient) {
        if (patient == null) {
            throw new NullPointerException("The patient cannot be null!");
        }
        this.records.put(patient.getPesel(), patient);
    }

    @Override
    public void update(Patient patient) {
        Pesel patientPesel = patient.getPesel();
        if (!this.records.containsKey(patientPesel)) {
            throw new IllegalArgumentException("Please use the add to insert new patient!");
        }
        this.records.put(patientPesel, patient);
    }

    @Override
    public boolean exist(Pesel pesel) {
        return false;
    }

    @Override
    public Optional<Patient> get(Pesel pesel) {
        return Optional.empty();
    }

    @Override
    public int size() {
        return 0;
    }
}
