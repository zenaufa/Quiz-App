package com.zenaufa.beginnertesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zenaufa.beginnertesting.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int hasil1;
    int hasil2;
    int hasil3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean cek_jawaban1(){
       RadioGroup nomor_1 = (RadioGroup) findViewById(R.id.nomor_1);
        if(nomor_1.getCheckedRadioButtonId() == R.id.answer_2){
            return true;
        }else
        {
            return false;
        }
    }

    public boolean cek_jawaban2(){
        CheckBox jawab1 = (CheckBox) findViewById(R.id.lolipop);
        CheckBox jawab2 = (CheckBox) findViewById(R.id.marshmallow);
        CheckBox jawab3 = (CheckBox) findViewById(R.id.symbian);

        if(jawab1.isChecked() && jawab2.isChecked() && !jawab3.isChecked()){
            return true;
        }else{
            return false;
        }
    }

    public boolean cek_jawaban3(){
        EditText jawaban3 = (EditText) findViewById(R.id.jawaban_nomor_3);

        if(jawaban3.getText().toString().equalsIgnoreCase("jakarta")){
            return true;
        }else{
            return false;
        }
    }

/*    public void validasi(View view){

        if(cek_jawaban1()){
            hasil1 = 1;
        }else{
            hasil1 = 0;
        }
        if(cek_jawaban2()){
            hasil2 = 1;
        }else{
            hasil2 = 0;
        }
        if(cek_jawaban3()){
            hasil3 = 1;
        }else {
            hasil3 = 0;
        }

        if(hasil1 == 1){
            if(hasil2 == 1){
                if(hasil3 == 1){
                    Toast.makeText(this, "Seluruh Jawaban anda benar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Jawaban Nomor 3 Salah", Toast.LENGTH_SHORT).show();
                }
            }else{
                if(hasil3 == 1){
                    Toast.makeText(this, "Jawaban Nomor 2 salah", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Jawaban nomor 2 dan 3 salah", Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            if(hasil2 == 1){
                if(hasil3 == 1){
                    Toast.makeText(this, "Jawaban nomor 1 salah", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Jawaban nomor 1 dan 3 salah", Toast.LENGTH_SHORT).show();
                }
            }else{
                if(hasil3 == 1){
                    Toast.makeText(this, "Jawaban nomor 1 dan 2 salah ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Semua jawaban salah", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }*/

    public void validasi_stringbuilder(View view){
        int jumlah_jawaban_benar;
        jumlah_jawaban_benar = 0;
        ArrayList<String> jawaban_salah = new ArrayList<>();
        if(cek_jawaban1()){
            jumlah_jawaban_benar++;
        }else{
            jawaban_salah.add("nomor 1 salah");
        }
        if(cek_jawaban2()){
            jumlah_jawaban_benar++;
        }else{
            jawaban_salah.add("nomor 2 salah");
        }
        if(cek_jawaban3()){
            jumlah_jawaban_benar++;
        }else{
            jawaban_salah.add("nomor 3 salah");
        }

        StringBuilder sb = new StringBuilder();

        for(String salah : jawaban_salah){
            sb.append(salah);
            sb.append("\n");
        }

        CharSequence text = "Jumlah jawaban benar = "+ jumlah_jawaban_benar + "\n" + sb.toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
