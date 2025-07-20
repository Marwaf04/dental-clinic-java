import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clinic implements Serializable {
    private List<Individual> individuals;

    public Clinic() {
        individuals = new ArrayList<>();
    }

    public void addIndividual(Individual i) {
        individuals.add(i);
    }

    public void displayAllIndividuals() {
        if (individuals.isEmpty()) {
            System.out.println("No patients in the clinic.");
            return;
        }

        System.out.println("\n--- Patient List ---");
        for (Individual i : individuals) {
            System.out.println(i);
        }
    }

    public Individual searchByHealthCardNumber(String hcn) {
        for (Individual i : individuals) {
            if (i.getHealthCardNumber().equalsIgnoreCase(hcn)) {
                return i;
            }
        }
        return null;
    }

    public boolean deleteByHealthCardNumber(String hcn) {
        Individual target = searchByHealthCardNumber(hcn);
        if (target != null) {
            individuals.remove(target);
            return true;
        }
        return false;
    }

    public List<Individual> getAll() {
        return individuals;
    }
}
