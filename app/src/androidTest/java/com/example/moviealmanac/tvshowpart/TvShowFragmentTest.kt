package com.example.moviealmanac.tvshowpart

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviealmanac.R
import com.example.moviealmanac.ui.main.MainActivity
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvShowFragmentTest {

    private val dummyTvData = DataTvShow.generateDummyTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }


    @Test
    fun loadTvData() {
        onView(withId(R.id.list_tvShow_data)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.list_tvShow_data)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvData.size))
    }

    @Test
    fun toTvShowDetails() {
        onView(withId(R.id.list_tvShow_data)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.list_tvShow_data)).perform(ViewActions.click())
        onView(withId(R.id.img_back_drop_tv_show)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_content_overview_tv_show_detail)).check(ViewAssertions.matches(ViewMatchers.withText("${dummyTvData[0].name}")))
    }
}