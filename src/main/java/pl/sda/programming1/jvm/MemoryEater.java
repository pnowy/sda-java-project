package pl.sda.programming1.jvm;

import java.util.ArrayList;

public class MemoryEater {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        while (true) {
            Thread.sleep(2);
            byte b[] = new byte[1048576];
            arrayList.add(b);
            long freeMemory = Runtime.getRuntime().freeMemory();
            System.out.println("Free memory: " + MemoryUtils.humanReadableByteCount(freeMemory));
        }
    }

}
