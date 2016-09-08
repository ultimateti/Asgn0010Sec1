package Ass0010Sec1;

import java.util.ArrayList;

class Student {
    private String id, name, surname;
    private int credits;
    private ArrayList<Subject.SubjectInfo> enrolledSubject = new ArrayList<>();
    private boolean submitted, enrolled, graded;

    UI ui = new UI();
    Student(String... info) {
        this.id = info[0];
        this.name = info[1];
        this.surname = info[2];
        this.submitted = false;
        this.enrolled = false;
        this.graded = false;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    int getCredits(){
        return credits;
    }

    void setCredits(int credits) {
        this.credits = credits;
    }

    boolean isSubmitStatus() {
        return submitted;
    }

    void setSubmitStatus(boolean submitStatus) {
        this.submitted = submitStatus;
    }

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    ArrayList<Subject.SubjectInfo> getEnrolledSubject() {
        return enrolledSubject;
    }

    boolean enroll(Subject.SubjectInfo subject){
        int currentCredit = getCredits();
        if(currentCredit + subject.credits > 22){
            ui.printError("Cannot enroll! (Maximum credits exceed)");
            return false;
        }

        enrolledSubject.add(subject);
        setCredits(currentCredit + subject.credits);
        return true;
    }

    boolean remove(Subject.SubjectInfo subject){
        enrolledSubject.remove(subject);
        setCredits(getCredits() - subject.credits);
        return true;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrollStatus(boolean enrollStatus) {
        this.enrolled = enrollStatus;
    }
}
