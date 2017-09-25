package com.example.insupmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.insupmemo.domain.Memo;
import com.example.insupmemo.util.FileReadWrite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    final int WRITE_ACTIVITY = 100;
    Button btnWrite;
    ListView listView;

    ArrayList<Memo> list;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
        initListener();
    }

    private void init(){
        btnWrite = (Button) findViewById(R.id.btnWrite);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        fileFromStorage();
        adapter = new ListAdapter(list, this);
        listView.setAdapter(adapter);
    }

    private void initListener(){
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WriteActivity.class);
                startActivityForResult(intent, WRITE_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==WRITE_ACTIVITY){
            if(resultCode==RESULT_OK)
            init();
        }

    }

    private void fileFromStorage(){

        File file = this.getFilesDir();
        File files[] = file.listFiles();

        for(File item : files){
            try {

                String wholeContent = FileReadWrite.read(this, item.getName()); //왜 getName인가???
                Toast.makeText(this, item.getName(), Toast.LENGTH_SHORT).show();
                Log.d("wholeContent", "String은 =" + wholeContent);
                Memo memo = new Memo();
                memo.divideContent(wholeContent);
                list.add(memo);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
