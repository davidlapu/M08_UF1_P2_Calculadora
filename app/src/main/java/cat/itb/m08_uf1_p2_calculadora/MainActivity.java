package cat.itb.m08_uf1_p2_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
            button0, buttonEqual, buttonPlus, buttonMultiply, buttonBar, buttonC, buttonMinus, buttonPoint;

    private double num1;
    private double num2;
    private String res;
    private String operador;
    private boolean completed = false, num1Set;
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
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonBar = findViewById(R.id.buttonBar);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPoint = findViewById(R.id.buttonPoint);


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
        buttonMultiply.setOnClickListener(this);
        buttonBar.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
    }

    public String num2Searcher() {
        String text = editText.getText().toString(), numText="";
        boolean read = false;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '=') {
                read = false;
            }

            if (read) {
                numText = numText.concat(String.valueOf(text.charAt(i)));
            }

            if (text.charAt(i) == '+' || text.charAt(i) == '*' || text.charAt(i) == '-' || text.charAt(i) == '/') {
                read = true;
            }
        }

        return numText;
    }

    public boolean thereIsNum2() {
        String numText = num2Searcher();
        return !numText.isEmpty();
    }

    public double getNum2() {
        String numText = num2Searcher();
        return Double.parseDouble(numText);
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
            case "C":
                clearText();
                bText = "";
                break;
            case "-" :
            case "*" :
            case "/" :
            case "+" :
                if (!isEmpty() && !num1Set) {
                    num1 = Double.parseDouble(editText.getText().toString());
                    num1Set = true;
                } else {
                    bText = "";
                }

                operador = bText;
                break;
            case "=":
                if (thereIsNum2()) {
                    res = calculator(operador, num1, getNum2());
                    bText = bText.concat(String.valueOf(res));
                    completed = true;

                } else {
                    bText = "";
                }
                num1Set = false;
                break;

        }

        setText(bText);

    }

    @SuppressLint("SetTextI18n")
    public void setText(String num) {
        editText.setText(editText.getText() + String.valueOf(num));
    }

    public void clearText() {
        editText.setText("");
    }

    public boolean isEmpty() {
        return editText.getText().toString().isEmpty();
    }

    public String calculator(String operator, double num1, double num2) {
        double res = 0;

        switch (operator) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case  "/":
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    return "No se puede dividir por 0";
                }

                break;
        }

        return String.valueOf(res);
    }

    public void sout(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}