package com.example.moviealmanac.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviealmanac.models.FilmDummy

class MoviesViewModel : ViewModel() {

    val movies = MutableLiveData<List<FilmDummy>>()
    val moviesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun generateDummyMovie(){

        val movie1 = FilmDummy(332562,
                "A Star Is Born",
                847.887,
                "2018-10-03",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "en",
                "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                7.5)

        val movie2 = FilmDummy(399579,
                "Alita: Battle Angel",
                118.974,
                "2019-01-31",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "en",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                7.1)

        val movie3 = FilmDummy(297802,
                "Aquaman",
                96.117,
                "2019-01-31",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "en",
                "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                6.9)

        val movie4 = FilmDummy(424694,
                "Bohemian Rhapsody",
                88.06,
                "2018-10-24",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "en",
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                8.0)

        val movie5 = FilmDummy(438650,
                "Cold Pursuit",
                88.06,
                "2019-02-07",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "en",
                "/cO802woIgZsLbOWPUSsleobKyDp.jpg",
                5.6)

        val movie6 = FilmDummy(480530,
                "Creed II",
                92.443,
                "2018-11-21",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "en",
                "/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                6.9)

        val movie7 = FilmDummy(338952,
                "Fantastic Beasts: The Crimes of Grindelwald",
                76.218,
                "2018-11-14",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "en",
                "/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                6.9)

        val movie8= FilmDummy(450465,
                "Glass",
                73.525,
                "2019-01-16",
                " In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "en",
            "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                6.6)

        val movie9= FilmDummy(166428,
                "How to Train Your Dragon: The Hidden World",
                118.962,
                "2019-01-03",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "en",
                "/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                7.8)

        val movie10= FilmDummy(299536,
                "Avengers: Infinity War",
                293.217,
                "2018-04-25",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "en",
                "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                8.3)

        val movieList= arrayListOf<FilmDummy>(movie1,movie2,movie3,movie4,movie5,movie6,movie7,movie8,movie9,movie10)

        movies.value = movieList
        moviesLoadError.value = false
        loading.value = false

    }
}