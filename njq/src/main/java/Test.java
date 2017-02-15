import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        //        Integer a = 200;
        //        Integer b = 200;
        //        System.out.println(a == b);
        //TestStatic.Iint();
        //User.Iint();
        // User.IintTest();
        //        TestStatic user = new User();
        //
        //        System.out.println("第二次执行-------------");
        //        User user2 = new User();
        //
        BigDecimal a = new BigDecimal("22.22");
        BigDecimal b = new BigDecimal("22.22");
        BigDecimal c = null;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }

}
