//Client interface
interface MediaPlayer{
    public void play(String type, String fileName);
}

class AudioPlayer implements MediaPlayer{
    @Override
    public void play(String type, String fileName) {
        // if(type.equalsIgnoreCase("vlc")){
        //     System.out.println("Playing "+fileName+"of type "+type);
        // }
        MediaPlayer md = new MediaAdapter();
        md.play(type, fileName);
    }
}

//Service Library->Adaptee
class AdvancedMediaPlayer{

    void playVlc(String fileName){System.out.println("Playing "+fileName+" of type VLC");};
    void playMp3(String fileName){System.out.println("Playing "+fileName+" of type mp3");};
    void playMp4(String fileName){System.out.println("Playing "+fileName+" of type mp4");};
}

//Adapter
class MediaAdapter implements MediaPlayer{
    //reference of Adaptee
    AdvancedMediaPlayer adv = new AdvancedMediaPlayer();

    @Override
    public void play(String type, String fileName) {
        if(type.equalsIgnoreCase("vlc"))
            adv.playVlc(fileName);
        else if(type.equalsIgnoreCase("mp3"))
            adv.playMp3(fileName);
        else if(type.equalsIgnoreCase("mp4"))
            adv.playMp4(fileName);
    }
}

//Client
public class LAb11AdapterPatternAudio {
        public static void main(String[] args) {
            MediaPlayer m1 = new AudioPlayer();
            m1.play("vlc","Hanuman_Chalisa.vlc");
            m1.play("mp3","Hare_Rama_Hare_Krishna.mp3");
            m1.play("mp4","Mahabharat_S1E1.mp4");
        }
}