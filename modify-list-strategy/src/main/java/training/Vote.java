package training;

import java.util.Objects;

public class Vote {
    private int date;
    private String name;
    private boolean vote;

    public Vote(int d, String n, boolean v) {
        this.date = d;
        this.name = n;
        this.vote = v;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote1 = (Vote) o;
        return Objects.equals(this.name.toUpperCase(), vote1.name.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name.toUpperCase());
    }
}
