import org.junit.jupiter.api.*;

public class myCollectionTest {
    @BeforeAll
    public static void beforeClass() {
        System.out.println("before class");
    }

    @BeforeEach
    public void before() {
        System.out.println("-- before");
    }

    @Test
    public void add(){
        System.out.println("----add test");
       myCollection MyCool = new myCollection();
        MyCool.add("15");
        MyCool.add("16");
        MyCool.add("17");
        MyCool.add("18");
        MyCool.add("19");
        System.out.println(MyCool);
    }

    @Test
    public void delete(){
        System.out.println("---- delete test");
      myCollection MyColl = new myCollection();
      MyColl.add("1");
      MyColl.add("2");
      MyColl.add("3");
      MyColl.add("4");
      MyColl.add("5");
      MyColl.delete(2);
        System.out.println(MyColl);
    }

    @Test
    public void get(){
        System.out.println("----get test");
        myCollection myColl = new myCollection();
        myColl.add("1");
        myColl.add("2");
        myColl.add("3");
        myColl.add("4");
        myColl.add("5");
        System.out.println(myColl.get(2));
    }

    @Test
    public void getsize(){
        System.out.println("----getsize test");
        myCollection myColl = new myCollection();
        myColl.add("1");
        myColl.add("2");
        myColl.add("3");
        myColl.add("4");
        myColl.add("5");
        System.out.println(myColl.getsize());
    }

    @Test
    public void clear(){
        System.out.println("----clear test");
        myCollection myColl = new myCollection();
        myColl.add("1");
        myColl.add("2");
        myColl.add("3");
        myColl.add("4");
        myColl.add("5");
        System.out.println(myColl.getsize());
        myColl.clear();
        System.out.println(myColl.getsize());
    }

    @Test
   public void contains(){
        System.out.println("----contains test");
        myCollection myColl = new myCollection();
        myColl.add("1");
        myColl.add("2");
        myColl.add("3");
        myColl.add("4");
        myColl.add("5");
        System.out.println(myColl.contains("4"));
    }

    @Test
    public void idexOf(){
        System.out.println("----indexOf test");
        myCollection myColl = new myCollection();
        myColl.add("1");
        myColl.add("2");
        myColl.add("3");
        myColl.add("4");
        myColl.add("5");
        System.out.println(myColl.indexOf("4"));
    }

    @Test
    public void equals(){
        System.out.println("----equals test");
        myCollection myColl = new myCollection();
        myColl.add("1");
        myColl.add("2");
        myColl.add("3");
        myColl.add("4");
        myColl.add("5");
        myCollection newColl = myColl;
        System.out.println(newColl.equals(myColl));
    }
     @AfterEach
    public void after() {
        System.out.println("-- after");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("after class");
    }

}


