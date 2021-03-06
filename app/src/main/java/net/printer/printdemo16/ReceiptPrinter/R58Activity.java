package net.printer.printdemo16.ReceiptPrinter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.posprinter.posprinterface.ProcessData;
import net.posprinter.posprinterface.TaskCallback;
import net.posprinter.utils.BitmapProcess;
import net.posprinter.utils.BitmapToByteData;
import net.posprinter.utils.DataForSendToPrinterPos58;
import net.posprinter.utils.DataForSendToPrinterPos80;
import net.posprinter.utils.StringUtils;
import net.printer.printdemo16.CustomPrinter;
import net.printer.printdemo16.MainActivity;
import net.printer.printdemo16.R;

import java.util.ArrayList;
import java.util.List;

public class R58Activity extends AppCompatActivity implements View.OnClickListener{


    private Button sample,text,barcode,qrcode,bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r58);
        initview();
    }

    private void initview(){
        sample = findViewById(R.id.bt_rcp);
        text = findViewById(R.id.bt_58text);
        barcode = findViewById(R.id.bt_58barcode);
        qrcode = findViewById(R.id.bt_58qr);
        bitmap = findViewById(R.id.bt_58bitmap2);

        sample.setOnClickListener(this);
        text.setOnClickListener(this);
        barcode.setOnClickListener(this);
        qrcode.setOnClickListener(this);
        bitmap.setOnClickListener(this);
    }



    @Override
    public void onClick(View view)
    {
        int id = view.getId();

        if (id==R.id.bt_rcp)
        {
            printSample();
        }

        if(id== R.id.bt_58text)
        {
            printText();
        }

        if (id== R.id.bt_58barcode)
        {
            printBarcode();
        }

        if (id== R.id.bt_58qr)
        {
            printqr();
        }
        if(id== R.id.bt_58bitmap2)
        {
            printBitmap();
        }
    }
    /**
     * ????????????
     */
    private void printSample(){
        if (MainActivity.ISCONNECT){
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
                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(50,00));//??????????????????
                    list.add(DataForSendToPrinterPos58.selectCharacterSize(17));//??????????????????
                    list.add(StringUtils.strTobytes("??????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(250,00));
                    list.add(StringUtils.strTobytes("??????"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                    list.add(StringUtils.strTobytes("?????????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                    list.add(StringUtils.strTobytes("5???"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                    list.add(StringUtils.strTobytes("????????????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                    list.add(StringUtils.strTobytes("6???"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                    list.add(StringUtils.strTobytes("?????????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                    list.add(StringUtils.strTobytes("7???"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                    list.add(StringUtils.strTobytes("?????????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                    list.add(StringUtils.strTobytes("8???"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                    list.add(StringUtils.strTobytes("?????????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                    list.add(StringUtils.strTobytes("9???"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(30,00));
                    list.add(StringUtils.strTobytes("?????????"));
                    list.add(DataForSendToPrinterPos58.setAbsolutePrintPosition(220,00));
                    list.add(StringUtils.strTobytes("10???"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());

                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ????????????
     */
    private void printText(){

        if (MainActivity.ISCONNECT){
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
                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    list.add(StringUtils.strTobytes("1234567890qwertyuiopakjbdscm nkjdv mcdskjb"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }

    }

    /**
    ??????????????????
     */
    private void printBarcode(){
        if (MainActivity.ISCONNECT){
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
                    //?????????????????????????????????
                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    //??????????????????
                    list.add(DataForSendToPrinterPos58.selectAlignment(1));
                    //??????HRI????????????
                    list.add(DataForSendToPrinterPos58.selectHRICharacterPrintPosition(02));
                    //??????????????????
                    list.add(DataForSendToPrinterPos58.setBarcodeWidth(2));
                    //????????????
                    list.add(DataForSendToPrinterPos58.setBarcodeHeight(80));
                    //???????????????????????????73???code128??????????????????????????????????????????????????????
                    list.add(DataForSendToPrinterPos58.printBarcode(73,10,"{B12345678"));
                    //????????????
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * ??????????????????
     */
    private void printqr(){
        if (MainActivity.ISCONNECT){
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
                    //?????????????????????????????????
                    list.add(DataForSendToPrinterPos58.initializePrinter());
                    //??????????????????
                    list.add(DataForSendToPrinterPos58.selectAlignment(1));
                    list.add(DataForSendToPrinterPos80.printQRcode(3,48,"www.xprinter.net"));
                    list.add(DataForSendToPrinterPos58.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }

    private void printBitmap(){

        final Bitmap bitmap1 =  BitmapProcess.compressBmpByYourWidth
                (BitmapFactory.decodeResource(getResources(), R.drawable.test),300);

        if (MainActivity.ISCONNECT){
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
                    list.add(DataForSendToPrinterPos80.initializePrinter());
                    List<Bitmap> blist= new ArrayList<>();
                    blist = BitmapProcess.cutBitmap(50,bitmap1);
                    for (int i= 0 ;i<blist.size();i++){
                        list.add(DataForSendToPrinterPos80.printRasterBmp(0,blist.get(i), BitmapToByteData.BmpType.Threshold, BitmapToByteData.AlignType.Center,384));
                    }
                    list.add(StringUtils.strTobytes("1234567890qwertyuiopakjbdscm nkjdv mcdskjb"));
                    list.add(DataForSendToPrinterPos80.printAndFeedLine());
                    return list;
                }
            });
        }else {
            Toast.makeText(getApplicationContext(),getString(R.string.connect_first),Toast.LENGTH_SHORT).show();
        }
    }

}
