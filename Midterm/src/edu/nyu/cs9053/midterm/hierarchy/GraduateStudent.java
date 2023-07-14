package edu.nyu.cs9053.midterm.hierarchy;

public class GraduateStudent extends Student {
    public GraduateStudent() {
    }

    public GraduateStudent(String name, int age, boolean matriculated) {
        super(name, age, matriculated);
    }

    @Override
    public String toString() {
        return String.format("GraduateStudent [name=%s, age=%d, isMatriculated=%s]", getName(), getAge(),
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
        GraduateStudent other = (GraduateStudent) obj;
        if (getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!getName().equals(other.getName()))
            return false;
        if (getAge() != other.getAge())
            return false;
        if (isMatriculated() != other.isMatriculated())
            return false;
        return true;
    }
}