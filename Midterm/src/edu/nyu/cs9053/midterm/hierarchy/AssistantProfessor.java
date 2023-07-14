package edu.nyu.cs9053.midterm.hierarchy;

public class AssistantProfessor extends Faculty {
    public AssistantProfessor() {
    }

    public AssistantProfessor(String name, int age, double salary, boolean tenured, boolean adjunct) {
        super(name, age, salary, tenured, adjunct);
    }

    @Override
    public String toString() {
        return String.format("AssistantProfessor [name=%s, age=%d, salary=%f, isTenured=%s, isAdjunct=%s]", getName(),
                getAge(),
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
        return true;
    }
}