package com.example.loinapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.editName);
                EditText pw = findViewById(R.id.editPW);
                if ((name.getText().toString().equals("james")) &&
                        (pw.getText().toString().equals("pw"))) {


                    Bundle data = new Bundle();
                    data.putString("account", name.getText().toString());
                    data.putInt("age", 24);

                    Intent it = new Intent(getApplicationContext(), Userctivity.class);

                    it.putExtras(data);
                    startActivityForResult(it, 100);

                    Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "登入失敗", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {

            if (resultCode == 1000) {
                Bundle da = data.getExtras();
                String val = da.getString("key");
                Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
            }
        }
    }
}