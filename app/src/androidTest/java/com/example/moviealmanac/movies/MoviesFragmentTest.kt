package com.example.moviealmanac.movies

import androidx.fragment.app.testing.FragmentScenario
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviealmanac.R
import org.junit.Test

import org.junit.Rule


class MoviesFragmentTest {
    private val dummyMovie = DataMovies.generateDummyMovie()

    @get:Rule
    private lateinit var fragmentRule : FragmentScenario<MoviesFragment>


    @Test
    fun onViewCreated() {
        onView(withId(R.id.list_movie_data)).check(matches(isDisplayed()))
        onView(withId(R.id.list_movie_data)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
        onView(withId(R.id.tv_title_movie)).check(matches(isDisplayed()))
    }
   @Test
    fun toMovieDetails() {
       onView(withId(R.id.list_movie_data)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
       onView(withId(R.id.list_movie_data)).perform(click())
       onView(withId(R.id.img_back_drop)).check(matches(isDisplayed()))
       onView(withId(R.id.txt_content_overview_detail_movie)).check(matches(withText("Deadline ${dummyMovie[0].overview}")))
    }

}