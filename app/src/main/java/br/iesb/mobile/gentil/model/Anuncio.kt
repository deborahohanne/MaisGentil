package br.iesb.mobile.gentil.model

data class Anuncio(
    val title: String,
    val preview: String,
    val date: String,
    val image: String
)

class AnuncioBuilder {
    var title: String = ""
    var preview: String = ""
    var date: String = ""

    fun build() : Anuncio = Anuncio(title, preview, date)
}

fun anuncio(block: AnuncioBuilder.() -> Unit): Anuncio = AnuncioBuilder().apply(block).build()

fun fakeAnuncios() = mutableListOf(
    anuncio {
        title = "@string/txtAnuncio1"
        preview = "Estou doando 3 cestas básicas com alimentos não perecíveis, contendo: 3 arroz, 3 feijão."
        date = "26 jun"
    },
    anuncio {
        title = "@string/txtAnuncio2"
        preview = "Estou doando diversas roupas, femininas masculinas e infantis."
        date = "30 fev"
    },
    anuncio {
        title = "@string/txtAnuncio3"
        preview = "Estou doando cobertores e lençois de cama."
        date = "16 jun"
    },
    anuncio {
        title = "@string/txtAnuncio4"
        preview = "Estou doando itens eletrônicos diversos e bom estado de funcionamento."
        date = "26 jan"
    }
)