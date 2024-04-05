import java.util.*;
public class S6Q1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Set<Integer> s = new TreeSet<>();
        System.out.println("Enter number of integers : ");
        int n = sc.nextInt();
        System.out.println("Enter "+n+" Integers : ");
        for (int i=0;i<n;i++){
            int num = sc.nextInt();
            s.add(num);
        }
        System.out.println("Integers in  sorted order : \n"+s);
        System.out.println("Enter number to search in collection : ");
        int key = sc.nextInt();
        if (s.contains(key))
            System.out.println("Number "+key+" found in collection\n");
        else    
        System.out.println("Number "+key+" not found in collection\n");
    }
}