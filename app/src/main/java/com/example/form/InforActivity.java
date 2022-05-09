package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class InforActivity extends AppCompatActivity{
    private EditText mssv, name, cccd, phone, email, birthday, quequan, currentHome;
    private RadioButton khmt, ktmt;
    private CheckBox c, java, python, privacy;
    private DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);

        mssv=findViewById(R.id.mssv);
        name=findViewById(R.id.name);
        cccd=findViewById(R.id.cccd);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        birthday=findViewById(R.id.birthday);
        quequan=findViewById(R.id.quequan);
        currentHome=findViewById(R.id.currentHome);

        khmt=findViewById(R.id.khmt);
        ktmt=findViewById(R.id.ktmt);

        c=findViewById(R.id.c);
        java=findViewById(R.id.java);
        python=findViewById(R.id.python);
        privacy=findViewById(R.id.privacy);
    }

    public void setBirthday(View view){
        Calendar calendar=Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        EditText text=(EditText)view;

        DatePickerDialog datePickerDialog=new DatePickerDialog(InforActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        text.setText(date);
                    }
                },year,month,day);
        datePickerDialog.show();
    }

    public void submit(View view){
        mssv.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        name.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        cccd.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        phone.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        email.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        birthday.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        quequan.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        currentHome.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        if(validate()){
            Intent intent=new Intent(InforActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    public boolean validate(){
        if(mssv.getText().toString().length()==0){
            mssv.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(InforActivity.this,"Thiếu MSSV", Toast.LENGTH_LONG).show();
            return false;
        }
        if(name.getText().toString().length()==0){
            name.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(InforActivity.this,"Thiếu họ và tên", Toast.LENGTH_LONG).show();
            return false;
        }
        if(cccd.getText().toString().length()==0){
            cccd.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(InforActivity.this,"Thiếu CCCD", Toast.LENGTH_LONG).show();
            return false;
        }
        if(phone.getText().toString().length()==0){
            phone.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(InforActivity.this,"Thiếu số điện thoại", Toast.LENGTH_LONG).show();
            return false;
        }
        if(email.getText().toString().length()==0){
            email.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(InforActivity.this,"Thiếu email", Toast.LENGTH_LONG).show();
            return false;
        }
        if(birthday.getText().toString().length()==0){
            birthday.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(InforActivity.this,"Thiếu ngày sinh", Toast.LENGTH_LONG).show();
            return false;
        }
        if(!khmt.isChecked() && !ktmt.isChecked()){
            Toast.makeText(InforActivity.this,"Thiếu ngành học", Toast.LENGTH_LONG).show();
            return false;
        }
        if(!privacy.isChecked()){
            Toast.makeText(InforActivity.this,"Bạn chưa đồng ý với điều khoản", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
