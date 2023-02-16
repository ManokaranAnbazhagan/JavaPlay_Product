package Entity;

public class Product {
    private int id;
    private String name;
    private int specId;

    public Product() {
    }

    public Product(int id, String name, int specId) {
        this.id = id;
        this.name = name;
        this.specId = specId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specId=" + specId +
                '}';
    }
}
