package com.example.insupmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.insupmemo.domain.Memo;
import com.example.insupmemo.util.FileReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriteActivity extends AppCompatActivity {

    EditText editTitle, editAuthor, editMemo;
    Button btnPost;
    ArrayList<Memo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        list = new ArrayList<>();
        init();
        initListener();
    }


    private void init(){
        editAuthor = (EditText) findViewById(R.id.editAuthor);
        editMemo = (EditText) findViewById(R.id.editMemo);
        editTitle = (EditText) findViewById(R.id.editTitle);
        btnPost = (Button) findViewById(R.id.btnPost);
    }

    private void write(Memo memo){
        String fileName = System.currentTimeMillis() + ".txt";
        try {
            FileReadWrite.write(this, fileName, memo.addWholeContent() );
            setResult(RESULT_OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initListener(){
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Memo memo = contentStore(new Memo());
                write(memo);
                finish();
            }
        });
    }


    private Memo contentStore(Memo memo){
        memo.setTitle(editTitle.getText().toString());
        memo.setAuthor(editAuthor.getText().toString());
        memo.setContent(editMemo.getText().toString());
        memo.setDatetime(System.currentTimeMillis());

        return memo;
    }
}
