package com.example.insupmemo.domain;

import android.util.Log;

/**
 * Created by 정인섭 on 2017-09-20.
 */

public class Memo {
    private int no;
    private String title;
    private String author;
    private String content;
    private long datetime;
    final String DELIMINATOR = "!";

    public Memo() {
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String addWholeContent(){
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle()).append(DELIMINATOR).append(getAuthor()).append(DELIMINATOR).append(getContent()).append(DELIMINATOR).append(getDatetime());

        return sb.toString();
    }

    public void divideContent(String wholeContent){
        String array[] = wholeContent.split(DELIMINATOR);
        Log.d("array[0]", "array[0] = " + array[0]);
        setTitle(array[0]);
        setAuthor(array[1]);
        setContent(array[2]);
        setDatetime(Long.parseLong(array[3]));
    }
}
