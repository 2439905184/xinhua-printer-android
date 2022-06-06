package net.printer.printdemo16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomR58 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_r58);
    }
    //小沙盒添加的代码
    public void gotoCustom(View v)
    {
        Intent i = new Intent(this, CustomPrinter.class);
        startActivity(i);
    }
}