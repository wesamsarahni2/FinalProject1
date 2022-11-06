package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForgotPassword#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgotPassword extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForgotPassword() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgotPassword.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgotPassword newInstance(String param1, String param2) {
        ForgotPassword fragment = new ForgotPassword();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false);
    }
    private Button ResetPassword;
    private EditText NewPassword, NewPasswordConfirm;

    @Override
    public void onStart() {
        super.onStart();
        NewPassword=getView().findViewById(R.id.etPasswordF);
        NewPasswordConfirm=getView().findViewById(R.id.etPasswordF2);
        ResetPassword=getView().findViewById(R.id.btnResetPass);

        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();

                Toast.makeText(getContext(), "Your Password has been reset", Toast.LENGTH_SHORT).show();
                FragmentTransaction ft =getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.LoginLayout, new LoginFragment());
                ft.commit();
            }
        });
    }

    public void Reset(){

        String password,confirmpassword;
        password = NewPassword.getText().toString();
        confirmpassword= NewPasswordConfirm.getText().toString();
        if(   password.trim().isEmpty()||  confirmpassword.trim().isEmpty())
        {
            Toast.makeText(getContext()
                    , "some feilds are missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.equals(confirmpassword))
        {
            Toast.makeText(getContext()
                    , "the confirmed password Dosent match", Toast.LENGTH_SHORT).show();
        }

    }

}