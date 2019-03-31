package pl.sda.programming1.jvm;

public class MemoryUtils {

    public static String humanReadableByteCount(long bytes) {
        int unit = 1024;
        if (bytes < unit) return bytes + " ";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = ("KMGTPE").charAt(exp - 1) + ("i");
        return String.format("%.1f %s", bytes / Math.pow(unit, exp), pre);
    }

}
