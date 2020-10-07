package com.tdd.duytran.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtSongName, txtTimeSong, txtTimeTotal;
    SeekBar sbControl;
    ImageButton btnMode, btnPrevious, btnPlay, btnNext, btnFavourite;
    ArrayList<Song> arraySong;
    int position = 0, mode = 0;
    MediaPlayer mediaPlayer;
    SimpleDateFormat simpleDateFormat;
    ImageView imgDisc;
    Animation anim_disc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        initial();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                }
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if (position < 0) {
                    position = arraySong.size() - 1;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                initial();
                btnPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if (position > arraySong.size() - 1) {
                    position = 0;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                initial();
                btnPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
            }
        });

        sbControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(sbControl.getProgress());
            }
        });

        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mode) {
                    case 0:
                        mode = 1;
                        btnMode.setImageResource(R.drawable.repeat_one);
                        break;
                    case 1:
                        mode = 2;
                        Song current = arraySong.get(position);
                        Collections.shuffle(arraySong);
                        arraySong.remove(current);
                        arraySong.add(position, current);
                        btnMode.setImageResource(R.drawable.shuffle);
                        break;
                    case 2:
                        mode = 0;
                        btnMode.setImageResource(R.drawable.repeat);
                        break;
                }
            }
        });

        btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arraySong.get(position).getIsLiked()) {
                    arraySong.get(position).setIsLiked(false);
                    btnFavourite.setImageResource(R.drawable.heart_empty);
                } else {
                    arraySong.get(position).setIsLiked(true);
                    btnFavourite.setImageResource(R.drawable.heart_full);
                }
            }
        });
    }

    private void updateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtTimeSong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                sbControl.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (mode == 1) {
                            playSong();
                        } else {
                            btnNext.performClick();
                        }
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 0);
    }

    private void playSong() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        initial();
        btnPlay.setImageResource(R.drawable.pause);
        mediaPlayer.start();
    }

    private void initial() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
        txtSongName.setText(arraySong.get(position).getName());
        txtTimeTotal.setText(simpleDateFormat.format(mediaPlayer.getDuration()).toString());
        sbControl.setMax(mediaPlayer.getDuration());
        updateTimeSong();
        imgDisc.startAnimation(anim_disc);
        if(arraySong.get(position).getIsLiked()) {
            btnFavourite.setImageResource(R.drawable.heart_full);
        } else {
            btnFavourite.setImageResource(R.drawable.heart_empty);
        }
    }

    private void mapping() {
        txtSongName = (TextView) findViewById(R.id.textViewSongName);
        txtTimeSong = (TextView) findViewById(R.id.textViewTimeSong);
        txtTimeTotal = (TextView) findViewById(R.id.textViewTimeTotal);
        sbControl = (SeekBar) findViewById(R.id.seekBarControl);
        btnMode = (ImageButton) findViewById(R.id.imageButtonMode);
        btnPrevious = (ImageButton) findViewById(R.id.imageButtonPrevious);
        btnPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        btnNext = (ImageButton) findViewById(R.id.imageButtonNext);
        btnFavourite = (ImageButton) findViewById(R.id.imageButtonFavourite);
        imgDisc = (ImageView) findViewById(R.id.imageViewDisc);
        anim_disc = AnimationUtils.loadAnimation(this, R.anim.anim_disc);

        arraySong = new ArrayList<>();
        // add song
        arraySong.add(new Song("Chắc ai đó sẽ về", R.raw.chac_ai_do_se_ve));
        arraySong.add(new Song("Chiều nay không có mưa bay", R.raw.chieu_nay_khong_co_mua_bay));
        arraySong.add(new Song("Chưa bao giờ", R.raw.chua_bao_gio));
        arraySong.add(new Song("Có anh ở đây rồi", R.raw.co_anh_o_day_roi));
        arraySong.add(new Song("Có chút ngọt ngào", R.raw.co_chut_ngot_ngao));
        arraySong.add(new Song("Deep side", R.raw.deep_side));
        arraySong.add(new Song("Here with you", R.raw.here_with_you));
        arraySong.add(new Song("If", R.raw.if_));
        arraySong.add(new Song("In the end", R.raw.in_the_end));
        arraySong.add(new Song("Không quan tâm", R.raw.khong_quan_tam));
        arraySong.add(new Song("Lemon", R.raw.lemon));
        arraySong.add(new Song("Mad at Disney", R.raw.mad_at_disney));
        simpleDateFormat = new SimpleDateFormat("mm:ss");
    }
}