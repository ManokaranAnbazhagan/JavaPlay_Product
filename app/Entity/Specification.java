package Entity;

public class Specification {
    public String specName;
    public String SpecValue;

    @Override
    public String toString() {
        return "Specification{" +
                "specName='" + specName + '\'' +
                ", SpecValue='" + SpecValue + '\'' +
                '}';
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecValue() {
        return SpecValue;
    }

    public void setSpecValue(String specValue) {
        SpecValue = specValue;
    }

    public Specification(String specName, String specValue) {
        this.specName = specName;
        SpecValue = specValue;
    }
}
