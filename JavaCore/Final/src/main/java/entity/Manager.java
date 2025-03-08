package entity;

public class Manager extends User{
    private int expInYear;
    private int ProjectId;
    public Manager(int id, String fullName, String email,  int expInYear, int ProjectId) {
        super(id, fullName, email);
        this.expInYear = expInYear;
        this.ProjectId = ProjectId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public Manager(int id, String fullName, String email) {
        super(id, fullName, email);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
}