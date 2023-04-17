package com.example.tcpclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private pad mMessage_pad;
    private LinearLayout mPad_Layout;
    private adapterView mAdapterView;
    private RecyclerView mMessageList;
    TcpClient mTcpClient;

    public messageLab getMessageLab() {
        return mMessageLab;
    }

    public void setMessageLab(messageLab messageLab) {
        mMessageLab = messageLab;
    }

    private messageLab mMessageLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater flatter = LayoutInflater.from(this);
        mPad_Layout = findViewById(R.id.message_pad);
        mMessageList = findViewById(R.id.chat_dialog_recycle);
        new ConnectTask().execute("");
        mMessageList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mMessageLab = new messageLab();
        mMessage_pad = new pad(mPad_Layout.getChildAt(0),this,mTcpClient);
    }
    public void updateUI(){
//        Log.d(TAG, String.valueOf(m_lab.getRoutines().size()));
        mAdapterView = new adapterView(getApplicationContext());
        mMessageList.setAdapter(mAdapterView.getAdapter(mMessageLab.getMessages()));
    }
    public class ConnectTask extends AsyncTask<String, String, TcpClient> {

        @Override
        protected TcpClient doInBackground(String... message) {

            //we create a TCPClient object
            mTcpClient = new TcpClient(new TcpClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                }
            });
            mTcpClient.run();

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            //response received from server
            Log.d("test", "response " + values[0]);
            //process server response here....

        }
    }
}