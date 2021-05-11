package sample.model;

public class Driver {
    private String firstname;
    private String lastname;
    private String email;
    private Integer work_skills;

    public Driver() {
    }

    public Driver(String firstname, String lastname, String email, Integer work_skills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.work_skills = work_skills;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWork_skills() {
        return work_skills;
    }

    public void setWork_skills(Integer work_skills) {
        this.work_skills = work_skills;
    }
}
