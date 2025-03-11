package com.example.exp5_1_1;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //将数据写入文件
        String FILENAME = "myfile";
        String data = "在内部文件中的数据";
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            osw.write(data);
            osw.flush();
            fos.flush();
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //从文件读出数据
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
            char[] data2=new char[fis.available()];
            isr.read(data2);
            isr.close();
            fis.close();
            TextView textView=(TextView)findViewById(R.id.textView);
            textView.setText(new String(data2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}