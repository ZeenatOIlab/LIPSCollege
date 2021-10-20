package com.lipscollage.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.lipscollage.R
import com.rajat.pdfviewer.PdfViewerActivity

class PDFActivity : AppCompatActivity() {
    lateinit var backImageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfactivity)
        backImageView=findViewById(R.id.backImageView)
        backImageView.setOnClickListener { onBackPressed() }

        startActivity(
            PdfViewerActivity.launchPdfFromUrl(
                this@PDFActivity,
               "https://www.tutorialspoint.com/android/android_tutorial.pdf",
                "Android ",
                "",
                enableDownload = true
            )

        )


    }
}