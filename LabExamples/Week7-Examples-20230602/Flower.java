public class Flower implements Comparable<Flower> {
    private String name;
    private String color;
    private int petalCount;

    public Flower(String name, String color, int petalCount) {
        this.name = name;
        this.color = color;
        this.petalCount = petalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPetalCount() {
        return petalCount;
    }

    public void setPetalCount(int petalCount) {
        this.petalCount = petalCount;
    }

    @Override
    public int compareTo(Flower other) {
        return this.petalCount - other.petalCount;
    }
}
