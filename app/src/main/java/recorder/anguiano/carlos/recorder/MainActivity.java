package recorder.anguiano.carlos.recorder;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button button;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton", Toast.LENGTH_SHORT).show();

                try {
//                    PlaybackFragment playbackFragment = new PlaybackFragment().newInstance(getItem(holder.getPosition()));
                    String a = "/storage/emulated/0/SoundRecorder/Mi grabación_3.mp4";
                    File file = new File(a);

                    RecordingItem recordingItem = new RecordingItem();
                    recordingItem.setFilePath(a);
                    recordingItem.setLength(56816);
                    recordingItem.setName("Mi grabacion_3.mp4");
//                   recordingItem.setTime(1508383369790);
                    recordingItem.setTime(1508383369);
                    recordingItem.setId(3);


//                    PlaybackFragment playbackFragment = new PlaybackFragment().newInstance(getItem(holder.getPosition()));
                    PlaybackFragment playbackFragment = new PlaybackFragment().newInstance(recordingItem);

                    FragmentTransaction transaction = MainActivity.this
                            .getSupportFragmentManager()
                            .beginTransaction();

                    playbackFragment.show(transaction, "dialog_playback");

                } catch (Exception e) {
                    Log.e(TAG, "exception", e);
                }
            }
        });
    }
}
