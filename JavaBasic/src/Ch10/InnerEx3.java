package Ch10;

class InnerEx3 {
    private int outerlv = 0;
    static int outerCv = 0;

    class InstanceInner{
        int iiv = outerlv;
        int iiv2 = outerCv;
    }
    static class StaticInner{
//        int siv = outerCv;
        static int scv = outerCv;
    }
    void myMethod(){
        int iv = 0;
        final int LV = 0;

        class LocalInner{
            int liv = outerlv;
            int liv2 = outerCv;
            int liv4 = LV;
        }
    }
}
