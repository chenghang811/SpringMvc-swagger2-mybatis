
public class TestStatic {
    static {
        System.out.println("基础  静态块");
    }

    public TestStatic() {
        System.out.println("基础  构造方法");
    }

    {
        System.out.println("基础  非静态语句块");
    }

    public static void Iint() {
        System.out.println("基础  静态方法Iint");
    }
}
