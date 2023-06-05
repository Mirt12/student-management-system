package web.app.api;

public class TempTest {
    public static void main(String[] args) {
        System.out.println(createStudent());
        System.out.println(createStudent2());
        System.out.println(createStudent3());
    }
    public static String createStudent() {
        String endpoint = "http://localhost:8080/students";
        String body = String.format("{\"firstName\":\"%s,\"lastName\":\"%s\",\"email\":\"%s\"}", "Sergio", "Teacher", "sergio_teacher@anywhere.school");
        return body;
    }

    public static String createStudent2() {
        String endpoint = "http://localhost:8080/students";
        String body = "{\"firstName\":\"" + "Sergio" + ",\"lastName\":\"" + "Teacher" + "\",\"email\":\"" + "sergio_teacher@anywhere.school" + "\"}";
        return body;
    }

    public static String createStudent3() {
        String endpoint = "http://localhost:8080/students";
        StringBuilder str = new StringBuilder();
        str.append("{\"firstName\":\"");
        str.append("Sergio");
        str.append(",\"lastName\":\"");
        str.append("Teacher");
        str.append("\",\"email\":\"");
        str.append("sergio_teacher@anywhere.school");
        str.append("\"}");
        String body = str.toString();
        return body;
    }

}
