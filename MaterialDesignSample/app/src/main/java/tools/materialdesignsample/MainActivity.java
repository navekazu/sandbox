package tools.materialdesignsample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);  // （1）
        toolbar.setLogo(R.mipmap.ic_launcher);  // （2）
        toolbar.setTitle(R.string.toolbar_title);  // （3）
        toolbar.setTitleTextColor(Color.WHITE);  // （4）
        toolbar.setSubtitle(R.string.toolbar_subtitle);  // （5）
        toolbar.setSubtitleTextColor(Color.LTGRAY);  // （6）
        setSupportActionBar(toolbar);  // （7）
    }
}
