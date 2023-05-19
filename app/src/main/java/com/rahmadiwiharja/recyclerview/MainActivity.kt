package com.rahmadiwiharja.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.rahmadiwiharja.recyclerview.adapter.AdapterTeamBola
import com.rahmadiwiharja.recyclerview.databinding.ActivityMainBinding
import com.rahmadiwiharja.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Marcelo Vieira da Silva Junior",R.drawable.marcelo,"Belakang","174","Brasil","12 Mei 1988"))
        listPemain.add(Pemain("Karim Benzema",R.drawable.benzema,"Penyerang","1.85","Prancis","19 Desember 1987"))
        listPemain.add(Pemain("Sergio Ramos Garcia",R.drawable.ramos,"Belakang","1.84"," Spanyol","30 Maret 1986"))
        listPemain.add(Pemain("Luka Modric",R.drawable.modric,"BGelandang","1.74"," Kroasia","09 September 1985"))
        listPemain.add(Pemain("Thibaut Nicolas Marc Courtois",R.drawable.curtois,"Penjaga Gawang","1.99","Bree, Belgia","11 Mei 1992"))
        listPemain.add(Pemain("Tonny Kross",R.drawable.kross,"Gelandang","1.82","Greifswald,Jerman","01 April 1990 "))
        listPemain.add(Pemain("Vinicius Jose Paixao de Oliveira",R.drawable.viny,"Penyerang","1.76","Sao Goncalo, Brasil","12 Juli 2000"))
        listPemain.add(Pemain("Eden Hazard",R.drawable.hazard,"Penyerang","1.75","La Louvière, Belgia","07 Januari 1991 "))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object  : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text =  "${item?.nama}"
                    posisi.text =  "${item?.posisi}"
                    tinggi.text =  "${item?.tinggi}"
                    tempatlahir.text =  "${item?.tempatlahir}"
                    tgllahir.text =  "${item?.tgllahir}"

                   btn.setOnClickListener {
                       this.dismiss()
                   }
                }.show()
            }

        })


    }
}