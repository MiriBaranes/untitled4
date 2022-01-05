
public class CD {
    public static final int MAX=20;
    private String title;
    private String [] songList;
    private double price;


    public CD(String title,double price){
        this.songList=new String[0];
        this.title=title;
        this.price=price;
    }
    public CD(CD other){
        if (other!=null){
            this.songList=other.songList;
            this.price=other.price;
            this.title=other.title;
        }
        else {
            System.out.println("An empty object cannot be copied");
        }

    }
    public void addSongToArr(String song) {
        if (this.songList.length < MAX) {
            String[] newSongList = new String[this.songList.length + 1];
            for (int i = 0; i < this.songList.length; i++) {
                newSongList[i] = this.songList[i];
            }
            newSongList[songList.length] = song;
            this.songList = newSongList;
        }
        else System.out.println("You have not reached the quota");
    }
    public int repeatSong(String songName){
        int count=0;
        for (int i=0; i<this.songList.length; i++){
            if (songList[i].equals(songName)){
                count++;
            }
        }
        return count;
    }
    public void delete(String songName){
        int repeatSong =repeatSong(songName);
        if (repeatSong>0) {
            String[] newStringList = new String[this.songList.length - repeatSong];
            for (int i = 0, k = 0; i < this.songList.length; i++) {
                if (!this.songList[i].equals(songName)) {
                    newStringList[k] = songList[i];
                    k++;
                }
            }
            this.songList = newStringList;
            System.out.println("Successfully deleted");
        }
        else {
            System.out.println("The song does not exist");
        }
    }
    public void printAllSong(){
        for (int i=0; i< this.songList.length; i++){
            System.out.println((i+1) + ". "+ this.songList[i]);
        }
    }
    public String toString(){
        StringBuilder output =new StringBuilder();
        output.append("Title: ").append(this.title).append(" price: ").append(this.price).append("\nsong list:");
        for (int i=0; i< songList.length; i++){
            output.append(i+1).append(". ").append(this.songList[i]).append("\n");
        }
       return output.toString();
    }


}
