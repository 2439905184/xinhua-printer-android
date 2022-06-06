package net.printer.printdemo16;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.posprinter.posprinterface.ProcessData;
import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.DataForSendToPrinterPos58;
import net.posprinter.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomPrinter extends Activity
{
    EditText item_name;
    EditText item_price;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_printer);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
    }
    //添加商品
    public void add_item(View v)
    {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView v_item = new TextView(this);
        TextView v_item_price = new TextView(this);

        v_item.setText(item_name.getText().toString());
        v_item_price.setText(item_price.getText().toString());

        linearLayout.addView(v_item);
        linearLayout.addView(item_price);
        sample();
        //linearLayout.setLayoutDirection(ViewGroup.);
    }
    //票据标签
    private void sample()
    {
        if (MainActivity.ISCONNECT)
        {
            MainActivity.myBinder.WriteSendData(new TaskCallback() {
            @Override
            public void OnSucceed() {
                Toast.makeText(getApplicationContext(),getString(R.string.con_success),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void OnFailed() {
                Toast.makeText(getApplicationContext(),getString(R.string.con_failed),Toast.LENGTH_SHORT).show();
            }
        }, new ProcessData() {
            @Override
            public List<byte[]> processDataBeforeSend() {
                List<byte[]> list = new ArrayList<>();
                list.add(DataForSendToPrinterPos58.openOrCloseLableModelInReceip(true));
                list.add(DataForSendToPrinterPos58.setTheLableWidth(40));
                list.add(DataForSendToPrinterPos58.initializePrinter());
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(50,00));//设置初始位置
                list.add(DataForSendToPrinterPos58.selectCharacterSize(17));//字体放大一倍
                list.add(StringUtils.strTobytes("商品"));
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(250,00));
                list.add(StringUtils.strTobytes("价格"));
                list.add(DataForSendToPrinterPos58.printAndFeedLine());
                list.add(DataForSendToPrinterPos58.printAndFeedLine());

                list.add(DataForSendToPrinterPos58.initializePrinter());
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                list.add(StringUtils.strTobytes(item_name.getText().toString()));
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                list.add(StringUtils.strTobytes(item_price.getText().toString()));
                list.add(DataForSendToPrinterPos58.printAndFeedLine());

                list.add(DataForSendToPrinterPos58.endOfLable());
                return list;

               /* list.add(DataForSendToPrinterPos58.openOrCloseLableModelInReceip(true));
                list.add(DataForSendToPrinterPos58.setTheLableWidth(40));
                list.add(DataForSendToPrinterPos58.initializePrinter());
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(50,00));//设置初始位置
                list.add(DataForSendToPrinterPos58.selectCharacterSize(17));//字体放大一倍
                list.add(StringUtils.strTobytes("商品"));
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(250,00));
                list.add(StringUtils.strTobytes("价格"));
                list.add(DataForSendToPrinterPos58.printAndFeedLine());
                list.add(DataForSendToPrinterPos58.printAndFeedLine());

                list.add(DataForSendToPrinterPos58.initializePrinter());
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                list.add(StringUtils.strTobytes("黄焖鸡"));
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                list.add(StringUtils.strTobytes("5元"));
                list.add(DataForSendToPrinterPos58.printAndFeedLine());

                list.add(DataForSendToPrinterPos58.initializePrinter());
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                list.add(StringUtils.strTobytes("黄焖鸡呀"));
                list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                list.add(StringUtils.strTobytes("6元"));
                list.add(DataForSendToPrinterPos58.printAndFeedLine());
                list.add(DataForSendToPrinterPos58.endOfLable());
                return list;*/
            }
        });
    }else {
        Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
    }
}
}