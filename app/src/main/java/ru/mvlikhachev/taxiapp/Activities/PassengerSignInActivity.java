package ru.mvlikhachev.taxiapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import ru.mvlikhachev.taxiapp.R;

public class PassengerSignInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSignUpButton;
    private TextView toggleLoginSignUpTextView;

    private boolean isLoginModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_sign_in);

        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);

        loginSignUpButton = findViewById(R.id.loginSignUpButton);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUpTextView);

        authorizationUi();
    }

    private boolean validateEmail() {

        String emailInput = textInputEmail
                .getEditText()
                .getText()
                .toString()
                .trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Введите email!");
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }
    private boolean validateName() {

        String nameInput = textInputName
                .getEditText()
                .getText()
                .toString()
                .trim();

        if (nameInput.isEmpty()) {
            textInputName.setError("Введите Ваше имя!");
            return false;
        } else if (nameInput.length() > 10) {
            textInputName.setError("Имя должно быть меньше 15 символов!");
            return false;
        } else {
            textInputName.setError("");
            return true;
        }
    }

    private boolean validatePassword() {

        String passwordInput = textInputPassword
                .getEditText()
                .getText()
                .toString()
                .trim();
        String confirmPasswordInput = textInputConfirmPassword
                .getEditText()
                .getText()
                .toString()
                .trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Введите Ваше имя!");
            return false;
        } else if (passwordInput.length() > 7) {
            textInputPassword.setError("Пароль должно быть меньше 7 символов!");
            return false;
        } else if (!passwordInput.equals(confirmPasswordInput)) {
            textInputPassword.setError("Пароли должны совпадать");
            return false;
        } else {
            textInputPassword.setError("");
            return true;
        }
    }

    public void loginSignUpUser(View view) {

        if (!validateEmail() | !validateName() | !validatePassword()) {
            return;
        }

        String userInput = "Авторизация прошла успешно!";

        Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show();

    }

    public void toggleLoginSignUp(View view) {
        if (isLoginModeActive) {
            registarionUi();
        } else {
            authorizationUi();
        }
    }

    private void registarionUi() {
        isLoginModeActive = false;
        loginSignUpButton.setText("Зарегистрироваться");
        toggleLoginSignUpTextView.setText("Или авторизуйтесь");
        textInputConfirmPassword.setVisibility(View.VISIBLE);
        textInputName.setVisibility(View.VISIBLE);
    }
    private void authorizationUi() {
        isLoginModeActive = true;
        loginSignUpButton.setText("Войти");
        toggleLoginSignUpTextView.setText("Или зарегистрируйтесь");
        textInputConfirmPassword.setVisibility(View.GONE);
        textInputName.setVisibility(View.GONE);
    }
}