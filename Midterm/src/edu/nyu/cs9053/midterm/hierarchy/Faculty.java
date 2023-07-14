package edu.nyu.cs9053.midterm.hierarchy;

public abstract class Faculty extends Employee {
    private boolean tenured;
    private boolean adjunct;

    public Faculty() {
    }

    public Faculty(String name, int age, double salary, boolean tenured, boolean adjunct) {
        super(name, age, salary);
        this.tenured = tenured;
        this.adjunct = adjunct;
    }

    public void setTenured(boolean tenured) {
        this.tenured = tenured;
    }

    public void setAdjunct(boolean adjunct) {
        this.adjunct = adjunct;
    }

    public boolean isTenured() {
        return this.tenured;
    }

    public boolean isAdjunct() {
        return this.adjunct;
    }

    @Override
    public String toString() {
        return String.format("Faculty [name=%s, age=%d, salary=%f, isTenured=%s, isAdjunct=%s]", getName(), getAge(),
                getSalary(), isTenured(), isAdjunct());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Faculty other = (Faculty) obj;
        if (tenured != other.tenured)
            return false;
        if (adjunct != other.adjunct)
            return false;
        return true;
    }

}