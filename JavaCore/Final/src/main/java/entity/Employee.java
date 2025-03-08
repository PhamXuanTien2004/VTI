package entity;

public class Employee extends User{
    private String ProSkill;
    private int ProjectId;


    public Employee(int id, String fullName, String email, String ProSkill, int ProjectId) {
        super(id, fullName, email);
        this.ProjectId = ProjectId;
        this.ProSkill = ProSkill;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }
}
