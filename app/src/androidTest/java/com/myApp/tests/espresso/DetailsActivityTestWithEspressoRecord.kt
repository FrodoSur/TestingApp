package com.myApp.tests.espresso


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.myApp.tests.R
import com.myApp.tests.view.search.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailsActivityTestWithEspressoRecord {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun detailsActivityTestWithEspressoRecord() {
        val materialButton = onView(
allOf(withId(R.id.toDetailsActivityButton), withText("to details"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        materialButton.perform(click())
        
        val materialButton2 = onView(
allOf(withId(R.id.incrementButton), withText("+"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()))
        materialButton2.perform(click())
        
        val textView = onView(
allOf(withId(R.id.detailsTotalCountTextView), withText("Number of results: 1"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView.check(matches(withText("Number of results: 1")))
        
        val button = onView(
allOf(withId(R.id.incrementButton), withText("+"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button.check(matches(isDisplayed()))
        
        val button2 = onView(
allOf(withId(R.id.incrementButton), withText("+"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button2.check(matches(isDisplayed()))
        
        val materialButton3 = onView(
allOf(withId(R.id.decrementButton), withText("-"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()))
        materialButton3.perform(click())
        
        val materialButton4 = onView(
allOf(withId(R.id.decrementButton), withText("-"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()))
        materialButton4.perform(click())
        
        val textView2 = onView(
allOf(withId(R.id.detailsTotalCountTextView), withText("Number of results: -1"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView2.check(matches(withText("Number of results: -1")))
        
        val textView3 = onView(
allOf(withId(R.id.detailsTotalCountTextView), withText("Number of results: -1"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView3.check(matches(withText("Number of results: -1")))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
