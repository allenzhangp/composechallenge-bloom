import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Login(navController: NavHostController) {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    val annotatedString =
        AnnotatedString.Builder("By clicking below, you agree to our Terms of Use and consent to our Privacy Policy")
            .apply {
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = 35,
                    end = 48
                )
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = 68,
                    end = 82
                )
            }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Log in with email",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(top = 184.dp)
                .align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(56.dp),
            textStyle = MaterialTheme.typography.body1,
            placeholder = {
                Text(
                    text = "Email Address",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary
                )
            },
            value = emailText,
            onValueChange = { emailText = it },
            keyboardOptions = KeyboardOptions.Default,
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(56.dp),
            value = passwordText,
            onValueChange = { passwordText = it },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(
                    text = "Password(8+characters)",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary,
                )
            }
        )
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            text = annotatedString.toAnnotatedString(),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center
        )
        Button(
            shape = MaterialTheme.shapes.medium,
            onClick = { navController.navigate("home") },
            content = {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.background,
                )
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .height(48.dp)
                .fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    MyTheme {
        Login(navController = rememberNavController())
    }
}

@Preview
@Composable
fun LoginDarkPreview() {
    MyTheme(true) {
        Surface(Modifier.background(color = MaterialTheme.colors.background)) {
            Login(navController = rememberNavController())
        }
    }
}
