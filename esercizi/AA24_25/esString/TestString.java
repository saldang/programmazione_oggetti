
public class TestString {

    public static void main(String[] args) {
        String s1 = "Massimo";
        System.out.println(s1.length());
        System.out.println(s1.indexOf("ssi"));
        System.out.println(s1.indexOf('a'));
        System.out.println(s1.charAt(3));
        String s2 = "massimo";
        String s3 = s1.concat(" ").concat(s2);
        System.out.println(s3);
        System.out.println(s3.indexOf(" "));
        System.out.println(s1.indexOf(" "));
        System.out.println(s3.substring(3, 7));
        System.out.println(s3.substring(3));
        System.out.println(s1.equals(s2));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println("   ".isBlank());
        System.out.println("   ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println("".isBlank());
        System.out.println(" g g ".strip());
        System.out.println(" g g ".replace(" ", ""));
        System.out.println(" g g i i".replace(" g g", "9"));
        System.out.println(" g g i i".replace(" g g", "9"));
        System.out.println(" g g i i".replaceAll("( [a-z]){2}","9"));

        

        
    }
}
