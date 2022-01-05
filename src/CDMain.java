import java.util.Scanner;

public class CDMain {
    public static final int MAX = 20;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        CD [] cds= new CD[10];
        System.out.println("Enter a song to remove: ");
        String deleting=scanner.nextLine();
        cds=deletingCDWithTheSongFromTheArray(cds,deleting);



//        String deleting="shir";///just for check
//        cds[0]= new CD("SONG",1234);
//        cds[0].addSongToArr("lala");
//        cds[1]= new CD("lala",1234);
//        cds[1].addSongToArr("lala");
//        cds[2]= new CD("lili",1234);
//        cds[2].addSongToArr("laa");
//        cds[3]= new CD("giigi",1234);
//        cds[3].addSongToArr("shir");
//        cds[4]= new CD("diidi",1234);
//        cds[4].addSongToArr("shir");
//        cds[5]= new CD("SONG",1234);
//        cds[5].addSongToArr("shir");
//        cds[6]= new CD("SONG",1234);
//        cds[6].addSongToArr("shir");
//        cds[7]= new CD("SONG",1234);
//        cds[7].addSongToArr("shir");
//        cds[8]= new CD("SONG",1234);
//        cds[8].addSongToArr("shir");


    }
    public static CD[] deletingCDWithTheSongFromTheArray(CD []cds,String songName){
        for (int i=0; i<cds.length; i++){
            if (cds[i]!=null){
                if (cds[i].repeatSong(songName)>0){
                    cds=removeCD(i,cds);
                    i=-1;
                }
            }
        }
        return cds;
    }
    public static CD [] removeCD(int index, CD [] cds){
        CD[] newCD= new CD[cds.length-1];
        for (int i=0,k=0;i<cds.length; i++){
            if (i!=index){
                newCD[k]=cds[i];
                k++;
            }
        }
        return newCD;
    }
    public static void actInCD(){ //// in case you wont to check the CD class
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a title: ");
        String title=scanner.nextLine();
        System.out.println("Enter a price: ");
        double price= scanner.nextDouble();
        CD cd=new CD(title,price);
        int size=0;
        do {
            System.out.println("Enter a number of song you wont to add: ");
            size=scanner.nextInt();
        }while (size>MAX||size<0);
        for (int i=0; i<size; i++){
            System.out.println("Enter a song name: ");
            String song=scanner.nextLine();
            cd.addSongToArr(song);
        }
        System.out.println("There is the song list: ");
        cd.printAllSong();
        System.out.println("Enter a song you wont to remove");
        String delete=scanner.nextLine();
        cd.delete(delete);
        cd.printAllSong();
        System.out.println("-------------------------------");
        System.out.println(cd);//print all object stat;
    }
}
