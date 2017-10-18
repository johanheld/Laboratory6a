package com.example.johan.laboratory6a;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private Button btnDisco;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        btnDisco = (Button)findViewById(R.id.btnDisco);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        btnDisco.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Colorize().execute();
            }
        });
    }

    public void disco1(int color)
    {
        tv1.setBackgroundColor(color);
    }

    public void disco2(int color)
    {
        tv2.setBackgroundColor(color);
    }

    private class Colorize extends AsyncTask<Void, Integer, Void>
    {

        @Override
        protected Void doInBackground(Void... params)
        {
            int n = 0;
            Random rand = new Random();

            while (n < 10)
            {
                int r = rand.nextInt();
                int g = rand.nextInt();
                int b = rand.nextInt();
                int color = Color.argb(255, r, g, b);
                Log.d("COLOR", " " + color);
                publishProgress(color);
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                n++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);

            int color = values[0];
            disco1(color);
            disco2(color);
        }
    }
}
