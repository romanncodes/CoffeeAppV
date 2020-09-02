package cl.roman.intentappv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {

    private String name;
    private TextView txttitulo, txtcantidad;
    private CheckBox opt1,opt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        txttitulo = findViewById(R.id.txttitulo);
        txtcantidad = findViewById(R.id.txtcantidad);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);

        name = getIntent().getStringExtra(MainActivity.NAME);

        txttitulo.setText("Order of " + name);
    }

    public void order(View view) {
        double total, cream=0,chocolate=0, cantidad,cafe=5;

        cantidad = Integer.parseInt(txtcantidad.getText().toString());

        if (opt1.isChecked()){
            cream = 1;
        }
        if (opt2.isChecked()){
            chocolate = 1.5;
        }

        total = (cafe+cream+chocolate)*cantidad;

        String mensaje = "Total a pagar:$"+total+"\n";
        mensaje += "total de coffes: "+cantidad;

        Uri uri = Uri.parse("mailto: contact@coffe.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order of " + name);
        startActivity(intent);
    }

    public void restar(View view) {
        int cantidad = Integer.parseInt(txtcantidad.getText().toString());
        if (cantidad > 1) {
            cantidad--;
        }
        txtcantidad.setText(String.valueOf(cantidad));
    }

    public void sumar(View view) {
        int cantidad = Integer.parseInt(txtcantidad.getText().toString());
        if (cantidad < 10) {
            cantidad++;
        }
        txtcantidad.setText(String.valueOf(cantidad));
    }
}