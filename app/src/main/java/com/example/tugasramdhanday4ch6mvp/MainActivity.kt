package com.example.tugasramdhanday4ch6mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tugasramdhanday4ch6mvp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presentImple: MainPresentImple
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presentImple = MainPresentImple(this)

        binding.btnSubmit.setOnClickListener {
            presentImple.inputBmi(
                binding.etBb.text.toString(),
                binding.etTb1.text.toString(),
                //binding.etJk.text.toString()

            )
        }
        binding.btnRiwayat.setOnClickListener {
            presentImple.loadHasil()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showData(data: String) {
        AlertDialog
            .Builder(this)
            .setNegativeButton("Close"){dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("Hapus Data"){dialog, _ ->
               //konfirmasi
                AlertDialog.Builder(this)
                    .setPositiveButton("Iya"){dialog,_ ->
                        presentImple.clearHasil()
                        dialog.dismiss()
                    }
                    .setNegativeButton("Tidak"){dialog,_ ->
                        dialog.dismiss()
                    }
                    .setTitle("Konfirmasi")
                    .setMessage("Yakin Mau Hapus Riwayat?")
                    .create()
                    .show()

                dialog.dismiss()
            }
            .setTitle("History")
            .setMessage(data)
            .create()
            .show()

    }

    override fun clearField() {
        binding.etBb.text!!.clear()
        binding.etTb1.text!!.clear()
    }
}