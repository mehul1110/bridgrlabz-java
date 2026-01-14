public class NullPointerDemo {
    public static void generateNullPointer() {
        String s = null;
        // this will throw NullPointerException
        System.out.println(s.length());
    }

    public static void handleNullPointer() {
        String s = null;
        try {
            System.out.println(s.length());
        } catch (NullPointerException ex) {
            System.out.println("Caught NullPointerException: string is null");
        }
    }

    public static void main(String[] args) {
        // first generate (will throw)
        try {
            generateNullPointer();
        } catch (NullPointerException ex) {
            System.out.println("generateNullPointer threw: " + ex.getClass().getSimpleName());
        }
        // now handle
        handleNullPointer();
    }
}
