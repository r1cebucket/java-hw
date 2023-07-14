package edu.nyu.cs9053.midterm.hierarchy;

public class Staff extends Employee {
    private String title;

    public Staff() {
    }

    public Staff(String name, int age, double salary, String title) {
        super(name, age, salary);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Staff [name=%s, age=%d, salary=%f, title=%s]", getName(), getAge(), getSalary(),
                getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Staff other = (Staff) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

}