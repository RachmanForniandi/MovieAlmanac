package com.example.moviealmanac.tvshowpart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.moviealmanac.models.TvShowDummy

class TvShowViewModel (application: Application): AndroidViewModel(application){

    val tvShows:List<TvShowDummy> = DataTvShow.generateDummyTvShow()
    val tvShowsLoadError by lazy { MutableLiveData<Boolean>() }
    val loadingTvShows by lazy { MutableLiveData<Boolean>() }

    fun tvShowsDetail(id:Int):TvShowDummy = DataTvShow.tvShowDetail(id)

    fun responseOnGenerateDummyTvShow(){
        /*val tvShow1 = TvShowDummy(1412,
            "Arrow",
            140.526,
            "2012-10-10",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "en",
            "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "/e6v6RUzAW7xO6OBeLtfOhlCawz6.jpg",
            6.5)

        val tvShow2 = TvShowDummy(79501,
            "Doom Patrol",
            68.289,
            "2019-02-15",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "en",
            "/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
            7.6)

        val tvShow3 = TvShowDummy(12971,
            "Dragon Ball Z",
            169.971,
            "1989-04-26",
            "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
            "ja",
            "/f2zhRLqwRLrKhEMeIM7Z5buJFo3.jpg",
                "/a2L4vWPp2NFHBALWBPyVH5vPk6e.jpg",
            8.1)

        val tvShow4 = TvShowDummy(46261,
            "Fairy Tail",
            26.987,
            "2009-10-12",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "ja",
            "/703mVJP8UyP1b1hEJi6aTrf0MQ1.jpg",
                "/sOzVgRsIjisBMQUxeMjnw1oF40w.jpg",
            7.6)

        val tvShow5 = TvShowDummy(1434,
            "Family guy",
            145.797,
            "1999-01-31",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for tvShows). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "en",
            "/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg",
                "/8mG1YRVseMBHXlKBCtObcVWZy0B.jpg",
            6.9)

        val tvShow6 = TvShowDummy(60735,
            "The Flash",
            244.514,
            "2014-10-07",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "en",
            "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "8xWZPVX1cv9V5YD1RPeLj9QZDE9.jpg",
            7.6)

        val tvShow7 = TvShowDummy(1399,
            "Game Of Thrones",
            324.094,
            "2011-04-17",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "en",
            "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "/7d3vRgbmnrRQ39Qmzd66bQyY7Is.jpg",
            8.3)

        val tvShow8 = TvShowDummy(60708,
            "Gotham",
            124.673,
            "2014-09-22",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "en",
            "/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "/a47zOXSfa6clj9Vb5Xv2sZg7W3R.jpg",
            7.4)

        val tvShow9 = TvShowDummy(1416,
            "Grey's Anatomy",
            759.096,
            "2005-03-27",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "en",
            "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "/xoBWd6WNcQKoxfYzcwWRZUiFGtx.jpg",
            8.1)

        val tvShow10 = TvShowDummy(54155,
            "Hanna",
            30.266,
            "2019-03-28",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "en",
            "/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
                "/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
            7.4)

        val tvShowList= arrayListOf(tvShow1,tvShow2,tvShow3,tvShow4,tvShow5,tvShow6,tvShow7,tvShow8,tvShow9,tvShow10)*/

        //tvShows.value = tvShowList
        tvShowsLoadError.value = false
        loadingTvShows.value = false
    }


}