import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class ProcessSyncP2 {
    public static void main(String[] args) {
        try {
            System.out.println("ProcessSyncP2 is running");
            File file = new File("File_Folder/PS/File1.txt");
            File dir = file.getParentFile();
            dir.mkdirs();
            file.createNewFile();

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            FileChannel channel = raf.getChannel();
            FileLock lock = channel.lock();

            System.out.println("Process 2: Got the lock. Writing...");

            raf.seek((int) raf.length()); // Move to the end of the file

            raf.writeBytes("Hello, ProcessSyncP2!\n");

            System.out.println("Process 2: Finished writing, releasing lock.");

            lock.release();
            channel.close();
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}