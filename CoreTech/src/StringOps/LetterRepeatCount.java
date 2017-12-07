package StringOps;
public class LetterRepeatCount
{
    public static void main(String[] args)
    {
        String s = "Javaj is java again java again";
 
        char c = 'j';
 
        int count = s.length() - s.toLowerCase().replace("j", "").length();
 
        System.out.println("Number of occurances of 'a' in "+s+" = "+count);
    }
}