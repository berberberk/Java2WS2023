package pr15;

public class MVCPatternDemo {
    private static Student retrieveStudentFromDB() {
        Student student = new Student();
        student.setName("Тарас");
        student.setId("1");
        return student;
    }
    public static void main(String[] args) {
        Student model = retrieveStudentFromDB();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("Лаврентий");
        controller.setStudentId("2");
        controller.updateView();
    }
}
