package cl.roman.intentappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {

    private String name;
    private TextView txttitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        txttitulo = findViewById(R.id.txttitulo);

        name = getIntent().getStringExtra(MainActivity.NAME);

        txttitulo.setText("Order of " + name);
    }

    public void order(View view) {
        Uri uri = Uri.parse("mailto: contact@coffe.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_TEXT, "contenido del correo");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order of " + name);
        startActivity(intent);

    }
}