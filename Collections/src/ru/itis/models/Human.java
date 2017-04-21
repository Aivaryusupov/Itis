package ru.itis.models;

public class Human {
    private int id;
    private String name;
    private int age;

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

        
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Human && obj!=null) {
            if(obj == this) return true;
                Human that = (Human)obj;
                    if(this.id == that.id
                            && this.name.equals(that.name)
                            && this.age == that.age) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.age;
    }
}
