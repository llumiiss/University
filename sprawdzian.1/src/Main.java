import java.io.IOException;
import java.io.RandomAccessFile;

public class Main
{
    static void newfile(String filename)
    {
        try(RandomAccessFile file = new RandomAccessFile(filename, "rw"))
        {
            file.writeUTF("Ala");
            file.writeUTF("Alowska");
            file.writeChar('k');
            file.writeLong(991213123);
            file.writeInt(27);

            file.writeUTF("Ola");
            file.writeUTF("Olowska");
            file.writeChar('k');
            file.writeLong(881213123);
            file.writeInt(22);

            file.writeUTF("Egon");
            file.writeUTF("Egonowski");
            file.writeChar('m');
            file.writeLong(991213123);
            file.writeInt(17);

            file.writeUTF("Wojtek");
            file.writeUTF("Wojtkowski");
            file.writeChar('m');
            file.writeLong(991213123);
            file.writeInt(37);

        }
        catch(IOException e)
        {
            System.out.println("Failure of file: " + filename );
        }
    }

    static void showFile(String filename)
    {
        try(RandomAccessFile file = new RandomAccessFile(filename, "r"))
        {
            while(file.getFilePointer() < file.length())
            {
                System.out.println("------------------------");
                System.out.println("Name:" + file.readUTF());
                System.out.println("Surname: " + file.readUTF());
                System.out.println(file.readChar() == 'k' ? "Woman" : "Man");
                System.out.println("PESEL: " + file.readLong());
                System.out.println("To pension: " + file.readInt());
            }
        }
        catch(IOException e)
        {
            System.out.println("Failure of file: " + filename );
        }
    }

    static String correctData(String filename)
    {
        String Name = "", Surname = "", maxName = "", maxSurname = "";
        int correct, toPension, max = 0;

        try(RandomAccessFile file = new RandomAccessFile(filename, "rw"))
        {

            while(file.getFilePointer() < file.length())
            {
                Name = file.readUTF();
                Surname = file.readUTF();
                correct = (file.readChar() == 'k') ? 7 : 2;
                file.readLong();
                toPension = file.readInt();
                toPension -= correct;
                file.seek(file.getFilePointer() - Integer.BYTES);
                file.writeInt(toPension);
                if(toPension > max)
                {
                    max = toPension;
                    maxName = Name;
                    maxSurname = Surname;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Failure of file: " + filename );
        }
        return maxName + " " + maxSurname;
    }
    public static void main(String[] args)
    {
        newfile("dane.dat");
        showFile("dane.dat");
        System.out.println(correctData("dane.dat"));
        showFile("dane.dat");
    }
}
