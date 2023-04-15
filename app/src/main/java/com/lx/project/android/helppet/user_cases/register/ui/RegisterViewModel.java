package com.lx.project.android.helppet.user_cases.register.ui;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterViewModel extends ViewModel {

    public void registerUser(String name, String email, String pwd, String pwdConfirm) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Registro exitoso, obtén el usuario actual
                        FirebaseUser user = mAuth.getCurrentUser();
                        // Guarda el nombre del usuario en Firestore
                        saveUserName(user.getUid(), name);
                    } else {
                        // Error en el registro, muestra un mensaje al usuario
                        Log.d("Error-register", "Ocurrio un errro");
                    }
                });
    }

    private void saveUserName(String userId, String name) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);

        db.collection("users")
                .document(userId)
                .set(user)
                .addOnSuccessListener(aVoid -> {
                    // El nombre del usuario se guardó correctamente
                    // Puedes mostrar un mensaje al usuario o redirigirlo a otra actividad
                })
                .addOnFailureListener(e -> {
                    // Ocurrió un error al guardar el nombre del usuario
                    Log.d("Error-data", "Error saving data");
                });
    }
}
