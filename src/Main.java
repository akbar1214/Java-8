import java.io.File;


public class Main {

    public static void main(String[] args) {

        File[] files = new File("C:\\").listFiles();
        List<File> fileList = new List<>();
        assert files != null;
        for(File file:files) {
            fileList.add(file);
        }
        fileList.printSelected(o1 -> o1.data.isFile());
        System.out.println("===================================================================================================================================");
        fileList.printSelected(file -> file.data.isDirectory());
    }

}

@FunctionalInterface
interface Comparator<T>{
    boolean test(Node<T> o1);
}



class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

class List<T> {

    private Node<T> head = null;

    public void add(T data) {

        Node<T> temp = head;
        if(temp != null) {
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node<>(data);
        } else {
            head = new Node<>(data);
        }
    }

    public void print() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void printSelected(Comparator<T> c) {

        Node<T> temp = head;
        while (temp != null) {

            if(c.test(temp)) {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }
}