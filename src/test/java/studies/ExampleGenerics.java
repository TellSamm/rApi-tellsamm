package studies;

public class ExampleGenerics<T, V> {

    private String string = "";

    public String getString() {
        return string;
    }

    public void addToString(T t, V v) {


        if (this.string.equals("")) {
            this.string = this.string + t.toString() + v.toString();
        } else {
            this.string = this.string + " - " + t.toString() + v.toString(); //test = 42
        }
    }

    public void addToStringTest(T tellSamm, V meTest) {
        String testSamm = this.string = this.string + " - " + tellSamm.toString() + meTest.toString();
        System.out.println(testSamm); // test = 22
    }


    public <J, P> void addToStringTest2(J tellSamm2, P meTest2) {
        String testSamm = this.string + " - " + tellSamm2.toString() + meTest2.toString();
        System.out.println(testSamm);// test = false = true
    }

}
