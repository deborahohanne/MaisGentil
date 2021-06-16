package br.iesb.mobile.gentil.ui.activity

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import br.iesb.mobile.gentil.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.material.snackbar.Snackbar

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private val MAP_REQUEST_TICKET = 9999

    private lateinit var map: GoogleMap

    private val listaPontos = mutableListOf<LatLng>()
    private val polyline = PolylineOptions().color(Color.RED)

    // Recupera localização do usuário
    private lateinit var locationManager: LocationManager
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Recupera a instância do mapa configurado na atividade
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // Solicita a apresentação do mapa em background
        mapFragment.getMapAsync(this)
    }
    override fun onStart() {
        super.onStart()

        checkPermission()
    }

    override fun onPause() {
        super.onPause()

        locationManager.removeUpdates(locationListener)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val posicaoIESB = LatLng(-15.834963163926998, -47.91285006006427)
        val pinoIESB = MarkerOptions().position(posicaoIESB).title("IESB Campus Sul")
        map.addMarker(pinoIESB)

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(posicaoIESB, 13f))

        map.setOnMapLongClickListener { ponto -> adicionarPino(ponto) }
    }

    private fun adicionarPino(ponto: LatLng) {
        val novoPino = MarkerOptions().position(ponto).title("Ponto Aleatório: ${ponto.latitude}, ${ponto.longitude}")
        map.addMarker(novoPino)

        val circulo = CircleOptions()
            .center(ponto)
            .radius(500.0)
            .strokeColor(Color.BLUE)
            .fillColor(Color.parseColor("#55000000"))

        map.addCircle(circulo)

        listaPontos.add(ponto)

        polyline.addAll(listaPontos)
        map.addPolyline(polyline)
    }

    // Verifica se o usuário concedeu a permissão para acesso à localização
    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                MAP_REQUEST_TICKET
            )
        } else {
            setupLocation()
        }
    }

    // Esse método é executado quando o usuário responde à solicitação de alguma
    // permissão do aplicativo. Neste caso estamos solicitando a permissão para
    // acesso à localização do dispositivo.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == MAP_REQUEST_TICKET) { // VERIFICA SE A RESPOSTA É PARA A SOLICITAÇÃO DO MAPA
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupLocation()
            } else {
                showSnackbar("A permissão de localização é obrigatória!") {
                    checkPermission()
                }
            }
        }
    }

    private fun showSnackbar(msg: String, callback: () -> Unit) {
        val rootView = findViewById<View>(android.R.id.content).rootView
        Snackbar
            .make(rootView, msg, Snackbar.LENGTH_LONG)
            .setAction("Aceito") {
                callback()
            }
            .show()
    }

    private fun setupLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        // Configura um função para ser executada respeitando
        // os critérios de Tempo (3000 milisegundos) entre as atualizações e
        // a distância mínima (1 metro)
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            3000,
            1.0f,
            locationListener
        )
    }

    private val locationListener = LocationListener { localicacao ->
        //O usuário se moveu.
        val ponto = LatLng(localicacao.latitude, localicacao.longitude)
        val novoPino = MarkerOptions().position(ponto).title("Usuario: ${ponto.latitude}, ${ponto.longitude}")
        map.addMarker(novoPino)

        val circulo = CircleOptions()
            .center(ponto)
            .radius(200.0)
            .strokeColor(Color.RED)
            .fillColor(Color.parseColor("#88FF0000"))

        map.addCircle(circulo)
    }
}