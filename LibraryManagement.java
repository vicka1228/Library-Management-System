import java.util.*;
import java.io.*;
class LibraryManagement 
{
    Scanner sc1=new Scanner(System.in);
    Scanner sc2=new Scanner(System.in);
    String bl[]=new String[1000];
    String bn[]={"Harry Potter and the Philosopher's Stone","Harry Potter and the Chamber of Secrets","Harry Potter and the Prisoner of Azkaban",
            "Harry Potter and the Goblet of Fire","Harry Potter and the Order of the Phoenix","Harry Potter and the Half-Blood Prince",
            "Harry Potter and the Deathly Hallows","Percy Jackson and the Lightning Thief","Percy Jackson and the Sea of Monsters",
            "Percy Jackson and the Titan's Curse","Percy Jackson and the Battle of the Labyrinth","Percy Jackson and the Last Olympian",
            "Heroes of Olympus:The Lost Hero","Heroes of Olympus:The Son of Neptune","Heroes of Olympus:The Mark of Athena",
            "Heroes of Olympus:The Blood of Olympus","The Hunger Games","Catching Fire","Mockingjay","Divergent","Insurgent","Allegiant","City of Bones",
            "City of Ashes","City of Glass","City of Fallen Angels","City of Lost Souls","City of Heavenly Fire","Clockwork Angel","Clockwork Prince",
            "Clockwork Princess","Lady Midnight","Lord of Shadows","Queen of Air and Darkness","Magnus Chase and the Sword of Summer",
            "Magnus Chase and the Hammer of Thor","Magnus Chase and the Ship of the Dead","The Trials of Apollo:The Hidden Oracle",
            "The Trials of Apollo:The Dark Prophecy","The Trials of Apollo:The Burning Maze","The Maze Runner","The Scorch Trials","The Death Cure",
            "The Lord of the Rings","The Chronicles of Narnia:Complete Volume","Diary of a Young Girl","The Catcher in the Rye",
            "The Complete Adventures of Sherlock Holmes","The Alchemist","Animal Farm","Murder on the Orient Express","Death in the Clouds",
            "And Then There Were None","The Murder of Mr. Roger Ackroyd","Three Act Tragedy","The Hollow","Five Little Pigs","Little Women","Emma","Jane Eyre",
            "Pride and Prejudice","Sense and Sensibility","Great Expectations","A Tale of Two Cities","Alice's Adventures in Wonderland","Heidi","It","Carrie",
            "The Shining","The Fault In Our Stars","All the Bright Places","Six of Crows","Russian Roulette","To Kill a Mockingbird","The Book Thief",
            "The Selection","The Perks of Being a Wallflower","Mein Kampf","Angels and Demons","Inferno","The Da Vinci Code","The Cuckoo's Calling","Silkworm",
            "Career of Evil","Lethal White","The Hitchhiker's Guide to the Galaxy","Wuthering Heights","Lord of the Flies","The Kite Runner","The Great Gatsby",
            "David Copperfield","Oliver Twist","The Adventures of Huckleberry Finn","Little Men","Jo's Boys","The Scarlet Letter","Gone With the Wind",
            "Anna Karenina","Moby Dick","War and Peace","The Old Man and the Sea","Crime and Punishment","The Canterbury Tales","Vanity Fair","Catch-22",
            "One Thousand and One Arabian Nights","A Clockwork Orange","1984"};
    int i,j,n;

    void writefile() throws IOException
    {
        FileWriter f= new FileWriter("D:\\BookList.txt",true); 
        BufferedWriter b= new BufferedWriter(f);
        PrintWriter p= new PrintWriter(b);
        for(i=0;i<bl.length;i++)
        {
            if(bl[i]!=null)
                p.println(bl[i]);
        }
        System.out.print("Enter number of book(s) you want to enter:");
        n=sc1.nextInt();
        System.out.println("Enter names of books:");
        for(i=0;i<n;i++)
        {
            p.println(sc2.nextLine());
        }
        p.flush();
        f.close();
        b.close();
        p.close();
    }

    void members() throws IOException
    {   
        System.out.print("Enter name:");
        String name=sc2.nextLine();
        FileWriter f= new FileWriter("D:\\"+name+".txt"); 
        BufferedWriter b= new BufferedWriter(f);
        PrintWriter p= new PrintWriter(b);
        p.println(name);
        System.out.print("Enter email address:");
        p.println(sc2.nextLine());
        System.out.print("Enter username:");
        p.println(sc2.nextLine());
        System.out.print("Enter password:");
        p.println(sc2.nextLine());
        p.flush();
        f.close();
        b.close();
        p.close();
    }

    void deleteBooks() throws IOException
    {  
        int ch=-1;
        FileReader f2= new FileReader ("D:\\BookList.txt"); 
        BufferedReader b2= new BufferedReader(f2);
        String s= b2.readLine();
        for(i=0;i<bl.length;i++)
        {
            bl[i]=null; 
        }
        i=0;
        while(s!=null)
        {
            bl[i]=s;
            s= b2.readLine();
            i++;
        }
        f2.close();
        b2.close();
        FileWriter f= new FileWriter("D:\\BookList.txt"); 
        BufferedWriter b= new BufferedWriter(f);
        PrintWriter p= new PrintWriter(b);
        for(i=0;i<bl.length;i++)
        {
            if(bl[i]==null)
                break;
            System.out.println((i+1)+". "+bl[i]);
        }
        System.out.print("Enter serial number of book you want to delete or 0 to exit:");
        ch=sc1.nextInt();
        if(ch==0)
            return;
        else
        {
            for(i=0;i<bl.length;i++)
            {
                if(bl[i]!=null && i!=(ch-1))
                    p.println(bl[i]);
            }
        }
        p.flush();
        f.close();
        b.close();
        p.close();
    }

    void deleteMember() throws IOException
    {
        System.out.print("Enter name of member you want to remove:");
        String name=sc2.nextLine();
        FileReader f= new FileReader("D:\\"+name+".txt"); 
        BufferedReader b= new BufferedReader(f);
        String s=b.readLine();
        s=b.readLine();
        s=b.readLine();
        System.out.print("Enter their username:");
        String un=sc2.nextLine();
        if(un.compareTo(s)!=0)
        {
            while(true)
            {
                System.out.print("Wrong username, try again:");  
                un=sc2.nextLine();
                if(un.equals(s))
                    break;
            }
        }
        s=b.readLine();
        System.out.print("Enter their password:");
        String p=sc2.nextLine();
        if(p.compareTo(s)!=0)
        {
            while(true)
            {
                System.out.print("Wrong password, try again:");  
                p=sc2.nextLine();
                if(p.equals(s))
                    break;
            }
        }
        f.close();
        b.close();
        File f2=new File("D:\\"+name+".txt");
        f2.delete();
    }

    void sort() throws IOException
    {   
        int ct=0;
        FileReader f2= new FileReader ("D:\\BookList.txt"); 
        BufferedReader b2= new BufferedReader(f2);
        String s= b2.readLine();
        for(i=0;i<bl.length;i++)
        {
            bl[i]=null; 
        }
        i=0;
        while(s!=null)
        {
            bl[i]=s;
            ct++;
            s= b2.readLine();
            i++;
        }
        f2.close();
        b2.close();
        String temp;
        for(i=0;i<ct;i++)
        {
            for(j=0;j<ct-1-i;j++)
            {
                if(bl[j].compareTo(bl[j+1])>0) 
                {
                    temp=bl[j];
                    bl[j]=bl[j+1];
                    bl[j+1]=temp;
                }
            }
        }
        FileWriter f= new FileWriter("D:\\BookList.txt"); 
        BufferedWriter b= new BufferedWriter(f);
        PrintWriter p= new PrintWriter(b);
        for(i=0;i<ct;i++)
        {
            p.println(bl[i]);
        }
        p.flush();
        f.close();
        b.close();
        p.close();
    }

    void edit() throws IOException
    {
        System.out.print("Enter name of account you want to make changes to:");
        String name=sc2.nextLine();
        FileReader f= new FileReader("D:\\"+name+".txt"); 
        BufferedReader b= new BufferedReader(f);
        String s=b.readLine();
        s=b.readLine();
        s=b.readLine();
        System.out.print("Enter old username:");
        String un=sc2.nextLine();
        if(un.compareTo(s)!=0)
        {
            while(true)
            {
                System.out.print("Wrong username, try again:");  
                un=sc2.nextLine();
                if(un.equals(s))
                    break;
            }
        }
        s=b.readLine();
        System.out.print("Enter old password:");
        String p=sc2.nextLine();
        if(p.compareTo(s)!=0)
        {
            while(true)
            {
                System.out.print("Wrong password, try again:");  
                p=sc2.nextLine();
                if(p.equals(s))
                    break;
            }
        }
        f.close();
        b.close();
        File t=new File("D:\\"+name+".txt");
        t.delete();
        System.out.print("Enter name with changes(if any):");
        name=sc2.nextLine();
        FileWriter f2= new FileWriter("D:\\"+name+".txt"); 
        BufferedWriter b2= new BufferedWriter(f2);
        PrintWriter p2= new PrintWriter(b2);
        p2.println(name);
        System.out.print("Enter email address with changes(if any):");
        p2.println(sc2.nextLine());
        System.out.print("Enter username with changes(if any):");
        p2.println(sc2.nextLine());
        System.out.print("Enter password with changes(if any):");
        p2.println(sc2.nextLine());
        p2.flush();
        f2.close();
        b2.close();
        p2.close();
    }

    void borrow() throws IOException
    {
        System.out.print("Before borrowing books, you must have an account. \n1.Borrow books\n2.Return to Main menu to create account\nEnter your choice:");
        int ch=sc1.nextInt();
        switch(ch)
        {
            case 1:System.out.print("Enter name:");
            String name=sc2.nextLine();
            FileReader f= new FileReader("D:\\"+name+".txt"); 
            BufferedReader b= new BufferedReader(f);
            String s=b.readLine();
            s=b.readLine();
            s=b.readLine();
            System.out.print("Enter username:");
            String un=sc2.nextLine();
            if(un.compareTo(s)!=0)
            {
                while(true)
                {
                    System.out.print("Wrong username, try again:");  
                    un=sc2.nextLine();
                    if(un.equals(s))
                        break;
                }
            }
            s=b.readLine();
            System.out.print("Enter password:");
            String p=sc2.nextLine();
            if(p.compareTo(s)!=0)
            {
                while(true)
                {
                    System.out.print("Wrong password, try again:");  
                    p=sc2.nextLine();
                    if(p.equals(s))
                        break;
                }
            }
            FileReader f2= new FileReader ("D:\\BookList.txt"); 
            BufferedReader b2= new BufferedReader(f2);
            String str= b2.readLine();
            for(i=0;i<bl.length;i++)
            {
                bl[i]=null; 
            }
            i=0;
            while(str!=null)
            {
                bl[i]=str;
                str= b2.readLine();
                i++;
            }
            f2.close();
            b2.close();
            for(i=0;i<bl.length;i++)
            {
                if(bl[i]==null)
                    break;
                System.out.println((i+1)+". "+
                    bl[i]);
            }
            System.out.println("You can choose upto 3 books. Press 0 to stop.");
            for(i=0;i<3;i++)
            {
                System.out.print("Enter serial number:");
                n=sc1.nextInt();
                if(n==0)
                    break;
                bl[n-1]=bl[n-1]+"(Currently in Circulation)";
            }
            FileWriter f3= new FileWriter("D:\\BookList.txt"); 
            BufferedWriter b3= new BufferedWriter(f3);
            PrintWriter p2= new PrintWriter(b3);
            for(i=0;i<bl.length;i++)
            {
                if(bl[i]==null)
                    break;
                p2.println(bl[i]);
            }
            p2.flush();
            f3.close();
            b3.close();
            p2.close();
            break;
            case 2:return;
            default:System.out.println("Wrong Choice");
        }
    }

    void returnBooks() throws IOException
    {
        int sn;
        System.out.print("Enter name:");
        String name=sc2.nextLine();
        FileReader f= new FileReader("D:\\"+name+".txt"); 
        BufferedReader b= new BufferedReader(f);
        String s=b.readLine();
        s=b.readLine();
        s=b.readLine();
        System.out.print("Enter username:");
        String un=sc2.nextLine();
        if(un.compareTo(s)!=0)
        {
            while(true)
            {
                System.out.print("Wrong username, try again:");  
                un=sc2.nextLine();
                if(un.equals(s))
                    break;
            }
        }
        s=b.readLine();
        System.out.print("Enter password:");
        String p=sc2.nextLine();
        if(p.compareTo(s)!=0)
        {
            while(true)
            {
                System.out.print("Wrong password, try again:");  
                p=sc2.nextLine();
                if(p.equals(s))
                    break;
            }
        }
        System.out.print("How many books are you returning?");
        n=sc1.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.print("Enter serial number(written on book):");
            sn=sc1.nextInt();
            System.out.print("Enter name of book:");
            bl[sn-1]=sc2.nextLine();
        }
        FileWriter f2= new FileWriter("D:\\BookList.txt"); 
        BufferedWriter b2= new BufferedWriter(f2);
        PrintWriter p2= new PrintWriter(b2);
        for(i=0;i<bl.length;i++)
        {
            if(bl[i]==null)
                break;
            p2.println(bl[i]);
        }
        p2.flush();
        f2.close();
        b2.close();
        p2.close();
    }

    public void main() throws IOException
    {   
        Scanner sc=new Scanner(System.in);
        int ch;
        int i,j,k;
        for(i=0;i<bn.length;i++)
            bl[i]=bn[i];
        LibraryManagement ob=new LibraryManagement();
        FileWriter f= new FileWriter("D:\\BookList.txt"); 
        BufferedWriter b= new BufferedWriter(f);
        PrintWriter p= new PrintWriter(b);
        for(i=0;i<bl.length;i++)
        {
            if(bl[i]!=null)
                p.println(bl[i]);
        }
        p.flush();
        String s="WELCOME TO THE SILVERSTONE LIBRARY!";
        System.out.println("\t\t\t**************************************************");
        System.out.println("\t\t\t*   ******************************************   *");
        System.out.println("\t\t\t*   *                                        *   *");
        System.out.print("\t\t\t*   *  ");
        for(i=0;i<s.length();i++)
        {   
            System.out.print(s.charAt(i));
            for(j=1;j<=900000;j++)
                for(k=1;k<=100;k++);
        }
        System.out.println("   *   *");
        System.out.println("\t\t\t*   *                                        *   *");
        System.out.println("\t\t\t*   ******************************************   *");
        System.out.println("\t\t\t**************************************************\n\n");
        for(j=1;j<=900000;j++)
            for(k=1;k<=1000;k++);
        do
        {
            System.out.print("\fDo you want to?\n1.Add new books\n2.Add member account\n3.Delete books from the record\n4.Delete members from the record\n5.Sort Books\n6.Edit Account\n7.Borrow Books\n8.Return Books\n9.Exit\nEnter your choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:ob.writefile();
                System.out.println("The books have been added successfully");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break;
                case 2:ob.members();
                System.out.println("Account has been created. Congratulations! You are now a member of Silverstone Library. For just Rs. 2000 a year, you can have access to some all-time bestsellers.\nPlease pay the required amount by either cash or card to the librarian."); 
                for(j=1;j<=900000;j++)
                    for(k=1;k<=10000;k++);
                break; 
                case 3:ob.deleteBooks();
                System.out.println("The book has been deleted successfully");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break;
                case 4:ob.deleteMember();
                System.out.println("Account has been deleted successfully");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break; 
                case 5:ob.sort();
                System.out.println("Books have been sorted successfully");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break;
                case 6:ob.edit();
                System.out.println("Changes have been made to the account");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break;
                case 7:ob.borrow();
                System.out.println("Books have been borrowed successfully. Enjoy Reading!");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break;
                case 8:ob.returnBooks();
                System.out.println("Books have been returned successfully.");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
                break; 
                case 9:System.out.println("Thank You!");
                break;
                default:System.out.println("Invalid input... Please try again");
                for(j=1;j<=900000;j++)
                    for(k=1;k<=1000;k++);
            }
        }while(ch!=9);
        f.close();
        b.close();
        p.close();
    }
}
