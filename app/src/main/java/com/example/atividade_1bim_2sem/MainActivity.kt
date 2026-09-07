package com.example.atividade_1bim_2sem

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        val etInput = findViewById<EditText>(R.id.etInput)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val ivQrCode = findViewById<ImageView>(R.id.ivQrCode)
        val btnScan = findViewById<Button>(R.id.btnScan)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- FUNCIONALIDADE 1: GERAÇÃO (ZXing) ---
        btnGenerate.setOnClickListener {
            val text = etInput.text.toString()
            if (text.isNotEmpty()) {
                val bitmap = generateQrCode(text)
                ivQrCode.setImageBitmap(bitmap)
            } else {
                Toast.makeText(this, "Digite algo para gerar o QR Code", Toast.LENGTH_SHORT).show()
            }
        }

        // --- FUNCIONALIDADE 2: LEITURA (Google Code Scanner) ---
        val options = GmsBarcodeScannerOptions.Builder()
            .setBarcodeFormats(com.google.mlkit.vision.barcode.common.Barcode.FORMAT_QR_CODE)
            .build()
        val scanner = GmsBarcodeScanning.getClient(this, options)

        btnScan.setOnClickListener {
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    val rawValue: String? = barcode.rawValue
                    tvResult.text = "Resultado: $rawValue"
                }
                .addOnFailureListener { e ->
                    tvResult.text = "Erro ao escanear: ${e.message}"
                }
                .addOnCanceledListener {
                    tvResult.text = "Scan cancelado"
                }
        }
    }

    private fun generateQrCode(text: String): Bitmap? {
        val width = 500
        val height = 500
        val matrix: BitMatrix
        try {
            matrix = MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height)
        } catch (e: WriterException) {
            e.printStackTrace()
            return null
        }

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (matrix.get(x, y)) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    }
}
