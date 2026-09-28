package fr.demo.entities;

public class Formation {
    private final long id;
    private String name;
    private String description;
    private int time;
    private String type;
    private double price;

    public Formation(long id, String name,String description, int time,String type, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.type = type;
        this.price = price;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getTime() { return time; }
    public double getPrice() {return price;}
    public String gettype() { return type; }

    @Override
    public String toString() {
        return "La formation "+ name + " : " + description + " dure " + time + " jours en " + type +" coûte " + price +"€";
    }
}
