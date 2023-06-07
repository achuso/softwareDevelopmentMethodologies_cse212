public class Main{
    public static void main(String args[]){
        String s1="word";
        String s2="word";
        String s3="worl";
        String s4="wdrd";
        String s5="flag";



        System.out.println(s1.compareTo(s2)); //equal -> 0
        System.out.println(s1.compareTo(s3)); //not equal -> -8 since l is 8 smaller than d
        System.out.println(s1.charAt(3) - s3.charAt(3)); //the difference operation
        
        System.out.println(s1.compareTo(s4)); //not equal -> 11 since d is 17 larger than o
        System.out.println(s1.compareTo(s5)); //17 since f is 17 times greater than w
        
        

        String a1 = "turkey";
        String a2 = "TURKEY";
        System.out.println(a1.compareTo(a2));
        System.out.println(a2.compareTo(a1));

        System.out.println(a1.compareToIgnoreCase(a2));


        // a b c d e f g h i j k l m n o p r s t u v w x y z
    }
}