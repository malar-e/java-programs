import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class ProcessSyncP1 {
    public static void main(String[] args) {
        try {
            System.out.println("ProcessSyncP1 is running");
            File file = new File("File_Folder/PS/File1.txt");
            File dir = file.getParentFile();
            dir.mkdirs();
            file.createNewFile();

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(0); // truncate the file
            FileChannel channel = raf.getChannel();
            FileLock lock = channel.lock();

            if (lock == null) {
                System.out.println("Could not get lock, file is in use. Exiting...");
                return;
            }
            
            System.out.println("Process 1: Got the lock. Writing...");


            raf.writeBytes("Hello, ProcessSyncP1!\n");

            Thread.sleep(5000);

            System.out.println("Process 1: Finished writing, releasing lock.");
            
            lock.release();
            channel.close();
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}