package com.mika.credit.facade.front.en.Util;//package com.IT3afloat.creditsafeInterface.Util;
//
//import org.apache.axis.types.UnsignedInt;
//
///**
// * Created by mika on 2016/6/28.
// */
//public class Util {
//    public static UnsignedInt[] intToUnsignedInt(int[] ints){
//        UnsignedInt[] unsignedInts = new UnsignedInt[ints.length];
//        for(int i=0 ; i<ints.length ;i++){
//            unsignedInts[i] = new UnsignedInt(ints[i]);
//        }
//        return unsignedInts;
//    }
//
//    public static int[] unsignedIntToInt(UnsignedInt[] unsignedInts){
//        int[] ints = new int[unsignedInts.length];
//        for(int i=0 ; i<unsignedInts.length ;i++){
//            ints[i] = Integer.parseInt(unsignedInts[i].toString());
//        }
//        return ints;
//    }
//
//    public static void main(String[] args) {
//        UnsignedInt[] unsignedInt = new UnsignedInt[5];
//        unsignedInt[0]=new UnsignedInt(0);
//        unsignedInt[1]=new UnsignedInt(1);
//        unsignedInt[2]=new UnsignedInt(2);
//        unsignedInt[3]=new UnsignedInt(3);
//        unsignedInt[4]=new UnsignedInt(4);
//
//        int[] a = unsignedIntToInt(unsignedInt);
//        for (int b : a){
//            System.out.println(b);
//        }
//    }
//}
