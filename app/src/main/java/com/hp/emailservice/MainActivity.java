package com.hp.emailservice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to[]={"mansiagrawal2103@gmail.com"};
                String sub=e1.getText().toString();
                String qry=e2.getText().toString();
                sendemail(to,sub,qry);




            }
        });
    }
    public  void sendemail(String to[],String subject,String qry)
    {
        Intent i=new Intent();//mailto is reserved word
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,subject);//predefined keys
        i.putExtra(Intent.EXTRA_TEXT,qry);
        startActivity(Intent.createChooser(i,"Email"));


    }
}
