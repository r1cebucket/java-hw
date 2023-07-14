package edu.nyu.cs9053.midterm.hierarchy;

public abstract class Student extends UniversityAffiliate {
    private boolean matriculated;

    public Student() {
    }

    public Student(String name, int age, boolean matriculated) {
        super(name, age);
        this.matriculated = matriculated;
    }

    public void setMatriculated(boolean matriculated) {
        this.matriculated = matriculated;
    }

    public boolean isMatriculated() {
        return this.matriculated;
    }

    @Override
    public String toString() {
        return String.format("Student [name=%s, age=%d, isMatriculated=%s]", getName(), getAge(),
                isMatriculated());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!getName().equals(other.getName()))
            return false;
        if (getAge() != other.getAge())
            return false;
        if (matriculated != other.matriculated)
            return false;
        return true;
    }
}