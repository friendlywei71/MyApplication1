package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    private class Temp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int iTemp = 22;
            Log.d("ShowMessage", "Demo" + iTemp);
            textView.setText("Hello World 方法1");
        }
    }

    private View.OnClickListener btnTestOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int iTemp = 22;
            Log.d("ShowMessage", "Demo" + iTemp);
            textView.setText("Hello World 方法4");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {//自寫程式的起始點函數
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自寫程式的起始點
        button = findViewById(R.id.btnTest);
        textView = findViewById(R.id.txtView);
        //方法1 詳細寫法+物件匿名
        button.setOnClickListener(new Temp());
        //方法2 類別匿名+物件匿名
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int iTemp = 22;
                Log.d("ShowMessage", "Demo" + iTemp);
                textView.setText("Hello World 方法2");
            }
        });
        //方法3 類別匿名+物件匿名+Lambda
        button.setOnClickListener((View view)->{
            int iTemp = 22;
            Log.d("ShowMessage", "Demo" + iTemp);
            textView.setText("Hello World 方法3");
        });
        //方法4 把匿名類別寫到外面去 可以增加閱讀的可看性
        button.setOnClickListener(btnTestOnClickListener);//把匿名類別寫到外面去 可以增加閱讀的可看性
    }
}