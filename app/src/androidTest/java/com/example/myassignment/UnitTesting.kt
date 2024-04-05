import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myassignment.MainActivity
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UnitTesting {

    @Test
    fun testAgeMatching() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Input an age
        onView(withId(R.id.numberAge)).perform(typeText("30"), closeSoftKeyboard())

        // Click the button to find matching historical figures
        onView(withId(R.id.btn1)).perform(click())

        // Check if the matched historical figure information is displayed
        onView(withId(R.id.information))
            .check(matches(withText(containsString("Eazy-E"))))
    }

    @Test
    fun testClearButton() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Input an age
        onView(withId(R.id.numberAge)).perform(typeText("40"), closeSoftKeyboard())

        // Click the button to find matching historical figures
        onView(withId(R.id.btn1)).perform(click())

        // Check if the matched historical figure information is displayed
        onView(withId(R.id.information))
            .check(matches(withText(containsString("paul walker"))))

        // Click the clear button
        onView(withId(R.id.btn2)).perform(click())

        // Check if the age input field is cleared
        onView(withId(R.id.numberAge)).check(matches(withText("")))

        // Check if the information field is empty
        onView(withId(R.id.information)).check(matches(withText("")))
    }

    @Test
    fun testInvalidAge() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Input an invalid age
        onView(withId(R.id.numberAge)).perform(typeText("10"), closeSoftKeyboard())

        // Click the button to find matching historical figures
        onView(withId(R.id.btn1)).perform(click())

        // Check if the error message is displayed
        onView(withId(R.id.information))
            .check(matches(withText("No Figure has been found from the input of your age.")))
    }
}
