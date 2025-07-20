import java.io.*;
import java.util.*;

public class DentalClinicDriver {
    private static final String DATA_FILE = "clinic_data.txt";
    private static Clinic clinic = new Clinic();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        int choice;
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1 -> addNewIndividual();
                case 2 -> clinic.displayAllIndividuals();
                case 3 -> searchByHealthCard();
                case 4 -> deleteByHealthCard();
                case 5 -> updateByHealthCard();
                case 6 -> exportToCSV();
                case 7 -> {
                    saveData();
                    System.out.println("Goodbye! Data saved.");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }

    private static void displayMenu() {
        System.out.println("\n=== Dental Clinic Management System ===");
        System.out.println("1. Add New Patient");
        System.out.println("2. Display All Patients");
        System.out.println("3. Search by Health Card Number");
        System.out.println("4. Delete by Health Card Number");
        System.out.println("5. Update Patient Info");
        System.out.println("6. Export Patients to CSV");
        System.out.println("7. Exit");
    }

    private static void addNewIndividual() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        int age = getIntInput("Enter age: ");

        System.out.print("Enter health card number: ");
        String hcn = scanner.nextLine();

        if (clinic.searchByHealthCardNumber(hcn) != null) {
            System.out.println("Patient with this health card already exists.");
            return;
        }

        clinic.addIndividual(new Individual(name, gender, age, hcn));
        System.out.println("Patient added.");
    }

    private static void searchByHealthCard() {
        System.out.print("Enter health card number: ");
        String hcn = scanner.nextLine();
        Individual i = clinic.searchByHealthCardNumber(hcn);
        System.out.println(i != null ? i : "Patient not found.");
    }

    private static void deleteByHealthCard() {
        System.out.print("Enter health card number: ");
        String hcn = scanner.nextLine();
        boolean deleted = clinic.deleteByHealthCardNumber(hcn);
        System.out.println(deleted ? "Patient deleted." : "Patient not found.");
    }

    private static void updateByHealthCard() {
        System.out.print("Enter health card number: ");
        String hcn = scanner.nextLine();
        Individual i = clinic.searchByHealthCardNumber(hcn);
        if (i == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Leave blank to keep existing value.");

        System.out.print("New name (" + i.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) i.setName(name);

        System.out.print("New gender (" + i.getGender() + "): ");
        String gender = scanner.nextLine();
        if (!gender.isEmpty()) i.setGender(gender);

        System.out.print("New age (" + i.getAge() + "): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) i.setAge(Integer.parseInt(ageInput));

        System.out.println("Patient updated.");
    }

    private static void exportToCSV() {
        try (PrintWriter writer = new PrintWriter("patients.csv")) {
            writer.println("Name,Gender,Age,HealthCardNumber");
            for (Individual i : clinic.getAll()) {
                writer.printf("%s,%s,%d,%s\n",
                        i.getName(), i.getGender(), i.getAge(), i.getHealthCardNumber());
            }
            System.out.println("Exported to patients.csv");
        } catch (IOException e) {
            System.out.println("Error exporting: " + e.getMessage());
        }
    }

    private static int getIntInput(String prompt) {
        int value = -1;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            clinic = (Clinic) ois.readObject();
            System.out.println("Loaded data from file.");
        } catch (Exception e) {
            System.out.println("Starting with empty clinic data.");
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(clinic);
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }
}
