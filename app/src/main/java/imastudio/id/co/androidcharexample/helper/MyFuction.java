package imastudio.id.co.androidcharexample.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import imastudio.id.co.androidcharexample.R;


public class MyFuction extends AppCompatActivity {
    public static Context c;
    Animation animation;
    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = MyFuction.this;
    }

    public void myanimation(EditText edtanimasi) {
        animation = AnimationUtils.loadAnimation(c, R.anim.animasigetar);
        edtanimasi.setAnimation(animation);
    }

    public void myIntent(Class kelastujuan) {
        startActivity(new Intent(c, kelastujuan));
    }


    public void myToast(String isipesan) {
        Toast.makeText(c, isipesan, Toast.LENGTH_SHORT).show();
    }

    public void showProgressDialog(String tittle) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle(tittle);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void keluar() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("infomasi");
        dialog.setMessage("Apakah anda yakin ingin keluar ? ");
        dialog.setPositiveButton("iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                System.exit(0);
                android.os.Process.killProcess(android.os.Process.myPid());

            }
        });
        dialog.setNegativeButton("tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getDeviceUUID(Context context) {
        final TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = ""
                + Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        String deviceMobileNo = tm.getLine1Number();

        UUID deviceUuid = new UUID(androidId.hashCode(),
                ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();

    }


}
