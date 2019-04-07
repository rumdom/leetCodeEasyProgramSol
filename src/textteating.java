interface A {
    default void x() {
        System.out.println ( "A" );
    }

    class C implements A{
        public void x(){
            System.out.println ( "C" );
        }
    }
}
//class Me{
//    public static void main(String[] args) {
//        A a=new A ( ) {
//            @Override
//            public void x() {
//
//            }
//        }
//    }
