package entity;

public class Engineer {
    private int id_engineer;
    private String name;
    private String specialty;

    public Engineer(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public Engineer() {

    }

    public int getId_engineer() {
        return id_engineer;
    }

    public void setId_engineer(int id_engineer) {
        this.id_engineer = id_engineer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Engineer {" +
                "id_engineer = " + id_engineer +
                ", name = '" + name + "\'" +
                ", specialty = '" + specialty + "\'" +
                "}";
    }
}
