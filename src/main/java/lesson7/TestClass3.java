package lesson7;

public class TestClass3 {

    @BeforeSuite
    public static void Before(){
        System.out.println("3 Run before");
    }
    @Test(priority = 10)
    public static void Test10() {
        System.out.println("3 Test from Method with priority 10");
    }
    @Test(priority = 1)
    public static void Test1() {
        System.out.println("3 Test from Method with priority 1");
    }
    @Test(priority = 4)
    public static void Test5() {
        System.out.println("3 Test from Method with priority 4");
    }
    @Test(priority = 4)
    public static void Test4() {
        System.out.println("3 Test from Method with priority 4");
    }
    @Test(priority = 7)
    public static void Test7() {
        System.out.println("3 Test from Method with priority 7");
    }
    @Test(priority = 8)
    public static void Test8() {
        System.out.println("3 Test from Method with priority 8");
    }
    @AfterSuite
    public static void After(){
        System.out.println("3 Run after");
    }
}
