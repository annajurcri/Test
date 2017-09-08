package com.example.annacristobal.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Test extends LinearLayout {

    private TextView mText1, mText2;
    private ImageView mImage;
    private Button mButton;

    public Test(Context context) {
        super(context);
        init(context, null, 0);

    }

    public Test(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public Test(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle){
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.test_layout,this, true);

        mText1 = (TextView) findViewById(R.id.Text1);
        mText2 = (TextView) findViewById(R.id.Text2);
        mImage = (ImageView) findViewById(R.id.Image);
        mButton = (Button) findViewById(R.id.Button);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView, defStyle, 0);

        String texto1 = a.getString(R.styleable.MyCustomView_texto1);
        mText1.setText(texto1);

        String texto2 = a.getString(R.styleable.MyCustomView_texto2);
        mText2.setText(texto2);

        Drawable imagen = a.getDrawable(R.styleable.MyCustomView_imagen);

        String boton = a.getString(R.styleable.MyCustomView_boton);


        if(boton == null || boton.isEmpty()){
            mButton.setVisibility(View.GONE);
        } else {
            mButton.setText(boton);
        }

        if(imagen == null){
            mImage.setVisibility(View.GONE);
        } else {
            mImage.setImageDrawable(imagen);
        }

        a.recycle();
    }

}
