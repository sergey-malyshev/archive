package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start application!" );
        String filename1 = "D:\\file1.txt";
        String filename2 = "D:\\file2.txt";
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("D:\\arch.zip"));)
        {
            /* Читаем содержимое файлов в байтовый буфер для дальнейшей компрессии */
            FileInputStream fis1= new FileInputStream(filename1);
            FileInputStream fis2= new FileInputStream(filename2);
            byte[] buffer1 = new byte[fis1.available()];
            byte[] buffer2 = new byte[fis2.available()];
            fis1.read(buffer1);
            fis2.read(buffer2);
            /* Создаем объекты записей архива */
            ZipEntry entry1=new ZipEntry("file1.txt");
//            ZipEntry entry2=new ZipEntry("file2.txt");
//            ZipEntry entry3=new ZipEntry("file3.txt");

            /* Пишем архив */
            zout.putNextEntry(entry1);
            zout.write(buffer1);
//            zout.putNextEntry(entry2);
//            zout.write(buffer2);
//            zout.putNextEntry(entry3);
//            zout.write(buffer2);

            // закрываем текущую запись для новой записи
            zout.closeEntry();
            zout.finish();
            zout.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
