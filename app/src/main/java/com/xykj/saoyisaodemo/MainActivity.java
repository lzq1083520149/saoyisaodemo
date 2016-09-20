package com.xykj.saoyisaodemo;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import zxing.CaptureActivity;
import zxing.QrCodeUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    AlertDialog alertDialog;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 生成二维码
     * @param v
     */
    public void shengCheng(View v){
        ImageView imv = new ImageView(this);
        Bitmap bitmap = QrCodeUtil.generateQrCode("Hello", 300, 300);
        imv.setImageBitmap(bitmap);

        alertDialog = new android.app.AlertDialog.Builder(this).
            setTitle("我的二维码").setView(imv).setPositiveButton("确定", null).create();
        alertDialog.show();
    }

    /**
     * 扫一扫
     * @param v
     */
    public void saoYiSao(View v){
        startActivityForResult(new Intent(this, CaptureActivity.class),2);
    }
}
