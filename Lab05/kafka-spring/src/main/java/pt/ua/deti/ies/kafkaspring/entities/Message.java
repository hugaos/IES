package pt.ua.deti.ies.kafkaspring.entities;

public class Message {
    private String nMec;
    private int generatedNumber;
    private String type;

    // Getters and Setters
    public String getNMec() {
        return nMec;
    }
    public void setNMec(String nMec) {
        this.nMec = nMec;
    }
    public int getGeneratedNumber() {
        return generatedNumber;
    }
    public void setGeneratedNumber(int generatedNumber) {
        this.generatedNumber = generatedNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
