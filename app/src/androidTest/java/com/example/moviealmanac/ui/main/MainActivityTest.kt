package com.example.moviealmanac.ui.main

import androidx.fragment.app.testing.FragmentScenario
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviealmanac.R
import com.example.moviealmanac.movies.DataMovies
import com.example.moviealmanac.movies.MoviesFragment
import com.example.moviealmanac.tvshowpart.DataTvShow
import com.example.moviealmanac.tvshowpart.TvShowFragment
import com.example.moviealmanac.utility.getStringDate
import org.junit.Rule
import org.junit.Test


class MainActivityTest{

    private val dummyMovie = DataMovies.generateDummyMovie()
    private val dummyTvData = DataTvShow.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    private lateinit var fragmentRule1 : FragmentScenario<MoviesFragment>

    @get:Rule
    private lateinit var fragmentRule2 : FragmentScenario<TvShowFragment>


    @Test
    fun loadDataMovie() {
        onView(withId(R.id.viewPager_Main)).perform(swipeLeft())
        onView(withText("MOVIES")).check(matches(isDisplayed()))
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.list_movie_data)).check(matches(isDisplayed()))
        onView(withId(R.id.list_movie_data)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun toMovieDetails() {
        onView(withText("MOVIES")).check(matches(isDisplayed()))
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.list_movie_data)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_back_drop)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title_movie_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title_movie_detail)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.txt_content_overview_detail_movie)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.txt_original_language_detail_movie)).check(matches(withText(dummyMovie[0].originalLanguage)))
        onView(withId(R.id.txt_vote_average_detail_movie)).check(matches(withText("${dummyMovie[0].voteAverage}")))
        onView(withId(R.id.txt_release_date_detail_movie)).check(matches(withText(dummyMovie[0].releaseDate.let {  getStringDate(it) }?: "-")))

        //onView(withId(R.id.txt_original_language_detail_movie)).check(matches(isDisplayed()))

        /*if (onView(withId(R.id.txt_original_language_detail_movie)).check(matches(withText(dummyMovie[0].originalLanguage))).equals("en")){
            Assert.assertEquals("English",dummyMovie[0].originalLanguage)
        }else if (onView(withId(R.id.txt_original_language_detail_movie)).check(matches(withText(dummyMovie[0].originalLanguage))).equals("ja")){
            Assert.assertEquals("Japanese",dummyMovie[0].originalLanguage)
        }else if (onView(withId(R.id.txt_original_language_detail_movie)).check(matches(withText(dummyMovie[0].originalLanguage))).equals("fr")){
            Assert.assertEquals("French",dummyMovie[0].originalLanguage)
        }else{
            Assert.assertEquals("Unknown Language",dummyMovie[0].originalLanguage)
        }*/
        //onView(withId(R.id.txt_original_language_detail_movie)).check(matches(withText(dummyMovie[0].originalLanguage)))
        /*try {
            onView(withId(R.id.txt_original_language_detail_movie)).check(matches(withText(dummyMovie[0].originalLanguage)))
        }catch (e: AssertionFailedError){
            onView(withId(R.id.txt_original_language_detail_movie)).check(doesNotExist())
        }*/


    }


    @Test
    fun loadTvData() {
        onView(withId(R.id.viewPager_Main)).perform(swipeRight())
        onView(withText("TV SHOW")).check(matches(isDisplayed()))
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.list_tvShow_data)).check(matches(isDisplayed()))
        onView(withId(R.id.list_tvShow_data)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvData.size))
    }

    @Test
    fun toTvShowDetails() {
        onView(withText("TV SHOW")).check(matches(isDisplayed()))
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.list_tvShow_data)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_back_drop_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_name_tv_show_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_name_tv_show_detail)).check(matches(withText(dummyTvData[0].name)))
        onView(withId(R.id.txt_content_overview_tv_show_detail)).check(matches(withText(dummyTvData[0].overview)))
        onView(withId(R.id.txt_original_language_tv_show_detail)).check(matches(withText(dummyTvData[0].originalLanguage)))
        onView(withId(R.id.txt_vote_average_detail_tv_show)).check(matches(withText("${dummyTvData[0].voteAverage}")))
        onView(withId(R.id.txt_release_date_tv_show_detail)).check(matches(withText(dummyTvData[0].firstAirDate.let {  getStringDate(it) }?: "-")))

    }
}