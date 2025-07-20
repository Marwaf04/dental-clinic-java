import java.io.Serializable;

public class Individual implements Serializable {
    private String name;
    private String gender;
    private int age;
    private String healthCardNumber;

    public Individual(String name, String gender, int age, String healthCardNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.healthCardNumber = healthCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getHealthCardNumber() {
        return healthCardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Gender: " + gender +
               ", Age: " + age +
               ", Health Card #: " + healthCardNumber;
    }
}
