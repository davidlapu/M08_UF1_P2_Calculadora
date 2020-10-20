package cat.itb.m08_uf1_p2_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
            button0, buttonEqual, buttonPlus, buttonC;

    private int num1, num2, res;
    private String sNum2;
    private boolean completed = false;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.resEditText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonC = findViewById(R.id.buttonC);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonPlus = findViewById(R.id.buttonPlus);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
    }

    public int getNum2() {
        String text = editText.getText().toString(), numText="";
        boolean read = false;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '=') {
                read = false;
            }

            if (read) {
                numText = numText.concat(String.valueOf(text.charAt(i)));
            }

            if (text.charAt(i) == '+') {
                read = true;
            }
        }

        return Integer.parseInt(numText);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String bText = (String) b.getText();

        if (completed) {
            clearText();
            completed = false;
        }

        switch (bText) {
///*            case "1":
//            case "2":
//            case "3":
//            case "4":
//            case "5":
//            case "6":
//            case "7":
//            case "8":
//            case "9":
//            case "0":
            case "+" :
                num1 = Integer.parseInt(editText.getText().toString());
                break;
            case "=":
                num2 = getNum2();
                res = num1 + num2;
                bText = bText.concat(String.valueOf(res));
                completed = true;
                break;
        }

        setText(bText);

        if (bText.equals("C")) {
            clearText();
        }
    }

    @SuppressLint("SetTextI18n")
    public void setText(String num) {
        editText.setText(editText.getText() + String.valueOf(num));
    }

    public void clearText() {
        editText.setText("");
    }

}