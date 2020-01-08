package com.desafio.varejo.navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.desafio.varejo.R
import com.schibsted.spain.barista.assertion.BaristaDrawerAssertions.assertDrawerIsClosed
import com.schibsted.spain.barista.assertion.BaristaDrawerAssertions.assertDrawerIsOpen
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.schibsted.spain.barista.interaction.BaristaDrawerInteractions.closeDrawer
import com.schibsted.spain.barista.interaction.BaristaDrawerInteractions.openDrawer
import com.schibsted.spain.barista.interaction.BaristaSleepInteractions.sleep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationActivityTest{

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<NavigationActivity> = ActivityTestRule(NavigationActivity::class.java)


    @Test
    fun openAndCloseDrawerById() {
        openDrawer(R.id.drawer_layout)
        assertDisplayed("Produtos")
        assertDrawerIsOpen(R.id.drawer_layout)

        closeDrawer(R.id.drawer_layout)
        assertNotDisplayed("Produtos")
        assertDrawerIsClosed(R.id.drawer_layout)
    }

    @Test
    fun navigateToProdutos(){
        openDrawer(R.id.drawer_layout)
        onView(withText("Produtos")).perform(click())
        sleep(2000)
    }




}