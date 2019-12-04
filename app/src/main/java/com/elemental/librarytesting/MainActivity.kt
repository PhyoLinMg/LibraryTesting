package com.elemental.librarytesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.elemental.validator.ValidateTor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var validateTor: ValidateTor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize validatetor instance

        setUpUiWidgets()

        validateTor = ValidateTor()

    }
    private fun setUpUiWidgets() {
        btn_validate.setOnClickListener {
            validateEmailField(edt_email as EditText)
            validatePasswordField(edt_password as EditText)
            validateCreditCardField(edt_creditcard as EditText)
        }
    }

    private fun validateCreditCardField(editText: EditText) {
        val str = editText.text.toString()

        if (validateTor.isEmpty(str)) {
            editText.error = "Field is empty!"
        }

        if (!validateTor.validateCreditCard(str)) {
            editText.error = "Invalid Credit Card number!"
        } else {
            Toast.makeText(this, "Valid Credit Card Number!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validatePasswordField(editText: EditText) {
        val str = editText.text.toString()

        if (validateTor.isEmpty(str)) {
            editText.error = "Field is empty!"
        }

        if (validateTor.isAtleastLength(str, 8)
            && validateTor.hasAtleastOneDigit(str)
            && validateTor.hasAtleastOneUppercaseCharacter(str)
            && validateTor.hasAtleastOneSpecialCharacter(str)) {
            Toast.makeText(this, "Valid Password!", Toast.LENGTH_SHORT).show()
        } else {
            editText.error = "Password needs to be of minimum length of 8 characters and should " +
                    "have " + "atleast 1 digit, 1 upppercase letter and 1 special character "
        }
    }

    private fun validateEmailField(editText: EditText) {
        val str = editText.text.toString()

        if (validateTor.isEmpty(str)) {
            editText.error = "Field is empty!"
        }

        if (!validateTor.isEmail(str)) {
            editText.error = "Invalid Email entered!"
        } else {
            Toast.makeText(this, "Valid Email!", Toast.LENGTH_SHORT).show()
        }
    }
}
