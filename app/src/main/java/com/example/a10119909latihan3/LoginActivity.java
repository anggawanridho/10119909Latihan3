package com.example.a10119909latihan3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txtCheckCodeAgree)
    TextView txtAgree;
    @BindView(R.id.edtInputCode)
    EditText edtInputCode;
    @BindString(R.string.check_code_warning_empty_title)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;
    private String code;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login_code);
        ButterKnife.bind(this);

        // Convert string dengan tag html </b> ke bentuk html kemudian di set ke textAgree
        txtAgree.setText(Html.fromHtml(getString(R.string.check_code_text_agreement)));
    }

    @OnClick(R.id.btnCheckCode)
    public void masuk(View view) {
        //Menampung nilai string dari edittext
        code = edtInputCode.getText().toString();

        //validasi jika inputan kode masih kosong
        if (isStringEmpty(code)) {
            //menampilkan dialog pesan warning
            showWarningMessage();
        } else {
            //Pindah halaman
            startActivity(new Intent(this, BiodataActivity.class));
        }
    }

    //Method membandingkan string
    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    //Method menampilkan dialog pesan warning
    public void showWarningMessage(){
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        text.setText(emptyMessage);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
