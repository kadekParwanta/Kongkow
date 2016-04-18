package com.creativeideas.kongkow;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.creativeideas.kongkow.Model.ChatUserRepository;
import com.strongloop.android.loopback.RestAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kadek_P on 4/14/2016.
 */
public class RegisterActivity extends Activity {
    // UI elements
    EditText txtName;
    EditText txtPassword;
    EditText txtEmail;

    // Register button
    Button btnRegister;
    Button btnLinkToLoginScreen;
    private ProgressDialog pDialog;
    RestAdapter restAdapter;
    ChatUserRepository userRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);

        KongkowApplication app = (KongkowApplication)getApplication();
        restAdapter = app.getLoopBackAdapter();
        userRepo = restAdapter.createRepository(ChatUserRepository.class);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        /*
		 * Click event on Register button
		 * */
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String username = txtName.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                // Check for empty data in the form
                if (email.trim().length() > 0 && password.trim().length() > 0) {
                    doRegister();
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        /*
		 * Click event on LinkToLogin button
		 * */
        btnLinkToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void doRegister() {
//        pDialog.setMessage("Registering ...");
//        showDialog();
        String username = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        Map<String, Object> optionals = new HashMap<String, Object>();
        optionals.put("username",username);
        userRepo.createUser(email, password, optionals);
//        hideDialog();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
