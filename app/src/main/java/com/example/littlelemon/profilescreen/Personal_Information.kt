package com.example.littlelemon.profilescreen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonalInformationForm(
    firstName: String,
    lastName: String,
    email: String,
    onLogOutClick: () -> Unit


){

    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Text(
            text = "Personal Information",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstName,
            onValueChange = {},
            label = { Text("First Name") },
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(color = Color.Black)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = lastName,
            onValueChange = {},
            label = { Text("Last Name") },
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(color = Color.Black)

        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = {},
            label = { Text("Email") },
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(color = Color.Black)

        )
        Spacer(modifier = Modifier.height(125.dp))
        Button(
            onClick = onLogOutClick,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color.White
            )
        ){
            Text(
                text = "Log out",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

    }

}



@Preview(showBackground = true)
@Composable
fun PersonalInformationFormPreview() {
    PersonalInformationForm(
        firstName = "John",
        lastName = "Doe",
        email = "john.doe@example.com",
        onLogOutClick = {}
    )
}




