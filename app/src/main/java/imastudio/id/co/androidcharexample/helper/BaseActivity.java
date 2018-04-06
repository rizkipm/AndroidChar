package imastudio.id.co.androidcharexample.helper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;

import com.androidquery.AQuery;


public class BaseActivity extends AppCompatActivity {
    protected Context c;
    public static final AlphaAnimation btnAnimasi = new AlphaAnimation(1F, 0.5F);
    protected AQuery aQuery;
    protected SessionManager sesi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c = this;
        aQuery = new AQuery(c);
        sesi= new SessionManager(c);

    }
}
