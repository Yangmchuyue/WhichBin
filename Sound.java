import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    
    private SoundEffect se;
    private String sound;
    private String setting;

    // public static void main(String[] args) {		
		// new Sound(); // put new sound in GameFrame constructor Sound sound = new Sound(); <-- in gameframe const.
    //}<-- in gameframe const.
    
    public Sound(){
        sound = "Visager_-_19_-_Village_Dreaming_Loop.wav";
        se = new SoundEffect(); 
        se.setFile(sound);
        se.play();
        se.loop();
    }

    public void stopSound(){
        se.stop();
    }
}

    class SoundEffect {
        private Clip clip;

        public void setFile(String soundName){
            try{
                File file = new File(soundName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            catch(Exception e){

            }

        }

        public void play(){
            clip.start();
        }

        public void loop(){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        public void stop(){
            clip.stop();
            clip.close();
        }
    }


   
