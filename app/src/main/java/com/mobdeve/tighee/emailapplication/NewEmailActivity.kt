package com.mobdeve.tighee.emailapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.tighee.emailapplication.databinding.ActivityNewEmailBinding

class NewEmailActivity : AppCompatActivity() {

    // Keys for new email intent data
    companion object {
        const val NEW_RECEIVER_KEY = "NEW_RECEIVER_KEY"
        const val NEW_SUBJECT_KEY = "NEW_SUBJECT_KEY"
        const val NEW_BODY_KEY = "NEW_BODY_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding for NewEmailActivity
        val viewBinding : ActivityNewEmailBinding = ActivityNewEmailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // When discarding an email, basically exit the activity by finishing the activity.
        viewBinding.discardBtn.setOnClickListener(View.OnClickListener {
                /* TODO:
                 *  1. Finish the activity
                 * */
            finish()
        })

        // Logic for "sending" an email
        viewBinding.sendBtn.setOnClickListener(View.OnClickListener {
            if (viewBinding.toEt.text.toString().isNotEmpty() && viewBinding.subjectEt.text.toString().isNotEmpty() && viewBinding.bodyEt.text.toString().isNotEmpty()) {
                /* TODO:
                 *  1. Extract information from views,
                 *  2. Place info into intent,
                 *  3. Set result and include intent, and
                 *  4. Finish the activity
                 * */
                val receiver = viewBinding.toEt
                val subject = viewBinding.subjectEt
                val body = viewBinding.bodyEt
                val returnIntent = Intent()

                returnIntent.putExtra(NEW_RECEIVER_KEY,receiver.getText().toString())
                returnIntent.putExtra(NEW_SUBJECT_KEY,subject.getText().toString())
                returnIntent.putExtra(NEW_BODY_KEY,body.getText().toString())

                setResult(RESULT_OK, returnIntent)
                finish()
            } else {
                Toast.makeText(
                    this@NewEmailActivity,
                    "Please make sure all entries have text.",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}