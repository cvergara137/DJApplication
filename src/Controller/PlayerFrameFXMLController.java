package Controller;

import Model.Model;
import javafx.scene.control.TextArea;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.MapChangeListener;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.X;
import static javafx.scene.input.KeyCode.Y;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author RT
 */
public class PlayerFrameFXMLController implements Initializable, AudioSpectrumListener {

    Model model;
    private MediaPlayer mediaPlayerLeft;
    private MediaPlayer mediaPlayerRight;
    private MediaPlayer mediaPlayerFull;
    private Media media;
    private Media media2;
    private String artist;
    private String title;
    private String album;
    private String genre;
    XYChart.Data[] series1Data;
    XYChart.Data[] series1Data2;
    int BANDS;
    int BANDS2;
    int bandsToDisplay;
    int bands2ToDisplay;
    private float[] buffer;
    private float[] correctedMagnitude;
    private static int output;
    AudioFormat.Encoding inputStream;
    static TargetDataLine targetLine;
    static AudioFormat mp3;
    TargetDataLine line;

    public PlayerFrameFXMLController() {

    }

    @FXML
    private Button rewindLeft;

    @FXML
    private Button rewindRight;

    @FXML
    private Button stopLeft;

    @FXML
    private Button stopRight;

    @FXML
    private Button pauseLeft;

    @FXML
    private Button pauseRight;

    @FXML
    private Button playLeft;

    @FXML
    private Button playRight;

    @FXML
    private Button ffLeft;

    @FXML
    private Button ffRight;

    @FXML
    private Button addLeft;

    @FXML
    private Button addRight;

    @FXML
    private Button headphonesLeft;

    @FXML
    private Button headphonesRight;

    @FXML
    private Button record;

    @FXML
    private HBox playerLeft;

    @FXML
    private HBox playerRight;

    @FXML
    private HBox hboxBottom;

    @FXML
    private ImageView albumCoverViewLeft;

    @FXML
    private ImageView albumCoverViewRight;

    @FXML
    private Label songtitleLeft;

    @FXML
    private Label songtitleRight;

    @FXML
    private AreaChart spektrumLeft;

    @FXML
    private AreaChart spektrumRight;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private Slider volumeLeft;

    @FXML
    private Slider volumeRight;

    @FXML
    private Slider bpmLeft;

    @FXML
    private Slider bpmRight;

    @FXML
    private Slider crossFader;

    static AudioInputStream audioInputStream;

    @FXML
    private void handleLeftButtonAction(ActionEvent event) {

        if (media != null) {
            if (event.getSource() == pauseLeft) {
                mediaPlayerLeft.pause();
            }
            if (event.getSource() == playLeft) {

                mediaPlayerLeft.setRate(1);
                mediaPlayerLeft.play();
            }
            if (event.getSource() == stopLeft) {
                mediaPlayerLeft.stop();
            }
            if (event.getSource() == ffLeft) {
                mediaPlayerLeft.setRate(3);
            }
            if (event.getSource() == rewindLeft) {
                mediaPlayerLeft.seek(mediaPlayerLeft.getCurrentTime().divide(1.5).add(Duration.ZERO));
            }
        }
    }

    @FXML
    private void handleRightButtonAction(ActionEvent event) {

        if (media2 != null) {
            if (event.getSource() == pauseRight) {
                mediaPlayerRight.pause();
            }
            if (event.getSource() == playRight) {
                mediaPlayerRight.setRate(1);
                mediaPlayerRight.play();
            }
            if (event.getSource() == stopRight) {
                mediaPlayerRight.stop();
            }
            if (event.getSource() == ffRight) {
                mediaPlayerRight.setRate(3);
            }
            if (event.getSource() == rewindRight) {
                mediaPlayerRight.seek(mediaPlayerRight.getCurrentTime().divide(1.5).add(Duration.ZERO));
            }

        }
    }

    @FXML
    private void LoadLeft(ActionEvent event) throws MalformedURLException {

        File file = null;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter("Audio files", "*.mp3", "*.wav");
        fileChooser.getExtensionFilters().add(fileExtension);
        Window stage = null;
        file = fileChooser.showOpenDialog(stage);
        if (media != null) {
            mediaPlayerLeft.stop();
        }

        media = new Media(file.toURI().toURL().toString());
        DisplayMetaDataLeft();

        mediaPlayerLeft = new MediaPlayer(media);

        mediaPlayerLeft.play();
        DisplayAlbumCoverLeft();
        WaveFormInitializeLeft();
        volumeLeft.setValue(mediaPlayerLeft.getVolume() * 100);

        VolumeLeftListener();
        BPMLeftListener();
        CrossFaderListenerForLeftTrack();

    }

    @FXML
    private void LoadRight(ActionEvent event) throws MalformedURLException {
        File file = null;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter("Audio files", "*.mp3", "*.wav");
        fileChooser.getExtensionFilters().add(fileExtension);
        Window stage = null;
        file = fileChooser.showOpenDialog(stage);
        if (media2 != null) {
            mediaPlayerRight.stop();
        }

        media2 = new Media(file.toURI().toURL().toString());
        DisplayMetaDataRight();
        mediaPlayerRight = new MediaPlayer(media2);
        mediaPlayerRight.play();
        DisplayAlbumCoverRight();
        WaveFormInitializeRight();
        volumeRight.setValue(mediaPlayerRight.getVolume() * 100);
        VolumeRightListener();
        BPMRightListener();
        CrossFaderListenerForRightTrack();
    }

    @FXML
    private void selectFileAction(ActionEvent event) {
        File file = null;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter("Audio files", "*.mp3", "*.wav");
        fileChooser.getExtensionFilters().add(fileExtension);
        Window stage = null;
        file = fileChooser.showOpenDialog(stage);
        System.out.println(file);
    }

    private void DisplayAlbumCoverLeft() {

        File file = new File("src/sample/images/blank_cd.jpeg");

        Image image = new Image(file.toURI().toString()) {
        };

        albumCoverViewLeft.setImage(image);

        // However if an album cover is found in the meta-data it will be displayed
        ObservableMap<String, Object> meta_data = media.getMetadata();

        meta_data.addListener((MapChangeListener<String, Object>) ch -> {

            if (ch.wasAdded()) {

                String key = ch.getKey();
                Object value = ch.getValueAdded();

                if (key.equals("image")) {

                    // If there's an album cover in the metadata it will be displayed
                    albumCoverViewLeft.setImage((Image) value);

                    System.out.println("Found album cover");

                }
            }
        });

    }

    private void DisplayAlbumCoverRight() {

        File file = new File("src/sample/images/blank_cd.jpeg");

        Image image = new Image(file.toURI().toString()) {
        };

        albumCoverViewRight.setImage(image);

        // However if an album cover is found in the meta-data it will be displayed
        ObservableMap<String, Object> meta_data = media2.getMetadata();

        meta_data.addListener((MapChangeListener<String, Object>) ch -> {

            if (ch.wasAdded()) {

                String key = ch.getKey();
                Object value = ch.getValueAdded();

                if (key.equals("image")) {

                    // If there's an album cover in the metadata it will be displayed
                    albumCoverViewRight.setImage((Image) value);

                    System.out.println("Found album cover");

                }
            }
        });

    }

    public void DisplayMetaDataLeft() {
        media.getMetadata().addListener((Change<? extends String, ? extends Object> c) -> {
            if (c.wasAdded()) {
                if ("artist".equals(c.getKey())) {
                    artist = c.getValueAdded().toString();
                } else if ("title".equals(c.getKey())) {
                    title = c.getValueAdded().toString();
                } else if ("album".equals(c.getKey())) {
                    album = c.getValueAdded().toString();
                } else if ("genre".equals(c.getKey())) {
                    genre = c.getValueAdded().toString();
                }
            }
            if (c.wasAdded()) {
                System.out.println(c.getKey() + " : " + c.getValueAdded());
                songtitleLeft.setText(" Artist: " + artist + "\n" + " Title: " + title + "\n" + " Album: " + album + "\n" + " Genre: " + genre);

            }
        });

    }

    public void DisplayMetaDataRight() {
        media2.getMetadata().addListener((Change<? extends String, ? extends Object> c) -> {
            if (c.wasAdded()) {
                if ("artist".equals(c.getKey())) {
                    artist = c.getValueAdded().toString();
                } else if ("title".equals(c.getKey())) {
                    title = c.getValueAdded().toString();
                } else if ("album".equals(c.getKey())) {
                    album = c.getValueAdded().toString();
                } else if ("genre".equals(c.getKey())) {
                    genre = c.getValueAdded().toString();
                }
            }
            if (c.wasAdded()) {
                System.out.println(c.getKey() + " : " + c.getValueAdded());
                songtitleRight.setText(" Artist: " + artist + "\n" + " Title: " + title + "\n" + " Album: " + album + "\n" + " Genre: " + genre);

            }
        });

    }

    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }

    public void RecordListener(ActionEvent event) {
        if (event.getSource() == record) {

            // path of the wav file
            File wavFile = new File("c:/RecordAudio.wav");

            // format of audio file
            AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
            try {

                AudioFormat format = getAudioFormat();
                DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

                // checks if system supports the data line
                if (!AudioSystem.isLineSupported(info)) {
                    System.out.println("Line not supported");
                    System.exit(0);
                }

                line = (TargetDataLine) AudioSystem.getLine(info);

                line = (TargetDataLine) AudioSystem.getLine(info);
                line.open(format);
                line.start();   // start capturing

                System.out.println("Start capturing...");

                AudioInputStream ais = new AudioInputStream(line);

                System.out.println("Start recording...");

                // start recording
                AudioSystem.write(ais, fileType, wavFile);

            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    static AudioInputStream getAudioInputStream​(AudioFormat.Encoding targetEncoding, AudioInputStream sourceStream) {

        return audioInputStream;
    }

    static TargetDataLine getTargetDataLine​(AudioFormat format, Mixer.Info mixerinfo) {
        return targetLine;
    }

    static int write(AudioInputStream stream, AudioFileFormat.Type fileType, File out) {

        return output;
    }

    public void SwitchtoHeadphonesLeft() {

    }

    public void SwitchtoHeadphonesRight() {

    }

    public void VolumeLeftListener() {

        volumeLeft.valueProperty().addListener(new InvalidationListener() {

            public void invalidated(Observable ov) {

                mediaPlayerLeft.setVolume(volumeLeft.getValue() / 100);
            }

        });

    }

    public void VolumeRightListener() {

        volumeRight.valueProperty().addListener(new InvalidationListener() {

            public void invalidated(Observable ov) {

                mediaPlayerRight.setVolume(volumeRight.getValue() / 100);
            }

        });

    }

    public void CrossFaderListenerForLeftTrack() {

        crossFader.valueProperty().addListener(new InvalidationListener() {

            public void invalidated(Observable ov) {

                if (crossFader.getValue() > 0) {

                    mediaPlayerLeft.setVolume(((100 - crossFader.getValue()) / 100) - (1 - (volumeLeft.getValue() / 100)));

                }

            }

        });

    }

    public void CrossFaderListenerForRightTrack() {

        crossFader.valueProperty().addListener(new InvalidationListener() {

            public void invalidated(Observable ov) {

                if (crossFader.getValue() < 0) {

                    mediaPlayerRight.setVolume(((100 + crossFader.getValue()) / 100) - (1 - (volumeRight.getValue() / 100)));
                }
            }

        });

    }

    public void BPMLeftListener() {

        bpmLeft.valueProperty().addListener(new InvalidationListener() {

            double rate = bpmLeft.getValue();

            public void invalidated(Observable ov) {

                if (bpmLeft.isValueChanging()) {

                    rate = Math.round(bpmLeft.getValue() * 100.0) / 100.0;

                    if (rate != mediaPlayerLeft.getRate()) {
                        mediaPlayerLeft.setRate(rate);
                    }
                }
            }

        });
    }

    public void BPMRightListener() {

        bpmRight.valueProperty().addListener(new InvalidationListener() {

            double rate = bpmRight.getValue();

            public void invalidated(Observable ov) {

                if (bpmRight.isValueChanging()) {

                    rate = Math.round(bpmRight.getValue() * 100.0) / 100.0;

                    if (rate != mediaPlayerRight.getRate()) {
                        mediaPlayerRight.setRate(rate);
                    }
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        bpmLeft.setValue(1);
        bpmRight.setValue(1);
        crossFader.setValue(0);

    }

    public void WaveFormInitializeLeft() {
        if (mediaPlayerLeft != null) {
            mediaPlayerLeft.setAudioSpectrumListener(this);
            BANDS = mediaPlayerLeft.getAudioSpectrumNumBands();
            bandsToDisplay = BANDS / 3;

            //       buffer = createFilledBuffer(BANDS, mediaPlayerLeft.getAudioSpectrumThreshold()); 
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();

            series1Data = new XYChart.Data[BANDS / 3];

            for (int i = 0; i < series1Data.length; i++) {
                series1Data[i] = new XYChart.Data<>(Integer.toString(i + 1), 0);
                series1.getData().add(series1Data[i]);

            }

            spektrumLeft.getData().add(series1);
        }
        System.out.println("success");

    }

    public void WaveFormInitializeRight() {
        if (mediaPlayerRight != null) {

            mediaPlayerRight.setAudioSpectrumListener(this);
            BANDS2 = mediaPlayerRight.getAudioSpectrumNumBands();

            //       buffer = createFilledBuffer(BANDS, mediaPlayerLeft.getAudioSpectrumThreshold()); 
            //     final NumberAxis xAxis = new NumberAxis(0,24,3);
            //    final NumberAxis yAxis = new NumberAxis(0,1,0.1);   
            XYChart.Series<String, Number> series2 = new XYChart.Series<>();

            series1Data2 = new XYChart.Data[BANDS2 / 3];

            for (int i = 0; i < series1Data2.length; i++) {
                series1Data2[i] = new XYChart.Data<>(Integer.toString(i + 1), 0);
                series2.getData().add(series1Data2[i]);
            }

            spektrumRight.getData().add(series2);
        }
        System.out.println("success");

    }

    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {

        if (mediaPlayerLeft != null) {
            for (int i = 0; i < magnitudes.length; i++) {

                try {
                    series1Data[i].setYValue(magnitudes[i] - mediaPlayerLeft.getAudioSpectrumThreshold());
                } catch (ArrayIndexOutOfBoundsException ignored) {

                }

            }
        }

        if (mediaPlayerRight != null) {
            for (int i = 0; i < magnitudes.length; i++) {

                try {
                    series1Data2[i].setYValue(magnitudes[i] - mediaPlayerRight.getAudioSpectrumThreshold());
                } catch (ArrayIndexOutOfBoundsException ignored) {

                }
            }
        }

    }

    public HBox getPlayerLeft() {
        return playerLeft;
    }

    public void setPlayerLeft(HBox playerLeft) {
        this.playerLeft = playerLeft;
    }

    public HBox getPlayerRight() {
        return playerRight;
    }

    public void setPlayerRight(HBox playerRight) {
        this.playerRight = playerRight;
    }

    public MediaPlayer getMediaPlayerLeft() {
        return mediaPlayerLeft;
    }

    public void setMediaPlayerLeft(MediaPlayer mediaPlayerLeft) {
        this.mediaPlayerLeft = mediaPlayerLeft;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

}
