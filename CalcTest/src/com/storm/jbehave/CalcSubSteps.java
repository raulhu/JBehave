package com.storm.jbehave;

import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


//Scenario: 2
//        Given x is equal to 10 or y is equal to 10 or c is equal to 0
//        When I sub x equal to 10 with y equal to 10
//        Then c is equal to 0

public class CalcSubSteps {
    int x, y, c;

    @Given("x is equal to $valueX or y is equal to $valueY or c is equal to $valueC")
    public void givenValue(int valueX, int valueY, int valueC){
        x = valueX;
        y = valueY;
        c = valueC;
    }

    @When("When I sub x equal to 10 with y equal to 10")
    public void whenISubXWithY(){
        c = x - y;
    }

    @Then("c is equal to $valueC")
    public void thenCequalTo(int valueC){
        Assert.assertEquals(valueC, c);
        //if(valueC != c)
          //  throw new RuntimeException("C is " + c + ", but should be " + valueC);

    }

}
