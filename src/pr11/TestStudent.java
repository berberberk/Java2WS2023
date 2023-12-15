package pr11;

public class TestStudent {
    public static void insertionSort(Student[] arr) {
        int min;
        int j;
        for (int i = 1; i < arr.length; i++) {
            min = i;
            Student tmp = arr[i];
            for (j = i; j > 0 && (tmp.compareTo(arr[j - 1]) < 0); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(18, "Дмитрий"),
                new Student(1, "Арсений"),
                new Student(15, "Георгий"),
                new Student(7, "Виктория"),
                new Student(3, "Борис")
        };
        for (Student s : students) {
            System.out.println(s);
        }
        insertionSort(students);
        System.out.println();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
