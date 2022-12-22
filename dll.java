import java.util.*;
public class dll {
    //create a node of the doubly linked list
    class Node {

        int data;
        Node prev;                   //pointer to the previous node
        Node next;                  //pointer to the next node

        Node(int data) {             //constructor
            this.data = data;
        }
    }
    //intitalize list to null
    Node head, tail = null;
    void insertNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    void linearsearchNode(int search) {
        int pos = 1, flag = 0;
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            if (current.data == search) {
                flag = 1;
                break;
            }
            current = current.next;
            pos++;
        }
        if (flag == 1)
            System.out.println("Node found at position " + pos);
        else
            System.out.println("Node not found");
    }
    void ascendsortList() {
        Node index = null, current = null;
        int temp;
        if (head == null)
            return;
        else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }
    void descendsortList() {
        Node index = null, current = null;
        int temp;
        if (head == null)
            return;
        else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data < index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }
    int[] arrayConvertor(int ct)
    {
        Node current = head;
        int i=0;
        int llarr[]=new int[ct];
        while(current!=null){
            llarr[i]=current.data;
            i++;
            if(i==ct)
                break;
            current=current.next;
        }
        for(i=0;i<ct;i++)
        {
            System.out.print(llarr[i]+" <---> ");
        }
        System.out.println("END");
        return llarr;
    }
    void binarysearch(int a[],int ct,int search)
    {
        int low=0,up=ct-1,mid=(low+up)/2,flag=0;
        while(low<=up)
        {
            mid=(low+up)/2;
            if(a[mid]<search)
            {
                low=mid+1;
            }
            else
            if(a[mid]>search)
            {
                up=mid-1;
            }
            else
            if( a[mid]==search)
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println("ELEMENT NOT FOUND");
        else
            System.out.println("Element "+search+" found at position "+(mid+1));
    }
    void hashsearch(int ct,int search)
    {
        Node current=head;
        int pos,i,flag=0;
        int hashtable[]=new int[ct];
        int poscheck[]=new int[ct];
        for(i=0;i<ct;i++)
            poscheck[i]=0;
        do{
            pos = (current.data) % 10;
            do {
                if(pos > ct)
                    pos = 0+(pos-ct);
                if(pos==ct)
                    pos=0;
                if(pos>=ct)
                    while(pos>ct)
                        pos=pos-ct;
                if (poscheck[pos] == 1) {
                    pos += 1;
                    continue;
                } else {
                    hashtable[pos] = current.data;
                    poscheck[pos] = 1;
                }

            } while (poscheck[pos] != 1);
            current = current.next;
        }while(current!=null);
        System.out.print("Hash Table\n");
        for(i=0;i<ct;i++)
        {
            System.out.println("|"+i+"|"+hashtable[i]+"|");
        }
        System.out.println();
        for(i=0;i<ct;i++)
        {
            if(hashtable[i]==search) {
                flag=1;
                break;
            }
            else {
                flag=0;
            }
        }
        if(flag==1)
            System.out.println("Element stored at " + i + " in hash table");
        else
            System.out.println("Element not found");
    }

    void display() {
        Node current = head;
        System.out.println("\n");
        while (current != null) {
            System.out.print(current.data + " <---> ");
            current = current.next;
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, num,ct=0;
        dll obj = new dll();
        do {

            System.out.println("\nSelect an operation:\n1.Insert node\n2.Search for a node - Linear Search\n3.Search for a node - Binary Search\n4.Search for a node - Hash Search\n5.Ascending Sort\n6.Descending Sort\n7.Display\n8.Exit\nEnter your choice:\n");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter a value:");
                    num = sc.nextInt();
                    obj.insertNode(num);
                    ct++;
                    System.out.println(ct);
                    break;

                case 2:
                    System.out.println("Enter value to be searched:");
                    num = sc.nextInt();
                    obj.linearsearchNode(num);
                    break;

                case 7:
                    obj.display();
                    break;

                case 5:
                    obj.ascendsortList();
                    break;

                case 6:
                    obj.descendsortList();
                    break;

                case 3:
                    System.out.println("Enter a value:");
                    num = sc.nextInt();
                    obj.ascendsortList();
                    int usagearr[] = obj.arrayConvertor(ct);
                    obj.binarysearch(usagearr,ct,num);
                    break;

                case 8:
                    break;

                case 4:
                    System.out.println("Enter a value:");
                    num = sc.nextInt();
                    obj.hashsearch(ct,num);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }while (ch != 8) ;
    }
}
