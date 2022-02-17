package com.example.moviealmanac.ui.main

import androidx.fragment.app.testing.FragmentScenario
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviealmanac.R
import com.example.moviealmanac.movies.DataMovies
import com.example.moviealmanac.movies.MoviesFragment
import com.example.moviealmanac.tvshowpart.DataTvShow
import com.example.moviealmanac.tvshowpart.TvShowFragment
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import java.util.regex.Pattern.matches

class MainActivityTest{

    private val dummyMovie = DataMovies.generateDummyMovie()
    private val dummyTvData = DataTvShow.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    /*@get:Rule
    private lateinit var fragmentRule1 : FragmentScenario<MoviesFragment>

    @get:Rule
    private lateinit var fragmentRule2 : FragmentScenario<TvShowFragment>*/

    @Test
    fun loadDataMovie() {
        onView(withId(R.id.list_movie_data)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.list_movie_data)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun toMovieDetails() {
        onView(withId(R.id.list_movie_data)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_back_drop)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.txt_title_movie_detail)).check(ViewAssertions.matches(withText(dummyMovie[0].title)))
    }

    @Test
    fun loadTvData() {
        onView(withId(R.id.list_tvShow_data)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.list_tvShow_data)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvData.size))
    }

    @Test
    fun toTvShowDetails() {
        onView(withId(R.id.list_tvShow_data)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_back_drop_tv_show)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.txt_name_tv_show_detail)).check(ViewAssertions.matches(withText(dummyTvData[0].name)))
    }
}