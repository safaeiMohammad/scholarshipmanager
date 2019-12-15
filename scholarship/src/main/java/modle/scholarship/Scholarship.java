package modle.scholarship;

public class Scholarship {

    private String lastUniversity;
    private String lastGrade;
    private String lsatField;
    private String destinationUniversity;
    private String destinationGrade;
    private String destinationField;
    private String status;
    private String dateRequested;
    private String dataChangeSupervisor;
    private String dataChangeManager;
    private int scholarId;
    private int studentId;
    private double gp;
    private String firstName;
    private String lastName;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(String dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getDataChangeSupervisor() {
        return dataChangeSupervisor;
    }

    public void setDataChangeSupervisor(String dataChangeSupervisor) {
        this.dataChangeSupervisor = dataChangeSupervisor;
    }

    public String getDataChangeManager() {
        return dataChangeManager;
    }

    public void setDataChangeManager(String dataChangeManager) {
        this.dataChangeManager = dataChangeManager;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastUniversity() {
        return lastUniversity;
    }

    public void setLastUniversity(String lastUniversity) {
        this.lastUniversity = lastUniversity;
    }

    public String getLastGrade() {
        return lastGrade;
    }

    public void setLastGrade(String lastGrade) {
        this.lastGrade = lastGrade;
    }

    public String getLsatField() {
        return lsatField;
    }

    public void setLsatField(String lsatField) {
        this.lsatField = lsatField;
    }

    public double getGp() {
        return gp;
    }

    public void setGp(double gp) {
        this.gp = gp;
    }

    public String getDestinationUniversity() {
        return destinationUniversity;
    }

    public void setDestinationUniversity(String destinationUniversity) {
        this.destinationUniversity = destinationUniversity;
    }

    public String getDestinationGrade() {
        return destinationGrade;
    }

    public void setDestinationGrade(String destinationGrade) {
        this.destinationGrade = destinationGrade;
    }

    public String getDestinationField() {
        return destinationField;
    }

    public void setDestinationField(String destinationField) {
        this.destinationField = destinationField;
    }

    public int getScholarId() {
        return scholarId;
    }

    public void setScholarId(int scholarId) {
        this.scholarId = scholarId;
    }
}
