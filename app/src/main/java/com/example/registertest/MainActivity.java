package com.example.registertest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText usernametext,passwordtext,repsdtext,cityText;
    private RadioButton maleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernametext=findViewById(R.id.username);
        passwordtext=findViewById(R.id.password);
        repsdtext=findViewById(R.id.repsd);
        maleBtn=findViewById(R.id.male);
        cityText=findViewById(R.id.city);
    }

    public void register(View view) {
        String checkResult=checkInfo();
        if (checkResult!=null){
             AlertDialog.Builder builder=new AlertDialog.Builder(this);
             builder.setTitle("错误提示");
             builder.setMessage(checkResult);
             builder.setPositiveButton("确定",null);
             builder.create().show();
        }
        else {
            String sex="男";
            if (!maleBtn.isChecked()){
                sex="女";
            }
            Intent intent=new Intent(this,ResultActivity.class);
            intent.putExtra("username",usernametext.getText().toString());
            intent.putExtra("city",cityText.getText().toString());
            intent.putExtra("sex",sex);
            startActivity(intent);
        }
    }
    public  String checkInfo(){
        String username=usernametext.getText().toString();
        String password=passwordtext.getText().toString();
        String repsd=repsdtext.getText().toString();
        if(username==null||"".equals(username)){
            return "用户名不能为空";
        }
        if (password.length()<6||password.length()>15){
            return "用户名密码应在6-15位之间";
        }
        if (!repsd.equals(password)){
            return "两次密码不一致";
        }
        return null;
    }
    public void chooseCity(View view){
        Intent intent=new Intent(this,ChooseCityActivity.class);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if (data!=null){
            if (resultCode==0x11)
            cityText.setText(data.getStringExtra("province")+data.getStringExtra("city"));
        }




    }
}
