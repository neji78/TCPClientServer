package com.example.tcpclient;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class pad {
    private ImageButton mSend;
    private EditText mEditText;
    private String mMessage;
    private MainActivity mParent;
    private TcpClient mSocket;
    private final String TAG = "messagePadTag";

    public pad(View view, Context context,TcpClient socket) {

        mSend = view.findViewById(R.id.send_button);
        mEditText = view.findViewById(R.id.textpad);
        mEditText.setText("Hello Every Body");
        mSocket = socket;
        mParent = (MainActivity) context;
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessage = mEditText.getText().toString();
                messageItem localMessage = new messageItem();
                localMessage.setMessage(mEditText.getText().toString());
                localMessage.setUserName("Esmaeil");
                mEditText.setText("");
                messageLab localLab = mParent.getMessageLab();
                localLab.addMessage(localMessage);
                mParent.setMessageLab(localLab);
                mParent.updateUI();
                if (mSocket != null) {
                    Log.d(TAG,"Clicked");
                    mSocket.sendMessage(mMessage);
                }
                //do something
            }
        });
    }
}
