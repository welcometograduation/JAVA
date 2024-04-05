import java.util.*;
public class S5Q1 {
    public static void main(String[] args) {
        Hashtable<String, String> studentDetails = new Hashtable<>();
        studentDetails.put("1234567890", "John Doe");
        studentDetails.put("9876543210", "Jane Smith");
        studentDetails.put("9998887776", "Alice Johnson");
        System.out.println("Student Details:");
        Enumeration<String> mobileNumbers = studentDetails.keys();
        while (mobileNumbers.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentDetails.get(mobileNumber);
            System.out.println("Mobile Number: " + mobileNumber + ", Name: " + studentName);
        }
    }
}
