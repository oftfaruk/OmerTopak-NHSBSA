package com.nhs.step_definitions;

import com.nhs.pages.NHSHealthCheck;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NHSStepDef {
    NHSHealthCheck nhs = new NHSHealthCheck();

    @Given("I am a person from {string}")
    public void i_am_a_person_from(String country) {
        nhs.country(country);


    }

    @When("I put my circumstances into the Checker tool")
    public void i_put_my_circumstances_into_the_Checker_tool() {
        nhs.circumstances();

    }

    @Then("I should get a result of whether I will get help or not")
    public void i_should_get_a_result_of_whether_I_will_get_help_or_not() {
        nhs.result();
    }



}
