package com.example.a10119909latihan3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.a10119909latihan3.DoneActivity.ID_EXTRA_MSG_EXIT;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        // logika untuk menampung nilai putekstra dari kelas DoneActivity,
        // agar ketika dihalaman akhir (DoneActivity) ditekan button ok,
        // Semua activity dapat tertutup juga (finish).
        if (getIntent().getBooleanExtra(ID_EXTRA_MSG_EXIT, false)) {
            finish();
        }
    }

    //Method dari butterknife untuk mengklik tombol dengan id btnWalkthroughStart
    @OnClick(R.id.btnWalkthroughStart)
    void mulai() {
        // Perintah pindah halaman
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}