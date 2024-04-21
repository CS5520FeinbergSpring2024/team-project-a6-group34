package edu.northeastern.alarmyquest.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.northeastern.alarmyquest.R;


public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mData;
    private LayoutInflater mInflater;
    private MediaPlayer mMediaPlayer;
    private TextView mLastClickedButton;

    public CustomSpinnerAdapter(Context context, int resource, List<String> data) {
        super(context, resource, data);
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    public void stop(){
        if (mMediaPlayer != null && mMediaPlayer.isPlaying())
            mMediaPlayer.pause();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.spinner_item_select, null, false);

        TextView textView = view.findViewById(R.id.text1);
        textView.setText(mData.get(position));

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.spinner_item, null, false);

        TextView textView = view.findViewById(R.id.text1);
        textView.setText(mData.get(position));
        TextView btn = view.findViewById(R.id.text2);

        btn.setOnClickListener(v -> {
            if (mLastClickedButton != null && mLastClickedButton != btn) {
                mLastClickedButton.setText("Start");
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer = null;
                }
            }
            mLastClickedButton = btn;
            String rawResourceName = mData.get(position);
            int resId = mContext.getResources().getIdentifier(rawResourceName, "raw", mContext.getPackageName());
            if (btn.getText().toString().trim().equals("Start")) {
                btn.setText("Pause");
                mMediaPlayer = MediaPlayer.create(mContext, resId);
                mMediaPlayer.start();
            } else {
                btn.setText("Start");
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                }
            }
        });

        return view;
    }
}

