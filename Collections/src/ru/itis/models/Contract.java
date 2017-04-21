package ru.itis.models;

public class Contract {
    private int id;
    private String nameFirst;
    private String nameSecond;
    private String date;

    public Contract(int id, String nameFirst, String nameSecond, String date) {
        this.id = id;
        this.nameFirst = nameFirst;
        this.nameSecond = nameSecond;
        this.date = date;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof Contract) {
            Contract that = (Contract) object;
            return this.id == that.id &&
                    this.nameFirst.equals(that.nameFirst) &&
                    this.nameSecond.equals(that.nameSecond) &&
                    this.date.equals(that.date);
        }
        return false;
    }
}
