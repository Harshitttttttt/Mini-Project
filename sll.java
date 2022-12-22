import java.util.*;
public class sll {
    class Node {
        int data;
        Node next;                  //pointer to the next node

        Node(int data) {             //constructor
            this.data = data;
            this.next = null;
        }
    }
    Node head,tail=null;
    void insertNodetest(int data)
    {
        Node newnode=new Node(data);
        if(head==null) {
            head = newnode;
            tail = newnode;
        }
        else
        {
            tail.next=newnode;
            tail=newnode;
        }
    }
    void display(int d)
    {
        Node current=head;
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        if(d==1)
            System.out.println("List 1:\t\t");
        else
            System.out.println("List 2:\t\t");
        while(current!=null)
        {
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("END");
    }
    void merge(Node current,Node head1,Node tail1)
    {
        while(current!=null)
        {
            Node newnode = new Node(current.data);
            current=current.next;
            tail1.next = newnode;
            tail1 = newnode;
        }
        current=head1;
        System.out.println("New List:\t\t");
        while(current!=null)
        {
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sll objlist1=new sll();
        sll objlist2=new sll();
        int ch,data;
        do{

            System.out.println("--------------------------------------------\nMENU\n1.Enter a node to list 1\n2.Enter a node to list 2\n3.Display list 1\n4.Display list 2\n5.Merge\n6.Exit\nEnter your choice:");
            ch=sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter a value:");
                    data = sc.nextInt();
                    objlist1.insertNodetest(data);
                    break;

                case 2:
                    System.out.println("Enter a value:");
                    data = sc.nextInt();
                    objlist2.insertNodetest(data);
                    break;

                case 3:
                    objlist1.display(1);
                    break;

                case 4:
                    objlist2.display(2);
                    break;

                case 5:
                    objlist1.display(1);
                    objlist2.display(2);
                    objlist1.merge(objlist2.head, objlist1.head, objlist1.tail);
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }while(ch!=6);
    }
}

