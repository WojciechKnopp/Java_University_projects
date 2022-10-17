import java.util.ArrayList;

public class Armstrong {
    public static boolean isArmstrong(int n){
        double length = 0;
        int result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = n; i>0; length++, i/=10){
            numbers.add(i%10);
        }

        for(int i=numbers.size(); i>0; i--){
            result+= Math.pow(numbers.get(i-1), length);
        }
        if(result==n) return true;
        return false;
    }
}
