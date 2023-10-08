class Point {

    public static String setWorld(String x){
//        x = new String("world");
        x += "teaca";
        return x;
    }

    public static void main(String[] args){
        String x = new String("hello");
        setWorld(x);
        System.out.println(x);
    }
}