package tz.co.matrixhub.systems.ussd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;
import com.hover.sdk.permissions.PermissionActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hover.initialize(this);

        Button permission, balance;

        balance = findViewById(R.id.balance);
        permission = findViewById(R.id.permission);

        final Intent perm = new Intent(this, PermissionActivity.class);
        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(perm, 0);
            }
        });

        final Intent i = new HoverParameters.Builder(this)
                .request("7f56572e")
                .buildIntent();
        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(i, 0);
            }
        });

    }

}
