package TJCore.utils;

public class Math {

    public static int add(int a, int b) {
        if (b == 0)
            return a;
        else if(a == 0)
            return b;
        return add(a ^ b, (a & b) << 1);
    }
}
