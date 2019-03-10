package pl.sda.programming1.datastructures.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;

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
        Objects.requireNonNull(pesel, "Pesel cannot be null");
        return this.records.containsKey(pesel);
    }

    @Override
    public Optional<Patient> get(Pesel pesel) {
        return Optional.ofNullable(this.records.get(pesel));
    }

    @Override
    public int size() {
        return this.records.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.records.entrySet().stream().forEach(new Consumer<Map.Entry<Pesel, Patient>>() {
            @Override
            public void accept(Map.Entry<Pesel, Patient> entry) {
                sb.append(entry.getValue()).append("\n");
            }
        });
        return sb.toString();
    }
}
