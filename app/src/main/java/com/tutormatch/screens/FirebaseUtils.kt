// FirebaseUtils.kt

import com.google.firebase.auth.FirebaseAuth

object FirebaseUtils {
    private val auth = FirebaseAuth.getInstance()

    // Función para registrar un nuevo usuario con correo electrónico y contraseña
    fun signUpWithEmailPassword(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registro exitoso, el usuario se ha creado correctamente
                    val user = auth.currentUser
                    // Puedes realizar acciones adicionales aquí, como enviar un correo electrónico de verificación
                    onComplete(true, null)
                } else {
                    // El registro falló, muestra un mensaje de error
                    val errorMessage = task.exception?.message ?: "Unknown error"
                    // Maneja el error según tus necesidades
                    onComplete(false, errorMessage)
                }
            }
    }
}
