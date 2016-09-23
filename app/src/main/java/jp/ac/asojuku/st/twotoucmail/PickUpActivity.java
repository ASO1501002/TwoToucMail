package jp.ac.asojuku.st.twotoucmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class PickUpActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgPlace = (RadioGroup) findViewById(R.id.rg_place);
                int checkedId = rgPlace.getCheckedRadioButtonId();
                String setPlace = ((RadioButton) findViewById(checkedId)).getText().toString();

                EditText edit01 = (EditText) findViewById(R.id.editText);
                String title = edit01.getText().toString();
                Resources res = getResources();

                Random random = new Random();
                int n = random.nextInt(3);
                Uri uri;
                if(n == 1){
                    uri = Uri.parse("mailto:" + res.getString(R.string.mail1_to).toString());
                } else if (n == 2) {
                    uri = Uri.parse("mailto:" + res.getString(R.string.mail2_to).toString());
                } else {
                    uri = Uri.parse("mailto:" + res.getString(R.string.mail3_to).toString());
                }
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra(intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, setPlace + "迎えに来て");
                startActivity(intent);

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PickUp Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://jp.ac.asojuku.st.twotoucmail/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PickUp Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://jp.ac.asojuku.st.twotoucmail/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
