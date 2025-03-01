public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Start");

        try{
            show();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            System.out.println("Finally");
        }

        System.out.println("End");

    }

    private static void show() {
        int[] a= new int[]{1,2,3,4,5};
        System.out.println(a[10]);
    }
}
