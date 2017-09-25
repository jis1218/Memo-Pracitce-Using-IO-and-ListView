package com.example.insupmemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.insupmemo.domain.Memo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-09-20.
 */

public class ListAdapter extends BaseAdapter {

    ArrayList<Memo> list = null;
    Context context = null;
    String title;
    String content;


    public ListAdapter(ArrayList<Memo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        Memo memo = list.get(position);
        if(view==null) {

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.datalist, null);
            holder = new Holder(view);

            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.setTxtViewTitle(memo.getTitle());
        holder.setTxtViewDate(memo.getDatetime());
        //view를 눌렀을 때 intent에 extra 값을 넣어주어 detailActivity로 넘겨주는 코드가 추가되어야 함
        return view;
    }

    private void putFileToList(){

    }

    private void getFileFromStorage(){


    }
}

//Holder에서 view의 모든 값을 먼저 입력해준다.
class Holder{
    private TextView txtTitleData;
    private TextView txtDateData;

    public Holder(View view){
        txtTitleData = view.findViewById(R.id.txtTitleData);
        txtDateData = view.findViewById(R.id.txtDateData);
    }

    public void setTxtViewTitle(String title){
        txtTitleData.setText(title);
    }

    public void setTxtViewDate(long datetime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String strDatetime = sdf.format(datetime);
        txtDateData.setText(strDatetime);
    }



}
