package com.example.tcpclient;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class adapterView {
    private Context m_context;
    private message_adaptor m_message_adapter;
    public final String TAG = "DEBUGGER";
    public adapterView(Context context) {
        m_context = context;
    }
    public message_adaptor getAdapter(List<messageItem> messages)
    {
        Log.d(TAG,String.valueOf(messages.size()));
        m_message_adapter = new message_adaptor(messages);
        return m_message_adapter;
    }

    private class message_adaptor extends RecyclerView.Adapter<message_holder>{
        private List<messageItem> mMessages;
        public message_adaptor(List<messageItem> messages ) {
            mMessages = messages;
        }

        @Override
        public message_holder onCreateViewHolder( ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(m_context);
            return new message_holder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder( message_holder holder, int position) {
            messageItem item = mMessages.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return mMessages.size();
        }
    }
    private class message_holder extends RecyclerView.ViewHolder {

        private TextView m_routineName;
        private TextView m_routineDescription;
        private messageItem m_routine;
        private TableLayout m_table;
        public message_holder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.message,parent,false));
            m_routineName = (TextView) itemView.findViewById(R.id.username);
            m_routineDescription = (TextView) itemView.findViewById(R.id.msg_text);
        }
        public void bind(messageItem crime) {
            m_routine = crime;
            m_routineName.setText(m_routine.getUserName());
            m_routineDescription.setText(m_routine.getMessage());
        }
    }
}
