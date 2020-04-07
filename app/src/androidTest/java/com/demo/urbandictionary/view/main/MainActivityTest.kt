package com.demo.urbandictionary.view.main

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
//import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.demo.urbandictionary.R
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.Espresso.onView
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.contrib.RecyclerViewActions
import com.demo.urbandictionary.view.main.recycler.DefinitionViewHolder



@RunWith(AndroidJUnit4::class)

class MainActivityTest {

  val item_below_the_fold = 10;

  @Rule
  val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun itemClickTest(){

   onView(withId(R.id.searchTextField))
      .perform(typeText("dog"))

    onView(withId(R.id.searchButton))
      .perform(click())

    onView(withId(R.id.definitionRecyclerView))
      .perform(RecyclerViewActions.actionOnItemAtPosition<DefinitionViewHolder>(item_below_the_fold, click()))

    val itemElementText = getApplicationContext<Context>().resources.getString(
      R.string.item_element_text) + item_below_the_fold.toString()
    onView(withText(itemElementText)).check(matches(isDisplayed()))

  }

}