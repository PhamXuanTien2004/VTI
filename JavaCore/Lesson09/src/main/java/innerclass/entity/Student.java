package innerclass.entity;

public class Student {
    private Skin skin;
    private int id;
    private String name;

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Skin skin, int id, String name) {
        this.skin = skin;
        this.id = id;
        this.name = name;
    }

    public static class Skin {
        private String color;

        public Skin(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}

