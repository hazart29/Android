package com.tugasakhirsemester.Misbakhul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.tugasakhirsemester.Misbakhul.Model.IndonesiaResponse
import com.tugasakhirsemester.Misbakhul.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showKasus()
    }
    private fun showKasus(){
        RetrofitClient.instance.getIndonesia().enqueue(object: Callback<ArrayList<IndonesiaResponse>> {
            override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>)
            {
                val indonesiaResponse = response.body()?.get(0)
                val resPositif = indonesiaResponse?.positif
                val resDirawat = indonesiaResponse?.dirawat
                val resSembuh = indonesiaResponse?.sembuh
                val resMeninggal = indonesiaResponse?.meninggal

                val valPositif: TextView = findViewById(R.id.jmlPositif)
                valPositif.text= resPositif
                val valDirawat: TextView = findViewById(R.id.jmlDirawat)
                valDirawat.text= resDirawat
                val valSembuh: TextView = findViewById(R.id.jmlSembuh)
                valSembuh.text= resSembuh
                val valMeninggal: TextView = findViewById(R.id.jmlMeninggal)
                valMeninggal.text= resMeninggal
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t:Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}