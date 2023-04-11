import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) {



        /*1. Есть  текстовый файл.  Написать метод,  читающий файл и
            возвращающий строку, состоящую из строчек этого файла,
           разделенных пробелом.
             Пример текстового файла:
            aaa
            bbbbbbb
             cc
             результат : aaa bbbbbbb cc*/


        readWrite("input.txt", "output.txt");


        /*. Есть  файл, состоящий из строчек текста.  Написать метод,
читающий файл и находящий самую длинную строчку в этом файле.
Метод возвращает эту строчку Пример текстового файла:
aaa
bbbbbbb
cc
 результат :  bbbbbbb*/

        writeLongest("input.txt");
        //bbbbbbb


        /*
3. *(со звездочкой)
Есть  не пустой текстовый файл, состоящий из строчек, содержащих
имя и возраст такого вида:
John, 3
Jack, 23
Jill, 19
Bill, 15
Ann, 54
Написать метод, читающий файл и возвращающий список из людей
старше 18 лет отсортированный по возрасту.*/

        readList("list_3.txt");
        /*Jill, 19
          Jack, 23
           Ann, 54*/


       /*4. *(со звездочкой)
        Есть текстовый файл, содержащий информацию о клиенте, название
        устройства и цену.   Имена клиентов могут повторяться.
        Файл имеет такой вид:
        John, Smith, Notebook, 500
        Jill, White, Mac,  800
        John, Smith, Keybord,25
        Ann, Green, Mousepad, 5
        Jill, White, Apple,60
        Написать метод, читающий информацию из файла, суммирующий
        цену для каждого покупателя  и записывающий результат в выходной
        файл. Этот файл будет иметь такой вид:
        Ann Green 5
        John Smith 525
        Jill White 86*/
        //sumClient("start.txt","finish.txt");
    }
    /*public static void sumClient(String input, String output) {
        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(output, true))) {
            String line;

            List<Client>list=new ArrayList<>();
            while ((line = br.readLine()) != null) {

                list.add(new Client(line));}
            for (int i = 0; i < list.size(); i++) {

                Client client = list.get(i);
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException exception) {
            exception.getMessage();
        }

    }*/

    public static void readList(String input) {

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            List<Person> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(new Person(line));

            }
            for (int i = 0; i < list.size(); i++) {
                Person person = list.get(i);
                Collections.sort(list, new PersonComparator());
                if (person.getAge() >= 18) {
                    System.out.println(person);
                }
            }

        } catch (IOException exception) {
            exception.getMessage();
        }

    }


    public static void readWrite(String input, String output) {
        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(output, true))) {
            String line = " ";
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.write(" ");
            }

        } catch (IOException exception) {
            exception.getMessage();
        }

    }

    public static void writeLongest(String input) {
        int max = 0;
        String longest = "";
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > max) {
                    max = line.length();
                    longest = line;
                }
            }

        } catch (IOException exception) {
            exception.getMessage();
        }
        System.out.println(longest);

    }
}